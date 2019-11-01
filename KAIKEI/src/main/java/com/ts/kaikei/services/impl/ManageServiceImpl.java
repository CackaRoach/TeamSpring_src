package com.ts.kaikei.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CompanyDAO;
import com.ts.kaikei.services.ManageService;
import com.ts.kaikei.vo.CompanyVO;

@Service("manageService")
public class ManageServiceImpl implements ManageService {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public List<CompanyVO> selectCompany(Map<String, Object> Params){
		return companyDAO.selectCompany(Params);
	}
}
