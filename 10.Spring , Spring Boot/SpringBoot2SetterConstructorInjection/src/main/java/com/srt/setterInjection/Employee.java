package com.srt.setterInjection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Employee {
	

   private String name = "sarang thakre";
   
   private int empno = 132;
   
   private long phoneNo ;
   
   private Boolean isMarried ;
   
   private double height;
   
   
   
   private Address address;
   
//   private List<String> pllist;
   
   private Set<String>  carSet;
    
   private Map<String, Float> education;
   
   
   public Employee() {
	   	System.out.println("Employeee object created no arg constructor ...  ");
	   }


   public String getName() {
	return name;
   }


   public void setName(String name) {
	this.name = name;
   }


   public int getEmpno() {
	return empno;
   }


   public void setEmpno(int empno) {
	this.empno = empno;
   }


   public long getPhoneNo() {
	return phoneNo;
   }


   public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
   }


   public Boolean getIsMarried() {
	return isMarried;
   }


   public void setIsMarried(Boolean isMarried) {
	this.isMarried = isMarried;
   }


   public double getHeight() {
	return height;
   }


   public void setHeight(double height) {
	this.height = height;
   }


   public Address getAddress() {
	return address;
   }

@Autowired
   public void setAddress(Address address) {
	this.address = address;
   }


   public Set<String> getCarSet() {
	return carSet;
   }


   public void setCarSet(Set<String> carSet) {
	this.carSet = carSet;
   }


   public Map<String, Float> getEducation() {
	return education;
   }


   public void setEducation(Map<String, Float> education) {
	this.education = education;
   }


   @Override
   public String toString() {
	return "Employee [name=" + name + ", empno=" + empno + ", phoneNo=" + phoneNo + ", isMarried=" + isMarried
			+ ", height=" + height + ", address=" + address + ", carSet=" + carSet + ", education=" + education + "]";
   }
   
   
   
}   