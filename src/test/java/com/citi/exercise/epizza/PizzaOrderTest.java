package com.citi.exercise.epizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

public class PizzaOrderTest extends TestCase {

	@Test
	public void testPizzOrderInput() {
		String orderInput = "SMALL|NORMAL|MARGARITA|CAPSICUM,ONION,OLIVE|MOZZARELLA";
		String splitOrderInput[] = orderInput.split("\\|");
		PizzaOrder pizzaOrder = new PizzaOrder();
		assertEquals(Size.SMALL, pizzaOrder.getPizzaSize(splitOrderInput));
		assertEquals(Crust.NORMAL, pizzaOrder.getPizzaCrust(splitOrderInput));
		assertEquals(Cheese.MOZZARELLA,
				pizzaOrder.getPizzaCheese(splitOrderInput));
		assertEquals(Sauce.MARGARITA, pizzaOrder.getPizzaSauce(splitOrderInput));
		assertEquals(3, pizzaOrder.getPizzaToppings(splitOrderInput).size());
		assertEquals(Topping.CAPSICUM.toString(),
				pizzaOrder.getPizzaToppings(splitOrderInput).get(0));
		assertEquals(Topping.ONION.toString(),
				pizzaOrder.getPizzaToppings(splitOrderInput).get(1));
		assertEquals(Topping.OLIVE.toString(),
				pizzaOrder.getPizzaToppings(splitOrderInput).get(2));
		assertEquals(false, pizzaOrder.isDoubleCheese(splitOrderInput));
	}

	@Test
	public void testNewCustomerEmailIsSavedInFile() throws IOException {
		PizzaOrder pizzaOrder = new PizzaOrder();
		String email = "EMAIL:email@example.com";
		pizzaOrder.isNewCustomer(email);
		boolean idEmailIdFoundInFile = false;
		String line = "";
		// email are stored in C:\\data\\email.txt
		File emailFile = new File("C:\\data\\email.txt");
		FileReader emailReader = new FileReader(emailFile);
		BufferedReader emailBufferedReader = new BufferedReader(emailReader);
		while ((line = emailBufferedReader.readLine()) != null) {
			if (line.equals("email@example.com")) {
				idEmailIdFoundInFile = true;
			}
		}
		assertTrue(idEmailIdFoundInFile);
		emailBufferedReader.close();
	}

	@Test
	public void testTotalCostOfPizza() {
		PizzaOrder pizzaOrder = new PizzaOrder();
		// Please create sample input file at below location before running the
		// test and should have content as
		// SMALL|NORMAL|MARGARITA|CAPSICUM,ONION,OLIVE|MOZZARELLA
		// LARGE|PAN|MARGARITA|ONION,PINEAPPLE|CREAM,DOUBLE
		// EMAIL:email@example.com
		String fileName = "C:\\data\\input.txt";
		Pizza pizza = pizzaOrder.preparePizzaOrder(fileName);
		if (pizza.getNewCustomerDiscount() != 0.0) {
			assertEquals(17.82, pizzaOrder.totalOrderCost);
		} else {
			assertEquals(19.80, pizzaOrder.totalOrderCost);
		}
	}
}