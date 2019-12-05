package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.UserListVO;
import com.ts.kaikei.vo.UserVO;

@Mapper
public interface UserDAO {
	public UserVO getUser(UserVO userVO);
	public void insertUser(UserVO userVO);
	public int checkId(String id);
	
	public UserVO getUserById(UserVO userVO);
	public void updateUser(UserVO userVO);
	
	public void userDeletecmp(String id);	//manage
	public List<UserListVO> selectUser(Map<String, Object> Params);	//manage
	public UserListVO infoUsers(String id);	//manage
	public void infoUpdateUser(UserListVO vo);	//manage
	public void userDelete(String code);	//manage
	public String getCompanyCode();	//manage
	
	public List<UserVO> getAcceptedUserList(String company_cd);
	public List<UserVO> getWaitingUserList(String company_cd);
	public void acceptUser(String id);
	public void deleteUser(String id);
//	public void rejectUser(String id);	
}
