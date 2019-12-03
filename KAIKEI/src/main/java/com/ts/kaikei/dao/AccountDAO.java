package com.ts.kaikei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.*;


@Mapper
public interface AccountDAO {
	
	public List<AccountVO> selectAccountTitle(String title);

}
 