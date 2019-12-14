package com.ts.kaikei.services;

import java.util.List;

import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

public interface SettingService {
	
	public UserVO getUserById(String id);
	public void updateUser(UserVO userVO);
	
	public CompanyVO getCompany(String company_cd);
	public void updateCompany(CompanyVO companyVO);
	
	public List<UserVO> getAcceptedUserList(String company_cd);
	public List<UserVO> getWaitingUserList(String company_cd);
	public void acceptUser(String id);
	public void deleteUser(String id);	
	
}
 