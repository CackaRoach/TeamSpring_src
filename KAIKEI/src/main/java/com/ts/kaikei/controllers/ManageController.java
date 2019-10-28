package com.ts.kaikei.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.services.ManageService;

@Controller
public class ManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	private ManageService manageService;

	/*
	 *  @RequestMapping(value = "/manage/*.do")
	 */
	
	//1. COMPANY MANAGEMENT
	@RequestMapping(value = "/manage/company.do", method = RequestMethod.GET)
	public String ledger(Model model) {
		logger.info("Call : /manage/company.do - GET");
		
		return "/manage/company";
	} 
	
	//2. USER MANAGEMENT
	@RequestMapping(value = "/manage/users.do", method = RequestMethod.GET)
	public String userList(Model model) {
		
		return "/manage/user";
	} 
	
	//3. CODE MANAGEMENT
	@RequestMapping(value = "/manage/code.do", method = RequestMethod.GET)
	public String codeList(Model model) {
		
		return "/manage/code";
	}
}
