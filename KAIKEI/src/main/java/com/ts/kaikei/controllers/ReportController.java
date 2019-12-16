package com.ts.kaikei.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ts.kaikei.services.ReportService;

import com.ts.kaikei.vo.AccountVO;
import com.ts.kaikei.vo.ReportGlVO;
import com.ts.kaikei.vo.TBTotalVO;


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
	
	  //General Ledger List Page (GL Page)
	  @RequestMapping(value = "/report/gl.do", method = RequestMethod.GET) 
	  public ModelAndView ledgerGL(	ModelAndView model, 
			  						HttpSession httsession,
			  						String quarter,
			  						String year) {
		  logger.info("Call : /report/gl.do - GET");
		  
		  Calendar calendar = new GregorianCalendar(Locale.JAPAN);
		  
		  String cd = (String) httsession.getAttribute("company_cd");
		  
		  if(quarter == null || quarter == "") {
			  int month = calendar.get(Calendar.MONTH) + 1;
			  quarter = Integer.toString((int)Math.ceil( month / 3.0 ));
		  }
		  if(year == null || year == "") {
			  year = Integer.toString(calendar.get(Calendar.YEAR));
		  }
		  
		  Map<String, Object> Parmas = new HashMap<String, Object>(); 
		  
		  Parmas.put("company_cd", cd); 
		  Parmas.put("QUARTER", quarter);
		  Parmas.put("YEAR", year);
		  
		  List<AccountVO> accList = reportService.Account_title(cd);
		  List<ReportGlVO> Fod_blc = reportService.Forward_balance(Parmas);	//forword balance find
		  List<ReportGlVO> GL_dataList = reportService.GL_Calculator(Parmas);	//list
		  
		  model.addObject("accList", accList);
		  model.addObject("Fod_blc", Fod_blc);
		  model.addObject("GL_dataList", GL_dataList);
		  model.setViewName("/report/gl"); 
		  return model; 
	  }
	
	// TBT page
	@RequestMapping(value = "/report/tbt.do", method = RequestMethod.GET)
	public String ledgerCTB(HttpSession session, Model model) {
		logger.info("Call : /report/tbt.do - GET");
		
		String company_cd = (String)session.getAttribute("company_cd");
		
		List<TBTotalVO> tbtList = reportService.getTbtList(company_cd);
		
		model.addAttribute("tbtList", tbtList);

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
