package com.ts.kaikei.services;

import java.util.List;
import java.util.Map;

import com.ts.kaikei.vo.CompanyListVO;

public interface ManageService {
	public List<CompanyListVO> selectCompany(Map<String, Object> Params);
}
 