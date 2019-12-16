package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("TBTotalVO")
public class TBTotalVO {
    private int acc_cd;
    private String classify;
    private String title;
    private int deb;
    private int debbal;
    private int cred;
    private int credbal;
    
	public int getAcc_cd() {
		return acc_cd;
	}
	public void setAcc_cd(int acc_cd) {
		this.acc_cd = acc_cd;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDeb() {
		return deb;
	}
	public void setDeb(int deb) {
		this.deb = deb;
	}
	public int getDebbal() {
		return debbal;
	}
	public void setDebbal(int debbal) {
		this.debbal = debbal;
	}
	public int getCred() {
		return cred;
	}
	public void setCred(int cred) {
		this.cred = cred;
	}
	public int getCredbal() {
		return credbal;
	}
	public void setCredbal(int credbal) {
		this.credbal = credbal;
	}
}
