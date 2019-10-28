package com.ts.kaikei.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

// TODO : 로그아웃 - Layout(height, width %) 수정
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	
	// 회원가입페이지 포워딩
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Call : /login.do - GET");
		
		return "/login";
	}
	
	// 실험용
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginP(CompanyVO companyVO, Model model) {
		logger.info("Call : /login.do - POST");
		logger.info("Company Code : " + companyVO.getCompany_cd());
		
		return "/login";
	}
	 
	// 로그인실행
	@RequestMapping(value = "/loginExc.do", method = RequestMethod.POST)
	public String loginExc(UserVO userVO, HttpSession httpSession, Model model) {
		// TODO : 회사 승인 Join해서 미승인시 로그인처리 구현
		// TODO : 보안강화 - 보안로그, 틀릴시 시간부여, 문자열최대치 설정
		
		logger.info("Call : /loginExc.do - POST");
		
		UserVO getUserVO = commonService.getUser(userVO); 
			
		if(getUserVO == null) {
			logger.info("Login Fail");
			model.addAttribute("state", "block");
			return "/login";
		}

		httpSession.setAttribute("userVO", getUserVO);
		return "redirect:home.do";	
	}
	
	// 로그인 후 기본 페이지 출력
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		logger.info("Call : /home.do - GET");
		
		if(httpSession.getAttribute("userVO") == null)
			return "error";
		
		return "/common/home";	
	}
	
	// 회원가입페이지 포워딩
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signup(Model model) {
		logger.info("Call : /signup.do - GET");
		
		return "/signup";	
	}
	
	// TODO : 회원가입 실행
	@RequestMapping(value = "/signupExc.do", method = RequestMethod.POST)
	public String signupExc(UserVO userVO, CompanyVO companyVO, String companyState, Model model) {
		logger.info("Call : /signExc.do - GET");

		// TODO : 보안강화 - 문자열최대치 설정
		
		if(commonService.checkCode(companyVO.getCompany_cd()) != 0) {
			// TODO : 회사중복코드 에러처리 구현
			return "/error";
		}
		
		if(companyState.equals("new")) {
			// TODO : 회원가입 구현 - 새 회사 추가
			commonService.signUpCompany(companyVO);
		}
		
		if(commonService.checkId(userVO.getId()) != 0) {
			// TODO : 중복아이디 에러처리 구현
			return "/error";
		}
		
		commonService.signUpUser(userVO, companyVO.getCompany_cd());
		
		return "/login";
	}
	
	// TODO : 중복아이디 체크 ajax length비교 + 에러메시지
	@RequestMapping(value = "/checkId.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkId(String id, Model model) {
		logger.info("Call : /checkId.do ajax id : " + id);

		return commonService.checkId(id);
	}
	
	// TODO : 중복회사코드 체크 ajax 구현(front)
	@RequestMapping(value = "/checkCode.do", method = RequestMethod.GET)
	@ResponseBody
	public int checkCode(String company_cd, Model model) {
		logger.info("Call : /checkCode.do ajax code : " + company_cd);
		return 1;
		//return commonService.checkCode(company_cd);
	}
	
	// 아이디 비밀번호 찾기 페이지 포워딩
	@RequestMapping(value = "/forgot.do", method = RequestMethod.GET)
	public String forgot(Model model) {
		logger.info("Call : /forgot.do - GET");
		
		return "/forgot";	
	}
	
	// TODO : ID, 비밀번호 찾기 구현
	@RequestMapping(value = "/forgotExc.do", method = RequestMethod.POST)
	public String forgotExc(Model model) {
		logger.info("Call : /forgotExc.do - POST");
		
		
		return "/forgot";	
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		logger.info("Call : /logout.do - GET");
		
		httpSession.invalidate();
		
		return "/login";	
	}
	
	// 에러페이지 포워딩
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public String error(HttpSession httpSession, Model model) {
		logger.info("Call : /error.do - GET");
		
		return "/error";	
	}
}
