
package com.ts.kaikei.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.StatementListVO;
import com.ts.kaikei.vo.StatementVO;
import com.ts.kaikei.vo.TBTotalVO;


@Mapper
public interface StatementDAO {
	public List<StatementListVO> selectStatementList(Map<String, String> searchParams);
	public void saveStatement(Map<String, Object> statement);
	
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();
	
	public void stateCompanyDelete(String id);	//manage
	public void companyCodeCh_std(Map<String, Object> Parmas);	//manage
	
	public List<TBTotalVO> selectTBTotal(String company_cd);
}

