package com.ts.kaikei.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.UserDAO;
import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.UserVO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}

}
