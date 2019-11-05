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
import java.util.*;
import com.ts.kaikei.vo.*;
import com.ts.kaikei.dao.*;

@Controller
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	private CustomerDAO customerDAO;

	/*
	 *  @RequestMapping(value = "/account/*.do")
	 */
	
	@RequestMapping(value = "/account/ledger.do", method = RequestMethod.GET)
	public String ledger(StatementVO sVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/ledger.jsp - GET");
		
		String company_cd = ((UserVO)httpSession.getAttribute("userVO")).getCompany_cd();
		
		List<StatementVO> list = accountService.getStatements(company_cd);
		list = codeToName(list);
		
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}
	
	private List<StatementVO> codeToName(List<StatementVO> list) {
		for(StatementVO s : list) {
			s.setCustomer_cd(customerDAO.getCustomerTitle(s.getCustomer_cd()));
		}
		
		return list;
	}
}
