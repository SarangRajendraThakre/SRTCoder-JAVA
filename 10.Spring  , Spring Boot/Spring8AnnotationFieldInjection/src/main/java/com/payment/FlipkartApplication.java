package com.payment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FlipkartApplication {

	public static void main(String[] args) {

		ApplicationContext container = new AnnotationConfigApplicationContext(BeansConfiguratin.class);

		PaymentGateway pGateway = (PaymentGateway) container.getBean("paymentGateway");
		System.out.println(pGateway.getPaymentType().getPaymentWay());

	}

}
