package com.srt.byName;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Cart {

	private int NoOfItem;
	
	
	private Product product1;

	private Product product2;
	
	
	public int getNoOfItem() {
		return NoOfItem;
	}
	public void setNoOfItem(int noOfItem) {
		NoOfItem = noOfItem;
	}
	public Product getProduct1() {
		return product1;
	}
	public void setProduct1(Product product1) {
		this.product1 = product1;
	}
	public Product getProduct2() {
		return product2;
	}
	public void setProduct2(Product product2) {
		this.product2 = product2;
	}
	
	
	
	
}
