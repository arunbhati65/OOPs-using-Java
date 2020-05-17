package com.pizza.service;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pizza.beans.Pizza;
import com.pizza.enums.Toppings;

public class PizzaService {

	public double calculatePizzaprice(Pizza pizza) {
		double price=0;
		//Pizza CAtegory Price
		price=price+pizza.getPizzaCategory().getPrice();
		//Pizza Crust Price
		price+=pizza.getCrust().getPrice();
		//Pizza Topping Price
		
		
		if(pizza.getAdditionalToppings()!=null)
			price+=pizza.getAdditionalToppings().stream().
					map(t->t.getPrice()).reduce( 0d,Double::sum);
		
		return price;
	}
	
	public void replaceTopping(Pizza pizza,Map<Toppings,Toppings> toppingList){
		List<Toppings> newToppings = toppingList.entrySet().stream()
		.filter(es->es.getKey().getPrice()<es.getValue().getPrice())
		.map(es->es.getValue()).collect(Collectors.toList());
		
		pizza.setAdditionalToppings(newToppings);
	}
	
	


}
