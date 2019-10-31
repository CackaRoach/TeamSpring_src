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
	
	//CTB Print
	@RequestMapping(value = "/report/ctb.do", method = RequestMethod.GET)
	public String ledgerCTB(Model model) {
		logger.info("Call : /report/ctb.do - GET");
		
		ArrayList<StatementVO> jasan = null, buche = null, jabon = null, suick = null, biyong = null;
		int jasanDebSum = 0, bucheDebSUM = 0, jabonDebSUM = 0, susickDebSUM = 0, biyongDebSUM = 0;
		int jasanCreSum = 0, bucheCreSUM = 0, jabonCreSUM = 0, susickCreSUM = 0, biyongCreSUM = 0;
		int jasanDebBalance = 0, bucheDebBalance = 0, jabonDebBalance = 0, susickDebBalance = 0, biyongDebBalance = 0;
		int jasanCreBalance = 0, bucheCreBalance = 0, jabonCreBalance = 0, susickCreBalance = 0, biyongCreBalance = 0;
		int DebBalanceTotal = 0, DebSumTotal = 0, CreBalanceTotal = 0, CreSumTotal = 0;
		ArrayList<StatementVO> statList = reportService.getStatementList();
		
		for(int i=0;i<statList.size();i++) {
			if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 101 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 240) {
				jasanDebSum += statList.get(i).getDebtor();
				jasanCreSum += statList.get(i).getCreditor();
				jasan.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 251 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 305) {
				bucheDebSUM += statList.get(i).getDebtor();
				bucheCreSUM += statList.get(i).getCreditor();
				buche.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 331 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 380) {
				jabonDebSUM += statList.get(i).getDebtor();
				jabonCreSUM += statList.get(i).getCreditor();
				jabon.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 401 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 412) {
				susickDebSUM += statList.get(i).getDebtor();
				susickCreSUM += statList.get(i).getCreditor();
				suick.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 451 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 999) {
				biyongDebSUM += statList.get(i).getDebtor();
				biyongCreSUM += statList.get(i).getCreditor();
				biyong.add(statList.get(i));
			}
		}
		
		DebSumTotal = jasanDebSum + bucheDebSUM + jabonDebSUM + susickDebSUM +biyongDebSUM;
		CreSumTotal = jasanCreSum + bucheCreSUM + jabonCreSUM + susickCreSUM + biyongCreSUM;
		
		model.addAttribute("jasan", jasan);
		model.addAttribute("buche", buche);
		model.addAttribute("jabon", jabon);
		model.addAttribute("suick", suick);
		model.addAttribute("biyong", biyong);
		
		return "/report/ctb";
	}
	
	@RequestMapping(value = "/report/pl.do", method = RequestMethod.GET)
	public String ledgerPL(Model model) {
		logger.info("Call : /report/pl.do - GET");
		
		model.addAttribute("StatementList", reportService.getStatementList());
		
		return "/report/pl";
	}
}
