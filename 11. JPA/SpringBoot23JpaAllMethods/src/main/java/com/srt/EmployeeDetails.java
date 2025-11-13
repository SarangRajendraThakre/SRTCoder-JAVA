package com.srt;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "emp")
@Entity
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
	@Column(name = "ename")
	private String employeeName;
	
	
	private String job;
	@Column(name = "mgr")
	private Integer managerId;
	@Column(name = "hiredate")
	private LocalDate hiredate;
	
	// jpa considering column name and entity property name the same , if the 
	// if column name same as variable name don't need to provide the @Column()
	private int sal;
	
	// if the data type is int
//	Exception in thread "main" org.springframework.orm.jpa.JpaSystemException: Null value was assigned to a property [class com.srt.EmployeeDetails.commition] of primitive type: 'com.srt.EmployeeDetails.commition' (setter)
	@Column(name = "comm")
	private Integer commition;
	
	@Column(name = "deptno")
	private int departmentNo;
	
	
//	
	
}
