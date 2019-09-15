package edu.bu.met.cs665.assignment1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * This Class represents a Coffee class.
 *
 * @author Hui Li
 *
 */

// Coffee is a type of drink, so this Coffee class inherits from Drink class, also implements Condiments interface when the coffee is hot
public class Coffee extends Drink implements Condiments {
    private String coffeeType;
    private static Logger logger = Logger.getLogger(Coffee.class);
    private int flag = 0;

    /**
     * Create a Coffee object using ice or hot and coffee type.
     *
     * @param iceOrHot ice or hot of the coffee as string
     * @param coffeeType coffee type of the coffee as string
     */
    public Coffee(String iceOrHot, String coffeeType) {
        super(iceOrHot);
        this.coffeeType = coffeeType;
    }

    /**
     * Setter method for coffee type string.
     *
     * @param coffeeType coffee type of a coffee
     */
    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }


    public String getCoffeeType() {
        return coffeeType;
    }

//    Check if the customer is choosing ice or hot, if hot and the coffee type is supported, the flag will be set to 1.
    @Override
    public void brewing() {

        PropertyConfigurator.configure("log4j.properties");

        logger.info("You've chosen coffee as the drink! Please select the coffee type you'd like to brew");

        if ((getIceOrHot().equals("ice")) || (getIceOrHot().equals("hot"))){

            if ((getCoffeeType().equals("latte") || getCoffeeType().equals("americano")|| getCoffeeType().equals("espresso"))) {
                flag = 1;
                logger.info("Now your " + getIceOrHot() + " " + getCoffeeType() + " is brewing!");

            }
        } else {
            logger.info("Now you are trying to brew " + getIceOrHot() + " " + getCoffeeType());
            logger.error("We only support ice or hot Latte, Americano or Espresso for the moment! Please select from one of them!");
        }
    }

// Only hot coffee can add condiments, so check if the flag is 1, if not, customers cannot add condiments to the coffee.
    @Override
    public void addingCondiments(int milkUnit, int sugarUnit) {
        PropertyConfigurator.configure("log4j.properties");
        if(flag == 1) {
            if (getIceOrHot().equals("hot")) {
                logger.info("You can add condiments for your hot coffee!");
                logger.info("You are trying to add " + milkUnit + " unit of milk" + " and " + sugarUnit + " unit of sugar to your hot " + getCoffeeType());

                if ((milkUnit > 3) || (sugarUnit > 3)) {
                    logger.error("You can only add milk and sugar within 3 units for each!");
                    logger.error("Adding condiments cannot fulfilled!");
                }
            } else {
                logger.error("Sorry, you cannot add condiments to ice coffee");
            }
        }
        else{
            logger.error("You cannot add condiments to an unsupported coffee type!");
        }

    }

    // Show the customer brewing is done if the coffee type is set correctly. If not, show the customers the vending machine cannot fulfill the request.
    @Override
    public void finishing() {
        PropertyConfigurator.configure("log4j.properties");
        if(flag == 1) {
            logger.info("  ");
            logger.info("Brewing is done!");
            logger.info("Please enjoy your " + getIceOrHot() + " " + getCoffeeType() + "!");
        }
        else{
            logger.error("Sorry, we cannot fulfill your brewing request at this time!");

        }
        super.finishing();
    }
}
