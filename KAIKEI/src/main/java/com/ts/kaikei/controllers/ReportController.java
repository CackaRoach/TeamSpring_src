package com.ts.kaikei.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.ReportService;

@Controller
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;

	/*
	 *  @RequestMapping(value = "/report/*.do")
	 */
	
	@RequestMapping(value = "/report/bs.do", method = RequestMethod.GET)
	public String ledgerBS(Model model) {
		logger.info("Call : /report/bs.do - GET");
		
		model.addAttribute("StatementList", reportService.getStatementList());
		
		return "/report/bs";
	}
	
	@RequestMapping(value = "/report/gl.do", method = RequestMethod.GET)
	public String ledgerGL(Model model) {
		logger.info("Call : /report/gl.do - GET");

		model.addAttribute("StatementList", reportService.getStatementList());
		
		return "/report/gl";
	}
	
	@RequestMapping(value = "/report/ctb.do", method = RequestMethod.GET)
	public String ledgerCTB(Model model) {
		logger.info("Call : /report/ctb.do - GET");
		
		model.addAttribute("StatementList", reportService.getStatementList());
		
		return "/report/ctb";
	}
	
	@RequestMapping(value = "/report/pl.do", method = RequestMethod.GET)
	public String ledgerPL(Model model) {
		logger.info("Call : /report/pl.do - GET");
		
		model.addAttribute("StatementList", reportService.getStatementList());
		
		return "/report/pl";
	}
}
