package com.citi.exercise.epizza;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.citi.exercise.epizza.Cheese;
import com.citi.exercise.epizza.Crust;
import com.citi.exercise.epizza.Pizza;
import com.citi.exercise.epizza.PizzaBuilder;
import com.citi.exercise.epizza.Sauce;
import com.citi.exercise.epizza.Size;

public class PizzaBuilderTest extends TestCase {

    @Test
    public void testCrustPricesForSmallSizeOfPizza() {
        Pizza normalCrustSmallPizza = new PizzaBuilder(Size.SMALL).withCrust(
                Crust.NORMAL).build();
        assertEquals(5.00, normalCrustSmallPizza.getPizzaPrice());
        Pizza panCrustSmallPizza = new PizzaBuilder(Size.SMALL).withCrust(
                Crust.PAN).build();
        assertEquals(6.00, panCrustSmallPizza.getPizzaPrice());
        Pizza thinCrustSmallPizza = new PizzaBuilder(Size.SMALL).withCrust(
                Crust.THIN).build();
        assertEquals(6.00, thinCrustSmallPizza.getPizzaPrice());
        Pizza cheesyCrustSmallPizza = new PizzaBuilder(Size.SMALL).withCrust(
                Crust.CHEESY_BITES).build();
        assertEquals(7.00, cheesyCrustSmallPizza.getPizzaPrice());

    }

    @Test
    public void testCrustPricesForMediumSizeOfPizza() {
        Pizza normalCrustSmallPizza = new PizzaBuilder(Size.MEDIUM).withCrust(
                Crust.NORMAL).build();
        assertEquals(5.00 * 1.25, normalCrustSmallPizza.getPizzaPrice());
        Pizza panCrustSmallPizza = new PizzaBuilder(Size.MEDIUM).withCrust(
                Crust.PAN).build();
        assertEquals(6.00 * 1.25, panCrustSmallPizza.getPizzaPrice());
        Pizza thinCrustSmallPizza = new PizzaBuilder(Size.MEDIUM).withCrust(
                Crust.THIN).build();
        assertEquals(6.00 * 1.25, thinCrustSmallPizza.getPizzaPrice());
        Pizza cheesyCrustSmallPizza = new PizzaBuilder(Size.MEDIUM).withCrust(
                Crust.CHEESY_BITES).build();
        assertEquals(7.00 * 1.25, cheesyCrustSmallPizza.getPizzaPrice());
    }

    @Test
    public void testCrustPricesForLargeSizeOfPizza() {
        Pizza normalCrustSmallPizza = new PizzaBuilder(Size.LARGE).withCrust(
                Crust.NORMAL).build();
        assertEquals(5.00 * 1.5, normalCrustSmallPizza.getPizzaPrice());
        Pizza panCrustSmallPizza = new PizzaBuilder(Size.LARGE).withCrust(
                Crust.PAN).build();
        assertEquals(6.00 * 1.5, panCrustSmallPizza.getPizzaPrice());
        Pizza thinCrustSmallPizza = new PizzaBuilder(Size.LARGE).withCrust(
                Crust.THIN).build();
        assertEquals(6.00 * 1.5, thinCrustSmallPizza.getPizzaPrice());
        Pizza cheesyCrustSmallPizza = new PizzaBuilder(Size.LARGE).withCrust(
                Crust.CHEESY_BITES).build();
        assertEquals(7.00 * 1.5, cheesyCrustSmallPizza.getPizzaPrice());
    }

    @Test
    public void testNoExtraChargesForSauce() {
        Pizza smallPizzaWithMargaritaSauce = new PizzaBuilder(Size.SMALL)
                .withSauce(Sauce.MARGARITA).build();
        assertEquals(0.0, smallPizzaWithMargaritaSauce.getPizzaPrice());
        Pizza smallPizzaWithMexicanSalsaSauce = new PizzaBuilder(Size.SMALL)
                .withSauce(Sauce.MEXICAN_SALSA).build();
        assertEquals(0.0, smallPizzaWithMexicanSalsaSauce.getPizzaPrice());
        Pizza mediumPizzaWithMargaritaSauce = new PizzaBuilder(Size.MEDIUM)
                .withSauce(Sauce.MARGARITA).build();
        assertEquals(0.0, mediumPizzaWithMargaritaSauce.getPizzaPrice());
        Pizza mediumPizzaWithMexicanSalsaSauce = new PizzaBuilder(Size.MEDIUM)
                .withSauce(Sauce.MEXICAN_SALSA).build();
        assertEquals(0.0, mediumPizzaWithMexicanSalsaSauce.getPizzaPrice());
        Pizza largePizzaWithMargaritaSauce = new PizzaBuilder(Size.LARGE)
                .withSauce(Sauce.MARGARITA).build();
        assertEquals(0.0, largePizzaWithMargaritaSauce.getPizzaPrice());
        Pizza largePizzaWithMexicanSalsaSauce = new PizzaBuilder(Size.LARGE)
                .withSauce(Sauce.MEXICAN_SALSA).build();
        assertEquals(0.0, largePizzaWithMexicanSalsaSauce.getPizzaPrice());
    }

