package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.ManageService;


@Controller
@RequestMapping("/manage/")
public class ManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	private ManageService manageService;

	// Submit
	@RequestMapping(value = "test.do", method = RequestMethod.POST)
	public String test(Model model) {
		logger.info("Call : Test");

		return "login";
	}
}
