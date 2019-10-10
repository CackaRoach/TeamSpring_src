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
@RequestMapping("/addBoard.do")
@SessionAttributes({"userVO"})
public class AddBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddBoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("userVO")
	public UserVO userVO() {
		UserVO userVO = new UserVO();
		return userVO;
	}
	
	
	// Menu-Click
	@RequestMapping(method = RequestMethod.GET)
	public String showAddBoardList(@ModelAttribute("userVO") UserVO userVO,
								     Model model) {
		logger.info("Call : showAddBoardList - GET NAME : " + userVO.getName());
		
		if(userVO.getId() == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("action", "addBoard.do");
		 
		return "inputBoard";
	}
	
	// Submit
	@RequestMapping(method = RequestMethod.POST)
	public String addBoardList(@ModelAttribute("userVO") UserVO userVO, 
								BoardVO boardVO,
								  Model model) {
		logger.info("Call : AddBoardList.jsp - POST INDEX : " + boardVO.getIdx());

		boardVO.setAuthor_id(userVO.getId());
		boardVO.setAuthor_name(userVO.getName());
		
		boardService.addBoard(boardVO);

		
		return "redirect:getBoardList.do";
	}
}
