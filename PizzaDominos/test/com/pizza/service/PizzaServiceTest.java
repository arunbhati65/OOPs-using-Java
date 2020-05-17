package com.pizza.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.pizza.beans.Pizza;
import com.pizza.enums.Crust;
import com.pizza.enums.PizzaCategory;
import com.pizza.enums.Toppings;

@RunWith(MockitoJUnitRunner.class)
public class PizzaServiceTest {
	
	private PizzaService pizzaService=new PizzaService();
	
	@Test
	public void test_CalculatePizzaPrice(){
		
		List<Toppings> defaultToppings=new ArrayList<>();
		defaultToppings.add(Toppings.CHEESE);
		defaultToppings.add(Toppings.TOMATO);
		
		List<Toppings> additionalToppings=null;
		
		
		//get the pizza object from builder patter or decorator
		Pizza pizza=new Pizza("Margiritha", PizzaCategory.SIMPLY_VEG, 
				Crust.PAN, defaultToppings, additionalToppings);
		
		double actualPrice=pizzaService.calculatePizzaprice(pizza);
		double expectedPrice=200;
		Assert.assertEquals(expectedPrice, actualPrice,2);
	}
	
	
	@Test
	public void test_calculatePizzaPriceWithAdditionalToppings(){
		
		Pizza pizza = getPizza();
		
		double actualPrice=pizzaService.calculatePizzaprice(pizza);
		double expectedPrice=230;
		Assert.assertEquals(expectedPrice, actualPrice,2);
	}


	private Pizza getPizza() {
		List<Toppings> defaultToppings=new ArrayList<>();
		defaultToppings.add(Toppings.CHEESE);
		defaultToppings.add(Toppings.TOMATO);
		
		List<Toppings> additionalToppings=new ArrayList<>();
		additionalToppings.add(Toppings.OLIVE);
		additionalToppings.add(Toppings.TOMATO);
		
		
		//get the pizza object from builder patter or decorator
		Pizza pizza=new Pizza("Margiritha", PizzaCategory.SIMPLY_VEG, 
				Crust.PAN, defaultToppings, additionalToppings);
		return pizza;
	}
	
	@Test
	public void test_calculatePizzaPriceWithReplacedToppings(){
		
		Pizza pizza = getPizza();
		
		Map<Toppings, Toppings> toppings=new HashMap<Toppings, Toppings>();
		
		toppings.put(Toppings.TOMATO, Toppings.OLIVE);
		
		pizzaService.replaceTopping(pizza, toppings);
		double actualPrice=pizzaService.calculatePizzaprice(pizza);
		double expectedPrice=220;
		Assert.assertEquals(expectedPrice, actualPrice,2);
	}
	
	@Test
	public void test_calculatePizzaPriceWithReplacedToppingsWithLesserPrice(){
		
		Pizza pizza = getPizza();
		
		Map<Toppings, Toppings> toppings=new HashMap<Toppings, Toppings>();
		toppings.put(Toppings.CHEESE, Toppings.OLIVE);
		
		pizzaService.replaceTopping(pizza, toppings);
		double actualPrice=pizzaService.calculatePizzaprice(pizza);
		double expectedPrice=200;
		Assert.assertEquals(expectedPrice, actualPrice,2);
	}
	
	
}
