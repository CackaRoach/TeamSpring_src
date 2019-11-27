package com.ts.kaikei.services.impl;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CustomerDAO;
import com.ts.kaikei.dao.StatementDAO;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementVO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	StatementDAO statementDAO;
	@Autowired
	CustomerDAO customerDAO;
	
	public static int pageSize = 20;

	/*
	 * =====================================
	 *          STATEMEMT SERVICE
	 * =====================================
	 */
	
	@Override
	public List<StatementVO> getStatementList(String company_cd, String pageNum, String searchString, String searchTarget) {
		List<StatementVO> list = statementDAO.getStatementList(company_cd);
		List<StatementVO> result = new LinkedList<StatementVO>();
		
		if(searchTarget != null && searchString != null) {
			for(int i = 0; i < list.size(); i++) {
				if(searchTarget == "account_cd" && list.get(i).getAccount_cd() == searchString)
					result.add(list.get(i));
				else if(searchTarget == "customer_cd" && list.get(i).getCustomer_cd() == searchString)
					result.add(list.get(i));
				else if(searchTarget == "date" && list.get(i).getDate() == searchString)
					result.add(list.get(i));
				else if(searchTarget == "classify" && list.get(i).getClassify() == searchString)
					result.add(list.get(i));
				else if(searchTarget == "abs" && list.get(i).getAbs() == searchString)
					result.add(list.get(i));
			}
		}
		
		for(int i = 0; i < 20; i++)
			result.add(list.get(Integer.parseInt(pageNum) + i));
		
		return result;
	}
	
	@Override
	public void addStatement(StatementVO statementVO, String userId, String company_cd) {		
		statementVO.setCompany_cd(company_cd);
		statementVO.setEnt_id(userId);
		statementVO.setEnt_prog("Web_kaikei");
		statementVO.setMod_id(userId);
		statementVO.setMod_prog("Web_kaikei");
		
		statementDAO.addStatement(statementVO);
	}
	
	@Override
	public String getPageSize(String company_cd) {
		return statementDAO.getPageSize(String.valueOf(Integer.parseInt(company_cd) / this.pageSize));
	}
	
	@Override
	public void editStatment(StatementVO statementVO, String userId, String company_cd) {
		statementVO.setCompany_cd(company_cd);
		statementVO.setMod_id(userId);
		statementVO.setMod_prog("Web_kaikei");
		
		statementDAO.editStatement(statementVO);
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
