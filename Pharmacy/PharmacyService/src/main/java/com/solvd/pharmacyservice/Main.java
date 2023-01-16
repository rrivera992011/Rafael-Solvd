package main.java.com.solvd.pharmacyservice;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) {
        LOGGER.log(MENU_LOG,"Hello world!");
    }


}