package com.pizza.beans;

import java.util.List;
import java.util.Map;

import com.pizza.enums.Crust;
import com.pizza.enums.PizzaCategory;
import com.pizza.enums.Toppings;

public class Pizza {
	
	private String pizzaName;
	private PizzaCategory pizzaCategory;
	private Crust crust;
	private List<Toppings> defaultToppings;
	private List<Toppings> additionalToppings;
	
	
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pizza(String pizzaName, PizzaCategory pizzaCategory, Crust crust,
			List<Toppings> defaultToppings,
			List<Toppings> additionalToppings) {
		super();
		this.pizzaName = pizzaName;
		this.pizzaCategory = pizzaCategory;
		this.crust = crust;
		this.defaultToppings = defaultToppings;
		this.additionalToppings = additionalToppings;
	}



	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public PizzaCategory getPizzaCategory() {
		return pizzaCategory;
	}
	public void setPizzaCategory(PizzaCategory pizzaCategory) {
		this.pizzaCategory = pizzaCategory;
	}
	public Crust getCrust() {
		return crust;
	}
	public void setCrust(Crust crust) {
		this.crust = crust;
	}
	public List<Toppings> getDefaultToppings() {
		return defaultToppings;
	}
	public void setDefaultToppings(List<Toppings> defaultToppings) {
		this.defaultToppings = defaultToppings;
	}
	public List<Toppings> getAdditionalToppings() {
		return additionalToppings;
	}
	public void setAdditionalToppings(List<Toppings> additionalToppings) {
		this.additionalToppings = additionalToppings;
	}
	@Override
	public String toString() {
		return "Pizza [pizzaName=" + pizzaName + ", pizzaCategory="
				+ pizzaCategory + ", crust=" + crust + ", defaultToppings="
				+ defaultToppings + ", additionalToppings="
				+ additionalToppings + "]";
	}
	
	
	
}
