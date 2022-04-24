package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDTO;


public interface BoardService {
	
	//게시물 목록
	public List<BoardDTO> list() throws Exception;
	
	//게시물 작성
	public void write(BoardDTO dto) throws Exception;
	
	//게시물 조회
	public BoardDTO view(int board_bno) throws Exception;
	
	//게시글 수정
	public void modify(BoardDTO dto) throws Exception;
	
	//게시글 삭제
	public void delete(int board_bno) throws Exception;
	
	//게시글 총 갯수
	public int count() throws Exception;
	
	//게시글 목록 + 페이징
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception;

	// 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 게시물 총 갯수 + 검색 적용
	public int searchCount(String searchType, String keyword) throws Exception;
}