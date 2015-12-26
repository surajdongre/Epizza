package com.citi.exercise.epizza;

import java.util.List;

public class Pizza {

	private double pizzaPrice = 0;
	private double vat = 0;
	private double newCustomerDiscount = 0;
	private Size size;
	private Crust crust;
	private List<String> toppings;
	private Sauce sauce;
	private Cheese cheese;

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public double getPizzaPrice() {
		return pizzaPrice;
	}

	/**
	 * Method to update cost of pizza as per order
	 * 
	 * @param price
	 */
	public void addToPrice(double price) {
		this.pizzaPrice = pizzaPrice + price;
	}

	/**
	 * Method to apply 10% new customer discount
	 * 
	 * @param totalOrderCost
	 * @return totalOrderCost
	 */
	public double applyNewCustomerDiscount(double totalOrderCost) {
		newCustomerDiscount = totalOrderCost * 0.1;
		totalOrderCost = totalOrderCost - newCustomerDiscount;
		return totalOrderCost;
	}

	/**
	 * Method to apply 20% VAT of total cost
	 * 
	 * @param totalOrderCost
	 * @return totalOrderCost
	 */
	public double applyVAT(double totalOrderCost) {
		vat = totalOrderCost * 0.2;
		totalOrderCost = totalOrderCost + vat;
		return totalOrderCost;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public double getVat() {
		return vat;
	}

	public double getNewCustomerDiscount() {
		return newCustomerDiscount;
	}
}