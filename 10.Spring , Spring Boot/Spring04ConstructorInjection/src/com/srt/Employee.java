package com.srt;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {

    private String name;
    private int empno;
    private long phoneNo;
    private Boolean isMarried;
    private double height;
    private Address address;
    private List<String> pllist;
    private Set<String> carSet;
    private Map<String, Float> education;

    public Employee(String name, int empno, long phoneNo, Boolean isMarried,
                    double height, Address address, List<String> pllist,
                    Set<String> carSet, Map<String, Float> education) {
        this.name = name;
        this.empno = empno;
        this.phoneNo = phoneNo;
        this.isMarried = isMarried;
        this.height = height;
        this.address = address;
        this.pllist = pllist;
        this.carSet = carSet;
        this.education = education;
        System.out.println("Employee constructor called");
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", empno=" + empno + ", phoneNo=" + phoneNo + 
               ", isMarried=" + isMarried + ", height=" + height + ", address=" + address + 
               ", pllist=" + pllist + ", carSet=" + carSet + ", education=" + education + "]";
    }
}
