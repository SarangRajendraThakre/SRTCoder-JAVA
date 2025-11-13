package com.srt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeansConfiguration {

	@Bean("student1")
	public Student getStudent1() {

		System.out.println("Student1 object created");
		return new Student();

	}
	@Bean("student2")
	public Student getStudent2() {
		
		System.out.println("Student2 object created");
		return new Student();
		
	}
	public Student getStudent3() {
		
		System.out.println("Student3 object created");
		return new Student();
		
	}

	
	

}
