package com.solvd.delivery.externaloutput;

import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.survey.ISurveyHelper;
import com.solvd.delivery.survey.Survey;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyManager {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void enterSurveyInfo() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> surveyAnswers = new ArrayList<>();

        // Use the surveyor variable to grab the answers
        Survey surveyor = new Survey();
        LOGGER.log(MENU_LOG, "\nRate from 1-10. How did you like our service?");
        int choiceNum = scanner.nextInt();
        ExceptionManager.surveyOutOfRange(choiceNum);
        surveyAnswers.add(choiceNum);

        LOGGER.log(MENU_LOG, "Rate from 1-10. How efficient was our service?");
        choiceNum = scanner.nextInt();
        ExceptionManager.surveyOutOfRange(choiceNum);
        surveyAnswers.add(choiceNum);

        LOGGER.log(MENU_LOG, "Rate from 1-10. How friendly was our staff?");
        choiceNum = scanner.nextInt();
        ExceptionManager.surveyOutOfRange(choiceNum);
        surveyAnswers.add(choiceNum);

        surveyor.setAnswerList(surveyAnswers);
        confirmSurveyInfo(surveyor.getAnswerList());
    }

    public static void confirmSurveyInfo(List<Integer> surveyAnswers) {
        LOGGER.log(MENU_LOG, "\nYou answers were: ");
        surveyAnswers.stream().forEach((answers) -> LOGGER.log(MENU_LOG, answers));
        int average = (int) surveyAnswers.stream().mapToInt(a -> a).average().orElse(0);
        LOGGER.log(MENU_LOG, "The average of your answers is " + average);

        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "YES":
                if (average > 8) {
                    LOGGER.log(MENU_LOG, "We are so happy we provided you great service");
                } else if (average > 4) {
                    LOGGER.log(MENU_LOG, "We are happy we provided a pleasant experience. " +
                            "We will improve exponentially");
                    LOGGER.log(MENU_LOG, "Please take a couple of free stamps as compensation");

                    ISurveyHelper<String> giveCompensationStamps = (givenAverage) -> {
                        LOGGER.log(MENU_LOG, "What is your favorite color?");
                        String favoriteColor = scanner.nextLine().toLowerCase();
                        return (givenAverage + " " + favoriteColor);
                    };

                    LOGGER.log(MENU_LOG, "Please take a total of " +
                            giveCompensationStamps.findAverageOrCompensation(String.valueOf(average)) + " stamps");
                } else {
                    LOGGER.log(MENU_LOG, "We apologize for the lackluster service");
                    LOGGER.log(MENU_LOG, "In return, we will give you a 25 percent discount on your next" +
                            " delivery or purchase of materials for shipping");
                }
                LOGGER.log(MENU_LOG, "Thank you for your service. Goodbye");
                System.exit(0);
                break;
            case "NO":
                LOGGER.log(MENU_LOG, "Please select your choices again");
                enterSurveyInfo();
                break;
            default:
                try {
                    ExceptionManager.checkYesOrNo(choice);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                confirmSurveyInfo(surveyAnswers);
                break;
        }
    }
}
