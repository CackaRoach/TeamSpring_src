package com.ts.kaikei.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.UserVO;

@Mapper
public interface UserDAO {
	public UserVO getUser(UserVO userVO);
	public void insertUser(UserVO userVO);
	public int checkId(String id);
	
	public UserVO getUserById(UserVO userVO);
	public void updateUser(UserVO userVO);
}
 