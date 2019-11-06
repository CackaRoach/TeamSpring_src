package com.ts.kaikei.services;

import java.util.List;
import java.util.Map;

import com.ts.kaikei.vo.CompanyListVO;
import com.ts.kaikei.vo.CompanyVO;

public interface ManageService {
	public List<CompanyListVO> selectCompany(Map<String, Object> Params);
}
 