package com.ts.kaikei.services;

import java.util.ArrayList;
import java.util.Map;

import com.ts.kaikei.vo.StatementVO;

public interface ReportService {
	
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getJasanList();
	public ArrayList<StatementVO> getBucheList();
	public ArrayList<StatementVO> getJabonList();
	public ArrayList<StatementVO> getSuickList();
	public ArrayList<StatementVO> getBiyongList();
	public ArrayList<int[]> getDataList();
	public int[] getTotal();
	public void StatementSort();
}