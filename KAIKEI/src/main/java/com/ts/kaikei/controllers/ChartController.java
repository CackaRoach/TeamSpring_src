package com.ts.kaikei.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChartController {

	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	
	// @Autowired
	// private ChartService chartService;

	@RequestMapping(value = "/chart/pl.do", method = RequestMethod.GET)
	public String viewChartPS(String year, Model model) {
		logger.info("Call : /chart/pl.do - GET");
		
		//model.addAttribute("chartList", chartService.getChart(year));
		
		return "/chart/pl";
	}
	
	@RequestMapping(value = "/chart/bs.do", method = RequestMethod.GET)
	public String viewChartBS(String year, Model model) {
		logger.info("Call : /chart/bs.do - GET");

		return "/chart/bs";
	}
}
