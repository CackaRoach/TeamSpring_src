package com.ts.kaikei.services;

import java.util.List;

import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;
import com.ts.kaikei.vo.StatementVO;


public interface AccountService {

	/*
	 * 
	 * 
	 */

	List<StatementListVO> getStatements(String company_cd);
	void addStatement(StatementVO statementVO, String userId, String company_cd);
	
	/*
	 * =====================================
	 *           CUSTOMER SERVICE
	 * =====================================
	 */
	
	boolean addCustomer(String company_cd, CustomerVO customerVO, String userId);
	int getCustomerCount(String string, String searchParam);
	List<CustomerVO> getCustomerList(String company_cd, String searchParam, String pageNum);
	CustomerVO getCustomerOf(String company_cd, String cus_cd);
	boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId);
	boolean deleteCustomer(String company_cd, String cus_cd);
	int customerCodeCheck(String cus_cd, String company_cd);
}

