package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.UserVO;

// TODO : �α׾ƿ� - Layout(height, width %) ����

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Call : /login.do - GET");
		
		return "/login";
	}
	 

	@RequestMapping(value = "/loginExc.do", method = RequestMethod.POST)
	public String loginExc(UserVO userVO, HttpSession httpSession, Model model) {
		// TODO : ȸ�� ���� Join�ؼ� �̽��ν� �α���ó�� ����
		logger.info("Call : /loginExc.do - POST");
		
		UserVO getUserVO = commonService.getUser(userVO); 
			
		if(getUserVO == null) {
			logger.info("Login Err");
			return "login";
		}

		httpSession.setAttribute("userVO", getUserVO);
		return "redirect:home.do";	
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		logger.info("Call : /home.do - GET");
		
		if(httpSession.getAttribute("userVO") == null)
			return "error";
		
		return "/common/home";	
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signup(Model model) {
		logger.info("Call : /signup.do - GET");
		
		return "/signup";	
	}
	
	@RequestMapping(value = "/signupExc.do", method = RequestMethod.POST)
	public String signupExc(Model model) {
		// TODO : ȸ������ ���� - �� ȸ�� 
		// TODO : ȸ������ ���� - ����ȸ��
		logger.info("Call : /signup.do - GET");
		  
		
		return "/signup";	
	}
	
	@RequestMapping(value = "/forgot.do", method = RequestMethod.GET)
	public String forgot(Model model) {
		// TODO : ID, ��й�ȣ ã�� ����
		logger.info("Call : /forgot.do - GET");
		
		
		return "/forgot";	
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		logger.info("Call : /logout.do - GET");
		
		httpSession.invalidate();
		
		return "/login";	
	}
	
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(HttpSession httpSession, Model model) {
		logger.info("Call : /error.do - GET");
		
		return "/error";	
	}
}
