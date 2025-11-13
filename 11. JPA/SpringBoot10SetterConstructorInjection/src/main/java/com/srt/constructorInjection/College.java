package com.srt.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class College {

	
	private Student student1;
	private Student student2;
	
	
	
	
	public Student getStudent1() {
		return student1;
	}








	public Student getStudent2() {
		return student2;
	}






@Autowired
	public College(Student stud1, Student stud2) {
		super();
		this.student1 = stud1;
		this.student2 = stud2;
	}
	

	
	
	
	
}
