package com.test.springboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/logout.do")
@SessionAttributes({"userVO", "author_id", "searchCondition", "searchKeyword"})
public class LogoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLogout(SessionStatus session, Model model) {
		logger.info("Call : logout.jsp - GET");

		session.setComplete();
		
		return "redirect:login.do";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String logout(SessionStatus session, Model model) {
		logger.info("Call : login.jsp - POST");
		
		session.setComplete();
		
		return "redirect:login.do";
	}
	
}