package com.ts.kaikei.services;

import java.util.List;
import java.util.Map;

import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;


public interface AccountService {

	/*
	 * =====================================
	 *         STATEMEMT CONTROLLER
	 * =====================================
	 */

	List<StatementListVO> getStatements(String company_cd);
	void addStatement(List<Map<String, String>> statementList, String userId, String company_cd);
	
	/*
	 * =====================================
	 *           CUSTOMER SERVICE
	 * =====================================
	 */
	
	boolean addCustomer(String company_cd, CustomerVO customerVO, String userId);
	List<CustomerVO> getCustomerList(String company_cd, String searchParam, String pageNum, String size);
	CustomerVO getCustomerOf(String company_cd, String cus_cd);
	boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId);
	boolean deleteCustomer(String company_cd, String cus_cd);
	int customerCodeCheck(String cus_cd, String company_cd);
}

