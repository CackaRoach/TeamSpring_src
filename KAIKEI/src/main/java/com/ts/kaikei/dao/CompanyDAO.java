package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.CompanyVO;

@Mapper
public interface CompanyDAO {

	public void signUpCompany(CompanyRegistVO companyRegisterVO);
	public CompanyVO getCompany(String company_cd);
	public int checkCode(String company_cd);
	
	public List<CompanyListVO> selectCompany(Map<String, Object> Params);

}
 