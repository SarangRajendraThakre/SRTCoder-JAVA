package com.srt.constructorInjection;

import org.springframework.stereotype.Component;


public class Student {

	private String name="SRT";
	private long pnr=211000121245050l;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, long pnr) {
		super();
		this.name = name;
		this.pnr = pnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPnr() {
		return pnr;
	}

	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	
	
	
	
	
	
	
	
}
