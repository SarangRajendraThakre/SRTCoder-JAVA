package com.srtCoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CollegeApplication {
    public static void main(String[] args) {

        ApplicationContext container = new FileSystemXmlApplicationContext("C:\\Users\\saran\\eclipse-workspace\\college\\spring.xml");

        // 1. Get the newly created, uninitialized Address bean
        Address a1 = (Address) container.getBean("address1");

        // 2. Manually set the values using the setter methods
        a1.setAddress("Wardha, India");
        a1.setPincode(442001);

        // 3. Display the manually set values
        System.out.println("--- Address Data Set Manually ---");
        System.out.println("Location: " + a1.getAddress());
        System.out.println("Pincode: " + a1.getPincode());
    }
}