package com.solvd.delivery.externaloutput;

import com.solvd.delivery.mailing.Envelope;
import com.solvd.delivery.mailing.Parcel;
import com.solvd.delivery.shipment.Shipment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FinishOrder {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("FACTOID_LOG", 700);
    public static void orderFinished(Shipment shipment) {
        // Output everything
        LOGGER.log(MENU_LOG, "\nOrder delivered");
        if (shipment.getMailing().getPackageType().equals("Box")) {
            Parcel parcel = (Parcel) shipment.getMailing();
            LOGGER.log(MENU_LOG, "\n" + parcel.getPackageType() + " received");
        } else if (shipment.getMailing().getPackageType().equals("Envelope")) {
            Envelope envelope = (Envelope) shipment.getMailing();
            LOGGER.log(MENU_LOG, "\n" + envelope.getPackageType() + " received");
        }

        LOGGER.log(MENU_LOG, shipment);
        moreOptionsForCheckout();
    }

    public static void moreOptionsForCheckout() {
        // More options
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nMore options");
        LOGGER.log(MENU_LOG, "1. Take our four question survey");
        LOGGER.log(MENU_LOG, "2. Buy stamps");
        LOGGER.log(MENU_LOG, "3. Sign up for our membership");
        LOGGER.log(MENU_LOG, "0. End");

        // Use integer for output
        int optionNum = scanner.nextInt();

        // Switch for more options
        switch (optionNum) {
            case 0:
                LOGGER.log(MENU_LOG, "Thank you for shopping here");
                System.exit(0);
                break;
            case 1:
                SurveyManager.enterSurveyInfo();
                break;
            case 2:
                StampStore.buyStamps();
                break;
            case 3:
                MembershipManager.enterMembershipInfo();
                break;
            default:
                LOGGER.error("You did not enter a choice given. Try again");
                moreOptionsForCheckout();
                break;
        }
    }
}
