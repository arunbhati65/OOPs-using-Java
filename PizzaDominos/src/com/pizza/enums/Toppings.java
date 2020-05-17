package com.pizza.enums;

public enum Toppings {
TOMATO(10),OLIVE(20),CHEESE(30),CORN(20),CAPSICUM(10),PANEER(30);
	
	double price;
	private Toppings(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
