package com.srt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.EmployeeRequest;
import com.srt.response.EmployeeResponse;
import com.srt.service.EmployeeService;


@RestController
@RequestMapping("/api/employees") 
public class EmployeeController {
    
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		String response = employeeService.createEmployee(employeeRequest);
		return response;	
	}
	
	@GetMapping("/get/emp/{id}") // METHOD 1: Get by Integer ID
    public EmployeeResponse getEmployeeById(@PathVariable("id") Integer id ) 
    {
        EmployeeResponse employeeResponse = employeeService.getEmpById(id);
        return employeeResponse;
    }
    
    // METHOD 2: Get by Department Name (Requires unique path, check this!)
    @GetMapping("/get/dept/{dname}") // Ensure this is the only path used for dname!
    public List<EmployeeResponse> getEmployeesByDepartment(@PathVariable("dname") String departmentName ) 
    {
        List<EmployeeResponse> employeeResponses = employeeService.getEmpByDepartmentName(departmentName);
        return employeeResponses;
    }
}