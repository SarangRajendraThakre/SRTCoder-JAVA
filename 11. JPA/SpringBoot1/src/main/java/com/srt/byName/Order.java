package com.srt.byName;

import org.springframework.stereotype.Component;


public class Order {

	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
