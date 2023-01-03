package com.solvd.delivery.externaloutput;

import com.solvd.delivery.factoid.FactoidHelper;
import com.solvd.delivery.factoid.IFactoid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Scanner;

public class FactoidMainMethod {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level FACTOID_LOG = Level.forName("FACTOID_LOG", 700);

    public static void factoid() throws Exception {

        IFactoid firstFactoid = () ->
        {
            LOGGER.log(FACTOID_LOG, "Did you know?: THE POSTAL SERVICE EMPLOYS MORE THAN 7.5 MILLION PEOPLE.");
            LOGGER.log(FACTOID_LOG, "The U.S. postal service is the reason more than 7.5 million people have " +
                    "jobs. The mailing industry brought in $70.6 billion in operating revenues in 2018.");
            LOGGER.log(FACTOID_LOG, "Source: Redbook (bit.ly/3VsbI6S)");
        };
        firstFactoid.outputFactoid();

        IFactoid secondFactoid = () ->
        {
            LOGGER.log(FACTOID_LOG, "The Postal Service processes and delivers 46 percent of the world’s" +
                    " mail and is constantly innovating to make customer experiences better.");
            LOGGER.log(FACTOID_LOG, "Source: USPS (https://facts.usps.com/top-facts/)");
        };
        secondFactoid.outputFactoid();

        FactoidHelper factoidHelper = FactoidHelper.class.getConstructor().newInstance();
        Method[] factoidMethods = factoidHelper.getClass().getMethods();

        LOGGER.log(FACTOID_LOG, "Please enter a factoid");
        Scanner scanner = new Scanner(System.in);
        String factoidInput = scanner.nextLine();

        // Printing method names
        for (Method factoidMethod : factoidMethods) {
            if (factoidMethod.getName().equals("setUserFactoid")) {
                factoidMethod.setAccessible(true);
                factoidMethod.invoke(factoidHelper, factoidInput);
            }

            if (factoidMethod.getName().equals("getUserFactoid")) {
                factoidMethod.setAccessible(true);
                LOGGER.log(FACTOID_LOG, factoidMethod.invoke(factoidHelper));
            }
        }

        System.exit(0);
    }
}
