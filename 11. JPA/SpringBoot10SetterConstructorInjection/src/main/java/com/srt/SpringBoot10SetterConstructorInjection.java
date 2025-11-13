package com.srt;
import com.srt.setterInjection.SetterBeansConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.srt.constructorInjection.College;
import com.srt.setterInjection.Employee;


@SpringBootApplication
public class SpringBoot10SetterConstructorInjection {

 
	public static void main(String[] args) {
		
		
		
		ApplicationContext container = SpringApplication.run(SpringBoot10SetterConstructorInjection.class,
				args);

		
		
		Object object = container.getBean("employee");

		Employee e1 = (Employee) object;

		System.out.println(e1.getEmpno());
		System.out.println(e1.getName());
		System.out.println(e1.getPhoneNo());

		System.out.println(e1.getAddress().getCity());
		System.out.println(e1.getAddress().getPincode());
		System.out.println(e1);
		
		
		System.out.println();
		System.out.println("Contructor injection using Student and College ");		
		/////////////////////////////////constructor injection calling /////////////////////////////////////////////////////

		
		College college = (College) container.getBean("college");
		 
		 
		 System.out.println(college);
	 
		 System.out.println(college.getStudent1().getName());
		 System.out.println(college.getStudent1().getPnr());
		 System.out.println();
//		 System.out.println(college.getStudent2().getName());
//		 System.out.println(college.getStudent2().getPnr());
//		 System.out.println();
		 
		
		
		
	}

}
