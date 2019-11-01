package com.ts.kaikei.services.impl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.CompanyDAO;
import com.ts.kaikei.dao.UserDAO;
import com.ts.kaikei.services.CommonService;
import com.ts.kaikei.vo.CompanyRegistVO;
import com.ts.kaikei.vo.UserVO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}
	
	@Override
	public boolean signUpUser(UserVO userVO, String posit_cd) {
		
		
		Pattern idPattern = Pattern.compile("^[a-z0-9]{5,15}$");
		Matcher idMatcher = idPattern.matcher(userVO.getId());
		
		if(!idMatcher.find()) {
			return false;
		}
		
		userVO.setPosit_cd(posit_cd);
		userVO.setAuth_cd("AUT003");
		userVO.setState_cd("STT001");
		
		userVO.setEnt_id(userVO.getId());
		userVO.setMod_id(userVO.getId());
		
		userVO.setEnt_prog("General-Web-SignUp");
		userVO.setMod_prog("General-Web-SignUp");
		
		
		userDAO.signUpUser(userVO);
		
		return true;
	}
	
	@Override
	public boolean signUpCompany(CompanyRegistVO companyRegisterVO) {
	
		Pattern codePattern = Pattern.compile("^[0-9]{5}$");
		Matcher codeMatcher = codePattern.matcher(companyRegisterVO.getCompany_cd());
		
		if(!codeMatcher.find()) {
			return false;
		}
		
		companyRegisterVO.setAuth_cd("AUT003");
		
		companyRegisterVO.setEnt_id(companyRegisterVO.getId());
		companyRegisterVO.setMod_id(companyRegisterVO.getId());
		
		companyRegisterVO.setEnt_prog("General-Web-SignUp");
		companyRegisterVO.setMod_prog("General-Web-SignUp");
		
		companyDAO.signUpCompany(companyRegisterVO);
		
		return true;
	}
	
	@Override
	public boolean forgotId(String email) {
		/*
		String host = "smtp.naver.com";  

		final String username = "";  
		final String password = "";
		int port = 465; 

		String recipient = ""; 
		String subject = ""; 
		String body = "";

		Properties props = System.getProperties();  

		props.put("mail.smtp.host", host);  
		props.put("mail.smtp.port", port);  
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");  
		props.put("mail.smtp.ssl.trust", host);  

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
			return new javax.mail.PasswordAuthentication(username, password);  
			}  
		});  
		
		Message mimeMessage = new MimeMessage(session); 
		try {
			mimeMessage.setFrom(new InternetAddress("@naver.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			mimeMessage.setSubject(subject); 
			mimeMessage.setText(body);
			Transport.send(mimeMessage); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		return false;
	}
	
	@Override
	public int checkId(String id) {
		return userDAO.checkId(id);
	}
	
	@Override
	public int checkCode(String code) {
		return companyDAO.checkCode(code);
	}

}
