package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("CompanyVO")
public class CompanyVO {
	private String company_cd;
	private String state_cd;
	private String title;
	private String regist_cd;
	private String fax;
	private String phone;
	private String domain;
	private String bank_title;
	private String bank_acc;
	private String ent_id;
	private String ent_date;
	private String ent_prog;
	private String mod_id;
	private String mod_date;
	private String mod_prog;
	
	public String getCompany_cd() {
		return company_cd;
	}
	
	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
	
	public String getState_cd() {
		return state_cd;
	}
	
	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRegist_cd() {
		return regist_cd;
	}
	
	public void setRegist_cd(String regist_cd) {
		this.regist_cd = regist_cd;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getBank_title() {
		return bank_title;
	}
	
	public void setBank_title(String bank_title) {
		this.bank_title = bank_title;
	}
	
	public String getBank_acc() {
		return bank_acc;
	}
	
	public void setBank_acc(String bank_acc) {
		this.bank_acc = bank_acc;
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
