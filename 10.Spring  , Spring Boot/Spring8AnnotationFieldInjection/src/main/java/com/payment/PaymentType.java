package com.payment;

import org.springframework.stereotype.Component;

@Component("upiPayment")
public class PaymentType {

	private String paymentWay;

	
	
	public PaymentType() {
	System.out.println("PaymentType Object created");
		
	}



	public String getPaymentWay() {
		return paymentWay;
	}



	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}



	
	
	
	
	
	
	
}
