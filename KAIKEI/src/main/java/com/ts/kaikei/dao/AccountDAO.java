package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.*;


@Mapper
public interface AccountDAO {

	public AccountVO getAccountOf(String account_cd);

}
 