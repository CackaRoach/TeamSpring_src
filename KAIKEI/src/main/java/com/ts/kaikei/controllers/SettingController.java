package com.ts.kaikei.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.SettingService;

@Controller
public class SettingController {

	
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;

	/*
	 *  @RequestMapping(value = "/setting/*.do")
	 */
	 
	@RequestMapping(value = "/setting/personal.do", method = RequestMethod.GET)
	public String ledger(Model model) {
		logger.info("Call : /setting/personal.do - GET");

		return "/setting/personal";
	}
}
