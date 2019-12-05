package com.ts.kaikei.controllers;

import javax.servlet.http.HttpServletRequest;
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
	public String ledger(HttpServletRequest request, Model model) {
		logger.info("Call : /setting/personal.do - GET");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO = settingService.getUserById(userVO);
		model.addAttribute("userVO", userVO);
		return "/setting/personal";
	}
	
	/* go to change personal info  page */
	@RequestMapping(value = "/setting/personalChangePage.do", method = RequestMethod.GET)
	public String personalChangePage(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO = settingService.getUserById(userVO);
		
		model.addAttribute("userVO", userVO);
		
		logger.info("Call : /setting/personalChangePage.do - GET");
		return "/setting/personalChangePage";
	}
	
	/* change personal info */
	@RequestMapping(value = "/setting/personalChange.do", method = RequestMethod.POST)
	public String personalChange(HttpServletRequest request) {
		
		UserVO userVO = new UserVO();
		
		userVO.setId(request.getParameter("id"));
		userVO.setPassword(request.getParameter("password"));
		userVO.setName(request.getParameter("name"));
		userVO.setEmail(request.getParameter("email"));
		userVO.setPhone(request.getParameter("phone"));
		
		settingService.updateUser(userVO);
		
		return "/setting/personal";
	}
	
	/* go to company info page */
	@RequestMapping(value = "/setting/company.do", method = RequestMethod.GET)
	public String companyPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		UserVO userVO = new UserVO();
		userVO.setId((String) session.getAttribute("id"));
		userVO  = settingService.getUserById(userVO);
		
		String company_cd = userVO.getCompany_cd();
		
		CompanyVO companyVO = new CompanyVO();
		
		companyVO.setCompany_cd(company_cd);
		companyVO = settingService.getCompany(companyVO);
		
		model.addAttribute("companyVO", companyVO);
		
		logger.info("Call : /setting/companyPage.do - GET");
		
		return "/setting/company";
	}
	
	/* go to change company info page */
	@RequestMapping(value = "/setting/companyChangePage.do", method = RequestMethod.GET)
	public String companyChangePage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		UserVO userVO = new UserVO();
		
		userVO.setId((String) session.getAttribute("id"));
		userVO  = settingService.getUserById(userVO);
		
		CompanyVO companyVO = new CompanyVO();
		
		String company_cd = userVO.getCompany_cd();
		
		companyVO.setCompany_cd(company_cd);
		companyVO = settingService.getCompany(companyVO);
		model.addAttribute("companyVO", companyVO);
		
		logger.info("Call : /setting/companyChangePage.do - GET");
		
		return "/setting/companyChangePage";
	}
	
	/* change company info */
	@RequestMapping(value = "/setting/companyChange.do", method = RequestMethod.POST)
	public String companyChange(HttpServletRequest request) {
		
		CompanyVO companyVO = new CompanyVO();
		
		companyVO.setCompany_cd(request.getParameter("company_cd"));
		// companyVO.company_logo
		companyVO.setRegist_cd(request.getParameter("reg_cd"));
		companyVO.setFax(request.getParameter("fax"));
		companyVO.setPhone(request.getParameter("phone"));
		companyVO.setDomain(request.getParameter("domain"));
		companyVO.setBank_title(request.getParameter("bank_title"));
		
		settingService.updateCompany(companyVO);
		
		return "/setting/company";
	}
}
