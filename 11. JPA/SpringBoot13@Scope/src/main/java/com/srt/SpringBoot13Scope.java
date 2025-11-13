package com.srt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.FileSystemXmlApplicationContext;



@SpringBootApplication
public class SpringBoot13Scope {



 
	public static void main(String[] args) {

		
		ApplicationContext container = SpringApplication.run(SpringBoot13Scope.class,
				args);
	
		
	Product product1 = 	(Product) container.getBean("product");
	System.out.println(product1);
	
	Product product2 = 	(Product) container.getBean("product");
	System.out.println(product2);
	
	Product product3 = 	(Product) container.getBean("product");
	System.out.println(product3);
	
//////////////////////////Order scopes and hash code ////////////////////////////////////
		
Order o1 =	(Order) container.getBean("order");
System.out.println(o1);

Order o2 =	(Order) container.getBean("order");
System.out.println(o2);
////////////  dependency object hashcode 
Order o3 =	(Order) container.getBean("order");
System.out.println(o3.getProduct());


		
	}
		
		
}
