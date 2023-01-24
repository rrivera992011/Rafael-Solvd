package com.solvd.delivery.externaloutput;

import com.solvd.delivery.Main;
import com.solvd.delivery.exceptions.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.*;

public class ExceptionManager {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");

    public static void checkYesOrNo(String confirmation) throws InvalidInputException {
        if (!(confirmation.equals("YES") || confirmation.equals("NO"))) {
            throw new InvalidInputException("\nPlease choose Yes or NO");
        }
    }

    public static void checkCustomers(String senderFirstName, String recipientFirstName) throws EmptyCustomerException {
        if (StringUtils.isEmpty(senderFirstName) || StringUtils.isEmpty(recipientFirstName)) {
            throw new EmptyCustomerException("\nPlease enter both a sender and a recipient");
        } else {
            Main.insuranceTotal();
        }
    }

    public static void tooManyOrFewerStamps(int numberOfStamps) throws TooManyStampsException {
        if (numberOfStamps > 100) {
            throw new TooManyStampsException("\nToo many stamps");
        } else if (numberOfStamps < 1) {
            throw new TooManyStampsException("\nToo few stamps");
        }
    }

    public static void checkOptionIsInvalid(int selection) throws InvalidDeliveryPlanException {
        if (selection < 0 || selection > 11) {
            throw new InvalidDeliveryPlanException("\nPlease select a number from the choices given");
        }
    }

    public static void surveyOutOfRange(int choiceNum) {
        if (choiceNum < 1 || choiceNum > 10) {
            try {
                incorrectSurveyOption();
            } catch (InvalidSurveyAnswerException e) {
                LOGGER.error("\nThere is an error", e);
            } finally {
                SurveyManager.enterSurveyInfo();
            }
        }
    }

    public static void incorrectSurveyOption() throws InvalidSurveyAnswerException {
        throw new InvalidSurveyAnswerException("\nPlease enter a number from 1 to 10");
    }

}
