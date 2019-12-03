package com.ts.kaikei.services;

import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

public interface SettingService {
	
	public UserVO getUserById(String id);
	public void updateUser(UserVO userVO);
	
	public CompanyVO getCompany(String company_cd);
	public void updateCompany(CompanyVO companyVO);
	
}
 