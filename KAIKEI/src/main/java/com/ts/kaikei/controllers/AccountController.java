package com.ts.kaikei.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.ts.kaikei.services.AccountService;

import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;

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
	public String ledger(   String year,
							String month,
							String crtPage,
							HttpSession httpSession, 
							Model model) {
		logger.info("Call : /account/ledger.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		if(year == null) {
			Calendar calendar = Calendar.getInstance();
			
			year = String.valueOf(calendar.get(Calendar.YEAR));
			month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		}
			
		List<StatementListVO> list = accountService.getStatements(company_cd, year, month, crtPage);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}

	@RequestMapping(value = "/account/statementSave.do", method = RequestMethod.POST)
	@ResponseBody
	public void statementSave(@RequestBody List<Map<String, String>> jsonState, 
								HttpSession httpSession, 
								Model model) {
		
		logger.info("Call : /account/addStatement.do - POST");
		
		String userId = httpSession.getAttribute("id").toString();
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		accountService.addStatement(jsonState, userId, company_cd);

	}
	
	/*
	 * =====================================
	 *          CUSTOMER CONTROLLER
	 * =====================================
	 */
	
	// TODO: Add Contact
	@RequestMapping(value = "/account/customer.do", method = RequestMethod.GET)
	public String customer(	String searchParam, 
							String crtPage, 
							HttpSession httpSession, 
							Model model) {
		
		logger.info("Call : /account/customer.do - GET");
		logger.info("searchParam : " + searchParam);
		logger.info("crtPage : " + crtPage);
		 
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		/*  0 index - FAX = PAGE NUM  */
		/*  DEFAULT CUSTOMER COUNT PER PAGE = 20  */
		model.addAttribute("customerList", accountService.getCustomerList(company_cd, searchParam, crtPage, "20"));
		model.addAttribute("searchParam", searchParam);
		
		return "/account/customer";
	}
	
	@RequestMapping(value = "/account/customerAdd.do", method = RequestMethod.GET)
	public String customerAdd(	CustomerVO customerVO, 
								HttpSession httpSession, 
								Model model) {
		
		logger.info("Call : /account/customerAdd.do - GET");
		
		return "/account/customerAdd";
	}
	
	@RequestMapping(value = "/account/customerCodeCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public int customerCodeCheck(	String cus_cd, 
									HttpSession httpSession, 
									Model model) {
		
		logger.info("Call : /account/customerCodeCheck.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		return accountService.customerCodeCheck(cus_cd, company_cd);
	}
	
	@RequestMapping(value = "/account/customerAddExc.do", method = RequestMethod.POST)
	public String customerAddExc(	CustomerVO customerVO, 
									HttpSession httpSession, 
									Model model) {
		
		logger.info("Call : /account/customerAddExc.do - GET");
		 
		String company_cd = httpSession.getAttribute("company_cd").toString();
		String id = httpSession.getAttribute("id").toString();
		
		accountService.addCustomer(company_cd, customerVO, id);
		
		return "redirect:/account/customer.do";
	}
	
	@RequestMapping(value = "/account/customerDetail.do", method = RequestMethod.GET)
	public String customerDetail(	String cus_cd, 
									HttpSession httpSession, 
									Model model) {
		
		logger.info("Call : /account/customerDetail.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		model.addAttribute("customerVO", accountService.getCustomerOf(company_cd, cus_cd));
		
		return "/account/customerDetail";
	}
	
	@RequestMapping(value = "/account/customerModify.do", method = RequestMethod.POST)
	@ResponseBody
	public void customerModify(	CustomerVO customerVO, 
								HttpSession httpSession, 
								Model model) {
		
		logger.info("Call : /account/customerModify.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		String id = httpSession.getAttribute("id").toString();
		
		accountService.updateCustomer(company_cd, customerVO, id);

	}
	
	@RequestMapping(value = "/account/customerDelete.do", method = RequestMethod.GET)
	public String customerDelete(	String cus_cd, 
									HttpSession httpSession, 
									Model model) {
		
		logger.info("Call : /account/customerDelete.do - GET");
		
		String company_cd = httpSession.getAttribute("company_cd").toString();
		
		accountService.deleteCustomer(company_cd, cus_cd);
		
		return "redirect:/account/customer.do";
	}
}