    @Test
    public void testFirstTwoToppingsFreeOfCost() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("CAPSICUM");
        toppings.add("ONION");
        Pizza smallPizzaWithTwoToppings = new PizzaBuilder(Size.SMALL)
                .withToppings(toppings).build();
        assertEquals(0.0, smallPizzaWithTwoToppings.getPizzaPrice());
        Pizza mediumPizzaWithTwoToppings = new PizzaBuilder(Size.MEDIUM)
                .withToppings(toppings).build();
        assertEquals(0.0, mediumPizzaWithTwoToppings.getPizzaPrice());
        Pizza largePizzaWithTwoToppings = new PizzaBuilder(Size.LARGE)
                .withToppings(toppings).build();
        assertEquals(0.0, largePizzaWithTwoToppings.getPizzaPrice());

    }

    @Test
    public void testPriceForPizzaWithThreeToppings() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("CAPSICUM");
        toppings.add("ONION");
        toppings.add("OLIVE");
        Pizza smallPizzaWithThreeToppings = new PizzaBuilder(Size.SMALL)
                .withToppings(toppings).build();
        assertEquals(1.00, smallPizzaWithThreeToppings.getPizzaPrice());
        Pizza mediumPizzaWithThreeToppings = new PizzaBuilder(Size.MEDIUM)
                .withToppings(toppings).build();
        assertEquals(1.50, mediumPizzaWithThreeToppings.getPizzaPrice());
        Pizza largePizzaWithThreeToppings = new PizzaBuilder(Size.LARGE)
                .withToppings(toppings).build();
        assertEquals(2.00, largePizzaWithThreeToppings.getPizzaPrice());
    }

    @Test
    public void testPriceForPizzaWithAllToppings() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("CAPSICUM");
        toppings.add("ONION");
        toppings.add("OLIVE");
        toppings.add("TOMATO");
        toppings.add("PINEAPPLE");
        toppings.add("JALAPENO");
        Pizza smallPizzaWithThreeToppings = new PizzaBuilder(Size.SMALL)
                .withToppings(toppings).build();
        assertEquals(1.00 * 4, smallPizzaWithThreeToppings.getPizzaPrice());
        Pizza mediumPizzaWithThreeToppings = new PizzaBuilder(Size.MEDIUM)
                .withToppings(toppings).build();
        assertEquals(1.50 * 4, mediumPizzaWithThreeToppings.getPizzaPrice());
        Pizza largePizzaWithThreeToppings = new PizzaBuilder(Size.LARGE)
                .withToppings(toppings).build();
        assertEquals(2.00 * 4, largePizzaWithThreeToppings.getPizzaPrice());
    }

    @Test
    public void testPizzaPriceWithNoDoubleCheese() {
        Pizza smallCreamPizzaNoDoubleCheese = new PizzaBuilder(Size.SMALL)
                .withCheese(Cheese.CREAM, false).build();
        assertEquals(0.0, smallCreamPizzaNoDoubleCheese.getPizzaPrice());
        Pizza smallMozzarellaPizzaNoDoubleCheese = new PizzaBuilder(Size.SMALL)
                .withCheese(Cheese.MOZZARELLA, false).build();
        assertEquals(0.0, smallMozzarellaPizzaNoDoubleCheese.getPizzaPrice());
        Pizza mediumCreamPizzaNoDoubleCheese = new PizzaBuilder(Size.MEDIUM)
                .withCheese(Cheese.CREAM, false).build();
        assertEquals(0.0, mediumCreamPizzaNoDoubleCheese.getPizzaPrice());
        Pizza mediumMozzarellaPizzaNoDoubleCheese = new PizzaBuilder(
                Size.MEDIUM).withCheese(Cheese.MOZZARELLA, false).build();
        assertEquals(0.0, mediumMozzarellaPizzaNoDoubleCheese.getPizzaPrice());
        Pizza largeCreamPizzaNoDoubleCheese = new PizzaBuilder(Size.LARGE)
                .withCheese(Cheese.CREAM, false).build();
        assertEquals(0.0, largeCreamPizzaNoDoubleCheese.getPizzaPrice());
        Pizza largeMozzarellaPizzaNoDoubleCheese = new PizzaBuilder(Size.LARGE)
                .withCheese(Cheese.MOZZARELLA, false).build();
        assertEquals(0.0, largeMozzarellaPizzaNoDoubleCheese.getPizzaPrice());
    }

    @Test
    public void testPizzaPriceWithDoubleCheese() {
        Pizza smallCreamPizzaWithDoubleCheese = new PizzaBuilder(Size.SMALL)
                .withCheese(Cheese.CREAM, true).build();
        assertEquals(0.5, smallCreamPizzaWithDoubleCheese.getPizzaPrice());
        Pizza smallMozzarellaPizzaWithDoubleCheese = new PizzaBuilder(
                Size.SMALL).withCheese(Cheese.MOZZARELLA, true).build();
        assertEquals(0.5, smallMozzarellaPizzaWithDoubleCheese.getPizzaPrice());
        Pizza mediumCreamPizzaWithDoubleCheese = new PizzaBuilder(Size.MEDIUM)
                .withCheese(Cheese.CREAM, true).build();
        assertEquals(1.0, mediumCreamPizzaWithDoubleCheese.getPizzaPrice());
        Pizza mediumMozzarellaPizzaWithDoubleCheese = new PizzaBuilder(
                Size.MEDIUM).withCheese(Cheese.MOZZARELLA, true).build();
        assertEquals(1.0, mediumMozzarellaPizzaWithDoubleCheese.getPizzaPrice());
        Pizza largeCreamPizzaWithDoubleCheese = new PizzaBuilder(Size.LARGE)
                .withCheese(Cheese.CREAM, true).build();
        assertEquals(1.5, largeCreamPizzaWithDoubleCheese.getPizzaPrice());
        Pizza largeMozzarellaPizzaWithDoubleCheese = new PizzaBuilder(
                Size.LARGE).withCheese(Cheese.MOZZARELLA, true).build();
        assertEquals(1.5, largeMozzarellaPizzaWithDoubleCheese.getPizzaPrice());
    }

    @Test
    public void testBuildSmallNormalCrustMargarita3ToppingMozzarellaPizza() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("CAPSICUM");
        toppings.add("ONION");
        toppings.add("OLIVE");
        Pizza pizza = new PizzaBuilder(Size.SMALL).withCrust(Crust.NORMAL)
                .withToppings(toppings).withCheese(Cheese.MOZZARELLA, false)
                .withSauce(Sauce.MARGARITA).build();
        assertEquals(Size.SMALL, pizza.getSize());
        assertEquals(3, pizza.getToppings().size());
        assertEquals(Crust.NORMAL, pizza.getCrust());
        assertEquals(Sauce.MARGARITA, pizza.getSauce());
        assertEquals(Cheese.MOZZARELLA, pizza.getCheese());
        assertEquals(6.0, pizza.getPizzaPrice());
    }

    @Test
    public void testBuildLargePanCrustMargarita2ToppingCreamDoublePizza() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("PINEAPPLE");
        toppings.add("ONION");
        Pizza pizza = new PizzaBuilder(Size.LARGE).withCrust(Crust.THIN)
                .withToppings(toppings).withCheese(Cheese.CREAM, true)
                .withSauce(Sauce.MARGARITA).build();
        assertEquals(Size.LARGE, pizza.getSize());
        assertEquals(2, pizza.getToppings().size());
        assertEquals(Crust.THIN, pizza.getCrust());
        assertEquals(Sauce.MARGARITA, pizza.getSauce());
        assertEquals(Cheese.CREAM, pizza.getCheese());
        assertEquals(10.50, pizza.getPizzaPrice());
    }

}