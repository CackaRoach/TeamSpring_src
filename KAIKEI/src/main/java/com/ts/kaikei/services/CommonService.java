package com.ts.kaikei.services;

import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.UserVO;


public interface CommonService {
	
	public UserVO getUser(UserVO userVO);
	public boolean createUser(UserVO userVO, String posit_cd);
	public boolean createCompany(CompanyRegistVO companyRegistVO);
	public boolean forgotUser(String id, String email);
	public int checkId(String id);
	public int checkCode(String code);
	
}
 