package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("AccountVO")
public class AccountVO {
	private String company_cd;
	private String acc_cd; // Account code --> (0101 - Cash)
	private String title; // Account title
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
	
	public String getAcc_cd() {
		return acc_cd;
	}
	
	public void setAcc_cd(String acc_cd) {
		this.acc_cd = acc_cd;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
