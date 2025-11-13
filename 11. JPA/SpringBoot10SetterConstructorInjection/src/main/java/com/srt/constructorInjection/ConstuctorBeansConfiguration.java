package com.srt.constructorInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ConstuctorBeansConfiguration {
	
//	if  variable name matched then by byName;
//	If  there  is only one bean direclty injecting  : byType 
//	If there is more then one bean then : Error of   a single bean, but 2 were found: 
	
//	Parameter 0 of constructor in com.srt.constructorInjection.College required a single bean, but 2 were found:
//		- student1: defined by method 'getStudent1' in class path resource [com/srt/constructorInjection/ConstuctorBeansConfiguration.class]
//		- student2: defined by method 'getStudent2' in class path resource [com/srt/constructorInjection/ConstuctorBeansConfiguration.class]

	
	
	@Bean("stud1")
	public Student  getStudent1() {
		
		// if you fail to write the new keyword UnsatisfiedDependencyException 
		return new  Student("Vidya" , 12312412l);
	}
	
	@Bean("stud2")
	public Student  getStudent2() {
		
		// if you fail to write the new keyword UnsatisfiedDependencyException 
		return new  Student("Rajendra" , 1234354342);
	}
	
	
	

	
}
