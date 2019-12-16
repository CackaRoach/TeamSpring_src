
package com.ts.kaikei.services;

import java.util.ArrayList;
import java.util.List;

import com.ts.kaikei.vo.StatementVO;
import com.ts.kaikei.vo.TBTotalVO;

public interface ReportService {

	public ArrayList<StatementVO> getStatementList();
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();

	public List<TBTotalVO> getTbtList(String company_cd);
  
  public List<ReportGlVO> GL_Calculator(Map<String, Object> Parmas);	//GL REPORT
	public List<ReportGlVO> Forward_balance(Map<String, Object> Parmas);	//GL Report Forward_balance [Carried Forward]
	public List<AccountVO> Account_title(String id);	//GL Report Forward_balance [account title]
}