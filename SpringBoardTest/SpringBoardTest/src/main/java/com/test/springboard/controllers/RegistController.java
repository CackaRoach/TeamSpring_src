package com.test.springboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.test.springboard.services.UserService;
import com.test.springboard.vo.UserVO;

@Controller
@RequestMapping("/regist.do")
public class RegistController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistController.class);
	
	@Autowired
	private UserService userService;

	// CALL
	@RequestMapping(method = RequestMethod.GET)
	public String showRegist(Model model) {

		return "register";
	}
	
	// Submit
	@RequestMapping(method = RequestMethod.POST)
	public String regist(UserVO userVO, Model model) {
		logger.info("Call : regist - POST");
		logger.info("UserVO Id = " + userVO.getId());
		logger.info("UserVO Name = " + userVO.getName());

		userService.registUser(userVO); 

		return "redirect:login.do";
	}
	
}
