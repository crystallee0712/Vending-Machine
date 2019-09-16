package edu.bu.met.cs665.assignment1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

abstract class Drink {



    private String iceOrHot;

    public Drink(String iceOrHot) {
        this.iceOrHot = iceOrHot;
    }

    public String getIceOrHot() {
        return iceOrHot;
    }


    public void setIceOrHot(String iceOrHot) {
        this.iceOrHot = iceOrHot;
    }
    private static Logger logger = Logger.getLogger(Drink.class);

    public void initializing(){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Please select Coffee or Tea to brew!");
        logger.info("---------------------------------------------------------------");
    }

    public void brewing(){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("---------------------------------------------------------------");
    }

    // Go back to the initializing stage after finishing
    public void finishing(){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Thanks for using this beverage brewing machine!");
        logger.info("---------------------------------------------------------------");
        initializing();
    }

}
