package com.solvd.delivery.externaloutput;

import com.solvd.delivery.Main;
import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.membership.*;
import com.solvd.delivery.person.*;
import org.apache.logging.log4j.*;
import java.util.Scanner;
import java.util.function.Predicate;

public class MembershipManager {

    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void enterMembershipInfo() {
        Scanner scanner = new Scanner(System.in);
        MembershipInformation membershipDetails = new MembershipInformation();

        Person person = new Person();
        membershipDetails.setPerson(person);

        LOGGER.log(MENU_LOG, "\nEnter your first name");
        String memberFirstName = scanner.nextLine();
        membershipDetails.getPerson().setFirstName(memberFirstName);

        LOGGER.log(MENU_LOG, "Enter your last name");
        String memberLastName = scanner.nextLine();
        membershipDetails.getPerson().setLastName(memberLastName);

        // Get the email for the membership
        LOGGER.log(MENU_LOG, "What is your email?");
        String email = scanner.nextLine();
        membershipDetails.getPerson().setEmail(email);

        LOGGER.log(MENU_LOG, "What is your age?");
        int age = scanner.nextInt();
        membershipDetails.getPerson().setAge(age);

        setMembershipNotificationPreferences(membershipDetails);

    }

    public static void setMembershipNotificationPreferences(MembershipInformation membershipDetails) {
        Scanner scanner = new Scanner(System.in);
        // If they want special offers, have them choose
        LOGGER.log(MENU_LOG, "\nWould you like information on our special offers and coupons? Yes/No?");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "YES":
                LOGGER.log(MENU_LOG, "You will receive offers and coupons");
                String yesOffers = MembershipInformation.OfferStatus.YES_OFFERS.getOfferStatus();
                confirmMembershipInfo(membershipDetails, yesOffers);
                break;
            case "NO":
                LOGGER.log(MENU_LOG, "You will not be sent offers");
                String noOffers = MembershipInformation.OfferStatus.NO_OFFERS.getOfferStatus();
                confirmMembershipInfo(membershipDetails, noOffers);
                break;
            default:
                try {
                    ExceptionManager.checkYesOrNo(choice);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                setMembershipNotificationPreferences(membershipDetails);
                break;
        }
    }

    public static void confirmMembershipInfo(MembershipInformation membershipDetails, String offerStatus) {
        // Use an int for a random membership number
        String membershipNumber = String.valueOf(Main.getRandomNumber(100000, 999999));
        membershipDetails.setMembershipNumber(membershipNumber);

        // Output for email correction
        LOGGER.log(MENU_LOG, "\nYour name is: " + membershipDetails.getPerson().toString());
        LOGGER.log(MENU_LOG, "Your email is: " + membershipDetails.getPerson().getEmail());
        LOGGER.log(MENU_LOG, "Your offer status is: " + offerStatus);
        LOGGER.log(MENU_LOG, "Your membership number is: " + membershipDetails.getMembershipNumber());
        LOGGER.log(MENU_LOG, "Your age is: " + membershipDetails.getPerson().getAge());

        // Use this for choice
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "YES":
                Predicate<Integer> seventeenOrOlder = (age) -> age >= 17;
                boolean isPerson17OrOlder = seventeenOrOlder.test(membershipDetails.getPerson().getAge());
                if (!isPerson17OrOlder) {
                    LOGGER.log(MENU_LOG, "\nI'm sorry, but you must be 17 or older to sign up");
                    LOGGER.log(MENU_LOG, "Please enter your information again");
                    enterMembershipInfo();
                }
                LOGGER.log(MENU_LOG, "\nThank you for information and welcome to our membership");
                System.exit(0);
                break;
            case "NO":
                LOGGER.log(MENU_LOG, "\nPlease enter your information again");
                enterMembershipInfo();
                break;
            default:
                try {
                    ExceptionManager.checkYesOrNo(choice);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                confirmMembershipInfo(membershipDetails, offerStatus);
                break;
        }
    }
}
