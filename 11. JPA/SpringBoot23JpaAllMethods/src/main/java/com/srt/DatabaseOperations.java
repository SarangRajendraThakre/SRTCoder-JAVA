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

    // Reusable Date Formatter (for Oracle date string format like 1/Jan/2025)
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MMM/yyyy");

    // ----------------------------------------------------
    // 1️⃣ Insert Single Employee
    // ----------------------------------------------------
    public void addEmployee() {
        LocalDate hireDate = LocalDate.parse("12/Nov/2000", formatter);
        EmployeeDetails ed = new EmployeeDetails(100L, "SRT", "Software", null, hireDate, 50000, 1, 10);
        employeeDetailsRepository.save(ed);
        System.out.println("✅ Employee added successfully: " + ed);
    }

    // ----------------------------------------------------
    // 2️⃣ Insert Multiple Employees
    // ----------------------------------------------------
    public void addMoreEmployee() {
        List<EmployeeDetails> empList = new ArrayList<>();

        empList.add(new EmployeeDetails(7L, "Manoj", "AI", null, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 10));
        empList.add(new EmployeeDetails(8L, "Kiran", "FSD", 1, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 20));
        empList.add(new EmployeeDetails(9L, "Kajol", "MSB", 2, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 20));
        empList.add(new EmployeeDetails(10L, "Rahul", "Analyst", 3, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 40));
        empList.add(new EmployeeDetails(11L, "Kalash", "Frontend", 4, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 20));
        empList.add(new EmployeeDetails(18L, "Pratik", "SQL", 5, LocalDate.parse("1/Jan/2025", formatter), 80000, 20000, 10));

        employeeDetailsRepository.saveAll(empList);
        System.out.println("✅ Multiple employees added successfully");
    }

    // ----------------------------------------------------
    // 3️⃣ Load All Employees
    // ----------------------------------------------------
    public void loadAllEmployee() {
        List<EmployeeDetails> list = employeeDetailsRepository.findAll();
        list.forEach(e -> {
            System.out.println(e.getEmpno() + " - " + e.getEmployeeName());
        });
    }

    // ----------------------------------------------------
    // 4️⃣ Load Employee by ID
    // ----------------------------------------------------
    public void loadAllEmployeeById() {
        Optional<EmployeeDetails> optional = employeeDetailsRepository.findById(2L);
        if (optional.isPresent()) {
            EmployeeDetails ed = optional.get();
            System.out.println("✅ Employee found: " + ed);
        } else {
            System.out.println("❌ No employee found with ID 2");
        }
    }

    // ----------------------------------------------------
    // 5️⃣ Find by Job
    // ----------------------------------------------------
    public void loadAllEmployeeByJob() {
        List<EmployeeDetails> list = employeeDetailsRepository.findByJob("Frontend");
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 6️⃣ Find by Manager ID
    // ----------------------------------------------------
    public void loadAllEmployeeByMgr() {
        List<EmployeeDetails> list = employeeDetailsRepository.findByManagerId(5);
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 7️⃣ Find by Employee Name
    // ----------------------------------------------------
    public void loadAllEmployeeByEname() {
        List<EmployeeDetails> list = employeeDetailsRepository.findByEmployeeName("SRT");
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 8️⃣ Find by Job AND Manager ID
    // ----------------------------------------------------
    public void loadAllEmployeeByJobAndMgr() {
        List<EmployeeDetails> list = employeeDetailsRepository.findByJobAndManagerId("SQL", 5);
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 9️⃣ Find by Hiredate AND Department No
    // ----------------------------------------------------
    public void loadAllEmployeeByHiredateAndDeptno() {
        LocalDate hireDate = LocalDate.parse("17/Nov/1981", formatter);
        List<EmployeeDetails> list = employeeDetailsRepository.findByHiredateAndDepartmentNo(hireDate, 10);
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 🔟 Find by Job OR Manager ID
    // ----------------------------------------------------
    public void loadAllEmployeeByJobOrMgr() {
        List<EmployeeDetails> list = employeeDetailsRepository.findByJobOrManagerId("SQL", 4);
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 11️⃣ Find by Hiredate OR Department No
    // ----------------------------------------------------
    public void loadAllEmployeeByHiredateOrDeptno() {
        LocalDate hireDate = LocalDate.parse("17/Nov/1981", formatter);
        List<EmployeeDetails> list = employeeDetailsRepository.findByHiredateOrDepartmentNo(hireDate, 10);
        list.forEach(e -> System.out.println(e.getEmployeeName()));
    }

    // ----------------------------------------------------
    // 12️⃣ Delete by ID
    // ----------------------------------------------------
    public void deleteEmployeeById() {
        employeeDetailsRepository.deleteById(7369L);
        System.out.println("✅ Employee deleted by ID");
    }

    // ----------------------------------------------------
    // 13️⃣ Delete by Hiredate
    // ----------------------------------------------------
    public void deleteEmployeeByHiredate() {
        LocalDate hireDate = LocalDate.parse("09/Dec/1982", formatter);
        int count = employeeDetailsRepository.deleteByHiredate(hireDate);
        System.out.println("✅ Employees deleted: " + count);
    }

    // ----------------------------------------------------
    // 14️⃣ Update Salary by ID
    // ----------------------------------------------------
    @Modifying
    @Transactional
    public void updateEmployeeSalaryById(long id, int newSalary) {
        Optional<EmployeeDetails> optional = employeeDetailsRepository.findById(id);

        if (optional.isPresent()) {
            EmployeeDetails emp = optional.get();
            System.out.println("🔹 Employee found: " + emp);

            emp.setSal(newSalary);  // update only salary
            employeeDetailsRepository.save(emp);

            System.out.println("✅ Salary updated successfully for empno " + id);
        } else {
            System.out.println("❌ No employee found with emp id " + id);
        }
    }

}
