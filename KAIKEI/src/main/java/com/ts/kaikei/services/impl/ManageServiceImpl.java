package com.ts.kaikei.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CompanyDAO;
import com.ts.kaikei.dao.CustomerDAO;
import com.ts.kaikei.dao.UserDAO;
import com.ts.kaikei.services.ManageService;
import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserListVO;
import com.ts.kaikei.vo.UserVO;

@Service("manageService")
public class ManageServiceImpl implements ManageService {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	/* company manage */
	@Override
	public List<CompanyListVO> selectCompany(Map<String, Object> Params){
		for ( String key : Params.keySet() ) {
		    System.out.println(key + ": " + Params.get(key) );
		}
		return companyDAO.selectCompany(Params);
	}
	
	@Override
	public CompanyListVO infoCompany(String id){
		return companyDAO.infoCompany(id);
	}
	
	@Override
	public void infoUpdate(CompanyListVO vo) {
		vo.setAuth_cd("AUT"+vo.getAuth_cd());
		companyDAO.infoUpdate(vo);
	}
	
	@Override
	public void companyDelete(String company_cd) {
		customerDAO.customerDeletecmp(company_cd);
		userDAO.userDeletecmp(company_cd);
		companyDAO.companyDelete(company_cd);
	}
	
	@Override
	public String getCompanyCode() {
		return userDAO.getCompanyCode();
	}
	
	/* user manage */
	@Override
	public List<UserListVO> selectUser(Map<String, Object> Params){
		return userDAO.selectUser(Params);
	}
	
	@Override
	public UserListVO infoUsers(String id) {
		return userDAO.infoUsers(id);
	}
	
	@Override
	public void infoUpdateUser(UserListVO vo) {
		userDAO.infoUpdateUser(vo);
	}
	
	@Override
	public void userDelete(String id) {
		userDAO.userDelete(id);
	}

}
