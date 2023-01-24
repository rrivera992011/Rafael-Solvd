package com.solvd.delivery.externaloutput;

import com.solvd.delivery.enums.*;
import com.solvd.delivery.television.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TelevisionInfoOutput {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void televisionInformation() throws Exception {
        try(TelevisionInformation televisionInformation = TelevisionInformation.class.getConstructor().newInstance()){
            Method[] tvMethods = televisionInformation.getClass().getMethods();
            Set<String> tvInformationSet = new HashSet<>();
            List<String> donors = Arrays.asList(
                    "Government of the United States",
                    "Government of Tennessee",
                    "Nashville City Council",
                    "Al Johnson",
                    "Tennessee Titans Organization");

            Scanner scanner = new Scanner(System.in);
            LOGGER.log(MENU_LOG, "\nWhat's the weather today?");
            String weather = scanner.nextLine();
            tvInformationSet.add(weather);

            LOGGER.log(MENU_LOG, "\nWhat is the day today");
            String dayOfTheWeek = scanner.nextLine().toUpperCase();
            switch (dayOfTheWeek) {
                case "MONDAY":
                    tvInformationSet.add(DayOfTheWeek.MONDAY.getDays());
                    break;
                case "TUESDAY":
                    tvInformationSet.add(DayOfTheWeek.TUESDAY.getDays());
                    break;
                case "WEDNESDAY":
                    tvInformationSet.add(DayOfTheWeek.WEDNESDAY.getDays());
                    break;
                case "THURSDAY":
                    tvInformationSet.add(DayOfTheWeek.THURSDAY.getDays());
                    break;
                case "FRIDAY":
                    tvInformationSet.add(DayOfTheWeek.FRIDAY.getDays());
                    break;
                case "SATURDAY":
                    tvInformationSet.add(DayOfTheWeek.SATURDAY.getDays());
                    break;
                case "SUNDAY":
                    tvInformationSet.add(DayOfTheWeek.SUNDAY.getDays());
                    break;
                default:
                    LOGGER.error("Wrong day. Please enter the information again");
                    televisionInformation();
                    break;
            }

            LOGGER.log(MENU_LOG, "\nInsert a quote from a famous individual for the day");
            String quote = scanner.nextLine();
            tvInformationSet.add(quote);

            for (Method tvMethod : tvMethods) {
                if (tvMethod.getName().equals("setInfoForTV")) {
                    tvMethod.setAccessible(true);
                    tvMethod.invoke(televisionInformation, tvInformationSet);
                }

                if (tvMethod.getName().equals("setListOfDonors")) {
                    tvMethod.setAccessible(true);
                    tvMethod.invoke(televisionInformation, donors);
                }
            }


            tvInformationSet.stream().forEach((element) -> LOGGER.log(MENU_LOG, element));

            List<String> governmentDonors = donors.stream().filter(s -> s.startsWith("G")).
                    collect(Collectors.toList());

            LOGGER.log(MENU_LOG, "\nThank you for your contributions to the delivery service");
            donors.stream().forEach((donor) -> LOGGER.log(MENU_LOG, donor));

            LOGGER.log(MENU_LOG, "\nAnother big thank you for the government donors");
            governmentDonors.stream().forEach((governmentDonor) -> LOGGER.log(MENU_LOG, governmentDonor));

        } catch(RuntimeException e){
            LOGGER.log(MENU_LOG, "Exception",e);
        }

        System.exit(0);

    }
}
