package com.test.springboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.springboard.services.UserService;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	private UserService userService;

	// CALL
	@RequestMapping(value="/regist/checkId.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkId(String userId, Model model) {
		logger.info("Call : checkId AJAX - " + userId);
		int how = userService.checkUserId(userId);
		logger.info(" " + how);
		return how;
	}
	
}