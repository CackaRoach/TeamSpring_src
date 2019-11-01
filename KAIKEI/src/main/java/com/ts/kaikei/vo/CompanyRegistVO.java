package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

// Company Regist Only VO Object
@Alias("CompanyRegistVO")
public class CompanyRegistVO {
	private String id;
	private String auth_cd;
	private String company_cd;
	private String company_title;
	private String company_regist_cd;
	private String company_fax;
	private String company_phone;
	private String company_domain;
	private String ent_id;
	private String ent_date;
	private String ent_prog;
	private String mod_id;
	private String mod_date;
	private String mod_prog;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuth_cd() {
		return auth_cd;
	}
	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
	}

	public String getCompany_cd() {
		return company_cd;
	}
	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}

	public String getCompany_title() {
		return company_title;
	}
	public void setCompany_title(String company_title) {
		this.company_title = company_title;
	}
	public String getCompany_regist_cd() {
		return company_regist_cd;
	}
	public void setCompany_regist_cd(String company_regist_cd) {
		this.company_regist_cd = company_regist_cd;
	}
	public String getCompany_fax() {
		return company_fax;
	}
	public void setCompany_fax(String company_fax) {
		this.company_fax = company_fax;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}
	public String getCompany_domain() {
		return company_domain;
	}
	public void setCompany_domain(String company_domain) {
		this.company_domain = company_domain;
	}
	public String getEnt_id() {
		return ent_id;
	}
	public void setEnt_id(String ent_id) {
		this.ent_id = ent_id;
	}
	public String getEnt_date() {
		return ent_date;
	}
	public void setEnt_date(String ent_date) {
		this.ent_date = ent_date;
	}
	public String getEnt_prog() {
		return ent_prog;
	}
	public void setEnt_prog(String ent_prog) {
		this.ent_prog = ent_prog;
	}
	public String getMod_id() {
		return mod_id;
	}
	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public String getMod_prog() {
		return mod_prog;
	}
	public void setMod_prog(String mod_prog) {
		this.mod_prog = mod_prog;
	}
	
	
	
}
