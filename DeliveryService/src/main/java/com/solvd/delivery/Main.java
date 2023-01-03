package com.solvd.delivery;

import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.insurance.*;
import com.solvd.delivery.mailing.*;
import com.solvd.delivery.person.*;
import com.solvd.delivery.shipment.*;
import com.solvd.delivery.stamp.*;
import com.solvd.delivery.vehicle.*;
import com.solvd.delivery.enums.*;
import com.solvd.delivery.externaloutput.*;
import org.apache.commons.lang3.StringUtils;
import java.util.*;
import java.io.*;
import org.apache.logging.log4j.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.*;

import static com.solvd.delivery.insurance.InsuranceUtils.getInsuranceNumber;

public class Main {
    static Customer sender = new Customer();
    static Customer recipient = new Customer();
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "Welcome to the delivery system. ");
        LOGGER.log(MENU_LOG, "Please choose from one of the following options: ");
        menuOptions();

        // Loop for menu
        // Do the selection while selection is not 0
        int selection;
        do {
            selection = scanner.nextInt();
            menuSelection(selection);
        } while (selection != 0);
    }

    public static void menuOptions() {
        // Print out the sender and the recipient while it's not empty
        if (StringUtils.isEmpty(sender.getFirstName())) {
            LOGGER.log(MENU_LOG, "\nPlease enter information about sender\n");
        } else {
            LOGGER.log(MENU_LOG, "\nName of sender: " + sender.toString());
            LOGGER.log(MENU_LOG, "Address of sender: " + sender.getAddress());
            LOGGER.log(MENU_LOG, "Phone number of recipient: " + sender.getPhoneNumber() + "\n");
        }

        if (StringUtils.isEmpty(recipient.getFirstName())) {
            LOGGER.log(MENU_LOG, "Please enter information about recipient\n");
        } else {
            LOGGER.log(MENU_LOG, "\nName of recipient: " + recipient.toString());
            LOGGER.log(MENU_LOG, "Address of recipient: " + recipient.getAddress());
            LOGGER.log(MENU_LOG, "Phone number of recipient: " + recipient.getPhoneNumber() + "\n");
        }

        LOGGER.log(MENU_LOG, "1. Enter the sender or the recipient");
        LOGGER.log(MENU_LOG, "2. Send a package");
        LOGGER.log(MENU_LOG, "3. Only buy stamps");
        LOGGER.log(MENU_LOG, "4. File a complaint");
        LOGGER.log(MENU_LOG, "5. Sign up for our membership");
        LOGGER.log(MENU_LOG, "6. Create a PO Box");
        LOGGER.log(MENU_LOG, "7. Clear the list of PO Boxes");
        LOGGER.log(MENU_LOG, "8. View the PO Boxes");
        LOGGER.log(MENU_LOG, "9. Enter the information for the facility televisions");
        LOGGER.log(MENU_LOG, "10. Read a file");
        LOGGER.log(MENU_LOG, "11. Get a small factoid");
        LOGGER.log(MENU_LOG, "0. Exit the program");
    }

    public static void menuSelection(int selection) {
        switch (selection) {
            case 0:
                LOGGER.log(MENU_LOG, "Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                createSenderOrRecipient();
                continueDelivery();
                break;
            case 2:
                try {
                    ExceptionManager.checkCustomers(sender.getFirstName(),recipient.getFirstName());
                } catch (EmptyCustomerException e) {
                    LOGGER.error("\nA problem occurred ", e);
                } finally {
                    menuOptions();
                }
                break;
            case 3:
                StampPurchaseMethod.buyStamps();
                break;
            case 4:
                ComplaintManager.submitComplaint();
                break;
            case 5:
                MembershipManager.enterMembershipInfo();
                break;
            case 6:
                POBoxManager.createPOBox();
                continueDelivery();
                break;
            case 7:
                POBoxManager.clearThePOBoxList();
                break;
            case 8:
                POBoxManager.viewThePOBoxList();
                continueDelivery();
                break;
            case 9:
                try {
                    TelevisionInfoOutput.televisionInformation();
                } catch (Exception e) {
                    LOGGER.error("An exception occurred", e);
                }
                break;
            case 10:
                try {
                    File file = new File("src/main/resources/HeyDiddleDiddle.txt");
                    ReadFile.readAFile(file);
                } catch (FileNotFoundException e) {
                    LOGGER.error("File not found. Exiting now", e);
                    continueDelivery();
                } catch (IOException e) {
                    LOGGER.error("Input and output failed", e);
                    continueDelivery();
                }
                break;
            case 11:
                try {
                    FactoidMainMethod.factoid();
                } catch (Exception e) {
                    LOGGER.error("An error occurred", e);
                    continueDelivery();
                }
                break;
            default:
                try {
                    ExceptionManager.checkOptionIsInvalid(selection);
                } catch (InvalidDeliveryPlanException e) {
                    LOGGER.error("\nA problem occurred ", e);
                } finally {
                    menuOptions();
                }
                break;
        }
    }

    public static void createSenderOrRecipient() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nEnter your first name");
        String firstName = scanner.nextLine();

        LOGGER.log(MENU_LOG, "Enter your last name");
        String lastName = scanner.nextLine();

        LOGGER.log(MENU_LOG, "Enter your address");
        String address = scanner.nextLine();

        LOGGER.log(MENU_LOG, "Enter your phone number");
        String phoneNumber = scanner.nextLine();

        LOGGER.log(MENU_LOG, "Would you like to set this to sender or recipient?");
        String senderOrRecipient = scanner.nextLine().toUpperCase();

        if (StringUtils.equals(senderOrRecipient,"SENDER")){
            sender.setFirstName(firstName);
            sender.setLastName(lastName);
            sender.setAddress(address);
            sender.setPhoneNumber(phoneNumber);
        } else if(StringUtils.equals(senderOrRecipient,"RECIPIENT")){
            recipient.setFirstName(firstName);
            recipient.setLastName(lastName);
            recipient.setAddress(address);
            recipient.setPhoneNumber(phoneNumber);
        } else {
            LOGGER.error("Please select either a sender or recipient");
            createSenderOrRecipient();
        }
    }

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
                menuOptions();
                break;
            default:
                LOGGER.error("Please choose one of these options\n");
                continueDelivery();
                break;
        }

    }

    public static void insuranceTotal() {
        Scanner scanner = new Scanner(System.in);

        // Insurance range
        LOGGER.log(MENU_LOG, "\nDo you want insurance? Select from our plans");
        LOGGER.log(MENU_LOG, "1. {} - ${}", InsuranceType.LIGHT.getNameOfInsurance(), InsuranceType.LIGHT.getPriceOfInsurance());
        LOGGER.log(MENU_LOG, "2. {} - ${}", InsuranceType.MEDIUM.getNameOfInsurance(), InsuranceType.MEDIUM.getPriceOfInsurance());
        LOGGER.log(MENU_LOG, "3. {} - ${}", InsuranceType.HEAVY.getNameOfInsurance(), InsuranceType.HEAVY.getPriceOfInsurance());
        LOGGER.log(MENU_LOG, "0. {} - ${}", InsuranceType.NONE.getNameOfInsurance(), InsuranceType.NONE.getPriceOfInsurance());
        int insuranceSelection = scanner.nextInt();

        Insurance insuranceInfo = new Insurance();
        Map<String, Double> insuranceDetails = new HashMap<>();
        insuranceInfo.setInsuranceNumber(getInsuranceNumber());

        InsuranceType insuranceType = InsuranceType.NONE;
        switch (insuranceSelection) {
            case 1:
                insuranceType = InsuranceType.LIGHT;
                break;
            case 2:
                insuranceType = InsuranceType.MEDIUM;
                break;
            case 3:
                insuranceType = InsuranceType.HEAVY;
                break;
            case 0:
                insuranceType = InsuranceType.NONE;
                break;
            default:
                LOGGER.error("Please select a number from the choices given\n");
                insuranceTotal();
                break;
        }

        insuranceDetails.put(insuranceType.getNameOfInsurance(), InsuranceUtils.calculateInsurance(insuranceType, StateTax.TN_STATE_TAX));
        insuranceInfo.setInsuranceDetails(insuranceDetails);
        setUpShipment(insuranceInfo, insuranceType.getNameOfInsurance());
    }

    public static void setUpShipment(Insurance insuranceInfo, String insuranceName) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nWhich delivery plan do you want?");
        LOGGER.log(MENU_LOG, "5 days for $3, 3 days for $6, or 1 day for $9?");
        LOGGER.log(MENU_LOG, "Select based on the number of days that you want");
        int numOfDays = scanner.nextInt();
        Shipment shipment = new Shipment();
        shipment.setDays(numOfDays);

        Map<String, Double> insuranceMap = insuranceInfo.getInsuranceDetails();
        double priceOfInsurance = insuranceMap.get(insuranceName);

        // Double variable for the price
        ShipmentCalculator shipmentCalculator;

        // Switch statement used to calculate total using TN state tax
        switch (numOfDays) {
            case 1:
                shipmentCalculator = new ShipmentCalculator(DeliveryTime.ONE_DAY.getPricePerDay(),
                        StateTax.TN_STATE_TAX.getPercentOfTax(), priceOfInsurance);
                shipment.setPrice(shipmentCalculator.calculatePackage());
                break;
            case 3:
                shipmentCalculator = new ShipmentCalculator(DeliveryTime.THREE_DAYS.getPricePerDay(),
                        StateTax.TN_STATE_TAX.getPercentOfTax(), priceOfInsurance);
                shipment.setPrice(shipmentCalculator.calculatePackage());
                break;
            case 5:
                shipmentCalculator = new ShipmentCalculator(DeliveryTime.FIVE_DAYS.getPricePerDay(),
                        StateTax.TN_STATE_TAX.getPercentOfTax(), priceOfInsurance);
                shipment.setPrice(shipmentCalculator.calculatePackage());
                break;
            default:
                LOGGER.log(MENU_LOG, "Please select a number from the choices given\n");
                setUpShipment(insuranceInfo, insuranceName);
                break;
        }

        totalOutput(insuranceInfo, shipment);

    }

    public static void totalOutput(Insurance insuranceInfo, Shipment shipment) {
        // Output for ending
        final DecimalFormat df = new DecimalFormat("0.00");

        // Use a long to get a random package number
        int packageNumber = getRandomNumber(1000000, 9999999);

        shipment.setPackageNumber(packageNumber);

        LOGGER.log(MENU_LOG, "\nName of sender: " + sender.toString());
        LOGGER.log(MENU_LOG, "Address of sender: " + sender.getAddress());
        LOGGER.log(MENU_LOG, "Phone number: " + sender.getPhoneNumber() + "\n");

        LOGGER.log(MENU_LOG, "\nName of recipient: " + recipient.toString());
        LOGGER.log(MENU_LOG, "Address of sender: " + recipient.getAddress());
        LOGGER.log(MENU_LOG, "Phone number: " + recipient.getPhoneNumber() + "\n");

        LOGGER.log(MENU_LOG, "\nPackage number: " + shipment.getPackageNumber());
        LOGGER.log(MENU_LOG, "Insurance number: " + insuranceInfo.getInsuranceNumber());
        LOGGER.log(MENU_LOG, "ETA: " + shipment.getDays() + " Day(s)");

        df.setRoundingMode(RoundingMode.UP);
        LOGGER.log(MENU_LOG, "Complete total: " + df.format(shipment.getPrice()));
        confirmShipping(insuranceInfo, shipment);

    }

    public static void confirmShipping(Insurance insuranceInfo, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nIs this okay? Yes/No? (Not case sensitive)");
        String confirmation = scanner.nextLine().toUpperCase();

        switch (confirmation) {
            case "YES":
                LOGGER.log(MENU_LOG, "\nSending package now!");
                LOGGER.log(MENU_LOG, "Thank you for your business");
                company(insuranceInfo, shipment);
                break;
            case "NO":
                LOGGER.log(MENU_LOG, "\nPlease try again then");
                insuranceTotal();
                break;
            default:
                try {
                    ExceptionManager.checkYesOrNo(confirmation);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                confirmShipping(insuranceInfo, shipment);
        }
    }

    public static void company(Insurance insuranceInfo, Shipment shipment) {
        // Output for the company and placing everything in one object
        LOGGER.log(MENU_LOG, "\nOrder obtained");

        shipment.setSender(sender);
        shipment.setRecipient(recipient);
        shipment.setInsurance(insuranceInfo);

        String outputTest = shipment.toString();

        LOGGER.log(MENU_LOG, outputTest + "\n");

        // Create a driver using the enterDriver function and send it to the confirmation
        Driver driver = enterDriver();
        confirmDriver(driver, shipment);

    }

    public static Driver enterDriver() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nEnter your driver's first name");
        String driverAFirst = scanner.nextLine();
        driver.setFirstName(driverAFirst);

        // Enter the driver's last name
        LOGGER.log(MENU_LOG, "Enter your driver's last name");
        String driverALast = scanner.nextLine();
        driver.setLastName(driverALast);

        int driverNumber = getRandomNumber(10000, 99999);
        driver.setNumber(String.valueOf(driverNumber));

        LOGGER.log(MENU_LOG, "Enter your driver's license number");
        String licenseNumber = scanner.nextLine();
        driver.setLicenseNumber(licenseNumber);

        LOGGER.log(MENU_LOG, "\nDriver information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        LOGGER.log(MENU_LOG, "Name: " + fullName);
        LOGGER.log(MENU_LOG, "Employee Number: " + driver.getNumber());
        LOGGER.log(MENU_LOG, "License Number: " + driver.getLicenseNumber());

        return driver;
    }

    public static void confirmDriver(Driver driver, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);

        //Driver confirmation output
        LOGGER.log(MENU_LOG, "\nWhat is driver " + driver.getFirstName() + " " + driver.getLastName());
        LOGGER.log(MENU_LOG, "'s status? Active, Inactive, or On Hold");
        String driverStatus = scanner.nextLine().toUpperCase();

        // Use a switch statement for confirmation
        switch (driverStatus) {
            case "INACTIVE":
                LOGGER.log(MENU_LOG, "Driver status is " + DriverStatus.INACTIVE.getDriverStatus());
                LOGGER.log(MENU_LOG, "Alerting driver for dispatching now");
                LOGGER.log(MENU_LOG, "\nPreparing package drop off now!");
                determinePackageValues(driver, shipment);
                break;
            case "ACTIVE":
                LOGGER.log(MENU_LOG, "Driver status is " + DriverStatus.ACTIVE.getDriverStatus());
                LOGGER.log(MENU_LOG, "Driver cannot fulfill package delivery");
                LOGGER.log(MENU_LOG, "Please go back to the other menu and enter a different driver");
                company(shipment.getInsurance(), shipment);
                break;
            case "ON HOLD":
                LOGGER.log(MENU_LOG, "Driver status is " + DriverStatus.ON_HOLD.getDriverStatus());
                LOGGER.log(MENU_LOG, "Driver is busy. Update status when driver is available");
                confirmDriver(driver, shipment);
            default:
                LOGGER.error("\nA problem occurred. Please select another status of the given choices");
                confirmDriver(driver, shipment);
                break;

        }

    }

    public static void determinePackageValues(Driver driver, Shipment shipment) {
        // Allow the facility worker to enter the values they need for the package
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nEnter the weight of the package in pounds");
        double packageWeight = scanner.nextDouble();
        shipment.setWeight(packageWeight);
        LOGGER.log(MENU_LOG, "Enter the width of the package in inches");
        double packageWidth = scanner.nextDouble();
        LOGGER.log(MENU_LOG, "Enter the height of the package in inches");
        double packageHeight = scanner.nextDouble();

        setupForDelivery(packageWeight, packageWidth, packageHeight, driver, shipment);

    }

    public static Envelope sellEnvelope(double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Put all the elements into a single box object
        Envelope envelope = new Envelope();
        envelope.setWeight(packageWeight);
        envelope.setHeight(packageHeight);
        envelope.setWidth(packageWidth);
        envelope.setPackageType("Envelope");

        LOGGER.log(MENU_LOG, "\nHow many stamps do you have on the envelope?");
        int numberOfStamps = scanner.nextInt();

        LOGGER.log(MENU_LOG, "\nWhat is the color of your stamp? ");
        LOGGER.log(MENU_LOG, "Blue, Red, Green, or Orange (default if any other color is chosen) " +
                "(Determines price value)");

        String colorChoice = scanner2.nextLine().toUpperCase();

        int i = 0;

        ArrayList<Stamp> stamps = new ArrayList<>();

        while (i < numberOfStamps) {
            Stamp stamp = new Stamp();
            switch (colorChoice) {
                case "BLUE":
                    stamp.setColor(StampType.BLUE.getColorName());
                    stamp.setPrice(StampType.BLUE.getPrice());
                    break;
                case "RED":
                    stamp.setColor(StampType.RED.getColorName());
                    stamp.setPrice(StampType.RED.getPrice());
                    break;
                case "GREEN":
                    stamp.setColor(StampType.GREEN.getColorName());
                    stamp.setPrice(StampType.GREEN.getPrice());
                    break;
                case "ORANGE":
                    stamp.setColor(StampType.ORANGE.getColorName());
                    stamp.setPrice(StampType.ORANGE.getPrice());
                    break;
            }

            int numberForStampName = i + 1;
            stamp.setName("Stamp " + numberForStampName);
            stamps.add(stamp);
            i++;
        }

        envelope.setStampArrayList(stamps); // Set the array in the envelope
        return envelope;

    }

    public static Parcel sellParcel(double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);

        // Put all the elements into a single box object
        Parcel parcel = new Parcel();
        parcel.setWeight(packageWeight);
        parcel.setHeight(packageHeight);
        parcel.setWidth(packageWidth);
        parcel.setPackageType("Box");

        //Boolean used to detect whether a package is fragile or not
        LOGGER.log(MENU_LOG, "\nIs the package fragile? Type true or false");
        boolean confirmDrive = scanner.nextBoolean();

        parcel.setFragility(confirmDrive);
        return parcel;
    }

    public static void setupForDelivery(double packageWeight, double packageWidth, double packageHeight,
                                        Driver driver, Shipment shipment) {
        // If package weight is less than 10 pounds, put it in a box. Else, put it in an envelope
        if (packageWeight < 10) {
            Envelope envelope = sellEnvelope(packageWeight, packageWidth, packageHeight);
            shipment.setMailing(envelope);
            weighForFacility(driver, shipment);
        } else {
            Parcel box = sellParcel(packageWeight, packageWidth, packageHeight);
            shipment.setMailing(box);
            weighForFacility(driver, shipment);
        }

    }

    public static void weighForFacility(Driver driver, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        String driverFullName = driver.getFirstName() + " " + driver.getLastName();
        String senderFullName = shipment.getSender().getFirstName() + " " + shipment.getSender().getLastName();

        LOGGER.log(MENU_LOG, "\nThe weight of the object is " + shipment.getMailing().getWeight());
        LOGGER.log(MENU_LOG, "This is a(n) " + shipment.getMailing().getPackageType());

        // Switch statement to output based on the package type
        switch (shipment.getMailing().getPackageType()) {
            case "Box":
                Parcel parcel = (Parcel) shipment.getMailing();
                if (!parcel.getFragility()) {
                    LOGGER.log(MENU_LOG, "It is not fragile");
                } else {
                    LOGGER.log(MENU_LOG, "It is fragile");
                }
                break;
            case "Envelope":
                Envelope envelope = (Envelope) shipment.getMailing();
                ArrayList<Stamp> stampArray = envelope.getStampArrayList();
                LOGGER.log(MENU_LOG, "It needs " + stampArray.size() + " stamp(s)\n");

                for (Stamp s : stampArray) {
                    LOGGER.log(MENU_LOG, s.getName());
                    LOGGER.log(MENU_LOG, s.getColor());
                    LOGGER.log(MENU_LOG, df.format(s.getPrice()));
                }
                break;
            default:
                LOGGER.error("This is nothing");
                break;
        }

        LOGGER.log(MENU_LOG, "\nEnter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = scanner.nextDouble();
        LOGGER.log(MENU_LOG, "The weight of the object in the facility is: " + weightAtFacility);

        // Create a hash map for the weight set to check for equals
        Map<String, Double> weightSet = new HashMap<>();
        weightSet.put(senderFullName, shipment.getWeight());
        weightSet.put(driverFullName, weightAtFacility);

        for (Map.Entry<String, Double> nameAndWeight : weightSet.entrySet()) {
            LOGGER.log(MENU_LOG, nameAndWeight.getKey() + " = " + nameAndWeight.getValue());
        }

        // If the weight isn't the same as the package weight, return to the function
        if (!weightSet.get(senderFullName).equals(weightSet.get(driverFullName))) {
            LOGGER.log(MENU_LOG, "\nThe package is not there. Find the correct package");
            weighForFacility(driver, shipment);

        } else {
            LOGGER.log(MENU_LOG, "\nThe correct package is found.");
            LOGGER.log(MENU_LOG, "ETA is " + shipment.getDays() + " day(s) until delivery");
            LOGGER.log(MENU_LOG, "Entering in vehicle now");
            vehicleChoice(shipment);
        }

    }

    public static void vehicleChoice(Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        LOGGER.log(MENU_LOG, "\nSet the name of your vehicle");
        String vehicleName = scanner.nextLine();
        vehicle.setName(vehicleName);
        LOGGER.log(MENU_LOG, "\nSet the number of your vehicle");
        String vehicleNumber = scanner2.nextLine();
        vehicle.setNumber(vehicleNumber);
        vehicleOutput(shipment, vehicle);
    }

    public static void vehicleOutput(Shipment shipment, Vehicle vehicle) {
        LOGGER.log(MENU_LOG, "\nVehicle name: " + vehicle.getName());
        LOGGER.log(MENU_LOG, "Vehicle number: " + vehicle.getNumber());
        LOGGER.log(MENU_LOG, "Sending package now");
        orderFinished(shipment);
    }

    public static void orderFinished(Shipment shipment) {
        // Output everything
        String order;
        LOGGER.log(MENU_LOG, "\nOrder delivered");
        if (shipment.getMailing().getPackageType().equals("Box")) {
            Parcel parcel = (Parcel) shipment.getMailing();
            LOGGER.log(MENU_LOG, "\n" + parcel.getPackageType() + " received");
            order = shipment.toString();
            LOGGER.log(MENU_LOG, order);
            moreOptionsForCheckout();
        } else if (shipment.getMailing().getPackageType().equals("Envelope")) {
            Envelope envelope = (Envelope) shipment.getMailing();
            LOGGER.log(MENU_LOG, "\n" + envelope.getPackageType() + " received");
            order = shipment.toString();
            LOGGER.log(MENU_LOG, order);
            moreOptionsForCheckout();
        }
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
                StampPurchaseMethod.buyStamps();
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

    public static int getRandomNumber(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }

}