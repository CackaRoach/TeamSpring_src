package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.CompanyVO;

@Mapper
public interface CompanyDAO {

	public void signUpCompany(CompanyRegistVO companyRegisterVO);
	public CompanyVO getCompany(String company_cd);
	public int checkCode(String company_cd);
}
