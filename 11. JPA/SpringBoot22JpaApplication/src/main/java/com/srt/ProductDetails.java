package com.srt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//CREATE TABLE PRODUCT (
//		  PID NUMBER(2,0) PRIMARY KEY ,
//		  PNAME VARCHAR2(20) ,
//		  PPRICE NUMBER(5)
//		);


@Entity
@Table(name = "PRODUCT")
public class ProductDetails {

	@Id
	@Column(name = "PID")
	private Integer productID;
	@Column(name = "PNAME")
	private String productName;
	@Column(name = "PPRICE")
	private double productPrice;
	
	
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductDetails(Integer productID, String productName, double productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
