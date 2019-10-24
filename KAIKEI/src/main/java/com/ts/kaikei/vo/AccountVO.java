package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("AccountVO")
public class AccountVO {
	String acc_cd; // Account code --> (0101 - Cash)
	String title; // Account title
	String ent_id;
	String ent_date;
	String ent_prog;
	String mod_id;
	String mod_date;
	String mod_prog;
	
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
