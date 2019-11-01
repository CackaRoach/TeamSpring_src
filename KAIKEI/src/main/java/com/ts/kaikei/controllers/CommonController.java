package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.UserVO;


// TODO : Logout - Layout(height, width %) modify

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	
	// Login Page Forwarding
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Call : /login.do - GET");
		
		return "/login";
	}
	 
	// Login Execution
	@RequestMapping(value = "/loginExe.do", method = RequestMethod.POST)
	public String loginExe(UserVO userVO, HttpSession httpSession, Model model) {
		// TODO : Security - Log or time
		
		logger.info("Call : /loginExe.do - POST");
		
		UserVO getUserVO = commonService.getUser(userVO); 
		
		if(getUserVO == null) {
			model.addAttribute("loginState", "Incorrect ID, Password");
			return "/login";
		} else if(getUserVO.getAuth_cd().equals("AUT003")) {
			model.addAttribute("loginState", "Unapproved Account");
			return "/login";
		}

		httpSession.setAttribute("userVO", getUserVO);
		return "redirect:home.do";	
	}
	
	// Home Page Forwarding
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		logger.info("Call : /home.do - GET");
		
		if(httpSession.getAttribute("userVO") == null)
			return "error";
		
		return "/common/home";	
	}
	
	// SignUp Page Forwarding
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signup(Model model) {
		logger.info("Call : /signup.do - GET");
		
		return "/signup";	
	}
	
	@RequestMapping(value = "/signupExe.do", method = RequestMethod.POST)
	public String signupExe(UserVO userVO, CompanyRegistVO companyRegistVO, String companyState, Model model) {
		logger.info("Call : /signExe.do - POST");
		
		// overlapping check
		if(commonService.checkId(userVO.getId()) != 0) {
			model.addAttribute("errorMsg", "REGIST ID ERROR!");
			return "/error";
		}
		
		// Select : Create New Company
		if(companyState.equals("new")) {
			if(commonService.checkCode(companyRegistVO.getCompany_cd()) != 0) {
				model.addAttribute("errorMsg", "REGIST CODE ERROR!");
				return "/error";
			}
			
			if(!commonService.signUpCompany(companyRegistVO)) {
				model.addAttribute("errorMsg", "REGIST COMPANY ERROR!");
				return "/error";
			}
			if(!commonService.signUpUser(userVO, "POS002")) {
				model.addAttribute("errorMsg", "REGIST USER ERROR!");
				return "/error";
			}
			
		// Select : Exist Company
		} else {
			if(!commonService.signUpUser(userVO, "POS003")) {
				model.addAttribute("errorMsg", "REGIST USER ERROR!");
				return "/error";
			}
		}
		
		return "/login";
		
	}
	
	@RequestMapping(value = "/checkId.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkId(String id, Model model) {
		logger.info("Call : /checkId.do ajax id : " + id);

		return commonService.checkId(id);
	}
	
	@RequestMapping(value = "/checkCode.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkCode(String company_cd, Model model) {
		logger.info("Call : /checkCode.do ajax code : " + company_cd);
		
		return commonService.checkCode(company_cd);
	}
	
	// Forgot Page Forawarding
	@RequestMapping(value = "/forgot.do", method = RequestMethod.GET)
	public String forgot(Model model) {
		logger.info("Call : /forgot.do - GET");
		
		return "/forgot";	
	}
	
	// TODO : ID, Password Search
	@RequestMapping(value = "/forgotExc.do", method = RequestMethod.POST)
	public String forgotExc(Model model) {
		logger.info("Call : /forgotExc.do - POST");
		
		
		return "/forgot";	
	}
	
	// Logout
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		logger.info("Call : /logout.do - GET");
		
		httpSession.invalidate();
		
		return "/login";	
	}
	
	// Error Page Forwarding
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(HttpSession httpSession, Model model) {
		logger.info("Call : /error.do - GET");
		
		return "/error";	
	}
}
