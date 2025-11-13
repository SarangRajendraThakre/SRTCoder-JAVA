package com.srt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.srt.DBConnection.Dbconn;




@PropertySource("aws.properties")
@SpringBootApplication
public class SpringBoot12ValueAndPropertySource {



 
	public static void main(String[] args) {

		
		ApplicationContext container = SpringApplication.run(SpringBoot12ValueAndPropertySource.class,
				args);
		
		Dbconn dbConnection = (Dbconn) container.getBean("dbconn");

		System.out.println(dbConnection.getUrl());
		System.out.println(dbConnection.getPassword());
		System.out.println(dbConnection.getPort());
		System.out.println(dbConnection.getUsername());

		System.out.println(dbConnection.getDepartmentNameList().size());
		System.out.println(dbConnection.getDepartmentNameList());

		System.out.println(dbConnection.getDepartmentSet().size());
		System.out.println(dbConnection.getDepartmentSet());

		System.out.println(dbConnection.getCoursesAndTrainer().size());
		System.out.println(dbConnection.getCoursesAndTrainer());

		System.out.println(dbConnection.getCoursesAndTrainer().size());
		System.out.println(dbConnection.getCoursesAndTrainer());

		System.out.println(dbConnection.getFruitsList().size());
		System.out.println(dbConnection.getFruitsList());

		System.out.println(dbConnection.getCitySet().size());
		System.out.println(dbConnection.getCitySet());

		System.out.println(dbConnection.getPercetageMap().size());
		System.out.println(dbConnection.getPercetageMap());

		System.out.println("Properties from the different properties file");
		System.out.println(dbConnection.getAwsPort());
		System.out.println(dbConnection.getAwsUrl());
		System.out.println(dbConnection.getAwsuserName());
		System.out.println(dbConnection.getAwsPassword());

	}
}
