package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.CompanyVO;

@Mapper
public interface CompanyDAO {

	public void signUpCompany(CompanyVO companyVO);
	public int checkCode(String code);
	
	public List<CompanyListVO> selectCompany(Map<String, Object> Params);
}
