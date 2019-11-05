package com.ts.kaikei.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.AccountDAO;
import com.ts.kaikei.dao.CustomerDAO;
import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.CustomerVO;
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

	@Autowired
	AccountDAO accountDAO;
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<CustomerVO> getCustomerList(String company_cd, String searchParam) {
		
		if(searchParam == null) {
			searchParam = "";
		}
		
		Map<String, String> searchParams = new HashMap<String, String>();
		searchParams.put("company_cd", company_cd);
		searchParams.put("searchParam", searchParam);
		
		return customerDAO.getCustomerList(searchParams);
	}
	
	@Override
	public CustomerVO getCustomerDetail(String company_cd, String cus_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.getCustomerDetail(param);
	}

	@Override
	public boolean addCustomer(String company_cd, CustomerVO customerVO, String userId) {
		 
		customerVO.setCompany_cd(company_cd);
		
		customerVO.setEnt_id(userId);
		customerVO.setMod_id(userId);
		
		customerVO.setEnt_prog("Web-kaikei");
		customerVO.setMod_prog("Web-kaikei");
		
		customerDAO.addCustomer(customerVO);
		
		return true;
		
	}
	
	@Override
	public boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId) {
		
		customerVO.setCompany_cd(company_cd);
		customerVO.setMod_id(userId);
		customerVO.setMod_prog("Web-kaikei");
		
		
		customerDAO.updateCustomer(customerVO);
		
		return true;
	}

	@Override
	public boolean deleteCustomer(String company_cd, String cus_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		customerDAO.deleteCustomer(param);
		
		return true;
	}

	@Override
	public int customerCodeCheck(String cus_cd, String company_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.customerCodeCheck(param);
	}
	

}
