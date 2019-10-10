package com.test.springboard.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.springboard.vo.UserVO;

@Mapper
public interface UserDAO {
	public void registUser(UserVO userVO);
	public int checkUserId(String userId);
    public UserVO searchUser(UserVO userVO);
}
