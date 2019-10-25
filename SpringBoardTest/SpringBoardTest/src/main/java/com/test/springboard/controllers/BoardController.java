package com.test.springboard.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.springboard.services.BoardService;
import com.test.springboard.vo.BoardVO;
import com.test.springboard.vo.UserVO;


@Controller
@RequestMapping("/")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "getBoardList.do", method = RequestMethod.GET)
	public String showBoard(HttpSession httpSession, Model model) {
		logger.info("Call : GetBoardList - GET");
		
		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("boardList", boardService.getBoardList());
		
		return "boardList";
	}
	
	@RequestMapping(value = "getBoardListCond.do", method = RequestMethod.POST)
	public String getBoardListCond(String searchCondition,
								    String searchKeyword, 
								     HttpSession httpSession,
								      Model model) {
		
		logger.info("Call : GetBoardList - POST");
		logger.info("Call : GetBoardList - POST searchCondition : " + searchCondition);
		logger.info("Call : GetBoardList - POST searchKeyword : " + searchKeyword);
		
		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		// mybatis send 2 Params (key - #{key})
		Map<String, String> searchParams = new HashMap<String, String>();
		
		searchParams.put("searchCondition", searchCondition);
		searchParams.put("searchKeyword", searchKeyword);
		
		model.addAttribute("boardList", boardService.getBoardList(searchParams));

		return "boardList";
	}
	
	@RequestMapping(value = "getBoardDetail.do", method = RequestMethod.GET)
	public String showGetBoardDetail(UserVO userVO,
									  BoardVO boardVO,
									   HttpSession httpSession,
									    Model model) {
		logger.info("Call : showGetBoardDetail - GET INDEX : " + boardVO.getIdx());
		
		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		BoardVO result = boardService.getBoardDetail(boardVO.getIdx());
		
		model.addAttribute("userVO", userVO);
		model.addAttribute("author_id", result.getAuthor_id());
		model.addAttribute("boardVO", result);
	
		return "boardDetail";
	}
	
	@RequestMapping(value = "updateBoard.do", method = RequestMethod.GET)
	public String showUpdateBoardList(UserVO userVO,
								      BoardVO boardVO,
								       HttpSession httpSession,
								        Model model) {
		logger.info("Call : showUpdateBoardList - GET NAME : " + userVO.getName());
		
		
		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("action", "updateBoard.do");
		
		return "inputBoard";
	}
	
	// Submit
	@RequestMapping(value = "updateBoard.do",method = RequestMethod.POST)
	public String updateBoardList(@ModelAttribute("userVO") UserVO userVO, 
								@ModelAttribute("boardVO") BoardVO boardVO,
								  Model model) {
		logger.info("Call : showUpdateBoardList - POST INDEX : " + boardVO.getIdx());
		
		boardService.updateBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "deleteBoard.do", method = RequestMethod.GET)
	public String showDeleteBoardList(@ModelAttribute("userVO") UserVO userVO,
									@ModelAttribute("author_id") String author_id,
									 int idx, Model model) {
		logger.info("Call : AddBoardList.jsp - GET DELETE INDEX : " + idx);
		logger.info("Call : AddBoardList.jsp - GET DELETE AUTHOR_ID : " + author_id);
		
		if(userVO.getId() == null) {
			return "redirect:login.do";
		} else if(!userVO.getId().equals(author_id)) {
			return "redirect:logout.do";
		}
		

		boardService.deleteBoard(idx);
		
		return "redirect:getBoardList.do";
	}
	
	// Menu-Click
	@RequestMapping(value = "addBoard.do", method = RequestMethod.GET)
	public String addBoard(HttpSession httpSession, Model model) {
		logger.info("Call : addBoard - GET");
		
		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("action", "addBoard.do");
		 
		return "inputBoard";
	}
	
	// Submit
	@RequestMapping(value = "addBoardExc.do", method = RequestMethod.POST)
	public String addBoardExc(BoardVO boardVO,
							   HttpSession httpSession,
								Model model) {
		logger.info("Call : addBoardExc - POST INDEX : " + boardVO.getIdx());

		if(httpSession.getAttribute("id") == null) {
			return "redirect:login.do";
		}
		
		boardVO.setAuthor_id((String)httpSession.getAttribute("id"));
		boardVO.setAuthor_name((String)httpSession.getAttribute("name"));
		
		boardService.addBoard(boardVO);

		
		return "redirect:getBoardList.do";
	}
}
