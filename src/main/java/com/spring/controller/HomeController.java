package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
import com.spring.service.BoardService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	BoardService service;
	
	// 메인 화면 '/' 입력 시 메인화면으로 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) throws Exception {
		
		// 여행후기 베스트 게시글 목록
		List<BoardDTO> list = null;
		list = service.review_bestList();

		model.addAttribute("list", list);
		
		return "index";
	}
}
