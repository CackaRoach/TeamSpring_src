package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.CustomerVO;

@Mapper
public interface CustomerDAO {
	List<CustomerVO> getCustomerList(Map<String, String> searchParams);
	CustomerVO getCustomerDetail(Map<String, String> params);
	void addCustomer(CustomerVO customerVO);
	void deleteCustomer(Map<String, String> param);
	void updateCustomer(CustomerVO customerVO);
}
