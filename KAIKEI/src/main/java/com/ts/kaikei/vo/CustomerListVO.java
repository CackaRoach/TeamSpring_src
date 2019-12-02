package com.ts.kaikei.vo;

import org.apache.ibatis.type.Alias;

@Alias("CustomerListVO")
public class CustomerListVO {

	private String pageNum;
	private String cus_cd;
	private String title;
	private String fax;
	private String ceo_name;
	private String worker_name;
	private String memo;
	
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
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
	public String getWorker_name() {
		return worker_name;
	}
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}