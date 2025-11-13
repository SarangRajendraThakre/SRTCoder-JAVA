package com.srt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnoationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext container = new AnnotationConfigApplicationContext(SpringBeansConfiguration.class , SpringBeansConfiguration2.class);
		
	     Student s1 = 	(Student) container.getBean("student1");
	     Student s2 = 	(Student) container.getBean("student2");
	     
	   College c1 =  (College) container.getBean("college1");
	   System.out.println(c1.getCollegeName());
	   System.out.println(c1.getEstablishYear());
	   
	   
	   
	 ProjectDetail pDetail =    (ProjectDetail) container.getBean("projectDetail");
	 System.out.println(pDetail.getProjectName());
	     
	     
	     
		

	}

}
