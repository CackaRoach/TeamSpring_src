package com.ts.kaikei.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.CompanyKeyVO;
import com.ts.kaikei.vo.StatementVO;

@Mapper
public interface CompanyDAO {
	public void signUpCompany(CompanyVO companyVO);
	public int checkCode(String code);
	
	public List<CompanyVO> getCompanies(CompanyKeyVO keyword);
	public List<CompanyVO> getCompanies();
	public List<CompanyVO> getCompanyAt(int idx);
}
