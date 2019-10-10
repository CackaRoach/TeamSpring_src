package com.test.springboard.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.springboard.services.UserService;
import com.test.springboard.vo.UserVO;


@Controller
@RequestMapping("/login.do")
@SessionAttributes({"userVO"})
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	// index CALL
	@RequestMapping(method = RequestMethod.GET)
	public String showLogin(Model model) {
		logger.info("Call : login.jsp - GET");

		return "login";
	}
	
	// Submit
	@RequestMapping(method = RequestMethod.POST)
	public String login(UserVO userVO, Model model) {
		logger.info("Call : login.jsp - POST");

		UserVO loginResult = userService.getUser(userVO); 
		
		if(loginResult == null) {
			model.addAttribute("userVO", userVO);
			model.addAttribute("state", "Incorrect username or password");
			
			return "login";
		}
		
		model.addAttribute("userVO", loginResult);
		return "redirect:getBoardList.do";
	}
	
}
