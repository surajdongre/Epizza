package com.citi.exercise.epizza;

import java.text.DecimalFormat;

import junit.framework.TestCase;

import org.junit.Test;

import com.citi.exercise.epizza.Pizza;

public class PizzaTest extends TestCase {
    DecimalFormat df = new DecimalFormat("#.00");

    @Test
    public void testAddToPrice() {
        Pizza pizza = new Pizza();
        pizza.addToPrice(12.20);
        pizza.addToPrice(2.20);
        assertEquals(14.40,
                Double.parseDouble(df.format(pizza.getPizzaPrice())));
    }

    @Test
    public void testApplyVat() {
        Pizza pizza = new Pizza();
        double totalOrderCost = 14.85;
        pizza.applyVAT(totalOrderCost);
        assertEquals(2.97, pizza.getVat());
    }

    @Test
    public void testApplyNewCustomerDiscount() {
        Pizza pizza = new Pizza();
        double totalOrderCost = 16.5;
        pizza.applyNewCustomerDiscount(totalOrderCost);
        assertEquals(1.65,
                Double.parseDouble(df.format(pizza.getNewCustomerDiscount())));
    }
}