package Dzial_11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Youtube
{
    private static final Logger LOGGER = Logger.getLogger(Youtube.class.getName());

    public static void main(String[] args)
    {
        LOGGER.setLevel(Level.INFO);
//        LOGGER.info("Hello World!");
//
//        Logger.global.info("Test loggera global");

        int x = 10;
        System.out.println("x = " +x);
        LOGGER.info("x = " +x);
    }
}
