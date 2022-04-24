package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	//게시물 목록
	@Override
	public List<BoardDTO> list() throws Exception {
		return dao.list();
	}

	//게시물 작성
	@Override
	public void write(BoardDTO dto) throws Exception {
		dao.write(dto);
	}

	//게시물 조회 
	@Override
	public BoardDTO view(int board_bno) throws Exception {
		return dao.view(board_bno);
	}
	
	//게시글 수정
	@Override
	public void modify(BoardDTO dto) throws Exception {
		dao.modify(dto);
	}

	//게시글 삭제
	@Override
	public void delete(int board_bno) throws Exception {
		dao.delete(board_bno);
	}
	
	//게시글 총 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	//게시글 목록 + 페이징
	@Override
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}
	
	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return dao.searchCount(searchType, keyword);
	}
}