package com.ts.kaikei.services;

import java.util.ArrayList;
import java.util.Map;

import com.ts.kaikei.vo.StatementVO;

public interface ReportService {
	public void addStatement(StatementVO boardVO);
	public void deleteStatement(int idx);
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);
	public StatementVO getStatementDetail(int idx);
	public void updateStatement(StatementVO boardVO);
}
