package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.UserVO;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Call : /login.do - GET");
		
		return "login";
	}
	

	@RequestMapping(value = "/main.do", method = RequestMethod.POST)
	public String loginExc(UserVO userVO, HttpSession httpSession, Model model) {
		logger.info("Call : /main.do - POST");
		
		UserVO getUserVO = commonService.getUser(userVO); 
			
		if(getUserVO == null) {
			logger.info("Login Err");
			return "login";
		}

		httpSession.setAttribute("userVO", getUserVO);
		return "/common/main";	
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		logger.info("Call : /logout.do - GET");
		
		httpSession.invalidate();
		
		return "login";	
	}
	
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(HttpSession httpSession, Model model) {
		logger.info("Call : /error.do - GET");
		
		return "error";	
	}
}
