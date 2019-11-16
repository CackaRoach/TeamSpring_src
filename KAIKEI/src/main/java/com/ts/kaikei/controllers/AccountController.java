package com.ts.kaikei.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.ts.kaikei.services.AccountService;

import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;
import com.ts.kaikei.vo.StatementVO;
import com.ts.kaikei.vo.UserVO;

@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired 
	private AccountService accountService;
	
	
	/*
	 * =====================================
	 *         STATEMEMT CONTROLLER
	 * =====================================
	 */

	@RequestMapping(value = "/account/ledger.do", method = RequestMethod.GET)
	public String ledger(HttpSession httpSession, Model model) {
		logger.info("Call : /account/ledger.do - GET");

		String company_cd = httpSession.getAttribute("company_cd").toString();

		List<StatementListVO> list = accountService.getStatements(company_cd);
		
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}

	@RequestMapping(value = "/account/addStatement.do", method = RequestMethod.POST)
	public String addStatement(StatementVO statementVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/addStatement.do - POST");
		
		String userId = httpSession.getAttribute("id").toString();
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		accountService.addStatement(statementVO, userId, company_cd);
		
		return "redirect:/account/ledger.do";

	}
	
	/*
	 * =====================================
	 *          CUSTOMER CONTROLLER
	 * =====================================
	 */
	
	// TODO: Add Contact
	@RequestMapping(value = "/account/customer.do", method = RequestMethod.GET)
	public String customer(String searchParam, String pageNum, HttpSession httpSession, Model model) {
		// TODO: Customer Page Paging;
		
		logger.info("Call : /account/customer.do - GET");
		 
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		model.addAttribute("pageNum", accountService.getCustomerCount(company_cd, searchParam));
		model.addAttribute("customerList", accountService.getCustomerList(company_cd, searchParam, pageNum));
		model.addAttribute("searchParam", searchParam);
		
		return "/account/customer";
	}
	
	@RequestMapping(value = "/account/customerAdd.do", method = RequestMethod.GET)
	public String customerAdd(CustomerVO customerVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerAdd.do - GET");
		
		return "/account/customerAdd";
	}
	
	@RequestMapping(value = "/account/customerCodeCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public int customerCodeCheck(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerCodeCheck.do - GET" + accountService.customerCodeCheck(cus_cd, httpSession.getAttribute("company_cd").toString()));
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		return accountService.customerCodeCheck(cus_cd, company_cd);
	}
	
	@RequestMapping(value = "/account/customerAddExc.do", method = RequestMethod.POST)
	public String customerAddExc(CustomerVO customerVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerAddExc.do - GET");
		 
		String company_cd = httpSession.getAttribute("company_cd").toString();
		String id = httpSession.getAttribute("id").toString();
		
		if(!accountService.addCustomer(company_cd, customerVO, id)) {
			model.addAttribute("errorMsg", "REGIST CUSTOMER ERROR");
			return "/error";
		}
		
		return "redirect:/account/customer.do";
	}
	
	@RequestMapping(value = "/account/customerDetail.do", method = RequestMethod.GET)
	public String customerDetail(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerDetail.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		model.addAttribute("customerVO", accountService.getCustomerOf(company_cd, cus_cd));
		
		return "/account/customerDetail";
	}
	
	@RequestMapping(value = "/account/customerModify.do", method = RequestMethod.POST)
	public String customerModify(CustomerVO customerVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerModify.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		String id = httpSession.getAttribute("id").toString();
		
		if(!accountService.updateCustomer(company_cd, customerVO, id)) {
			model.addAttribute("errorMsg", "UPDATE CUSTOMER ERROR");
			return "/error";
		}
		
		
		return "redirect:/account/customerDetail.do?cus_cd=" + customerVO.getCus_cd();
	}
	
	@RequestMapping(value = "/account/customerDelete.do", method = RequestMethod.GET)
	public String customerDelete(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerDelete.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		if(accountService.deleteCustomer(company_cd, cus_cd));
		
		return "redirect:/account/customer.do";
	}
}
