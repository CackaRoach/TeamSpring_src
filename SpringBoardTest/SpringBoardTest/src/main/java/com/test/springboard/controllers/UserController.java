package com.test.springboard.controllers;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.springboard.services.UserService;
import com.test.springboard.vo.UserVO;


@Controller
@RequestMapping("/")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	// index CALL
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String showLogin(Model model) {
		logger.info("Call : login.jsp - GET");
		
		return "login";
	}
	
	// Submit
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession httpSession, Model model) {
		logger.info("Call : login.jsp - POST");

		UserVO loginResult = userService.getUser(userVO); 
		
		if(loginResult == null) {
			model.addAttribute("userVO", userVO);
			model.addAttribute("state", "Incorrect username or password");
			
			return "login";
		}
		
		httpSession.setAttribute("Id", loginResult.getId());
		httpSession.setAttribute("Name", loginResult.getName());
		model.addAttribute("userVO", loginResult);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String showLogout(HttpSession httpSession, Model model) {
		logger.info("Call : logout.jsp - GET");
		
		httpSession.invalidate();
		
		return "redirect:login.do";
	}
	
	// Submit
	@RequestMapping(value = "regist.do", method = RequestMethod.POST)
	public String regist(UserVO userVO, Model model) {
		logger.info("Call : regist - POST");
		logger.info("UserVO Id = " + userVO.getId());
		logger.info("UserVO Name = " + userVO.getName());

		userService.registUser(userVO); 

		return "redirect:login.do";
	}
	
	@RequestMapping(value = "regist/checkId.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkId(String userId, Model model) {
		logger.info("Call : checkId AJAX - " + userId);
		int how = userService.checkUserId(userId);
		logger.info(" " + how);
		return how;
	}
}
