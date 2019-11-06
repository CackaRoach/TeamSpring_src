package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface CustomerDAO {
	public CustomerVO getCustomerOf(String company_cd);
}
