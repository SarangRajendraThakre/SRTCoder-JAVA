
package com.srt;

public class ProductDetails {

//	CREATE TABLE PRODUCT (
//			  PID NUMBER(2,0) PRIMARY KEY ,
//			  PNAME VARCHAR2(20) ,
//			  PPRICE NUMBER(5)
//			);
	
	
	private int pid;
	private String pname;
	private int pprice;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	
}
	
