package com.ts.kaikei.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {

	public ArrayList<StatementListVO> getStatementList(String company_cd);
	public void addStatement(StatementVO statementVO);
}

