package com.srt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class DatabaseOperations {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	public void loadEmployee() {
		List<EmployeeDetails> employeeDetails = employeeDetailsRepository.getAllEmployee();

		for (EmployeeDetails e : employeeDetails) {

			System.out.println(e.getEmpno());
			System.out.println(e.getEmployeeName());
			System.out.println();

		}
	}
	

}
