package com.test.springboard.services;


import com.test.springboard.vo.UserVO;

public interface UserService {
	public void registUser(UserVO userVO);
	public int checkUserId(String userId);
	public UserVO getUser(UserVO userVo);
}
