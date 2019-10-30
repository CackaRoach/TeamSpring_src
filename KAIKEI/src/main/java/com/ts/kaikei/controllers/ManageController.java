package com.ts.kaikei.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//1. COMPANY MANAGEMENT - LIST
	@RequestMapping(value = "/manage/company.do", method = RequestMethod.GET)
	public String ledger( 	Model model,
							String PAGE,
							String FIND) {
		logger.info("Call : /manage/company.do - GET");
		
		if(PAGE == "" || PAGE == null) {
			PAGE = "1";
		}
		
		
		
		
		
		return "/manage/company";
	} 
	
	//2. USER MANAGEMENT - LIST
	@RequestMapping(value = "/manage/users.do", method = RequestMethod.GET)
	public String userList( Model model,
							String PAGE,
							String FIND) {
		
		Map<String, Object> Params = new HashMap<String, Object>();
		
		if(PAGE == "" || PAGE == null) {
			PAGE = "1";
		}
		
		Params.put("PAGE", PAGE);
		Params.put("FIND", FIND);
		
		/*
		 * List<UserVo> UserList = manageService.getUser(Params);
		 * 
		 */
		 return "/manage/user";
		
	} 
	
	//3. CODE MANAGEMENT
	@RequestMapping(value = "/manage/code.do", method = RequestMethod.GET)
	public String codeList( Model model ) {
		
		return "/manage/code"; //commit
	}
}
