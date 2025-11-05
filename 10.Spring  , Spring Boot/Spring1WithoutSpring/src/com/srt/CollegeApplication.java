package com.srt;

public class CollegeApplication {

	public static void main(String[] args)
	{
		
		Address address1 = new Address();
		
		address1.setCity("wardha");
		address1.setPincode(442001);
		
		Student student1 = new Student();
		
		student1.setName("sarang");
		
		// student is having the dependecny of address object 
		// so injecting address object into student object 
	    student1.setAddress(address1);
	    
	    
	    
     System.out.println(student1.getName());
     System.out.println(student1.getAddress().getCity());
     System.out.println(student1.getAddress().getPincode());
	    
	    
	    
	    
	    
		
	}
	
}
