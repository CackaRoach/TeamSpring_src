package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("CustomerVO")
public class CustomerVO {

	private String company_cd;
	private String cus_cd;
	private String title;
	private String reg_cd;
	private String domain;
	private String fax;
	private String ceo_name;
	private String ceo_phone;
	private String ceo_email;
	private String worker_name;
	private String worker_phone;
	private String worker_email;
	private String memo;
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
	
	public String getCus_cd() {
		return cus_cd;
	}
	
	public void setCus_cd(String cus_cd) {
		this.cus_cd = cus_cd;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getReg_cd() {
		return reg_cd;
	}
	
	public void setReg_cd(String reg_cd) {
		this.reg_cd = reg_cd;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getCeo_name() {
		return ceo_name;
	}
	
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	
	public String getCeo_phone() {
		return ceo_phone;
	}
	
	public void setCeo_phone(String ceo_phone) {
		this.ceo_phone = ceo_phone;
	}
	
	public String getCeo_email() {
		return ceo_email;
	}
	
	public void setCeo_email(String ceo_email) {
		this.ceo_email = ceo_email;
	}
	
	public String getWorker_name() {
		return worker_name;
	}
	
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	
	public String getWorker_phone() {
		return worker_phone;
	}
	
	public void setWorker_phone(String worker_phone) {
		this.worker_phone = worker_phone;
	}
	
	public String getWorker_email() {
		return worker_email;
	}
	
	public void setWorker_email(String worker_email) {
		this.worker_email = worker_email;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
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
