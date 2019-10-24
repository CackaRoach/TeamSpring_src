package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("CustomerVO")
public class CustomerVO {
	String company_cd;
	String cus_cd;
	String title;
	String reg_cd;
	String domain;
	String fax;
	String ceo_name;
	String ceo_phone;
	String ceo_email;
	String worker_name;
	String worker_phone;
	String worker_emial;
	String memo;
	String ent_id;
	String ent_date;
	String ent_prog;
	String mod_id;
	String mod_date;
	String mod_prog;
}
