package com.ts.kaikei.dao;


import org.apache.ibatis.annotations.Mapper;
import java.util.*;
import com.ts.kaikei.vo.*;


@Mapper
public interface StatementDAO {
	public void addStatement(StatementVO statementVO);
	public void deleteStatement(int idx);
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);
	public StatementVO getStatementDetail(int idx);
	public void updateStatement(StatementVO statementVO);
	
	public List<StatementVO> getStatements(StatementKeyVO keyword);
	public List<StatementVO> getStatements();
	public List<StatementVO> getStatementAt(int idx);
}