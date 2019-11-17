package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("StatementListVO")
public class StatementListVO {
	private String account_cd;
	private String title;
	private String customer_cd;
	private String year;
	private String month;
	private String date;
	private String classify;
	private int debtor;
	private int creditor;
	private String abs;
	
	public String getAccount_cd() {
		return account_cd;
	}
	public void setAccount_cd(String account_cd) {
		this.account_cd = account_cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCustomer_cd() {
		return customer_cd;
	}
	public void setCustomer_cd(String customer_cd) {
		this.customer_cd = customer_cd;
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
	
}
