package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.UserVO;

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
		logger.info("Call : /account/ledger.jsp - GET");
		
		return "/account/ledger";
	}
}
