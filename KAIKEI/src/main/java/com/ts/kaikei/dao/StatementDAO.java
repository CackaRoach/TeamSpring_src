package com.ts.kaikei.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {
	public void addStatement(StatementVO statementVO);
	public void deleteStatement(int idx);
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);
	public StatementVO getStatementDetail(int idx);
	public void updateStatement(StatementVO statementVO);
	
	public List<StatementVO> getStatements(String company_cd);
	public List<StatementVO> getStatementAt(String company_cd, int idx);
	public List<StatementVO> findStatements(String company_cd, SearchKeyVO key);
	
	public int getMaxSeq(String company_cd);	
}