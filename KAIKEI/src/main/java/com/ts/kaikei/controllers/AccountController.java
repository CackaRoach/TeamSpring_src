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
import com.ts.kaikei.vo.StatementVO;
import com.ts.kaikei.vo.UserVO;

@Controller
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/account/ledger.do", method = RequestMethod.GET)
	public String ledger(HttpSession httpSession, Model model) {
		logger.info("Call : /account/ledger.do - GET");
		
		String company_cd = ((UserVO)httpSession.getAttribute("userVO")).getCompany_cd();
		
		List<StatementVO> list = accountService.getStatements(company_cd);
		
		model.addAttribute("statements", list);
		
		return "/account/ledger";
	}
	
	@RequestMapping(value = "/account/customer.do", method = RequestMethod.GET)
	public String customer(String searchParam, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customer.do - GET");
		
		model.addAttribute("customerList", accountService.getCustomerList(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), searchParam));
		
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
		logger.info("Call : /account/customerCodeCheck.do - GET" + accountService.customerCodeCheck(cus_cd, ((UserVO)httpSession.getAttribute("userVO")).getCompany_cd()));
		
		return accountService.customerCodeCheck(cus_cd, ((UserVO)httpSession.getAttribute("userVO")).getCompany_cd());
		
	}
	
	@RequestMapping(value = "/account/customerAddExc.do", method = RequestMethod.POST)
	public String customerAddExc(CustomerVO customerVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerAddExc.do - GET");
		 
		if(!accountService.addCustomer(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), customerVO, ((UserVO)httpSession.getAttribute("userVO")).getId())) {
			model.addAttribute("errorMsg", "REGIST CUSTOMER ERROR");
			return "/error";
		}
		
		return "redirect:/account/customer.do";
	}
	
	@RequestMapping(value = "/account/customerDetail.do", method = RequestMethod.GET)
	public String customerDetail(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerDetail.do - GET");
		
		model.addAttribute("customerVO", accountService.getCustomerDetail(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), cus_cd));
		
		return "/account/customerDetail";
	}
	
	@RequestMapping(value = "/account/customerModify.do", method = RequestMethod.GET)
	public String customerModify(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerModify.do - GET");
		
		model.addAttribute("customerVO", accountService.getCustomerDetail(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), cus_cd));
		
		return "/account/customerModify";
	}
	
	@RequestMapping(value = "/account/customerModifyExc.do", method = RequestMethod.POST)
	public String customerModify(CustomerVO customerVO, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerModifyExc.do - GET");
		
		if(!accountService.updateCustomer(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), customerVO,
				((UserVO)httpSession.getAttribute("userVO")).getId())) {
			model.addAttribute("errorMsg", "UPDATE CUSTOMER ERROR");
			return "/error";
		}
		
		return "redirect:/account/customerDetail.do?cus_cd=" + customerVO.getCus_cd();
	}
	
	@RequestMapping(value = "/account/customerDelete.do", method = RequestMethod.GET)
	public String customerDelete(String cus_cd, HttpSession httpSession, Model model) {
		logger.info("Call : /account/customerDelete.do - GET");
		
		if(accountService.deleteCustomer(((UserVO)httpSession.getAttribute("userVO")).getCompany_cd(), cus_cd));
		
		return "redirect:/account/customer.do";
	}
}
