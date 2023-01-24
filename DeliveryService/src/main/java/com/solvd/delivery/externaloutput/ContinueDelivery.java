package com.solvd.delivery.externaloutput;

import com.solvd.delivery.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ContinueDelivery {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void continueDelivery() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nTo return to operation, press 1");
        LOGGER.log(MENU_LOG, "To exit the operation, press 0\n");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                LOGGER.log(MENU_LOG, "Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                Main.menuOptions();
                break;
            default:
                LOGGER.error("Please choose one of these options\n");
                continueDelivery();
                break;
        }
    }
}
