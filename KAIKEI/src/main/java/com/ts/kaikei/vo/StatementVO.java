package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("StatementVO")
public class StatementVO {
	private String company_cd;
	private int seq;
	private String account_cd;
	private String customer_cd;
	private String date;
	private String classify;
	private String debtor;
	private String creditor;
	private String abs;			// Abstract
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
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getAccount_cd() {
		return account_cd;
	}
	
	public void setAccount_cd(String account_cd) {
		this.account_cd = account_cd;
	}
	
	public String getCustomer_cd() {
		return customer_cd;
	}
	
	public void setCustomer_cd(String customer_cd) {
		this.customer_cd = customer_cd;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getClassify() {
		return classify;
	}
	
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	public String getDebtor() {
		return debtor;
	}
	
	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}
	
	public String getCreditor() {
		return creditor;
	}
	
	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}
	
	public String getAbs() {
		return abs;
	}
	
	public void setAbs(String abs) {
		this.abs = abs;
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
