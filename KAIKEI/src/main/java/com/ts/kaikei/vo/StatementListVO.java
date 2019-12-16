package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("StatementListVO")
public class StatementListVO {
	
	private String pagenum;
	private String seq;
	private String account_cd;
	private String acc_title;
	private String customer_cd;
	private String cus_title;
	private String year;
	private String month;
	private String date;
	private String classify;
	private int debtor;
	private int creditor;
	private String abs;
	private String mod_date;
	
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getAccount_cd() {
		return account_cd;
	}
	public void setAccount_cd(String account_cd) {
		this.account_cd = account_cd;
	}
	public String getAcc_title() {
		return acc_title;
	}
	public void setAcc_title(String acc_title) {
		this.acc_title = acc_title;
	}
	public String getCustomer_cd() {
		return customer_cd;
	}
	public void setCustomer_cd(String customer_cd) {
		this.customer_cd = customer_cd;
	}
	public String getCus_title() {
		return cus_title;
	}
	public void setCus_title(String cus_title) {
		this.cus_title = cus_title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	public int getDebtor() {
		return debtor;
	}
	public void setDebtor(int debtor) {
		this.debtor = debtor;
	}
	public int getCreditor() {
		return creditor;
	}
	public void setCreditor(int creditor) {
		this.creditor = creditor;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	
	
}
