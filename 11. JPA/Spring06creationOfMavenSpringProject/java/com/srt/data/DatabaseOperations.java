package com.srt.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseOperations {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	// --- CRUD Methods ---
	
	public EmployeeDetails saveEmployee(EmployeeDetails employee) {
		return employeeDetailsRepository.save(employee);
	}

	public Optional<EmployeeDetails> getEmployeeById(Long empno) {
		return employeeDetailsRepository.findById(empno);
	}
    
    public List<EmployeeDetails> getAllEmployees() {
        // CrudRepository's findAll() returns an Iterable, cast it to List
        return (List<EmployeeDetails>) employeeDetailsRepository.findAll();
    }
    
    // --- Custom Query Methods ---

	public List<EmployeeDetails> findHighSalariedEmployees(int minSal) {
		return employeeDetailsRepository.findBySalGreaterThan(minSal);
	}

	public List<EmployeeDetails> findEmployeesByJobAndDept(String job, int deptNo) {
		return employeeDetailsRepository.findByJobAndDepartmentNo(job, deptNo);
	}
    
    public void deleteEmployeeById(Long empno) {
		employeeDetailsRepository.deleteById(empno);
	}
}