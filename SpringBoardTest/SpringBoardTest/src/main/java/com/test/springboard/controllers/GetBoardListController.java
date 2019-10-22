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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.springboard.services.BoardService;
import com.test.springboard.vo.UserVO;


@Controller
@RequestMapping("/getBoardList.do")
public class GetBoardListController {
	
	private static final Logger logger = LoggerFactory.getLogger(GetBoardListController.class);
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(method = RequestMethod.GET)
	public String showGetBoardList(HttpSession httpSession, Model model) {
		logger.info("Call : GetBoardList - GET NAME : " + httpSession.getAttribute("Id"));
		
		if(httpSession.getAttribute("Id") == null) {
			return "redirect:login.do";
		} else {
			model.addAttribute("boardList", boardService.getBoardList());
			model.addAttribute("boardListDAO", boardService.getBoardList().get(0));
		}
		
		return "boardList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getBoardList(HttpSession httpSession,
								String searchCondition,
								 String searchKeyword, 
								  Model model) {
		// TODO Detail -> List Sesison ->> GET?
		
		logger.info("Call : GetBoardList - POST");
		logger.info("Call : GetBoardList - POST searchCondition : " + searchCondition);
		logger.info("Call : GetBoardList - POST searchKeyword : " + searchKeyword);
		
		if(httpSession.getAttribute("Id") == null) {
			return "redirect:login.do";
		} else {
		
			// mybatis send 2 Params (key - #{key})
			Map<String, String> searchParams = new HashMap<String, String>();
			
			searchParams.put("searchCondition", searchCondition);
			searchParams.put("searchKeyword", searchKeyword);
			
			model.addAttribute("boardList", boardService.getBoardList(searchParams));
			model.addAttribute("searchCondition", searchCondition);
			model.addAttribute("searchKeyword", searchKeyword);
		}

		return "boardList";
	}
}
