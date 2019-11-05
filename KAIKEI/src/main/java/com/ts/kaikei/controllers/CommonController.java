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
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;


// TODO : Security - bufferOverflow
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
	
	// Testing
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginP(CompanyVO companyVO, Model model) {
		logger.info("Call : /login.do - POST");
		logger.info("Company Code : " + companyVO.getCompany_cd());
		
		return "/login";
	}
	 
	// Login Execution
	@RequestMapping(value = "/loginExe.do", method = RequestMethod.POST)
	public String loginExe(UserVO userVO, HttpSession httpSession, Model model) {
		// TODO : Company AUT Join LoginExecution
		// TODO : Security - Log, time
		
		logger.info("Call : /loginExe.do - POST");
		
		UserVO getUserVO = commonService.getUser(userVO); 
			
		if(getUserVO == null) {
			logger.info("Login Fail");
			model.addAttribute("state", "block");
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
	
	// TODO : SignUp Execution
	@RequestMapping(value = "/signupExe.do", method = RequestMethod.POST)
	public String signupExe(UserVO userVO, CompanyVO companyVO, String companyState, Model model) {
		logger.info("Call : /signExe.do - GET");
		
		if(commonService.checkCode(companyVO.getCompany_cd()) != 0) {
			// TODO : �쉶�궗以묐났肄붾뱶 �뿉�윭泥섎━ 援ы쁽
			return "/error";
		}
		
		if(companyState.equals("new")) {
			// TODO : �쉶�썝媛��엯 援ы쁽 - �깉 �쉶�궗 異붽�
			commonService.signUpCompany(companyVO);
		}
		
		if(commonService.checkId(userVO.getId()) != 0) {
			// TODO : 以묐났�븘�씠�뵒 �뿉�윭泥섎━ 援ы쁽
			return "/error";
		}
		
		commonService.signUpUser(userVO, companyVO.getCompany_cd());
		
		return "/login";
	}
	
	// TODO : 以묐났�븘�씠�뵒 泥댄겕 ajax length鍮꾧탳 + �뿉�윭硫붿떆吏�
	@RequestMapping(value = "/checkId.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkId(String id, Model model) {
		logger.info("Call : /checkId.do ajax id : " + id);

		return commonService.checkId(id);
	}
	
	// TODO : 以묐났�쉶�궗肄붾뱶 泥댄겕 ajax 援ы쁽(front)
	@RequestMapping(value = "/checkCode.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkCode(String company_cd, Model model) {
		logger.info("Call : /checkCode.do ajax code : " + company_cd);
		return 1;
		//return commonService.checkCode(company_cd);
	}
	
	// �븘�씠�뵒 鍮꾨�踰덊샇 李얘린 �럹�씠吏� �룷�썙�뵫
	@RequestMapping(value = "/forgot.do", method = RequestMethod.GET)
	public String forgot(Model model) {
		logger.info("Call : /forgot.do - GET");
		
		return "/forgot";	
	}
	
	// TODO : ID, 鍮꾨�踰덊샇 李얘린 援ы쁽
	@RequestMapping(value = "/forgotExc.do", method = RequestMethod.POST)
	public String forgotExc(Model model) {
		logger.info("Call : /forgotExc.do - POST");
		
		
		return "/forgot";	
	}
	
	// 濡쒓렇�븘�썐
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		logger.info("Call : /logout.do - GET");
		
		httpSession.invalidate();
		
		return "/login";	
	}
	
	// �뿉�윭�럹�씠吏� �룷�썙�뵫
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(HttpSession httpSession, Model model) {
		logger.info("Call : /error.do - GET");
		
		return "/error";	
	}
}
