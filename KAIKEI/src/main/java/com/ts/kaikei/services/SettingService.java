package com.ts.kaikei.services;

import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

public interface SettingService {
	
	public UserVO getUserById(UserVO userVO);
	public void updateUser(UserVO userVO);
	public CompanyVO getCompany(CompanyVO companyVO);
	public void updateCompany(CompanyVO companyVO);
	
}
 