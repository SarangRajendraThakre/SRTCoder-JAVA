package com.srt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import jakarta.transaction.Transactional;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

//	customized findBy...
	
	/////////////////////////////    findBy  ///////////////////////////////////

	
	List<EmployeeDetails> findByJob(String job);
	List<EmployeeDetails> findBySal(int sal);
	List<EmployeeDetails> findByManagerId(int mg);
	List<EmployeeDetails> findByEmployeeName( String Ename);
	
	
	
	
	/////////////////////////////    findBy...And.....   ///////////////////////////////////
	
	
	// get employee based on job and mgr 
	List<EmployeeDetails> findByJobAndManagerId(String job , int mgr);
	
	// get employee based on  hiredate and deptno
	List<EmployeeDetails> findByHiredateAndDepartmentNo(LocalDate hiredate, int dn);


	
	/////////////////////////////    findBy...Or.....   ///////////////////////////////////
	

	// get employee based on job and mgr 
	List<EmployeeDetails> findByJobOrManagerId(String job , int mgr);
	
	// get employee based on  hiredate and deptno
	List<EmployeeDetails> findByHiredateOrDepartmentNo(LocalDate hiredate, int dn);
	
	
//	how to delete data based on non primary key column
	@Transactional
	
	 int deleteByHiredate(LocalDate hiredate);
	

}
	
	
	