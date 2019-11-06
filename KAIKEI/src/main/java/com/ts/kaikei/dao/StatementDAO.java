package com.ts.kaikei.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {

	public ArrayList<StatementVO> getStatementList();
	public ArrayList<StatementVO> getStatementListCond(Map<String, String> searchParams);
	
	public List<StatementVO> getStatements(String company_cd);
} 