package com.ts.kaikei.services;

import java.util.List;

import com.ts.kaikei.vo.CustomerVO;

public interface AccountService {
	public List<StatementVO> getStatements(String company_cd);
	public String getCategoryName(int _category);
	public void insertRandom();
	boolean addCustomer(String company_cd, CustomerVO customerVO, String userId);
	List<CustomerVO> getCustomerList(String company_cd, String searchParam);
	CustomerVO getCustomerDetail(String company_cd, String cus_cd);
	boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId);
	boolean deleteCustomer(String company_cd, String cus_cd);
	int customerCodeCheck(String cus_cd, String company_cd);

}
