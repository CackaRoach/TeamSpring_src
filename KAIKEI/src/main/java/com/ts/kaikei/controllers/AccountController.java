package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;
import java.util.*;
import com.ts.kaikei.vo.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.AccountService;

@Controller
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;

	/*
	 *  @RequestMapping(value = "/account/*.do")
	 */
	
	@RequestMapping(value = "/account/ledger.do", method = RequestMethod.GET)
	public String ledger(HttpSession httpSession, Model model) {
		// Load first 30 statements
		
		logger.info("Call : /account/ledger.jsp - GET");
		
		ArrayList<StatementVO> list = new ArrayList<StatementVO>(accountService.getStatements());
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}
	
	@RequestMapping(value = "/account/searchStatements.do", method = RequestMethod.POST)
	public String searchStatements(HttpSession httpSession, Model model) {
		logger.info("Call : /account/searchStatements.jsp - GET");
		
		StatementKeyVO keyword = new StatementKeyVO();
		// keyword should be set from user.
		
		ArrayList<StatementVO> list = new ArrayList<StatementVO>(accountService.getStatements(keyword));
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}
}