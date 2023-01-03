package com.solvd.delivery.externaloutput;
import com.solvd.delivery.Main;
import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.linkedlist.POBoxLinkedList;
import com.solvd.delivery.person.POBoxOwner;
import org.apache.logging.log4j.*;

import java.util.Scanner;

public class POBoxManager {

    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    static POBoxLinkedList poBoxList = new POBoxLinkedList();

    public static void createPOBox() {
        POBoxOwner poBox = new POBoxOwner();
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nEnter your first name");
        String firstName = scanner.nextLine();
        poBox.setFirstName(firstName);

        LOGGER.log(MENU_LOG, "Enter your last name");
        String lastName = scanner.nextLine();
        poBox.setLastName(lastName);

        LOGGER.log(MENU_LOG, "Enter your address");
        String address = scanner.nextLine();
        poBox.setAddress(address);

        LOGGER.log(MENU_LOG, "Enter your phone number");
        String phoneNumber = scanner.nextLine();
        poBox.setPhoneNumber(phoneNumber);

        final int LOW = 1000;
        final int HIGH = 9999;

        int boxId = Main.getRandomNumber(LOW, HIGH);

        String boxAddress = ("PO Box " + boxId);
        poBox.setPOBox(boxAddress);

        poBoxList.add(poBox);
        LOGGER.log(MENU_LOG, "Number of boxes: " + poBoxList.getSize());
        LOGGER.log(MENU_LOG, "Here are the boxes in our system\n" + poBoxList);

    }

    public static void clearThePOBoxList() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.log(MENU_LOG, "Would you like to clear the list? Yes/No?");
        String choice = scanner.nextLine().toUpperCase();
        switch (choice) {
            case "YES":
                poBoxList.clear();
                LOGGER.log(MENU_LOG, "List has been cleared");
                LOGGER.log(MENU_LOG, "Closing the system so changes go into effect");
                System.exit(0);
                Main.continueDelivery();
                break;
            case "NO":
                LOGGER.log(MENU_LOG, "List has not been cleared");
                break;
            default:
                try {
                    ExceptionManager.checkYesOrNo(choice);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                clearThePOBoxList();
                break;
        }
    }



    public static void viewThePOBoxList() {
        LOGGER.log(MENU_LOG, "Here is the list of PO Boxes");
        LOGGER.log(MENU_LOG, poBoxList);

    }
}
