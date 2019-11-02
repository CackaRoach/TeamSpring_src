package com.ts.kaikei.services;

import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;


public interface CommonService {
	
	public UserVO getUser(UserVO userVO);
	public CompanyVO getCompany(String company_cd);
	public boolean signUpUser(UserVO userVO, String posit_cd);
	public boolean signUpCompany(CompanyRegistVO companyRegistVO);
	public boolean forgotId(String email);
	public int checkId(String id);
	public int checkCode(String code);
	
}
