package com.payment;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ComponentScan("com.payment")
@Configuration
public class BeansConfiguratin {

	@Bean
	public PaymentType creditCardPaymentType() {
		
		PaymentType payment = new PaymentType();
		
		payment.setPaymentWay("Credit card Payment");
		
		return payment;
	}
	
	@Primary
	@Bean
	public PaymentType debitCardPaymentType() {
		
		PaymentType payment = new PaymentType();
		
		payment.setPaymentWay("Debit card Payment");
		
		return payment;
	}
	

	
	
	
}
