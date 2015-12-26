package com.citi.exercise.epizza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PizzaOrder {

	public double totalOrderCost = 0.0;

	public static void main(String[] args) {
		PizzaOrder pizzaOrder = new PizzaOrder();
		// Get the pizza order through input file
		System.out.println("Please enter pizza order input file location: ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		pizzaOrder.preparePizzaOrder(fileName);
		if (scanner != null) {
			scanner.close();
		}
	}

	/**
	 * Method to prepare the pizza and to calculate the total order cost
	 * 
	 * @param fileName
	 * @return pizza
	 */
	public Pizza preparePizzaOrder(String fileName) {
		BufferedReader bufferedReader = null;
		Pizza pizza = null;
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			// Empty file check
			if (new File(fileName).length() == 0) {
				throw new FileNotFoundException("Input order is empty");
			}
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.toUpperCase().contains("EMAIL")) {
					String[] inputOrder = line.split("\\|");
					PizzaBuilder buildPizza = new PizzaBuilder(
							getPizzaSize(inputOrder));
					pizza = buildPizza
							.withToppings(getPizzaToppings(inputOrder))
							.withCrust(getPizzaCrust(inputOrder))
							.withSauce(getPizzaSauce(inputOrder))
							.withCheese(getPizzaCheese(inputOrder),
									isDoubleCheese(inputOrder)).build();
					totalOrderCost = totalOrderCost + pizza.getPizzaPrice();
					System.out.print(line + "-----> £");
					System.out.println(pizza.getPizzaPrice());
				} else if (line.contains("EMAIL") && isNewCustomer(line)) {
					totalOrderCost = pizza
							.applyNewCustomerDiscount(totalOrderCost);
					System.out.println("New customer discount (10%) -----> -£"
							+ String.format("%.2f",
									pizza.getNewCustomerDiscount()));
				}
			}
			System.out.println("Order total ----->  £" + totalOrderCost);
			totalOrderCost = pizza.applyVAT(totalOrderCost);
			System.out.println("VAT (20%) -----> £"
					+ String.format("%.2f", pizza.getVat()));
			System.out.println("Total -----> £" + totalOrderCost);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Unable to open file '" + fileName
					+ "..Please provide correct path Or File is empty");
		} catch (IOException ioe) {
			System.out.println("Error reading file '" + fileName);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ioe) {
				System.out.println("Error while closing the buffer reader");
			}
		}
		return pizza;
	}

	/**
	 * Method to check if order is placed by new customer. This will be
	 * validated against c:\data\email.txt file For new customer, his/her email
	 * id will not be found in email.txt file
	 * 
	 * @param line
	 * @return isNewCustomer
	 */
	public boolean isNewCustomer(String line) {
		String emailAddress = line.split(":")[1];
		FileReader emailReader = null;
		BufferedReader emailBufferedReader = null;
		FileWriter emailWriter = null;
		BufferedWriter emailBufferedWriter = null;
		// C:\data\email.txt file will be created to persist the customer
		// email ids
		String fileName = "C:\\data\\email.txt";
		boolean isNewCustomer = false;
		try {
			File emailFile = new File(fileName);
			if (!emailFile.exists()) {
				emailFile.createNewFile();
			}
			emailReader = new FileReader(emailFile);
			emailBufferedReader = new BufferedReader(emailReader);
			isNewCustomer = (emailBufferedReader.readLine() == null);
			while ((line = emailBufferedReader.readLine()) != null) {
				if (!line.contains(emailAddress)) {
					isNewCustomer = true;
				}
			}
			emailWriter = new FileWriter(fileName);
			emailBufferedWriter = new BufferedWriter(emailWriter);
			emailBufferedWriter.write(emailAddress);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Unable to open file '" + fileName);
		} catch (IOException ioe) {
			System.out.println("Error reading file '" + fileName);
		} finally {
			try {
				if (emailBufferedReader != null)
					emailBufferedReader.close();
				if (emailBufferedWriter != null)
					emailBufferedWriter.close();
			} catch (IOException e) {
				System.out
						.println("Error while closing email buffer reader/writer");
			}
		}
		return isNewCustomer;
	}

	/**
	 * Method to parse the pizza size from given order input
	 * 
	 * @param input
	 * @return Size
	 */
	public Size getPizzaSize(String[] input) {
		return Size.valueOf(input[0].toUpperCase());
	}

	/**
	 * Method to parse the pizza crust from given order input
	 * 
	 * @param input
	 * @return Crust
	 */
	public Crust getPizzaCrust(String[] input) {
		return Crust.valueOf(input[1].toUpperCase());
	}

	/**
	 * Method to parse the pizza Sauce from given order input
	 * 
	 * @param input
	 * @return Size
	 */
	public Sauce getPizzaSauce(String[] input) {
		return Sauce.valueOf(input[2].toUpperCase());
	}

	/**
	 * Method to parse the pizza toppings from given order input
	 * 
	 * @param input
	 * @return List<String>
	 */
	public List<String> getPizzaToppings(String[] input) {
		String[] toppings = input[3].split(",");
		return Arrays.asList(toppings);
	}

	/**
	 * Method to parse the pizza cheese from given order input
	 * 
	 * @param input
	 * @return Cheese
	 */
	public Cheese getPizzaCheese(String[] input) {
		String cheese = input[4].toUpperCase();
		if (cheese.contains("DOUBLE")) {
			return Cheese.valueOf((cheese.split(",")[0]));
		} else {
			return Cheese.valueOf(cheese);
		}
	}

	/**
	 * Method to parse if customer has requested for double cheese
	 * 
	 * @param input
	 * @return boolean
	 */
	public boolean isDoubleCheese(String[] input) {
		return input[4].toUpperCase().contains("DOUBLE");
	}
}