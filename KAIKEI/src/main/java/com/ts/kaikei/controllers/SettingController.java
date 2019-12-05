package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.SettingService;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

@Controller
public class SettingController {

	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;

	
	/* go to personal info page */
	@RequestMapping(value = "/setting/personal.do", method =  RequestMethod.GET)
	public String ledger(HttpSession session, Model model) {
		logger.info("Call : /setting/personal.do - GET");

		String id = (String) session.getAttribute("id");

		model.addAttribute("userVO", settingService.getUserById(id));
		
		return "/setting/personal";
	}
	
	/* go to change personal info  page */
	@RequestMapping(value = "/setting/personalChangePage.do", method = RequestMethod.GET)
	public String personalChangePage(HttpSession session, Model model) {
		logger.info("Call : /setting/personalChangePage.do - GET");
	
		String id = (String)session.getAttribute("id");
		
		model.addAttribute("userVO", settingService.getUserById(id));
		
		return "/setting/personalChangePage";
	}
	
	/* change personal info */
	@RequestMapping(value = "/setting/personalChange.do", method = RequestMethod.POST)
	public String personalChange(UserVO userVO, Model model) {
		logger.info("Call : /setting/personalChange.do - POST");
		
		settingService.updateUser(userVO);
		
		return "/setting/personal";
	}
	
	/* go to company info page */
	@RequestMapping(value = "/setting/company.do", method = RequestMethod.GET)
	public String companyPage(HttpSession session, Model model) {
		logger.info("Call : /setting/company.do - GET");
		
		String posit_cd = (String)session.getAttribute("posit_cd");
		
		if(posit_cd.equals("POS003")) {
			return "redirect:/error.do";
		}
		
		String company_cd = (String)session.getAttribute("company_cd");

		model.addAttribute("companyVO", settingService.getCompany(company_cd));
		
		return "/setting/company";
	}
	
	/* go to change company info page */
	@RequestMapping(value = "/setting/companyChangePage.do", method = RequestMethod.GET)
	public String companyChangePage(HttpSession session, Model model) {
		logger.info("Call : /setting/companyChangePage.do - GET");
		
		String posit_cd = (String)session.getAttribute("posit_cd");
		
		if(posit_cd.equals("POS003")) {
			return "redirect:/error.do";
		}

		String company_cd = (String)session.getAttribute("company_cd");

		model.addAttribute("companyVO", settingService.getCompany(company_cd));
		
		return "/setting/companyChangePage";
	}
	
	/* change company info */
	@RequestMapping(value = "/setting/companyChange.do", method = RequestMethod.POST)
	public String companyChange(CompanyVO companyVO) {
		logger.info("Call : /setting/companyChange.do - POST");

		settingService.updateCompany(companyVO);
		
		return "/setting/company";
	}
}
