package com.ts.kaikei.services;

import java.util.ArrayList;
import java.util.Map;

import com.ts.kaikei.vo.StatementVO;

public interface ReportService {
	
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);

}