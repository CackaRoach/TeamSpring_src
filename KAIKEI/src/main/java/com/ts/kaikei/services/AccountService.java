package com.ts.kaikei.services;

import java.util.*;
import com.ts.kaikei.vo.*;

public interface AccountService {
	public List<StatementVO> getStatements(String company_cd);
	public String getCategoryName(int _category);
	public List<StatementVO> codeToName(List<StatementVO> list);
	public void addStatement(StatementVO statement);
	public int getMaxSeq(String company_cd);
	public CompanyVO getCompanyOfCode(String company_cd);	
	public CustomerVO getCustomerOfCode(String customer_cd);
}
