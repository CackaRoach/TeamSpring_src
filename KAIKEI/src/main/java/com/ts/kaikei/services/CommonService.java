package com.ts.kaikei.services;

import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.UserVO;


public interface CommonService {
	
	public UserVO getUser(UserVO userVO);
	public void signUpUser(UserVO userVO, String company_cd);
	public void signUpCompany(CompanyRegistVO companyRegistVO);
	public int checkId(String id);
	public int checkCode(String code);
	
}
