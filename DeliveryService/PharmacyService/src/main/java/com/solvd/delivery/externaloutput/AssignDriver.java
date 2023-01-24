package com.solvd.delivery.externaloutput;

import com.solvd.delivery.person.Driver;
import org.apache.logging.log4j.*;

import java.util.Scanner;

public class AssignDriver {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("FACTOID_LOG", 700);
    public static Driver enterDriver() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "Enter your driver's license number");
        String licenseNumber = scanner.nextLine();
        Driver driver = new Driver(licenseNumber);

        LOGGER.log(MENU_LOG, "\nEnter your driver's first name");
        String driverFirst = scanner.nextLine();
        driver.setFirstName(driverFirst);

        // Enter the driver's last name
        LOGGER.log(MENU_LOG, "Enter your driver's last name");
        String driverLast = scanner.nextLine();
        driver.setLastName(driverLast);

        int driverNumber = RandomOperations.getRandomNumber(10000, 99999);
        driver.setIdNumber(String.valueOf(driverNumber));

        LOGGER.log(MENU_LOG, "\nDriver information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        LOGGER.log(MENU_LOG, "Name: " + fullName);
        LOGGER.log(MENU_LOG, "Employee Number: " + driver.getIdNumber());
        LOGGER.log(MENU_LOG, "License Number: " + driver.getLicenseNumber());

        return driver;
    }
}
