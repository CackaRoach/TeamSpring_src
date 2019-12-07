package com.ts.kaikei.services;

import java.util.ArrayList;

import com.ts.kaikei.vo.StatementListVO;

public interface ReportService {

	public ArrayList<StatementListVO> getStatementList();
	public ArrayList<ArrayList<StatementListVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();

}