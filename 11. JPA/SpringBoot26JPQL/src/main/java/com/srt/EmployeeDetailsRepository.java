package com.srt;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

	// native query
//	@Query(value = "Select * from emp", nativeQuery = true)
	// in JPQL query everything is class oriented means table name also class name  , 
	// column name is also variable name all that 
	@Query(value = "Select e from EmployeeDetails e", nativeQuery = false)
	List<EmployeeDetails> getAllEmployee();
	

	
}
