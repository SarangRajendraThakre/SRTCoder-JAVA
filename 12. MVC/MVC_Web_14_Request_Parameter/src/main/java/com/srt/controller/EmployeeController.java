package com.srt.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// Path variable 
	@GetMapping("/get/emp/{id}") // METHOD 1: Get by Integer ID
    public EmployeeResponse getEmployeeById(@PathVariable("id") Integer id ) 
    {
        EmployeeResponse employeeResponse = employeeService.getEmpById(id);
        return employeeResponse;
    }
	
	// KEEP THIS METHOD BLOCK (The correct RESTful DELETE endpoint)
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
	    String response = employeeService.deleteEmployee(id);
	    return response;
	}
	
	
    
	// Path variable 
    // METHOD 2: Get by Department Name (Requires unique path, check this!)
    @GetMapping("/get/dept/{dname}") // Ensure this is the only path used for dname!
    public List<EmployeeResponse> getEmployeesByDepartment(@PathVariable("dname") String departmentName ) 
    {
        List<EmployeeResponse> employeeResponses = employeeService.getEmpByDepartmentName(departmentName);
        return employeeResponses;
    }
    
//    @GetMapping("/get/emp/{hDate}/{name}") // Error will occur tell me why
    @GetMapping("/search/date_name/{hDate}/{name}") // FIX: Renamed base path
    public List<EmployeeResponse> getEmployeByHiredateAndNameStartwithS(
//        @PathVariable("hDate") LocalDate hDate, 
//        @PathVariable("name") String name
// you can skip the name in path variable if the names are same in method variable and pathvariable     		
        @PathVariable LocalDate hDate, 
        @PathVariable String name
    ) {
    	List<EmployeeResponse> employeeResponse = employeeService.getEmployeByHiredateAndNameStartwithS(hDate, name);
    	return employeeResponse;
    }
    
    
    
    // Path variable 
    // METHOD 2: Get by Department Name (Requires unique path, check this!)
    @GetMapping("/get/all") // Ensure this is the only path used for dname!
    public List<EmployeeResponse> getAllEmployees( ) 
    {
    	List<EmployeeResponse> employeeResponses = employeeService.getAllEmployees();
    	return employeeResponses;
    }
    
    // thisis the example of @Resquet Parameter using the join inside 
    
    @GetMapping("/search/country_salary")
    public List<EmployeeResponse> searchEmployees(
    		
//        @RequestParam("country") String country,
//        @RequestParam("salary") double salary
// you can make the query parameter optional too , by default required is true		
        @RequestParam( name = "country", required = false ) String country,
        @RequestParam("salary") double salary
// you can skip the variable if the name are same     		
//        @RequestParam String country,
//        @RequestParam double salary
    		
    ) {
        // Call the new service method
        List<EmployeeResponse> employeeResponses = employeeService.getEmployeesByCountryAndSalary(country, salary);
        
        return employeeResponses;
    }
    
    
    @PutMapping("/{id}") // Maps to: PUT /api/employees/{id}
    public EmployeeResponse updateEmpById(
        @PathVariable Integer id,
        @RequestBody EmployeeRequest employeeRequest
    ) {
        // Call the service layer to perform the update
        EmployeeResponse updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return updatedEmployee;
    }
    
    
    
    
//    -> Note :
//
//    	if we are having limited no of properties and all are madnatory, then go with Path variables.
//
//    	> Request Params we can consider when we have many searh criterias with non-mandatory options
//    
    
    
    
    
    
}