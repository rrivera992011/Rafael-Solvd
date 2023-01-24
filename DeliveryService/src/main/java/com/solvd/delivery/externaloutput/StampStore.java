package com.solvd.delivery.externaloutput;

import com.solvd.delivery.enums.StampType;
import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.stamp.Stamp;
import com.solvd.delivery.stamp.StampCalculator;
import org.apache.logging.log4j.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StampStore {

    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void buyStamps() {

        Stamp stamp = new Stamp();
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nHow many stamps would you like to buy?");
        int numberOfStamps = scanner.nextInt();

        try {
            ExceptionManager.tooManyOrFewerStamps(numberOfStamps);
        } catch (TooManyStampsException e) {
            LOGGER.warn(e);
        }

        if (numberOfStamps > 100 || numberOfStamps < 1) {
            buyStamps();
        } else {
            calculateStampTotal(numberOfStamps, stamp);
        }

    }

    public static void calculateStampTotal(int numberOfStamps, Stamp stamp) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "What color would you like your stamp?");
        LOGGER.log(MENU_LOG, "1. {} - ${}", StampType.BLUE.getColorName(), StampType.BLUE.getPrice());
        LOGGER.log(MENU_LOG, "2. {} - ${}", StampType.RED.getColorName(), StampType.RED.getPrice());
        LOGGER.log(MENU_LOG, "3. {} - ${}", StampType.GREEN.getColorName(), StampType.BLUE.getPrice());
        LOGGER.log(MENU_LOG, "4. {} - ${}", StampType.ORANGE.getColorName(), StampType.ORANGE.getPrice());

        int colorChoice = scanner.nextInt();
        StampType stampType = StampType.BLUE;
        switch (colorChoice) {
            case 1:
                stampType = StampType.BLUE;
                break;
            case 2:
                stampType = StampType.RED;
                break;
            case 3:
                stampType = StampType.GREEN;
                break;
            case 4:
                stampType = StampType.ORANGE;
                break;
        }
        stamp.setColor(stampType.getColorName());
        stamp.setPrice(stampType.getPrice());
        stampOutput(numberOfStamps, StampCalculator.calculateStamp(stampType, numberOfStamps), stamp);
    }

    public static void stampOutput(int numberOfStamps, double completeTotal, Stamp stamp) {

        final DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);

        LOGGER.log(MENU_LOG, "\nYou bought " + numberOfStamps + " " + stamp.getColor() +
                " stamps for $" + df.format(completeTotal));
        LOGGER.log(MENU_LOG, "Thank you!");

        System.exit(0);
    }

}
