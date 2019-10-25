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

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Call : login.jsp - GET");
		
		return "login";
	}
	

	@RequestMapping(value = "/loginExc.do", method = RequestMethod.POST)
	public String loginExc(UserVO userVO, HttpSession httpSession, Model model) {
		logger.info("Call : login.jsp - POST" + userVO.getId() + userVO.getPassword());
		
		UserVO user = commonService.getUser(userVO); 
			
		if(user == null) {
			logger.info("Login Err");
			return "login";
		}

		logger.info("Company_CD : " + user.getCompany_cd());
		return "main";	
	}
}
