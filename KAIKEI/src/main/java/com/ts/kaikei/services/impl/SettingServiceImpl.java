package com.ts.kaikei.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CompanyDAO;
import com.ts.kaikei.dao.UserDAO;
import com.ts.kaikei.services.SettingService;
import com.ts.kaikei.vo.CompanyVO;
import com.ts.kaikei.vo.UserVO;

@Service("settingService")
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	CompanyDAO companyDAO;
	
	@Override
	public void updateUser(UserVO userVO) {
		userDAO.updateUser(userVO);
	}

	@Override
	public void updateCompany(CompanyVO companyVO) {
		companyDAO.updateCompany(companyVO);
	}

	@Override
	public CompanyVO getCompany(String company_cd) {
		return companyDAO.getCompany(company_cd);
	}
	
	@Override
	public UserVO getUserById(String id) {
		return userDAO.getUserById(id);
	}
	
	@Override
	public List<UserVO> getAcceptedUserList(String company_cd) {
		return userDAO.getAcceptedUserList(company_cd);
	}

	@Override
	public List<UserVO> getWaitingUserList(String company_cd) {
		return userDAO.getWaitingUserList(company_cd);
	}

	@Override
	public void acceptUser(String id) {
		userDAO.acceptUser(id);
	}

	@Override
	public void deleteUser(String id) {
		userDAO.deleteUser(id);
	}
}
 