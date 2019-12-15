package com.ts.kaikei.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ts.kaikei.vo.AccountVO;
import com.ts.kaikei.vo.ReportGlVO;
import com.ts.kaikei.vo.StatementVO;

public interface ReportService {
	
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist();
	/* public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator(); */
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();
	
	public List<ReportGlVO> GL_Calculator(Map<String, Object> Parmas);	//GL REPORT
	public List<ReportGlVO> Forward_balance(Map<String, Object> Parmas);	//GL Report Forward_balance [Carried Forward]
	public List<AccountVO> Account_title(String id);	//GL Report Forward_balance [account title]

}