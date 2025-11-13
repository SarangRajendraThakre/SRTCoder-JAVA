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

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	public Student getStudent2() {
		return student2;
	}

	public void setStudent2(Student student2) {
		this.student2 = student2;
	}

	@Autowired
	public College(Student student1, Student student2) {
		super();
		this.student1 = student1;
		this.student2 = student2;
	}
	

	

	
	
	
	
}
