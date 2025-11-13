package com.srt;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton" )
@Component
public class Order implements InitializingBean , DisposableBean {


  
	
	private Product product;


	
	public Product getProduct() {
		return product;
	}

	@Autowired
	public void setProduct(Product product) {
		System.out.println("Setter method called for product");
		this.product = product;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		 
   System.out.println("AFter property method is called");		
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
System.out.println("destroy method of life cycle is called ");
		
	}
	
	
	
}
