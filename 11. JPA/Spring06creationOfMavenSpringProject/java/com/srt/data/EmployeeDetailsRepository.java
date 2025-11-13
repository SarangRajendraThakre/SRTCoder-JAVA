package com.srt.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails, Long> {

	// Find employees with salary greater than the input value
	List<EmployeeDetails> findBySalGreaterThan(int sal);
	
	// Find employees whose name contains a fragment, ignoring case
	List<EmployeeDetails> findByEmployeeNameContainingIgnoreCase(String nameFragment);
	
	// Find employees who were hired after a specific date
	List<EmployeeDetails> findByHiredateAfter(LocalDate hiredate);
	
	// Find employees by job AND department number
	List<EmployeeDetails> findByJobAndDepartmentNo(String job, int departmentNo);
	
	// Find employee by job AND order the results by name ascending
	List<EmployeeDetails> findByJobOrderByEmployeeNameAsc(String job);
}