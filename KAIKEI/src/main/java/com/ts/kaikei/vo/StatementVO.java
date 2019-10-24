package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("StatementVO")
public class StatementVO {
	int seq;
	String date;
	String classify;
	int deb;
	int cred;
	String abs;
	String ent_id;
	String ent_prog;
	String mod_id;
	String company_cd;
	

}
