package com.pizza.enums;

public enum Crust {
PAN(0),THIN(40),CHEESE_BURST(80);
	
	int price;
	private Crust(int price) {
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}


