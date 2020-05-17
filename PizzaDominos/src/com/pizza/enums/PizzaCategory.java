package com.pizza.enums;

public enum PizzaCategory {
	SIMPLY_VEG(200),CLASSIC_VEG(250),EXOTIC_VEG(300);
	
	int price;
	private PizzaCategory(int price) {
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
