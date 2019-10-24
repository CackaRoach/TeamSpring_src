package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("ComapnayVO")
public class CompanyVO {
	String company_cd;
	String state_cd;
	String name;
	String regist_cd;
	String fax;
	String phone;
	String domain;
	String bank_title;
	String bank_acc;
	String ent_id;
	String ent_date;
	String ent_prog;
	String mod_id;
	String mod_date;
	String mod_prog;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
