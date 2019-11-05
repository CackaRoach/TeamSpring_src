package com.ts.kaikei.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.StatementVO;
import com.ts.kaikei.dao.*;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	StatementDAO statement;
	
	public List<StatementVO> getStatements(String company_cd) {
		return statement.getStatements(company_cd);
	}

	public String getCategoryName(int _category) {
		switch(_category) {
		case 0:
			return "company_cd";
		case 1:
			return "seq";
		case 2:
			return "account_cd";
		case 3:
			return "customer_cd";
		case 4:
			return "date";
		case 5:
			return "classify";
		case 6:
			return "abs";
		default:
			return "null";
		}
	}
	
	public void insertRandom() {
		statement.insertRandom();
	}
}
