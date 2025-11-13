package com.srt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
public class SpringBoot14BeanLifeCyle {

	public static void main(String[] args) {

		ApplicationContext container = SpringApplication.run(SpringBoot14BeanLifeCyle.class, args);

//		Product product1 = (Product) container.getBean("product");
//		System.out.println(product1);
//		System.out.println(product1.getProductName());
//
//		Product product2 = (Product) container.getBean("product");
//		System.out.println(product2);
//		System.out.println(product2.getProductName());

	}

}
