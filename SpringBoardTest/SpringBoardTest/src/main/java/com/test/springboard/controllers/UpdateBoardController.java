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
@RequestMapping("/updateBoard.do")
@SessionAttributes({"userVO", "boardVO"})
public class UpdateBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateBoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("userVO")
	public UserVO userVO() {
		UserVO userVO = new UserVO();
		return userVO;
	}
	
	@ModelAttribute("boardVO")
	public BoardVO boardVO() {
		BoardVO boardVO = new BoardVO();
		return boardVO;
	}
	
	// Menu-Click
	@RequestMapping(method = RequestMethod.GET)
	public String showUpdateBoardList(@ModelAttribute("userVO") UserVO userVO,
								    @ModelAttribute("boardVO") BoardVO boardVO,
								     Model model) {
		logger.info("Call : showUpdateBoardList - GET NAME : " + userVO.getName());
		
		
		if(userVO.getId() == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("action", "updateBoard.do");
		
		return "inputBoard";
	}
	
	// Submit
	@RequestMapping(method = RequestMethod.POST)
	public String updateBoardList(@ModelAttribute("userVO") UserVO userVO, 
								@ModelAttribute("boardVO") BoardVO boardVO,
								  Model model) {
		logger.info("Call : showUpdateBoardList - POST INDEX : " + boardVO.getIdx());
		
		boardService.updateBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
}
