package com.srt.data;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;



@Component
public class EmployeeDetails {

//	CREATE TABLE emp (
//		    empno NUMBER(4,0) PRIMARY KEY,
//		    ename VARCHAR2(10),
//		    job VARCHAR2(9),
//		    mgr NUMBER(4,0),
//		    hiredate DATE,
//		    sal NUMBER(7,2),
//		    comm NUMBER(7,2),
//		    deptno NUMBER(2,0) REFERENCES dept(deptno)
//		);
	


	@Id
	private Long empno;
	private String employeeName;
	
	
	private String job;
	private Integer managerId;
	private LocalDate hiredate;
	
	// jpa considering column name and entity property name the same , if the 
	// if column name same as variable name don't need to provide the @Column()
	private int sal;
	
	// if the data type is int
//	Exception in thread "main" org.springframework.orm.jpa.JpaSystemException: Null value was assigned to a property [class com.srt.EmployeeDetails.commition] of primitive type: 'com.srt.EmployeeDetails.commition' (setter)
	private Integer commition;
	
	private int departmentNo;
	
	
//	
	
}
