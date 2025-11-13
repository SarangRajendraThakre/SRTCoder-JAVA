package com.srt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.srt.interfacce.Garrage;



@SpringBootApplication
public class SpringBoot10SetterConstructorInjection {

 
	public static void main(String[] args) {
		
		
		
		ApplicationContext container = SpringApplication.run(SpringBoot10SetterConstructorInjection.class,
				args);

		
   Garrage garrage = 		(Garrage) container.getBean("garrage");
   
   garrage.startVehicle();
  
		
		
	}
}
