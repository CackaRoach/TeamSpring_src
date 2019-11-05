package com.ts.kaikei.services;

import java.util.List;

import com.ts.kaikei.vo.CustomerVO;

public interface AccountService {
	
	boolean addCustomer(String company_cd, CustomerVO customerVO, String userId);
	List<CustomerVO> getCustomerList(String company_cd, String searchParam);
	CustomerVO getCustomerDetail(String company_cd, String cus_cd);
	boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId);
	boolean deleteCustomer(String company_cd, String cus_cd);

}
