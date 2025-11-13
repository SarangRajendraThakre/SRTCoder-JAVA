package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot23JpaAllMethodsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot23JpaAllMethodsApplication.class,
				args);

		DatabaseOperations dbo = (DatabaseOperations) container.getBean("databaseOperations");
		

		// *************** insert *******************8
//      dbo.addEmployee();
//		dbo.addMoreEmployee();
		
// ************		select  queries ********************
		
//		dbo.loadAllEmployee();
//		dbo.loadAllEmployeeById();
//		dbo.loadAllEmployeeByJob();
//		dbo.loadAllEmployeeByMgr();
//		dbo.loadAllEmployeeByEname();
		
		
//		dbo.loadAllEmployeeByJobAndMgr();
//		dbo.loadAllEmployeeByHiredateAndDeptno();
	
		
//		dbo.loadAllEmployeeByHiredateOrDeptno();		
//		dbo.loadAllEmployeeByJobOrMgr();
		
		
//		dbo.deleteEmployeeById();
//		dbo.deleteEmployeeByHiredate();
//		dbo.updateEmployeeSalaryById();
		dbo.updateEmployeeSalaryById(10L, 80);
		
	}

}
