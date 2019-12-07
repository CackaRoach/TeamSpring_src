
package com.ts.kaikei.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {
	public ArrayList<StatementListVO> selectStatementList(Map<String, String> searchParams);
	public void saveStatement(Map<String, Object> statement);
	
	public ArrayList<StatementListVO> getStatementList();
	public ArrayList<ArrayList<StatementListVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();
	
	public void stateCompanyDelete(String id);	//manage
	public void companyCodeCh_std(Map<String, Object> Parmas);	//manage
}

