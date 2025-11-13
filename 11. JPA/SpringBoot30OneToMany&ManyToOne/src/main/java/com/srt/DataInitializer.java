package com.srt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Clear previous data for demonstration
        departmentRepository.deleteAll(); 
        
        // --- 1. Create Parent and Children ---
        Department hr = new Department(101, "Human Resources");
        
        Employee alice = new Employee("Alice Johnson");
        Employee bob = new Employee("Bob Smith");
        
        // --- 2. Link the relationship (crucial to link from BOTH sides, though JPA mostly needs the owning side) ---
        
        // Link Employee to Department (CRUCIAL: Employee owns the FK)
        alice.setDepartment(hr);
        bob.setDepartment(hr);
        
        // Link Department to Employees (Optional, but useful for accessing list)
        hr.getEmployees().addAll(Arrays.asList(alice, bob));
        
        // --- 3. Save the Parent (Cascade saves the children) ---
        departmentRepository.save(hr);
        
        System.out.println("✅ One-to-Many setup complete. Saved Department and 2 Employees.");
        
        // --- 4. Read and Verify the Join ---
        Department retrievedDept = departmentRepository.findById(101).orElseThrow();
        System.out.println("Retrieved Dept: " + retrievedDept.getDeptName());
        System.out.println("Employees in Dept: " + retrievedDept.getEmployees().size());
        retrievedDept.getEmployees().forEach(e -> System.out.println(" - " + e.getEmpName() + " (ID: " + e.getEmpId() + ")"));
    }
}