package com.ts.kaikei.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ts.kaikei.services.ReportService;
import com.ts.kaikei.vo.StatementVO;

@Controller
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;

	/*
	 *  @RequestMapping(value = "/report/*.do")
	 */
	
	//BS page
	@RequestMapping(value = "/report/bs.do", method = RequestMethod.GET)
	public String ledgerBS(Model model) {
		logger.info("Call : /report/bs.do - GET");
		/*
		reportService.BS_Calculator();
		
		model.addAttribute("dataList", reportService.getBS_dataList());
		*/
		return "/report/bs";
	}
	
	//GL page
	@RequestMapping(value = "/report/gl.do", method = RequestMethod.GET)
	public String ledgerGL(Model model) {
		logger.info("Call : /report/gl.do - GET");
		/*
		reportService.GL_Calculator();
		model.addAttribute("dataList", reportService.getGL_dataList());
		model.addAttribute("MonthlyTotal", reportService.getGL_MonthlyTotal());
		model.addAttribute("Total", reportService.getGL_Total());
		*/
		return "/report/gl";
	}
	
	//CTB page
	@RequestMapping(value = "/report/ctb.do", method = RequestMethod.GET)
	public String ledgerCTB(Model model) {
		logger.info("Call : /report/ctb.do - GET");
		/*
		reportService.StatementSort();
		model.addAttribute("jasan", reportService.getJasanList());
		model.addAttribute("buche", reportService.getBucheList());
		model.addAttribute("jabon", reportService.getJabonList());
		model.addAttribute("suick", reportService.getSuickList());
		model.addAttribute("biyong", reportService.getBiyongList());
		model.addAttribute("dataList", reportService.getDataList());
		model.addAttribute("dataTotal", reportService.getTotal());
		*/
		return "/report/ctb";
	}
	
	//CL page
	@RequestMapping(value = "/report/pl.do", method = RequestMethod.GET)
	public String ledgerPL(Model model) {
		logger.info("Call : /report/pl.do - GET");
		/*
		reportService.PL_Calculator();
		
		model.addAttribute("dataList", reportService.getPL_dataList());
		*/
		return "/report/pl";
	}
}
