package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.UserVO;

@Mapper
public interface UserDAO {
	public UserVO getUser(UserVO userVO);
}
