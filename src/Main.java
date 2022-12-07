import complaint.*;
import exceptions.*;
import factoid.FactoidOutput;
import insurance.*;
import mailing.*;
import membership.*;
import person.*;
import shipment.*;
import stamp.*;
import survey.*;
import vehicle.*;

import org.apache.logging.log4j.*;

import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main {

    static Customer sender = new Customer();
    static Customer recipient = new Customer();

    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "Welcome to the delivery system. ");
        LOGGER.log(MENU_LOG,"Please choose from one of the following options: ");
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
        if(!sender.getFirstName().equals("")) {
            LOGGER.log(MENU_LOG, "\nName of sender: " + sender.toString());
            LOGGER.log(MENU_LOG, "Address of sender: " + sender.getAddress());
            LOGGER.log(MENU_LOG, "Phone number: " + sender.getPhoneNumber() + "\n");
        }

        if(!recipient.getFirstName().equals("")) {
            LOGGER.log(MENU_LOG, "\nName of recipient: " + recipient.toString());
            LOGGER.log(MENU_LOG, "Address of recipient: " + recipient.getAddress());
            LOGGER.log(MENU_LOG, "Phone number: " + recipient.getPhoneNumber() + "\n");
        }

        LOGGER.log(MENU_LOG,"1. Enter the sender");
        LOGGER.log(MENU_LOG,"2. Enter the recipient");
        LOGGER.log(MENU_LOG,"3. Send a package");
        LOGGER.log(MENU_LOG,"4. Only buy stamps");
        LOGGER.log(MENU_LOG,"5. File a complaint");
        LOGGER.log(MENU_LOG,"6. Sign up for our membership");
        LOGGER.log(MENU_LOG,"0. Exit the program");

    }

    public static void menuSelection(int selection) {

        switch (selection) {
            case 0:
                LOGGER.log(MENU_LOG,"Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                createASender();
                continueDelivery();
                break;
            case 2:
                createARecipient();
                continueDelivery();
                break;
            case 3:
                    try {
                        checkCustomers();
                    } catch (EmptyCustomerException e) {
                        LOGGER.error("\nA problem occurred " + e);
                    } finally {
                        menuOptions();
                    }
                break;
            case 4:
                buyStamps();
                break;
            case 5:
                submitComplaint();
                break;
            case 6:
                enterMembershipInfo();
                break;
            default:
                try {
                    invalidOption(selection);
                } catch(InvalidDeliveryPlanException e) {
                    LOGGER.error("\nA problem occurred " + e);
                } finally {
                    menuOptions();
                }

                break;
        }
    }

    public static void createASender() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nEnter your first name");
        String senderFirstName = scanner.nextLine();
        sender.setFirstName(senderFirstName);

        LOGGER.log(MENU_LOG,"Enter your last name");
        String senderLastName = scanner.nextLine();
        sender.setLastName(senderLastName);

        LOGGER.log(MENU_LOG,"Enter your address");
        String senderAddress = scanner.nextLine();
        sender.setAddress(senderAddress);

        LOGGER.log(MENU_LOG,"Enter your phone number");
        String phoneNumber = scanner.nextLine();
        sender.setPhoneNumber(phoneNumber);

    }

    public static void createARecipient() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nEnter the recipient's first name");
        String recipientFirstName = scanner.nextLine();
        recipient.setFirstName(recipientFirstName);

        LOGGER.log(MENU_LOG,"Enter the recipient's last name");
        String recipientLastName = scanner.nextLine();
        recipient.setLastName(recipientLastName);

        LOGGER.log(MENU_LOG,"Enter the recipient's address");
        String recipientAddress = scanner.nextLine();
        recipient.setAddress(recipientAddress);

        LOGGER.log(MENU_LOG,"Enter the recipient's phone number");
        String phoneNumber = scanner.nextLine();
        recipient.setPhoneNumber(phoneNumber);



    }

    public static void continueDelivery() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nTo return to operation, press 1");
        LOGGER.log(MENU_LOG,"To exit the operation, press 0\n");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                LOGGER.log(MENU_LOG,"Thank you for your service! Have a great day!");
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
        LOGGER.log(MENU_LOG,"\nDo you want insurance? Select from our plans");
        LOGGER.log(MENU_LOG,"1. $10 coverage");
        LOGGER.log(MENU_LOG,"2. $30 coverage");
        LOGGER.log(MENU_LOG,"3. $50 coverage");
        LOGGER.log(MENU_LOG,"0. No insurance");
        int insuranceSelection = scanner.nextInt();

        Insurance insuranceInfo = new Insurance();

        double priceOfInsurance;
        final double TEN_DOLLARS = 10;
        final double THIRTY_DOLLARS = 30;
        final double FIFTY_DOLLARS = 50;
        final double TN_STATE_TAX = 0.07;
        final double ZERO = 0;
        final int LOW = 1000000;
        final int HIGH = 9999999;

        // Random number generating bar code
        long insuranceNumber = setRandomNumber(LOW,HIGH );
        insuranceInfo.setInsuranceNumber(insuranceNumber);

        // Switch statement used for insurance prices using TN state tax
        switch (insuranceSelection) {
            case 1:
                    priceOfInsurance = TEN_DOLLARS + (TEN_DOLLARS * TN_STATE_TAX);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 2:
                    priceOfInsurance = THIRTY_DOLLARS + (THIRTY_DOLLARS * TN_STATE_TAX);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 3:
                    priceOfInsurance = THIRTY_DOLLARS + (FIFTY_DOLLARS * TN_STATE_TAX);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 0:
                    priceOfInsurance = ZERO;
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            default:
                    LOGGER.error("Please select a number from the choices given\n");
                    insuranceTotal();
                    break;
        }

        setUpShipment(insuranceInfo, TN_STATE_TAX);


    }

    public static void setUpShipment(Insurance insuranceInfo, final double TN_STATE_TAX) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nWhich delivery plan do you want? 5 days for $3, 3 days for $6, or 1 day for $9?");
        LOGGER.log(MENU_LOG,"Select based on the number of days that you want");
        int numOfDays = scanner.nextInt();
        Shipment shipment = new Shipment();
        shipment.setDays(numOfDays);


        // Double variable for the price
        double priceOfPackage;
        final double THREE_DOLLARS = 3;
        final double SIX_DOLLARS = 6;
        final double NINE_DOLLARS = 9;


        // Switch statement used to calculate total using TN state tax
        switch(numOfDays) {
            case 1:
                priceOfPackage = NINE_DOLLARS + (NINE_DOLLARS * TN_STATE_TAX) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            case 3:
                priceOfPackage = SIX_DOLLARS + (SIX_DOLLARS * TN_STATE_TAX) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            case 5:
                priceOfPackage = THREE_DOLLARS + (THREE_DOLLARS * TN_STATE_TAX) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            default:
                LOGGER.log(MENU_LOG,"Please select a number from the choices given\n");
                setUpShipment(insuranceInfo, TN_STATE_TAX);
                break;
        }



        totalOutput(insuranceInfo, shipment);

    }
    public static void totalOutput(Insurance insuranceInfo, Shipment shipment) {
        // Output for ending
        final DecimalFormat df = new DecimalFormat("0.00");

        // Use a long to get a random package number
        long packageNumber = setRandomNumber(100000000, 999999999);

        shipment.setPackageNumber(packageNumber);

        LOGGER.log(MENU_LOG,"\nName of sender: " + sender.toString());
        LOGGER.log(MENU_LOG,"Address of sender: " + sender.getAddress());
        LOGGER.log(MENU_LOG,"Phone number: " + sender.getPhoneNumber() + "\n");

        LOGGER.log(MENU_LOG,"\nName of recipient: " + recipient.toString());
        LOGGER.log(MENU_LOG,"Address of sender: " + recipient.getAddress());
        LOGGER.log(MENU_LOG,"Phone number: " + recipient.getPhoneNumber() + "\n");

        LOGGER.log(MENU_LOG,"\nPackage number: " + shipment.getPackageNumber());
        LOGGER.log(MENU_LOG,"Insurance number: " + insuranceInfo.getInsuranceNumber());
        LOGGER.log(MENU_LOG,"ETA: " + shipment.getDays() + " Day(s)");

        df.setRoundingMode(RoundingMode.UP);
        LOGGER.log(MENU_LOG,"Complete total: " + df.format(shipment.getPrice()));

        confirmShipping(insuranceInfo, shipment);


    }

    public static void confirmShipping(Insurance insuranceInfo, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nIs this okay? Yes/No? (Not case sensitive)");
        String confirmation = scanner.nextLine().toUpperCase();

        switch(confirmation){
            case "YES":
                        LOGGER.log(MENU_LOG,"\nSending package now!");
                        LOGGER.log(MENU_LOG,"Thank you for your business");
                        company(insuranceInfo, shipment);

                        break;
            case "NO":
                        LOGGER.log(MENU_LOG,"\nPlease try again then");
                        insuranceTotal();
                        break;
            default:
                        try{
                            checkYesOrNo(confirmation);
                        } catch (YesOrNoException e) {
                            LOGGER.error("\nA problem occurred " + e);
                        }

                        // LOGGER.log(MENU_LOG,"\nPlease try something other than Yes or No");
                        confirmShipping(insuranceInfo, shipment);

        }
    }

    public static void company(Insurance insuranceInfo, Shipment shipment) {
        // Output for the company and placing everything in one object
        LOGGER.log(MENU_LOG,"\nOrder obtained");

        shipment.setSender(sender);
        shipment.setRecipient(recipient);
        shipment.setInsurance(insuranceInfo);


        String outputTest = shipment.toString();

        LOGGER.log(MENU_LOG,outputTest + "\n");

        // Create a driver using the enterDriver function and send it to the confirmation
        Driver driver = enterDriver();
        confirmDriver(driver, shipment);


    }

    public static Driver enterDriver() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nEnter your driver's first name");
        String driverAFirst = scanner.nextLine();
        driver.setFirstName(driverAFirst);

        // Enter the driver's last name
        LOGGER.log(MENU_LOG,"Enter your driver's last name");
        String driverALast = scanner.nextLine();
        driver.setLastName(driverALast);

        long driverNumber = setRandomNumber(10000, 99999);

        driver.setEmployeeNumber(driverNumber);

        // Enter the car's status
        LOGGER.log(MENU_LOG,"How is the car doing?");
        String carStatus = scanner.nextLine();
        driver.setStatus(carStatus);

        LOGGER.log(MENU_LOG,"\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        LOGGER.log(MENU_LOG,"Name: " + fullName);
        LOGGER.log(MENU_LOG,"Number: " + driver.getEmployeeNumber());
        LOGGER.log(MENU_LOG,"Status: " + driver.getStatus());

        return driver;
    }

    public static void confirmDriver(Driver driver, Shipment shipment){
        Scanner scanner = new Scanner(System.in);

        //Driver confirmation output
        LOGGER.log(MENU_LOG,"\nCan you confirm that " + "driver " + driver.getFirstName() + " " + driver.getLastName());
        LOGGER.log(MENU_LOG," will take this delivery? Yes or No? (Not case sensitive)");
        String confirmDrive = scanner.nextLine().toUpperCase();

        // Use a switch statement for confirmation
        switch(confirmDrive){
            case "YES":
                LOGGER.log(MENU_LOG,"\nPreparing package drop off now!");
                determinePackageValues(driver, shipment);
                break;
            case "NO":
                LOGGER.log(MENU_LOG,"\nPlease go back to the other menu and enter a different driver");
                company(shipment.getInsurance(), shipment);
                break;
            default:
                try{
                    checkYesOrNo(confirmDrive);
                } catch (YesOrNoException e) {
                    LOGGER.error("\nA problem occurred " + e);
                }
                confirmDriver(driver, shipment);
                break;

        }


    }

    public static void determinePackageValues(Driver driver, Shipment shipment){

        // Allow the facility worker to enter the values they need for the package
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nEnter the weight of the package in pounds");
        double packageWeight = scanner.nextDouble();
        shipment.setWeight(packageWeight);
        LOGGER.log(MENU_LOG,"Enter the width of the package in inches");
        double packageWidth = scanner.nextDouble();
        LOGGER.log(MENU_LOG,"Enter the height of the package in inches");
        double packageHeight = scanner.nextDouble();

        setupForDelivery(packageWeight, packageWidth, packageHeight, driver, shipment);




    }

    public static Envelope sellEnvelope (double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);

        // Put all the elements into a single box object
        Envelope envelope = new Envelope();
        envelope.setWeight(packageWeight);
        envelope.setHeight(packageHeight);
        envelope.setWidth(packageWidth);
        envelope.setPackageType("Envelope");

        LOGGER.log(MENU_LOG,"\nHow many stamps do you have on the envelope?");
        int stampNum = scanner.nextInt();
        envelope.setNumberOfStamps(stampNum);

        // Use an arraylist to set the stamps on an envelope
        ArrayList <Stamp> stamps = new ArrayList<>();
        final double STAMP_PRICE = 0.75;


        int i = 0;
        while (i < stampNum) {

            Stamp stamp = new Stamp();
            int stampNameInt = i+1;
            stamp.setName("Stamp " + stampNameInt);
            stamp.setPrice(STAMP_PRICE);
            stamps.add(stamp);
            i++;
        }

        // Set the array in the envelope
        envelope.setStampArrayList(stamps);

        return envelope;

    }

    public static Parcel sellParcel (double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);

        // Put all the elements into a single box object
        Parcel parcel = new Parcel();
        parcel.setWeight(packageWeight);
        parcel.setHeight(packageHeight);
        parcel.setWidth(packageWidth);
        parcel.setPackageType("Box");

        //Boolean used to detect whether a package is fragile or not
        LOGGER.log(MENU_LOG,"\nIs the package fragile? Type true or false");
        boolean confirmDrive = scanner.nextBoolean();

        parcel.setFragility(confirmDrive);

        return parcel;

    }

    public static void setupForDelivery(double packageWeight, double packageWidth, double packageHeight,
                                        Driver driver, Shipment shipment) {
        // If package weight is less than 10 pounds, put it in a box. Else, put it in an envelope
        if (packageWeight < 10)
        {
            Envelope envelope = sellEnvelope(packageWeight,packageWidth, packageHeight);
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
        String driverFullName = driver.getFirstName() + " " + driver.getLastName();
        String senderFullName = shipment.getSender().getFirstName() + " " + shipment.getSender().getLastName();

        LOGGER.log(MENU_LOG,"\nThe weight of the object is " + shipment.getMailing().getWeight());
        LOGGER.log(MENU_LOG,"This is a(n) " + shipment.getMailing().getPackageType());

        // Switch statement to output based on the package type
        switch(shipment.getMailing().getPackageType()){
            case "Box":
                Parcel parcel = (Parcel) shipment.getMailing();
                if (!parcel.getFragility()) {
                    LOGGER.log(MENU_LOG,"It is not fragile");
                } else {
                    LOGGER.log(MENU_LOG,"It is fragile");
                }
                break;
            case "Envelope":
                Envelope envelope = (Envelope) shipment.getMailing();
                LOGGER.log(MENU_LOG,"It needs " + envelope.getNumberOfStamps() + " stamp(s)\n");
                ArrayList <Stamp> stampArray = envelope.getStampArrayList();

                for (Stamp s: stampArray) {
                    LOGGER.log(MENU_LOG,s.getName());
                    LOGGER.log(MENU_LOG,s.getPrice());
                }

                break;
            default:
                LOGGER.error("This is nothing");
                break;
        }

        LOGGER.log(MENU_LOG,"\nEnter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = scanner.nextDouble();

        LOGGER.log(MENU_LOG,"The weight of the object in the facility is: " + weightAtFacility);

        // Create a hash map for the weight set to check for equals
        Map<String, Double> weightSet = new HashMap<>();
        weightSet.put(senderFullName, shipment.getWeight());
        weightSet.put(driverFullName, weightAtFacility);

        // If the weight isn't the same as the package weight, return to the function
        if (!weightSet.get(senderFullName).equals(weightSet.get(driverFullName))) {

            LOGGER.log(MENU_LOG,"\nThe package is not there. Find the correct package");
            weighForFacility(driver, shipment);

        } else {
            LOGGER.log(MENU_LOG,"\nThe correct package is found.");
            LOGGER.log(MENU_LOG,"ETA is " + shipment.getDays() + " day(s) until delivery");
            LOGGER.log(MENU_LOG,"Entering in vehicle now");
            vehicleChoice(shipment);
        }

    }

    public static void vehicleChoice(Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nWhat vehicle do you want to use? A car or an plane?");
        String choice = scanner.nextLine().toUpperCase();

        // Random element for car/plane number

        long carOrPlaneNum;

        // Use a switch statement to output the correct element
        switch(choice) {
            case "CAR":
                LOGGER.log(MENU_LOG,"\nYou have chosen a car");
                carOrPlaneNum = setRandomNumber(100000, 999999);
                Car car = new Car();
                car.setVehicleName("Car");
                car.setTruckNumber(carOrPlaneNum);
                vehicleOutput(shipment, car);
                break;
            case "PLANE":
                LOGGER.log(MENU_LOG,"\nYou have chosen an airplane");
                carOrPlaneNum = setRandomNumber(1, 1000);
                Plane plane = new Plane();
                plane.setVehicleName("Plane");
                plane.setPlaneNumber(carOrPlaneNum);
                vehicleOutput(shipment, plane);
                break;
            default:
                LOGGER.error("\nPlease choose something else");
                vehicleChoice(shipment);
                break;
        }
    }

    public static void vehicleOutput(Shipment shipment, IVehicle carOrPlane) {

        // Equalize the plane or car object for correct output
        if(carOrPlane.getVehicleName().equals("Car")) {
            Car car = ((Car) carOrPlane);
            LOGGER.log(MENU_LOG,"\nVehicle choice: " + car.getVehicleName());
            LOGGER.log(MENU_LOG,"Number: " + car.getCarNumber());
            LOGGER.log(MENU_LOG,"\nSending package now");
            orderFinished(shipment);

        } else if (carOrPlane.getVehicleName().equals("Plane")) {
            Plane plane = ((Plane) carOrPlane);
            LOGGER.log(MENU_LOG,"\nVehicle choice: " + plane.getVehicleName());
            LOGGER.log(MENU_LOG,"Number: " + plane.getPlaneNumber());
            LOGGER.log(MENU_LOG,"\nSending package now");
            orderFinished(shipment);
        }

    }

    public static void orderFinished(Shipment shipment) {

        // Output everything
        String order;
        LOGGER.log(MENU_LOG,"\nOrder delivered");
        if (shipment.getMailing().getPackageType().equals("Box")) {
            Parcel parcel = (Parcel) shipment.getMailing();
            LOGGER.log(MENU_LOG,"\n" + parcel.getPackageType() + " received");
            order = shipment.toString();
            LOGGER.log(MENU_LOG,order);
            moreOptions();

        } else if (shipment.getMailing().getPackageType().equals("Envelope")) {
            Envelope envelope = (Envelope) shipment.getMailing();
            LOGGER.log(MENU_LOG,"\n" + envelope.getPackageType() + " received");
            order = shipment.toString();
            LOGGER.log(MENU_LOG,order);
            moreOptions();
        }
    }

    public static void moreOptions() {
        // More options

        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nMore options");
        LOGGER.log(MENU_LOG,"1. Take our 3 question survey");
        LOGGER.log(MENU_LOG,"2. Get a small factoid of the mail while leaving");
        LOGGER.log(MENU_LOG,"3. Buy stamps. 0.75 per stamp");
        LOGGER.log(MENU_LOG,"4. Sign up for our membership");
        LOGGER.log(MENU_LOG,"0. End");

        // Use integer for output
        int optionNum = scanner.nextInt();

        // Switch for more options
        switch (optionNum) {
            case 0:
                    LOGGER.log(MENU_LOG,"Thank you for shopping here");
                    System.exit(0);
                    break;
            case 1:
                    enterSurveyInfo();
                    break;
            case 2:
                    factoid();
                    break;
            case 3:
                    buyStamps();
                    break;
            case 4:
                    enterMembershipInfo();
                    break;
            default:
                    LOGGER.error("You did not enter a choice given. Try again");
                    moreOptions();
                    break;
        }

    }

    public static void enterSurveyInfo() {
        Scanner scanner = new Scanner(System.in);

        // Use the surveyor variable to grab the answers
        Survey surveyor = new Survey();
        LOGGER.log(MENU_LOG,"\nRate from 1-10. How did you like our service?");
        int choiceNum = scanner.nextInt();

        if (choiceNum < 1 || choiceNum > 10) {
            try {
                incorrectSurveyOption();
            } catch (InvalidSurveyAnswerException e) {
                LOGGER.error("\nThere is an error" + e);
            } finally {
                enterSurveyInfo();
            }
        }

        surveyor.setServiceNum(choiceNum);
        LOGGER.log(MENU_LOG,"Rate from 1-10. How efficient was our service?");
        choiceNum = scanner.nextInt();

        if (choiceNum < 1 || choiceNum > 10) {
            try {
                incorrectSurveyOption();
            } catch (InvalidSurveyAnswerException e) {
                LOGGER.error("\nThere is an error" + e);
            } finally {
                enterSurveyInfo();
            }
        }

        surveyor.setEfficiencyNum(choiceNum);

        LOGGER.log(MENU_LOG,"Rate from 1-10. How friendly was our staff?");
        choiceNum = scanner.nextInt();

        if (choiceNum < 1 || choiceNum > 10) {
            try {
                incorrectSurveyOption();
            } catch (InvalidSurveyAnswerException e) {
                LOGGER.error("\nThere is an error" + e);
            } finally {
                enterSurveyInfo();
            }
        }

        surveyor.setFriendlinessNum(choiceNum);
        LOGGER.log(MENU_LOG,"\nYou answers were: " +
                surveyor.getServiceNum() + ", " + surveyor.getEfficiencyNum() +
                ", and " + surveyor.getFriendlinessNum());

        confirmSurveyInfo();
    }

    public static void confirmSurveyInfo() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                LOGGER.log(MENU_LOG,"\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
            case "NO":
                LOGGER.log(MENU_LOG,"Please select your choices again");
                enterSurveyInfo();
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch(YesOrNoException e) {
                    LOGGER.error("\nA problem occurred " + e);
                }
                confirmSurveyInfo();
                break;
        }
    }
    public static void factoid() {
        // Output a small factoid using
        FactoidOutput factoid = new FactoidOutput();
        factoid.outputFactoid();
        System.exit(0);
    }
    public static void buyStamps() {

        Stamp stamp = new Stamp();
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nHow many stamps would you like to buy? 0.75 per stamp");
        int numberOfStamps = scanner.nextInt();

        try{
            tooManyOrFewerStamps(numberOfStamps);
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
        // Calculate the number of stamps
        final double STAMP_PRICE = 0.75;
        stamp.setPrice(STAMP_PRICE);
        double completeTotal = stamp.getPrice() * numberOfStamps;

        stampOutput(numberOfStamps, completeTotal);
    }

    public static void stampOutput(int numberOfStamps, double completeTotal) {

        final DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);

        LOGGER.log(MENU_LOG,"\nYou bought " + numberOfStamps +
                " stamps for $" + df.format(completeTotal));
        LOGGER.log(MENU_LOG,"Thank you!");

        System.exit(0);
    }


    public static void enterMembershipInfo() {
        Scanner scanner = new Scanner(System.in);
        MembershipInformation membershipDetails = new MembershipInformation();

        Person person = new Person();
        membershipDetails.setPerson(person);

        LOGGER.log(MENU_LOG,"\nEnter your first name");
        String memberFirstName = scanner.nextLine();
        membershipDetails.getPerson().setFirstName(memberFirstName);

        LOGGER.log(MENU_LOG,"Enter your last name");
        String memberLastName = scanner.nextLine();
        membershipDetails.getPerson().setLastName(memberLastName);

        // Get the email for the membership
        LOGGER.log(MENU_LOG,"What is your email?");
        String email = scanner.nextLine();
        membershipDetails.getPerson().setEmail(email);

        LOGGER.log(MENU_LOG,"What is your age?");
        int age = scanner.nextInt();
        membershipDetails.getPerson().setAge(age);

        setMembershipNotificationPreferences(membershipDetails);

    }

    public static void setMembershipNotificationPreferences(MembershipInformation membershipDetails){
        Scanner scanner = new Scanner(System.in);
        // If they want special offers, have them choose
        LOGGER.log(MENU_LOG,"\nWould you like information on our special offers and coupons? Yes/No?");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                LOGGER.log(MENU_LOG,"You will receive offers and coupons");
                membershipDetails.setOfferStatus(true);
                confirmMembershipInfo(membershipDetails);
                break;
            case "NO":
                LOGGER.log(MENU_LOG,"You will not be sent offers");
                membershipDetails.setOfferStatus(false);
                confirmMembershipInfo(membershipDetails);
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch (YesOrNoException e) {
                    LOGGER.error("\nA problem occurred " + e);
                }
                setMembershipNotificationPreferences(membershipDetails);
                break;
        }
    }
    public static void confirmMembershipInfo(MembershipInformation membershipDetails){

        // Use a long for a random membership number
        long membershipNumber = setRandomNumber(100000000, 999999999);

        membershipDetails.setMembershipNumber(membershipNumber);


        // Output for email correction
        LOGGER.log(MENU_LOG,"\nYour name is: " + membershipDetails.getPerson().toString());
        LOGGER.log(MENU_LOG,"Your email is: " + membershipDetails.getPerson().getEmail());
        LOGGER.log(MENU_LOG,"Your membership status is: " + membershipDetails.getOfferStatus());
        LOGGER.log(MENU_LOG,"Your membership number is: " + membershipDetails.getMembershipNumber());
        LOGGER.log(MENU_LOG,"Your age is: " + membershipDetails.getPerson().getAge());

        // Use this for choice
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                if(membershipDetails.getPerson().getAge() <= 17) {
                    LOGGER.log(MENU_LOG,"\nI'm sorry, but you must be 18 or older to sign up");
                    LOGGER.log(MENU_LOG,"Please enter your information again");
                    enterMembershipInfo();
                } else {
                    LOGGER.log(MENU_LOG,"\nThank you for information and welcome to our membership");
                    System.exit(0);
                }
                break;
            case "NO":
                LOGGER.log(MENU_LOG,"\nPlease enter your information again");
                enterMembershipInfo();
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch (YesOrNoException e) {
                    LOGGER.error("\nA problem occurred " + e);
                }
                confirmMembershipInfo(membershipDetails);
                break;
        }

    }

    public static void submitComplaint(){
        // Use scanner for the user to input their name and type of complaint
        Scanner scanner = new Scanner(System.in);

        LOGGER.log(MENU_LOG,"\nWhat is your first name?");
        String complaintFirstName = scanner.nextLine();


        LOGGER.log(MENU_LOG,"\nWhat is your last name?");
        String complaintLastName = scanner.nextLine();

        LOGGER.log(MENU_LOG,"\nWhat type of complaint is it?");
        LOGGER.log(MENU_LOG,"1. Issue with a package");
        LOGGER.log(MENU_LOG,"2. An employee experience");
        LOGGER.log(MENU_LOG,"3. Other");
        LOGGER.log(MENU_LOG,"0. Exit");

        int complaintType = scanner.nextInt();

        Person person = new Person();

        // Use this random to set a complaint number

        long complaintNumber = setRandomNumber(1, 999999);

        // Switch to select what type of complaint someone wants
        switch (complaintType){
            case 1:
                PackageComplaint packageComplaint = new PackageComplaint();
                packageComplaint.setPerson(person);
                packageComplaint.getPerson().setFirstName(complaintFirstName);
                packageComplaint.getPerson().setLastName(complaintLastName);
                packageComplaint.setComplaintNumber(complaintNumber);
                packageComplaint.setBaseComplaintType("Package");
                complaintOfPackage(packageComplaint);
                break;
            case 2:
                EmployeeComplaint employeeComplaint = new EmployeeComplaint();
                employeeComplaint.setPerson(person);
                employeeComplaint.getPerson().setFirstName(complaintFirstName);
                employeeComplaint.getPerson().setLastName(complaintLastName);
                employeeComplaint.setComplaintNumber(complaintNumber);
                employeeComplaint.setBaseComplaintType("Employee");
                complaintOfEmployee(employeeComplaint);
                break;
            case 3:
                OtherComplaint otherComplaint = new OtherComplaint();
                otherComplaint.setPerson(person);
                otherComplaint.getPerson().setFirstName(complaintFirstName);
                otherComplaint.getPerson().setLastName(complaintLastName);
                otherComplaint.setComplaintNumber(complaintNumber);
                otherComplaint.setBaseComplaintType("Other");
                complaintOfOther(otherComplaint);
                break;
            case 0:
                LOGGER.log(MENU_LOG,"\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
        }

    }

    public static void complaintOfPackage(PackageComplaint packageComplaint) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        // Have the user set the number of the package and the complaint
        LOGGER.log(MENU_LOG,"\nWhat is the number of your package?");
        Shipment shipment = new Shipment();
        packageComplaint.setShipment(shipment);
        long numberOfPackage = scanner.nextLong();
        packageComplaint.getShipment().setPackageNumber(numberOfPackage);

        LOGGER.log(MENU_LOG,"\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        packageComplaint.setComplaint(complaint);

        LOGGER.log(MENU_LOG,"\nYour information");
        LOGGER.log(MENU_LOG,"Name: " + packageComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG,"Complaint Number: " + packageComplaint.getComplaintNumber());
        LOGGER.log(MENU_LOG,"Complaint Type: " + packageComplaint.getBaseComplaintType());
        LOGGER.log(MENU_LOG,"Number of Package: " + packageComplaint.getShipment().getPackageNumber());
        LOGGER.log(MENU_LOG,"Complaint: " + packageComplaint.getComplaint());

        finalizeComplaint();

    }

    public static void complaintOfEmployee(EmployeeComplaint employeeComplaint) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Employee employee = new Employee();

        employeeComplaint.setEmployee(employee);

        // Have the user set the name of the employee and the complaint
        LOGGER.log(MENU_LOG,"\nWhat is the first name of the employee who served you?");
        String employeeFirst = scanner.nextLine();
        employeeComplaint.getEmployee().setFirstName(employeeFirst);

        LOGGER.log(MENU_LOG,"\nWhat is the last name of the employee who served you?");
        String employeeLast = scanner.nextLine();
        employeeComplaint.getEmployee().setLastName(employeeLast);

        LOGGER.log(MENU_LOG,"\nWhat is the number of the employee? Between 10000 and 99999");
        int employeeNum = scanner.nextInt();
        employeeComplaint.getEmployee().setEmployeeNumber(employeeNum);


        LOGGER.log(MENU_LOG,"\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        employeeComplaint.setComplaint(complaint);

        LOGGER.log(MENU_LOG,"\nYour information");
        LOGGER.log(MENU_LOG,"Name: " + employeeComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG,"Complaint Number: " + employeeComplaint.getComplaintNumber());
        LOGGER.log(MENU_LOG,"Complaint Type: " + employeeComplaint.getBaseComplaintType());
        LOGGER.log(MENU_LOG,"Name of Employee: " + employeeComplaint.getEmployee().toString());
        LOGGER.log(MENU_LOG,"Complaint: " + employeeComplaint.getComplaint());

        finalizeComplaint();

    }

    public static void complaintOfOther(OtherComplaint otherComplaint) {

        Scanner scanner = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        LOGGER.log(MENU_LOG,"\nWhat is the other type of complaint you would like to make?");
        String typeOfComplaint = scanner.nextLine();
        otherComplaint.setOtherComplaintType(typeOfComplaint);
        LOGGER.log(MENU_LOG,"\nWhat is your complaint?");
        String complaint = scanner.nextLine();
        otherComplaint.setComplaint(complaint);

        LOGGER.log(MENU_LOG,"\nYour information");
        LOGGER.log(MENU_LOG,"Name: " + otherComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG,"Complaint Number: " + otherComplaint.getComplaintNumber());
        LOGGER.log(MENU_LOG,"Complaint Type: " + otherComplaint.getBaseComplaintType());
        LOGGER.log(MENU_LOG,"Type of Complaint: " + otherComplaint.getOtherComplaintType());
        LOGGER.log(MENU_LOG,"Complaint: " + otherComplaint.getComplaint());

        finalizeComplaint();


    }
    public static void finalizeComplaint() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG,"\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                LOGGER.log(MENU_LOG,"\nThank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                LOGGER.log(MENU_LOG,"\nPlease enter your information again");
                submitComplaint();
            default:
                try{
                    checkYesOrNo(choice);
                } catch (YesOrNoException e) {
                    LOGGER.error("\nA problem occurred " + e);
                }
                finalizeComplaint();
        }
    }

    public static long setRandomNumber(long low, long high) {
        Random r = new Random();
        return r.nextLong(high-low) + low;
    }

    public static void checkYesOrNo(String confirmation) throws YesOrNoException {
        if (!(confirmation.equals("YES") || confirmation.equals("NO"))) {
            throw new YesOrNoException("\nPlease choose Yes or NO");
        }
    }

    public static void checkCustomers() throws EmptyCustomerException {
        if(sender.getFirstName().equals("") || recipient.getFirstName().equals("")) {
            throw new EmptyCustomerException("\nPlease enter both a sender and a recipient\n",
                    "Empty sender or recipient");

        } else {
            insuranceTotal();
        }
    }

    public static void tooManyOrFewerStamps(int numberOfStamps) throws TooManyStampsException {
        if(numberOfStamps > 100) {
            throw new TooManyStampsException("\nToo many stamps");
        } else if (numberOfStamps < 1) {
            throw new TooManyStampsException("\nToo few stamps");
        }


    }

    public static void invalidOption(int selection) throws InvalidDeliveryPlanException {
        if(selection < 0 || selection > 6) {
            throw new InvalidDeliveryPlanException("\nPlease select a number from the choices given");
        }
    }

    public static void incorrectSurveyOption() throws InvalidSurveyAnswerException {
        throw new InvalidSurveyAnswerException("\nPlease enter a number from 1 to 10");
    }

}