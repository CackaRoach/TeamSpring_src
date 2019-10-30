package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyVO;

@Mapper
public interface CompanyDAO {

	public void signUpCompany(CompanyVO companyVO);
	public int checkCode(String code);
}
