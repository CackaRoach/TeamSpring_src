
package com.ts.kaikei.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {
	public ArrayList<StatementListVO> selectStatementList(Map<String, String> searchParams);
	public void saveStatement(Map<String, Object> statement);
	
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();
	
	public void stateCompanyDelete(String id);	//manage
	public void companyCodeCh_std(Map<String, Object> Parmas);	//manage
	
	public List<ReportGlVO> GeneralLedgerList(Map<String, Object> Params);	//general ledger report list
	public List<ReportGlVO> Forward_balance(Map<String, Object> Parmas);	//general ledger report list [Carried Forward]
	public List<AccountVO> Account_title(String id);	//general ledger report list [account title]
}

