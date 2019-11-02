package com.ts.kaikei.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.ChartService;

@Controller
public class ChartController {

	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	
	//@Autowired
	//private ChartService chartService;

	@RequestMapping(value = "/chart/pl.do", method = RequestMethod.GET)
	public String ledger(Model model) {
		logger.info("Call : /chart/pl.do - GET");
		
		return "/chart/pl";
	}
}
