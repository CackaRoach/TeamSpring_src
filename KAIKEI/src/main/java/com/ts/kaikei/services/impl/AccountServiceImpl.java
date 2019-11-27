package com.ts.kaikei.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CustomerDAO;
import com.ts.kaikei.dao.StatementDAO;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;
import com.ts.kaikei.vo.StatementVO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	StatementDAO statementDAO;
	@Autowired
	CustomerDAO customerDAO;

	/*
	 * =====================================
	 *          STATEMEMT SERVICE
	 * =====================================
	 */
	
	@Override
	public List<StatementListVO> getStatements(String company_cd) {
		return statementDAO.getStatementList(company_cd);
	}
	
	public void addStatement(List<Map<String, String>> statementList, String userId, String company_cd) {
		StatementVO statementVO = new StatementVO();
		
		for(Map<String, String> statement : statementList) {
			statementVO.setDate(statement.get("DATE"));
			statementVO.setAccount_cd(statement.get("ACCOUNT_CD"));
			statementVO.setCustomer_cd(statement.get("CUSTOMER_CD"));
			statementVO.setClassify(statement.get("CLASSIFY"));
			statementVO.setDebtor(Integer.parseInt(statement.get("DEBTOR")));
			statementVO.setCreditor(Integer.parseInt(statement.get("CREDITOR")));
			statementVO.setAbs(statement.get("ABS"));
			
			System.out.println("DATE : " + statement.get("DATE"));
			
			statementVO.setCompany_cd(company_cd);
			statementVO.setEnt_id(userId);
			statementVO.setMod_id(userId);
			
			statementDAO.addStatement(statementVO);
		}
	}


	/*
	 * =====================================
	 *           CUSTOMER SERVICE
	 * =====================================
	 */
	
	@Override
	public boolean addCustomer(String company_cd, CustomerVO customerVO, String userId) {
		 
		customerVO.setCompany_cd(company_cd);
		
		customerVO.setEnt_id(userId);
		customerVO.setMod_id(userId);
		
		customerDAO.addCustomer(customerVO);
		
		return true;
		
	}
	
	@Override
	public int getCustomerCount(String company_cd, String searchParam) {
		
		if(searchParam == null) {
			searchParam = "";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("company_cd", company_cd);
		params.put("searchParam", searchParam);

		return customerDAO.getCustomerCount(params);
	}
	
	@Override
	public List<CustomerVO> getCustomerList(String company_cd, String searchParam, String pageNum) {

		if(searchParam == null) {
			searchParam = "";
		}
		
		if(pageNum == null) {
			pageNum = "0";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("company_cd", company_cd);
		params.put("searchParam", searchParam);
		params.put("pageNum", pageNum);
		
		return customerDAO.getCustomerList(params);
	}
	
	@Override
	public CustomerVO getCustomerOf(String company_cd, String cus_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.getCustomerDetail(param);
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
	
	/*
	 *  AJAX
	 */
	
	@Override
	public int customerCodeCheck(String cus_cd, String company_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.customerCodeCheck(param);
	}

}
