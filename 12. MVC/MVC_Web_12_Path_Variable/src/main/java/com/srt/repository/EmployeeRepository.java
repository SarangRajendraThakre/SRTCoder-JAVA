package com.srt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srt.entity.EmployeeE;
import java.util.List;



public interface EmployeeRepository extends JpaRepository<EmployeeE,Integer > {

public 	List<EmployeeE> findByDname(String dname);
	
}
