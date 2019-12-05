package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("UserListVO")
public class UserListVO {
	private String id;
	private String password;
	private String company_cd;
	private String posit_cd;
	private String auth_cd;
	private String state_cd;
	private String name;
	private String email;
	private String phone;
	private String ent_id;
	private String ent_date;
	private String ent_prog;
	private String mod_id;
	private String mod_date;
	private String mod_prog;
	private String posit_cd_title;
	private String state_cd_title;
	private String company_name;
	
	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPosit_cd_title() {
		return posit_cd_title;
	}

	public void setPosit_cd_title(String posit_cd_title) {
		this.posit_cd_title = posit_cd_title;
	}

	public String getState_cd_title() {
		return state_cd_title;
	}

	public void setState_cd_title(String state_cd_title) {
		this.state_cd_title = state_cd_title;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCompany_cd() {
		return company_cd;
	}
	
	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
	
	public String getPosit_cd() {
		return posit_cd;
	}
	
	public void setPosit_cd(String posit_cd) {
		this.posit_cd = posit_cd;
	}
	
	public String getAuth_cd() {
		return auth_cd;
	}
	
	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
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
