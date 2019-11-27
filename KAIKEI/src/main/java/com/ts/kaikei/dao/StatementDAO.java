
package com.ts.kaikei.dao;

import java.util.*;


import org.apache.ibatis.annotations.Mapper;
import com.ts.kaikei.vo.*;

@Mapper
public interface StatementDAO {
	public ArrayList<StatementVO> getStatementList(String company_cd);
	public void addStatement(StatementVO statementVO);
	public void editStatement(StatementVO statementVO);
	public String getPageSize(String company_cd);
}

