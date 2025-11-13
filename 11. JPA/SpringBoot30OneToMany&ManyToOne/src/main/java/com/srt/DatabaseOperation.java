package com.srt; // Assuming this is the correct package for the service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Assuming Employee and Department entities and their repositories are available
// You would need to ensure the DepartmentRepository and EmployeeRepository interfaces are defined.

@Component
public class DatabaseOperation {

    // You need the repository interfaces injected here
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository; 

    // --- 1. Create and Save the Graph (Cascade Operation) ---

    @Transactional
    public void saveOneToManyRelationship() {
        System.out.println("\n--- Starting 1:N Save Operation (Dept ID 1) ---");
        
        // 1. Create Parent and Children
        Department sales = new Department(1, "Sales");
        Employee emp1 = new Employee("Michael Scott");
        Employee emp2 = new Employee("Dwight Schrute");
        
        // 2. Link the Relationship (CRUCIAL: Employee owns the FK)
        emp1.setDepartment(sales);
        emp2.setDepartment(sales);
        
        // 3. Link the Inverse Side (For object access in Java)
        sales.getEmployees().addAll(Arrays.asList(emp1, emp2));
        
        // 4. Save the Parent: Cascade saves the children (employees) automatically.
        departmentRepository.save(sales); 
        
        System.out.println("✅ Department 'Sales' and 2 Employees saved (Dept ID: 1).");
    }

    // --- 2. Retrieve the Graph (Demonstrating Lazy Loading) ---

    @Transactional(readOnly = true)
    public void loadOneToManyRelationship(Integer deptId) {
        // We use a different message format here since we don't know the package of this code
        System.out.println("\n--- Loading 1:N Relationship (Dept ID: " + deptId + ") ---");
        
        // 1. Retrieve the Parent (Department)
        Optional<Department> deptOptional = departmentRepository.findById(deptId);
        
        deptOptional.ifPresent(dept -> {
            System.out.println("Retrieved Dept: " + dept.getDeptName());
            
            // 2. Accessing the Employees list triggers the LAZY load (a separate SELECT query)
            List<Employee> employees = dept.getEmployees();
            
            System.out.println("Total Employees (Lazy Loaded): " + employees.size());
            employees.forEach(e -> {
                // Accessing child fields
                System.out.println(" -> Employee: " + e.getEmpName() + " (Emp ID: " + e.getEmpId() + ")");
            });
        });
        deptOptional.orElseGet(() -> {
            System.out.println("Department with ID " + deptId + " not found.");
            return null;
        });
    }

    // --- 3. Deletion of the Parent (Demonstrating Cascade) ---
    
    @Transactional
    public void deleteDepartment(Integer deptId) {
        System.out.println("\n--- Deleting Department (ID: " + deptId + ") ---");
        
        // The @OneToMany(cascade = CascadeType.ALL) ensures cascading deletion.
        departmentRepository.deleteById(deptId);
        System.out.println("✅ Department and all associated Employees have been deleted (cascaded).");
    }
}