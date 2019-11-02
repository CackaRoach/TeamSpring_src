package com.ts.kaikei.services.impl;

import java.util.*;
import com.ts.kaikei.vo.*;
import com.ts.kaikei.dao.*;

import org.springframework.stereotype.Service;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.*;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	StatementDAO statement;
	CompanyDAO company;
	
	public List<StatementVO> getStatements(StatementKeyVO keyword) {
		return statement.getStatements(keyword);
	}
	
	public List<StatementVO> getStatements() {
		StatementKeyVO sk = new StatementKeyVO();
		sk.setSeq(0);
		
		return getStatements(sk);
	}
	
	public List<CompanyVO> getCompanies(CompanyKeyVO keyword) {
		return company.getCompanies(keyword);
	}
	
	public List<CompanyVO> getCompanies() {
		CompanyKeyVO keyword = new CompanyKeyVO();
		
		return getCompanies(keyword);
	}
}
