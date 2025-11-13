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
		

//		dbo.loadEmployee();
//		dbo.loadEmployeeByName();
//		dbo.loadEmployeeByNameAndSalary();
//		dbo.loadEmployeeByNameAndDepartment();

		dbo.insertEmpRecordByIndexedParameter();
		dbo.insertEmpRecordByNamedParameter();
		
	}

}
