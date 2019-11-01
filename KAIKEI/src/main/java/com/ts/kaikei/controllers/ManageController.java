package com.ts.kaikei.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.services.ManageService;
import com.ts.kaikei.vo.CompanyVO;

@Controller
public class ManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	private ManageService manageService;

	/*
	 *  @RequestMapping(value = "/manage/*.do")
	 */
	
	//COMPANY - LIST(FIND)
	@RequestMapping(value = "/manage/company.do", method = RequestMethod.GET)
	public ModelAndView ledger(	ModelAndView model,
							@RequestParam(value = "mPAGE", required = false) String PAGE,
							@RequestParam(value = "mFIND", required = false) String FIND,
							@RequestParam(value = "mSTAT", required = false) String STAT_op
						) {
		logger.info("Call : /manage/company.do - GET");
		
		
		if(PAGE == null || PAGE == "") PAGE = "1";
		if(STAT_op == null || STAT_op == "")  STAT_op = "00";
		
		Map<String, Object> Params = new HashMap<String, Object>();
		Params.put("PAGE", PAGE);
		Params.put("FIND", FIND);
		Params.put("STAT_op", STAT_op);
		
		List<CompanyVO> companyList = manageService.selectCompany(Params);
		
		model.addObject("companyList", companyList);
		model.setViewName("/manage/company");
		return model;
	}
	
	//COMPANY - DETAIL
	@RequestMapping(value = "/manage/companyDetail.do", method = RequestMethod.GET)
	public String ledger1(Model model) {
		logger.info("Call : /manage/company.do - GET");

		return "/manage/company";
	}
	
	
}
