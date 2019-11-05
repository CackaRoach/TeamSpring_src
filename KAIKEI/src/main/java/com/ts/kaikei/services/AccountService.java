package com.ts.kaikei.services;

import java.util.*;
import com.ts.kaikei.vo.*;

public interface AccountService {
	public List<StatementVO> getStatements(String company_cd);
	public String getCategoryName(int _category);
	public void insertRandom();
}
