package com.ts.kaikei.services;

import java.util.List;
import java.util.Map;

import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.UserListVO;

public interface ManageService {
	
	//company manage
	public List<CompanyListVO> selectCompany(Map<String, Object> Params);
	public CompanyListVO infoCompany(String id);
	public void infoUpdate(CompanyListVO vo);
	public void companyDelete(String id);
	public String getCompanyCode();
	
	//companycode change
	public void companyCodeCh(Map<String, Object> Params);
	
	//user manage
	public List<UserListVO> selectUser(Map<String, Object> Params);
	public UserListVO infoUsers(String id);
	public void infoUpdateUser(UserListVO vo);
	public void userDelete(String id);
	
}
 