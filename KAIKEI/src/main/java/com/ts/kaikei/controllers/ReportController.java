package com.ts.kaikei.controllers;



import javax.servlet.http.HttpSession;

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

	//BS page
	@RequestMapping(value = "/report/bs.do", method = RequestMethod.GET)
	public String ledgerBS(Model model) {
		logger.info("Call : /report/bs.do - GET");
		
		model.addAttribute("BS_dataList", reportService.BS_Calculator());
		
		return "/report/bs";
	}
	
	//GL page
	@RequestMapping(value = "/report/gl.do", method = RequestMethod.GET)
	public String ledgerGL(Model model) {
		logger.info("Call : /report/gl.do - GET");
		
		model.addAttribute("GL_dataList", reportService.GL_Calculator());
		
		return "/report/gl";
	}
	
	// TBT page
	// NOW WARNING - Server side rendering & Classify
	// RECOMMEND - Client side rendering & Classify
	@RequestMapping(value = "/report/tbt.do", method = RequestMethod.GET)
	public String ledgerCTB(HttpSession session, Model model) {
		logger.info("Call : /report/tbt.do - GET");
		
		String company_cd = (String)session.getAttribute("company_cd");
		
		model.addAttribute("tbtList", reportService.getTbtList(company_cd));

		return "/report/tbt";
	}
	
	//PL page
	@RequestMapping(value = "/report/pl.do", method = RequestMethod.GET)
	public String ledgerPL(Model model) {
		logger.info("Call : /report/pl.do - GET");
		
		model.addAttribute("PL_dataList", reportService.PL_Calculator());
		
		return "/report/pl";
	}

}
