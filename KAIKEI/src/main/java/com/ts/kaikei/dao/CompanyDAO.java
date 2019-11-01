package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyRegistVO;

@Mapper
public interface CompanyDAO {

	public void signUpCompany(CompanyRegistVO companyRegisterVO);
	public int checkCode(String code);
}
