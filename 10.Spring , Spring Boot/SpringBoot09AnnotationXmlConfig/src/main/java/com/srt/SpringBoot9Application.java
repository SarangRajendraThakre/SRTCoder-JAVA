package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.payment.PaymentGateway;
import com.srt.byName.Cart;
import com.srt.byName.Order;



//@ComponentScan("com.payment")
@SpringBootApplication(scanBasePackages  = {"com.payment" , "com.srt.byName"})
//@SpringBootApplication
//@ImportResource("classpath:spring.xml")
public class SpringBoot9Application {

	public static void main(String[] args) {
		
		ApplicationContext container1 =   	SpringApplication.run(SpringBoot9Application.class, args);
		
		
		
	     ApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");


		PaymentGateway pGateway = (PaymentGateway) container1.getBean("paymentGateway");
		System.out.println(pGateway.getPaymentType().getPaymentWay());

		
		
		
	Order o1 = (Order) container.getBean("order");
		
		Cart cart = o1.getCart();
		
		System.out.println(cart.getProduct1().getProductName());
		System.out.println(cart.getProduct1().getProductPrice());
		System.out.println(cart.getProduct2().getProductName());
		System.out.println(cart.getProduct2().getProductPrice());
		
		
	
		
		
		
	}

}
