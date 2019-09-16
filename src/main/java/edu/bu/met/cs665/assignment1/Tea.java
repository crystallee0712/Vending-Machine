package edu.bu.met.cs665.assignment1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * This Class represents a Tea class.
 *
 * @author Hui Li
 *
 */
// Tea is a type of drink, so this Tea class inherits from Drink class
public class Tea extends Drink{

    private static Logger logger = Logger.getLogger(Tea.class);
    private String teaType;
    private int flag = 0;

    /**
     * Create a Tea object using ice or hot and coffee type.
     *
     * @param iceOrHot ice or hot of the tea as string
     * @param teaType tea type of the tea as string
     */
    public Tea(String iceOrHot, String teaType) {
        super(iceOrHot);
        this.teaType = teaType;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    // Override the brewing method from Drink class
    @Override
    public void brewing() {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("You've chosen tea as the drink! Please select the tea type you'd like to brew");

        if ((getIceOrHot().equals("ice")) || (getIceOrHot().equals("hot"))) {

            if ((getTeaType().equals("black") || getTeaType().equals("green") || getTeaType().equals("yellow"))) {
                flag = 1;
                logger.info("Now your " + getIceOrHot() + " " + getTeaType() + " tea is brewing!");
            } else{
                logger.error("Now you are trying to brew " + getTeaType() + " tea!");
                logger.error("We cannot brew " + getTeaType() + " tea! Only black tea, green tea or yellow tea is accepted!");
            }
        }else {
            logger.info("Now you are trying to brew " + getIceOrHot() + " " + getTeaType() + " tea!");
            logger.error("We only support ice or hot black tea, green tea or yellow tea for the moment! Please select from one of them!");
        }
    }

    // Override the finishing method from Drink class
    @Override
    public void finishing() {
        PropertyConfigurator.configure("log4j.properties");
        if(flag == 1) {
            logger.info("  ");
            logger.info("Brewing is done!");
            logger.info("Please enjoy your " + getIceOrHot() + " " + getTeaType() + " tea!");
        }
        else{
            logger.info("We cannot fulfill your brewing request at this time!");
        }
        super.finishing();
    }


}
