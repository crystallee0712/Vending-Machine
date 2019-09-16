package edu.bu.met.cs665.assignment1;

import org.junit.Test;


public class TestVendingMachine {
    Tea tea = new Tea("ice", "red");
    Coffee coffee = new Coffee("ice", "mocha");

    @Test
    public void init() {
        System.out.println("**********************************************");
        System.out.println("Welcome to the beverage brewing machine......");
        System.out.println("**********************************************");
    }

    // Unit test11 is testing on a wrong coffee type and a wrong iceOrHot value for Coffee class.
    @Test
    public void testCoffee_11(){
        coffee.setCoffeeType("mocha");
        coffee.setIceOrHot("warm");
        // Initialize the drink vending machine to brew coffee
        coffee.initializing();
        // Brew with the wrong coffee type and wrong iceOrHot value
        // Will get error message with the current arrangement
        coffee.brewing();
        coffee.addingCondiments(1, 1);
        coffee.finishing();
    }

    // Unit test12 is testing on a correct coffee type but a wrong iceOrHot value for Coffee class.
    @Test
    public void testCoffee_12(){
        coffee.setCoffeeType("latte");
        coffee.setIceOrHot("warm");

        // Brew with the correct coffee type (latte) and wrong iceOrHot value (warm)
        // Will get error message with the current arrangement
        coffee.brewing();
        coffee.addingCondiments(1, 1);
        coffee.finishing();
    }

    // Unit test13 is testing on a correct coffee type (Latte), correct iceOrHot value (ice), but adding condiments to an ice coffee
    @Test
    public void testCoffee_13(){
        coffee.setCoffeeType("latte");
        coffee.setIceOrHot("ice");

        // Brew with the correct coffee type (latte) and correct iceOrHot value (ice), but not able to add condiments to ice coffee
        // Will get error message with the current arrangement
        coffee.brewing();
        coffee.addingCondiments(1, 1);
        coffee.finishing();
    }

    // Unit test14 is testing on a correct coffee type (latte), correct iceOrHot value (hot), but adding wrong unit of condiments
    @Test
    public void testCoffee_14(){
        coffee.setCoffeeType("latte");
        coffee.setIceOrHot("hot");

        // Brew with the correct coffee type (latte) and correct iceOrHot value (hot), but wrong unit of condiments
        // Will get error message with the current arrangement
        coffee.brewing();
        coffee.addingCondiments(4, 1);
        coffee.finishing();
    }

    // Unit test15 is testing on a correct coffee type (latte), correct iceOrHot value (hot), correct amount of condiments
    @Test
    public void testCoffee_15(){
        coffee.setCoffeeType("latte");
        coffee.setIceOrHot("hot");

        // Brew with the correct coffee type (latte) and correct iceOrHot value (hot), correct unit of condiments (1, 1)
        coffee.brewing();
        coffee.addingCondiments(1, 1);
        coffee.finishing();
    }

    // Unit test21 is testing on a wrong tea type and a wrong iceOrHot value
    @Test
    public void testTea_21(){
        tea.setTeaType("red");
        tea.setIceOrHot("warm");
        // Brew with the wrong tea type (red tea) and wrong iceOrHot value (warm)
        tea.brewing();
        tea.finishing();
    }

    // Unit test22 is testing on a wrong tea type but a correct iceOrHot value
    @Test
    public void testTea_22(){
        tea.setTeaType("red");
        tea.setIceOrHot("hot");

        // Brew with the wrong tea type (red tea) and correct iceOrHot value (hot)
        tea.brewing();
        tea.finishing();
    }

    // Unit test23 is testing on a correct tea type but a wrong iceOrHot value
    @Test
    public void testTea_23(){
        tea.setTeaType("green");
        tea.setIceOrHot("warm");

        // Brew with the correct tea type (green tea) and wrong iceOrHot value (warm)
        tea.brewing();
        tea.finishing();
    }

    // Unit test24 is testing on a correct tea type and a correct iceOrHot value
    @Test
    public void testTea_24(){
        tea.setTeaType("green");
        tea.setIceOrHot("hot");

        // Brew with the correct tea type (green tea) and correct iceOrHot value (warm)
        tea.brewing();
        tea.finishing();
    }
}

