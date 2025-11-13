 package com.srt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	

//    @Query("SELECT e FROM Employee e JOIN e.address a WHERE a.city = :cityName")
//    List<Employee> findByAddressCityJPQL(@Param("cityName") String cityName);
    
    
	// Inside the EmployeeRepository interface:

	// FIX: Change 'Address_City' to 'Department_DeptName' 
	// (If you want to search by the Department's name field)
	List<Employee> findByDepartment_DeptName(String deptName); 

	// You must remove or correct the faulty findByAddress_City method.
    
    
//    @Query(value = "SELECT e.* FROM employee e JOIN address a ON e.address_id = a.address_id WHERE a.city = ?1", 
//            nativeQuery = true)
//     List<Employee> findByAddressCityNative(String cityName);
 
    
	
}
