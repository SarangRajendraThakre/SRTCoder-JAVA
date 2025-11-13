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

	public void loadEmployeeByName() {
		List<EmployeeDetails> employeeDetails = employeeDetailsRepository.getEmployeeByName("JAMES");

		for (EmployeeDetails e : employeeDetails) {

			System.out.println(e.getEmpno());
			System.out.println(e.getEmployeeName());
			System.out.println();

		}
	}

	public void loadEmployeeByNameAndSalary() {
		List<EmployeeDetails> employeeDetails = employeeDetailsRepository.getEmployeeByNameAndSalary("SRT", 50000);

		for (EmployeeDetails e : employeeDetails) {

			System.out.println(e.getEmpno());
			System.out.println(e.getEmployeeName());
			System.out.println();

		}

	}

	public void loadEmployeeByNameAndDepartment() {
		List<EmployeeDetails> employeeDetails = employeeDetailsRepository.getEmployeeByNameAndDeptNo("SRT", 10);

		for (EmployeeDetails e : employeeDetails) {

			System.out.println(e.getEmpno());
			System.out.println(e.getEmployeeName());
			System.out.println();
		}
	}

	public void insertEmpRecordByIndexedParameter() {

		// 1. Create the correct Java LocalDate object
		LocalDate hireDate = LocalDate.of(1981, 2, 22);

		// 2. Call the custom repository method with correct types and order
		int count = employeeDetailsRepository.insertEmployeeIndexed(7595L, // Use L suffix for Long type
				"Vidya", "SALESMAN", 7698, hireDate, 1250.00, 500.00, 30);

		System.out.println("Employee record inserted. Records affected: " + count);
	}

	public void insertEmpRecordByNamedParameter() {

		// 1. Create the correct Java LocalDate object
		LocalDate hireDate = LocalDate.of(1981, 2, 22);

		// 2. Call the custom repository method with correct types and order
		int count = employeeDetailsRepository.insertEmployeeNamed(7596L, // Use L suffix for Long type
				"WARD", "SALESMAN", 7698, hireDate, 1250.00, 500.00, 30);

		System.out.println("Employee record inserted. Records affected: " + count);
	}

}
