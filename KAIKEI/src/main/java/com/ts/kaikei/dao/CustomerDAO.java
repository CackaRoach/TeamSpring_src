package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDAO {
	public String getCustomerTitle(String company_cd);
}
