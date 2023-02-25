package com.nit.dto;

import java.io.Serializable;

public class customerDTO implements Serializable {
	
	
	private Integer cno;
	private String cname;
	private String cadd;
	private float TotalBillamount;
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public float getTotalBillamount() {
		return TotalBillamount;
	}
	public void setTotalBillamount(float totalBillamount) {
		TotalBillamount = totalBillamount;
	}
	
	
	

}
