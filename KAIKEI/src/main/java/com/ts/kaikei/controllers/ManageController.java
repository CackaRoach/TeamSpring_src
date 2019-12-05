package com.ts.kaikei.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ts.kaikei.services.ManageService;
import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.UserListVO;

@Controller
public class ManageController {

	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);

	@Autowired
	private ManageService manageService;

	// COMPANY - LIST(FIND)
	@RequestMapping(value = "/manage/company.do", method = RequestMethod.GET)
	public ModelAndView companylist(@RequestParam(value = "mPAGE", required = false) String mPAGE,
			@RequestParam(value = "mINPUT", required = false) String mINPUT,
			@RequestParam(value = "STAT_op", required = false) String STAT_op, ModelAndView model) {

		logger.info("Call : /manage/company.do - GET");

		if (mPAGE == null || mPAGE == "") {
			mPAGE = "1";
		}
		if (STAT_op == null || STAT_op == "") {
			STAT_op = "00";
		}
		if (mINPUT == null || mINPUT == "") {
			mINPUT = "";
		}

		Map<String, Object> Params = new HashMap<String, Object>();

		Params.put("mPAGE", mPAGE);
		Params.put("STAT_op", STAT_op);
		Params.put("mINPUT", mINPUT);

		List<CompanyListVO> companyList = manageService.selectCompany(Params);

		model.addObject("companyList", companyList);
		model.setViewName("/manage/company");

		return model;
	}

	// COMPANY - DETAIL
	@RequestMapping(value = "/manage/companyDetail.do", method = RequestMethod.GET)
	public ModelAndView companyinfo(@RequestParam(value = "id", required = false) String code,
			@RequestParam(value = "mod", required = false) String isMod, // modify check
			ModelAndView model, HttpSession httpsession) {
		logger.info("Call : /manage/company.do - GET");

		Map<String, Object> Params = new HashMap<String, Object>();

		if (isMod == null || isMod == "")
			isMod = " ";

		if (isMod.equals("M")) {
			model.setViewName("/manage/companyModify");
		} else {
			model.setViewName("/manage/companyDetail");
		}

		Params.put("company_cd", code);
		CompanyListVO companyInfo = manageService.infoCompany(code);

		httpsession.setAttribute("cmp_Cd", companyInfo.getCompany_cd());

		model.addObject("companyInfo", companyInfo);
		return model;
	}

	// COMPANY - INFO MODIFY (UPLOAD)
	@RequestMapping(value = "/manage/companyModify.do", method = RequestMethod.POST)
	public String companyMod(CompanyListVO vo, HttpSession httpsession) {

		logger.info("Call : /manage/companyModify.do - POST");
		
		String cmpCd = (String) httpsession.getAttribute("cmp_Cd");
		
		//change Code
		if(!cmpCd.equals(vo.getCompany_cd())) {
			Map<String, Object> Params = new HashMap<String, Object>();
			
			Params.put("org", cmpCd);
			Params.put("new", vo.getCompany_cd());  
			
			manageService.companyCodeCh(Params);
		}
		
		 manageService.infoUpdate(vo); 
		String id = vo.getCompany_cd();
		return "redirect:/manage/companyDetail.do?mod=M?&id=" + id;
	}

	// COMPANY - INFO DELETE
	@RequestMapping(value = "/manage/companyDelete.do", method = RequestMethod.GET)
	public String deleteCompany(@RequestParam(value = "id", required = false) String code) {

		logger.info("Call : /manage/companyDelete.do - GET");

		manageService.companyDelete(code);

		return "redirect:/manage/company.do";
	}

	// COMPANY - FORWARD COMPANY PAGE
	@RequestMapping(value = "/manage/companySite.do", method = RequestMethod.GET)
	public ModelAndView CmtSite(@RequestParam(value = "id", required = false) String id, HttpSession httpSession,
			ModelAndView model) {

		logger.info("Call : manage/companySite.do - GET");

		model.setViewName("/manage/companyModify");

		/* httpSession.setAttribute("posit_cd", "POS002"); */

		httpSession.setAttribute("company_cd", id);


		model.setViewName("/manage/goCompanySite");

		return model;
	}

	// COMPANY - FWARD MANAGE PAGE
	@RequestMapping(value = "/manage/manage.do", method = RequestMethod.GET)
	public ModelAndView manageBack(HttpSession httpSession, ModelAndView model) {
		logger.info("Call : manage/manage.do - GET");

		String code = manageService.getCompanyCode();

		httpSession.setAttribute("company_cd", code);

		model.setViewName("/manage/goCompanySite");
		return model;
	}

	// USER - MANAGE LIST
	@RequestMapping(value = "/manage/users.do", method = RequestMethod.GET)
	public ModelAndView userList(@RequestParam(value = "mPAGE", required = false) String mPAGE,
			@RequestParam(value = "mINPUT", required = false) String mINPUT,
			@RequestParam(value = "STAT_op", required = false) String STAT_op, ModelAndView model) {
		logger.info("Call : /manage/users.do - GET");

		if (mPAGE == null || mPAGE == "") {
			mPAGE = "1";
		}
		if (STAT_op == null || STAT_op == "") {
			STAT_op = "00";
		}
		if (mINPUT == null || mINPUT == "") {
			mINPUT = "";
		}

		Map<String, Object> Params = new HashMap<String, Object>();

		Params.put("mPAGE", mPAGE);
		Params.put("STAT_op", STAT_op);
		Params.put("mINPUT", mINPUT);
		System.out.println(mINPUT);
		List<UserListVO> userList = manageService.selectUser(Params);

		model.addObject("userList", userList);
		model.setViewName("/manage/user");

		return model;
	}

	// USER - DETAIL INFO
	@RequestMapping(value = "/manage/userDetail.do", method = RequestMethod.GET)
	public ModelAndView userdetailInfo(@RequestParam(value = "id", required = false) String code,
			@RequestParam(value = "mod", required = false) String isMod, // modify check
			ModelAndView model) {
		logger.info("Call : /manage/usersDetail.do - GET");

		Map<String, Object> Params = new HashMap<String, Object>();

		if (isMod == null || isMod == "")
			isMod = " ";

		if (isMod.equals("M")) {
			model.setViewName("/manage/userModify");
		} else {
			model.setViewName("/manage/userDetail");
		}

		Params.put("id", code);
		UserListVO userInfo = manageService.infoUsers(code);

		model.addObject("userInfo", userInfo);

		return model;
	}

	// USER - INDO UPLOAD
	@RequestMapping(value = "/manage/userModify.do", method = RequestMethod.POST)
	public String usermod(UserListVO vo) {

		logger.info("Call : /manage/userModify.do - POST");
		manageService.infoUpdateUser(vo);
		String id = vo.getId();
		return "redirect:/manage/userDetail.do?mod=M?&id=" + id;
	}

	@RequestMapping(value = "/manage/userDelete.do", method = RequestMethod.GET)
	public String deleteUsers(@RequestParam(value = "id", required = false) String code) {

		logger.info("Call : /manage/userDelete.do - GET");

		manageService.userDelete(code);

		return "redirect:/manage/company.do";
	}
}