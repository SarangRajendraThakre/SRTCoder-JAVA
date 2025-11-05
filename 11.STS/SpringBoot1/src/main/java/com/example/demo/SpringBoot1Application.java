package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.payment.PaymentGateway;

//@ComponentScan("com.payment")
@SpringBootApplication(scanBasePackages  = {"com.payment"})
//@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		ApplicationContext container =   	SpringApplication.run(SpringBoot1Application.class, args);
		
		

		PaymentGateway pGateway = (PaymentGateway) container.getBean("paymentGateway");
		System.out.println(pGateway.getPaymentType().getPaymentWay());

		
	}

}
