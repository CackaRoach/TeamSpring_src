package com.ts.kaikei.vo;

public class ReportGlVO {
	private String company_cd;
	private String seq;
	private String account_cd;
	private String date;
	private String classify;
	private String debtor;
	private String creditor;
	private String abs;
	private String ent_id;
	private String ent_date;
	private String ent_prog;
	private String mod_id;
	private String mod_date;
	private String mod_prog;
	
	private String SUM_DEB;	//Debtor sum()
	private String SUM_CRED;	//Creditor sum()
	private String BALANCE;	// Debtor - Creditor
	private String MONTH;	// Quarterly month
	private String COUNT_TOTAL;	// Monthly total count
	private String ACC_TITLE;	//Account name
	private String QUARTER;	//QUARTER
	private String YEAR;	//YEAR
	
	
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public String getQUARTER() {
		return QUARTER;
	}
	public void setQUARTER(String qUARTER) {
		QUARTER = qUARTER;
	}
	public String getCompany_cd() {
		return company_cd;
	}
	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
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
	public String getSUM_DEB() {
		return SUM_DEB;
	}
	public void setSUM_DEB(String sUM_DEB) {
		SUM_DEB = sUM_DEB;
	}
	public String getSUM_CRED() {
		return SUM_CRED;
	}
	public void setSUM_CRED(String sUM_CRED) {
		SUM_CRED = sUM_CRED;
	}
	public String getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(String bALANCE) {
		BALANCE = bALANCE;
	}
	public String getMONTH() {
		return MONTH;
	}
	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}
	public String getCOUNT_TOTAL() {
		return COUNT_TOTAL;
	}
	public void setCOUNT_TOTAL(String cOUNT_TOTAL) {
		COUNT_TOTAL = cOUNT_TOTAL;
	}
	public String getACC_TITLE() {
		return ACC_TITLE;
	}
	public void setACC_TITLE(String aCC_TITLE) {
		ACC_TITLE = aCC_TITLE;
	}
	
	
}
