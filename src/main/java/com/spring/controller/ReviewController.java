package com.spring.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.dto.BoardDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.service.ReplyService;
import com.spring.service.ReviewBoardService;
import com.spring.utils.UploadFileUtils;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

	@Inject
	ReviewBoardService service;

	@Inject
	private ReplyService replyService;
	
	@Resource(name="uploadPath")
    private String uploadPath;

	// 여행후기 목록
	@RequestMapping(value = "/review_list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = service.review_list();

		model.addAttribute("list", list);
	}

	// 여행후기 작성 get
	@RequestMapping(value = "/review_write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 여행후기 작성 post
	@RequestMapping(value = "/review_write", method = RequestMethod.POST)
	public String postWrite(HttpServletRequest request, BoardDTO dto, MultipartFile file, MultipartHttpServletRequest mtfRequest) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String file_name = null;
		System.out.println(imgUploadPath);
		/*
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 file_name =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 file_name = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		

		HttpSession session = request.getSession();
		session.getAttribute("member");
		int user_num = (Integer)session.getAttribute("user_num");
		
		dto.setReview_img(File.separator + "upload" + ymdPath + File.separator + file_name);
		dto.setReview_thumbnail(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + file_name);
		dto.setUser_num(user_num);
		*/
		
		List<MultipartFile> fileList = mtfRequest.getFiles("product_detail_image");

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);
            
            String blankImage = null;
            String blankImageThum = null;
            
            int review_bno = (service.review_checkBoardBno()+1);
            dto.setDivision_bno(review_bno);
            
            if(originFileName == "") {
            	System.out.println("originFileName : 빈칸!!!!");
            	
            	blankImage = uploadPath + File.separator + "images" + File.separator + "none.png";
            	blankImageThum = uploadPath + File.separator + "images" + File.separator + "s_none.png";
            	
            	//이미지 업로드 시 DB에 저장되는 경로
                String dtoBlankImage = File.separator + "images" + File.separator + "none.png";
                String dtoBlankThubmnail = File.separator + "images" + File.separator + "s" + File.separator + "s_none.png";
            	
            	File blankFile = new File(blankImage);
                File blankThumFile = new File(blankImageThum);
            	
            	//dto 세팅
                dto.setImg(dtoBlankImage);
    			dto.setThumbnail(dtoBlankThubmnail);
                
                try {
                	if(mf.isEmpty() ) { // 이미지 업로드 없을시
                		mf.transferTo(new File(blankImage));
                		Files.copy(blankFile.toPath(), blankThumFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else {
                    	//mf.transferTo(new File(safeFile));	// 실제 경로에 이미지 업로드
                        //Files.copy(orgFile.toPath(), outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);	// 이미지를 복사하여 썸네일 업로드, 이름이 같으면 덮어쓰기
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            } else {
            	//이미지 업로드 시 실제 저장 경로
                String safeFile = imgUploadPath + ymdPath + File.separator + originFileName;
                String safeFileThum = imgUploadPath + ymdPath + File.separator + "s" + File.separator + "s_" + originFileName;
                
                //이미지 업로드 시 DB에 저장되는 경로
                String dtoImageFile = File.separator + "upload" + ymdPath + File.separator + originFileName;
                String dtoThubmnail = File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + originFileName;
                
                //이미지 업로드 저장 경로 출력
                System.out.println("파일 이미지 경로 : " + safeFile);
                System.out.println("썸네일 이미지 경로 : " + safeFileThum);
                
                //이미지 업로드 DB 경로 출력
                System.out.println("파일 이미지 DB 경로 : " + dtoImageFile);
                System.out.println("썸네일 이미지 DB 경로 : " + dtoThubmnail);
                
                //파일 저장을 위함
                File orgFile = new File(safeFile);
                File outFile = new File(safeFileThum);
                
                //dto 세팅
                dto.setImg(dtoImageFile);
    			dto.setThumbnail(dtoThubmnail);
                
                try {
                	if(mf.isEmpty() ) { // 이미지 업로드 없을시
                		//mf.transferTo(new File(blankImage));
                		//Files.copy(blankFile.toPath(), blankThumFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else {
                    	mf.transferTo(new File(safeFile));	// 실제 경로에 이미지 업로드
                        Files.copy(orgFile.toPath(), outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);	// 이미지를 복사하여 썸네일 업로드, 이름이 같으면 덮어쓰기
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
			
			service.review_writeImage(dto);
            
        }
        
		
		service.review_write(dto);
		
		return "redirect:/review/review_listPageSearch?num=1";
	}

	// 여행후기 조회
	@RequestMapping(value = "/review_view", method = RequestMethod.GET)
	public void getView(@RequestParam("review_bno") int review_bno, Model model) throws Exception {
		
		BoardDTO dto = service.review_view(review_bno);
		
		List<BoardDTO> list = null;
		list = service.review_viewImage(review_bno);
		
		model.addAttribute("view", dto);
		model.addAttribute("list", list);

		// 댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.review_list(review_bno);
		model.addAttribute("reply", reply);
		
	}

	// 여행후기 수정
	@RequestMapping(value = "/review_modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("review_bno") int review_bno, Model model) throws Exception {
		BoardDTO dto = service.review_view(review_bno);

		model.addAttribute("view", dto);
	}

	// 여행후기 수정
	@RequestMapping(value = "/review_modify", method = RequestMethod.POST)
	public String postModify(BoardDTO dto) throws Exception {
		service.review_modify(dto);

		return "redirect:/review/review_view?review_bno=" + dto.getReview_bno();
	}

	// 여행후기 삭제
	@RequestMapping(value = "/review_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("review_bno") int review_bno) throws Exception {
		service.review_delete(review_bno);

		return "redirect:/review/review_listPageSearch?num=1";
	}

	// 여행후기 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/review_listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.review_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> list = null;
		list = service.review_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/review_updateLike", method = RequestMethod.GET)
	public void gettUpdateLike() throws Exception {
		
	}
	
	//게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/review_updateLike" , method = RequestMethod.POST)
	public int postUpdateLike(int review_bno, int user_num)throws Exception{

		int likeCheck = service.review_likeCheck(review_bno, user_num);
		if (likeCheck == 0) {
			// 좋아요 처음누름
			service.review_insertLike(review_bno, user_num); // like테이블 삽입
			service.review_updateLike(review_bno); // 게시판테이블 +1
			service.review_updateLikeCheck(review_bno, user_num);// like테이블 구분자 1
		} else if (likeCheck == 1) {
			service.review_updateLikeCheckCancel(review_bno, user_num); // like테이블 구분자0
			service.review_updateLikeCancel(review_bno); // 게시판테이블 - 1
			service.review_deleteLike(review_bno, user_num); // like테이블 삭제
		}
		return likeCheck;
	}
	
}
