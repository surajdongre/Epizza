package com.citi.exercise.epizza;

import java.util.List;

public class PizzaBuilder {

	Pizza pizza = new Pizza();
	Size PizzaSize;

	public PizzaBuilder(Size PizzaSize) {
		this.PizzaSize = PizzaSize;
		pizza.setSize(PizzaSize);
	}

	/**
	 * Method to build pizza with toppings as per customer's pizza order
	 * 
	 * @param toppings
	 * @return PizzaBuilder
	 */
	public PizzaBuilder withToppings(List<String> toppings) {
		pizza.setToppings(toppings);
		// First two toppings free
		int numberofToppings = toppings.size();
		if (toppings != null && numberofToppings > 0) {
			for (int i = numberofToppings - 1; i > 1; i--) {
				Topping topping = Topping
						.valueOf(toppings.get(i).toUpperCase());
				pizza.addToPrice(topping.getCost(PizzaSize));
			}
		}
		return this;
	}

	/**
	 * Method to build pizza with crust as per customer's pizza order
	 * 
	 * @param toppings
	 * @return PizzaBuilder
	 */
	public PizzaBuilder withCrust(Crust crust) {
		pizza.setCrust(crust);
		pizza.addToPrice(crust.getCost(PizzaSize));
		return this;
	}

	/**
	 * Method to build pizza with Sauce as per customer's pizza order
	 * 
	 * @param toppings
	 * @return PizzaBuilder
	 */
	public PizzaBuilder withSauce(Sauce sauce) {
		pizza.setSauce(sauce);
		pizza.addToPrice(sauce.getCost());
		return this;
	}

	/**
	 * Method to build pizza with Cheese as per customer's pizza order
	 * 
	 * @param toppings
	 * @return PizzaBuilder
	 */
	public PizzaBuilder withCheese(Cheese cheese, boolean isDoubleCheese) {
		pizza.setCheese(cheese);
		if (isDoubleCheese) {
			pizza.addToPrice(cheese.getCost(PizzaSize));
		}
		return this;
	}

	/**
	 * Method to provide pizza
	 * 
	 * @return Pizza
	 */
	public Pizza build() {
		return pizza;
	}

	/**
	 * Method to get the pizza price
	 * 
	 * @return PizzaPrice
	 */
	public double calculatePrice() {
		return pizza.getPizzaPrice();
	}
}