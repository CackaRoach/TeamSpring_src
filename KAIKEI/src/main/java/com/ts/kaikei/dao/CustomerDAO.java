package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CustomerListVO;
import com.ts.kaikei.vo.CustomerVO;

@Mapper
public interface CustomerDAO {

	List<CustomerListVO> selectCustomerList(Map<String, String> params);
	CustomerVO getCustomerDetail(Map<String, String> params);
	void addCustomer(CustomerVO customerVO);
	void deleteCustomer(Map<String, String> params);
	void updateCustomer(CustomerVO customerVO);
	int customerCodeCheck(Map<String, String> params);

	CustomerVO getCustomerOf(String company_cd);
	int getCustomerCount(Map<String, String> params);
	
	public void customerDeletecmp(String id);//manage
	
	List<CustomerVO> selectCustomerTitle(Map<String, String> searchParams);

}
 