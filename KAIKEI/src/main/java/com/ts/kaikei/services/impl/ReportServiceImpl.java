package com.ts.kaikei.services.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.StatementDAO;
import com.ts.kaikei.services.ReportService;
import com.ts.kaikei.vo.StatementVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Override
	public ArrayList<StatementVO> getStatementList() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	@Autowired
	private StatementDAO statementDAO;
	
	@Override
	public ArrayList<StatementVO> getStatementList() {
		return statementDAO.getStatementList();
		
	}
	/*
	@Override
	public void addStatement(StatementVO statementVO) {
		statementDAO.addStatement(statementVO);
	}

	@Override
	public void deleteStatement(int idx) {
		statementDAO.deleteStatement(idx);
	}

	@Override
	public ArrayList<StatementVO> getStatementList() {
		return statementDAO.getStatementList();
		
	}

	@Override
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams) {
		return statementDAO.getStatementListCond(searchParams);
	}

	@Override
	public StatementVO getStatementDetail(int idx) {
		return statementDAO.getStatementDetail(idx);
	}

	@Override
	public void updateStatement(StatementVO statementVO) {
		statementDAO.updateStatement(statementVO);
	}
	*/
}
