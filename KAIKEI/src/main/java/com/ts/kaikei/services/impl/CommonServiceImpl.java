package com.ts.kaikei.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CompanyDAO;
import com.ts.kaikei.dao.UserDAO;
import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}
	
	@Override
	public void signUpUser(UserVO userVO, String company_cd) {
		
		userVO.setCompany_cd(company_cd);
		
		userVO.setPosit_cd("POS003");
		userVO.setAuth_cd("AUT003");
		userVO.setState_cd("STT001");
		
		userVO.setEnt_id(userVO.getId());
		userVO.setMod_id(userVO.getId());
		
		userVO.setEnt_prog("General-Web-SignUp");
		userVO.setMod_prog("General-Web-SignUp");
		
		
		userDAO.signUpUser(userVO);
	}
	
	@Override
	public void signUpCompany(CompanyRegistVO companyRegisterVO) {
	
		companyRegisterVO.setAuth_cd("AUT003");
		
		companyRegisterVO.setEnt_id(companyRegisterVO.getId());
		companyRegisterVO.setMod_id(companyRegisterVO.getId());
		
		companyRegisterVO.setEnt_prog("General-Web-SignUp");
		companyRegisterVO.setMod_prog("General-Web-SignUp");
		
		companyDAO.signUpCompany(companyRegisterVO);
	}
	
	@Override
	public int checkId(String id) {
		return userDAO.checkId(id);
	}
	
	@Override
	public int checkCode(String code) {
		return companyDAO.checkCode(code);
	}

}
