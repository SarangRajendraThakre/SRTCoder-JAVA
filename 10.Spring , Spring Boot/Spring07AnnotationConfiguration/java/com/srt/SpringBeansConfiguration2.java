package com.srt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.srt")
@Configuration
public class SpringBeansConfiguration2 {

	
//	making the multiple bean for one class Address class one by component and one by bean
//  and by this Bean method object creation only i can initiazie the value to value and not by the @Component
	// because it always call the no arg constucture
	
	@Bean("add")
	public Address getAddress()
	{
		return new Address("Pune" , 2123);
	}
	
	
	// i am having the bean object with same bean id then priority given to first bean and seocnd bean will get ignored ,
		// but in case of the xml there was Exception
		@Bean("college1")
		public College getCollege1() {
			
			College college = new College();
			
			college.setCollegeName("J B Science College ");
			college.setEstablishYear(1950);
			
			System.out.println("College1 object created");
			return college;
			
		}
		
		@Bean("college1")
		public College getCollege2() {
			
			College college = new College();
			
			college.setCollegeName("GCOEY College ");
			college.setEstablishYear(2018);
			
			System.out.println("College2 object created");
			return college;
			
		}
		// i am not passing the bean id , then method name will be the bean id means getCollege3
		@Bean
		public College getCollege3() {
			
			College college = new College();
			
			college.setCollegeName("J B Science College ");
			college.setEstablishYear(1950);
			
			System.out.println("College3 object created");
			return college;
			
		}
		
		
	
	
	

}
