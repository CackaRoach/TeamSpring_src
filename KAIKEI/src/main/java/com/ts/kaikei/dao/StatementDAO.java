package com.ts.kaikei.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.StatementVO;


@Mapper
public interface StatementDAO {
	public void addStatement(StatementVO statementVO);
	public void deleteStatement(int idx);
	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);
	public StatementVO getStatementDetail(int idx);
	public void updateStatement(StatementVO statementVO);
}
