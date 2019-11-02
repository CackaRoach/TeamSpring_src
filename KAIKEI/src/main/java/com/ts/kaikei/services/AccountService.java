package com.ts.kaikei.services;

import java.util.*;
import com.ts.kaikei.vo.*;

public interface AccountService {
	public List<StatementVO> getStatements(StatementKeyVO keyword);
	public List<StatementVO> getStatements();
	public List<CompanyVO> getCompanies(CompanyKeyVO keyword);
	public List<CompanyVO> getCompanies();
}
