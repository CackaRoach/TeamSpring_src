package com.test.springboard.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.springboard.services.BoardService;

import com.test.springboard.vo.BoardVO;
import com.test.springboard.vo.UserVO;


@Controller
@RequestMapping("/getBoardDetail.do")
@SessionAttributes({"userVO", "author_id"})
public class GetBoardDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(GetBoardDetailController.class);
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("userVO")
	public UserVO userVO() {
		UserVO userVO = new UserVO();
		return userVO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showGetBoardDetail(@ModelAttribute("userVO") UserVO userVO,
									  BoardVO boardVO,
									   Model model) {
		logger.info("Call : showGetBoardDetail - GET INDEX : " + boardVO.getIdx());
		
		if(userVO.getId() == null) {
			return "redirect:login.do";
		}
		
		BoardVO result = boardService.getBoardDetail(boardVO.getIdx());
		
		model.addAttribute("userVO", userVO);
		model.addAttribute("author_id", result.getAuthor_id());
		model.addAttribute("boardVO", result);
		
		return "boardDetail";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getBoardDetail(BoardVO boardVO, Model model) {
		logger.info("X");

		return "";
	}
	
}
