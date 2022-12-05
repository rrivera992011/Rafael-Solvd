import complaint.*;
import exceptions.EmptyCustomerException;
import exceptions.YesOrNoException;
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

    static Logger logger = LogManager.getLogger(Main.class);




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Welcome to the delivery system. ");
        logger.info( "Please choose from one of the following options: ");
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
            logger.info( "\nName of sender: " + sender.toString());
            logger.info( "Address of sender: " + sender.getAddress());
            logger.info( "Phone number: " + sender.getPhoneNumber() + "\n");
        }

        if(!recipient.getFirstName().equals("")) {
            logger.info( "\nName of recipient: " + recipient.toString());
            logger.info( "Address of recipient: " + recipient.getAddress());
            logger.info( "Phone number: " + recipient.getPhoneNumber() + "\n");
        }

        logger.info("1. Enter the sender");
        logger.info("2. Enter the recipient");
        logger.info("3. Send a package");
        logger.info("4. Only buy stamps");
        logger.info("5. File a complaint");
        logger.info("6. Sign up for our membership");
        logger.info("0. Exit the program");

    }

    public static void menuSelection(int selection) {

        switch (selection) {
            case 0:
                logger.info("Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                createASender();
                contDelivery();
                break;
            case 2:
                createARecipient();
                contDelivery();
                break;
            case 3:
                    try {
                        checkCustomers();
                    } catch (Exception e) {
                        logger.error("\nA problem occurred " + e);
                    }

                    menuOptions();
                break;
            case 4:
                buyStamps();
                break;
            case 5:
                submitComplaint();
                break;
            case 6:
                membership();
                break;
            default:
                // Add exception here
                logger.error("Please choose one of these options\n");
                menuOptions();
                break;
        }
    }

    public static void createASender() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nEnter your first name");
        String senderFirstName = scanner.nextLine();
        sender.setFirstName(senderFirstName);

        logger.info("Enter your last name");
        String senderLastName = scanner.nextLine();
        sender.setLastName(senderLastName);

        logger.info("Enter your address");
        String senderAddress = scanner.nextLine();
        sender.setAddress(senderAddress);

        logger.info("Enter your phone number");
        String phoneNumber = scanner.nextLine();
        sender.setPhoneNumber(phoneNumber);

    }

    public static void createARecipient() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nEnter the recipient's first name");
        String recipientFirstName = scanner.nextLine();
        recipient.setFirstName(recipientFirstName);

        logger.info("Enter the recipient's last name");
        String recipientLastName = scanner.nextLine();
        recipient.setLastName(recipientLastName);

        logger.info("Enter the recipient's address");
        String recipientAddress = scanner.nextLine();
        recipient.setAddress(recipientAddress);

        logger.info("Enter the recipient's phone number");
        String phoneNumber = scanner.nextLine();
        recipient.setPhoneNumber(phoneNumber);



    }

    public static void contDelivery() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nTo return to operation, press 1");
        logger.info("To exit the operation, press 0\n");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                logger.info("Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                menuOptions();
                break;
            default:
                logger.error("Please choose one of these options\n");
                contDelivery();
                break;
        }

    }

    public static void insuranceTotal() {
        Scanner scanner = new Scanner(System.in);

        // Insurance range
        logger.info("\nDo you want insurance? Select from our plans");
        logger.info("1. $10 coverage");
        logger.info("2. $30 coverage");
        logger.info("3. $50 coverage");
        logger.info("0. No insurance");
        int insuranceSelection = scanner.nextInt();

        Insurance insuranceInfo = new Insurance();

        double priceOfInsurance;

        // Random number generating bar code
        long insuranceNumber = setRandomNumber(1000000,9999999 );
        insuranceInfo.setInsuranceNumber(insuranceNumber);

        // Switch statement used for insurance prices using TN state tax
        switch (insuranceSelection) {
            case 1:
                    priceOfInsurance = 10 + (10 * 0.07);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 2:
                    priceOfInsurance = 30 + (30 * 0.07);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 3:
                    priceOfInsurance = 50 + (50 * 0.07);
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            case 0:
                    priceOfInsurance = 0;
                    insuranceInfo.setInsurancePrice(priceOfInsurance);
                    break;
            default:
                    logger.error("Please select a number from the choices given\n");
                    insuranceTotal();
                    break;
        }

        setUpTotal(insuranceInfo);


    }

    public static void setUpTotal(Insurance insuranceInfo) {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nWhich delivery plan do you want? 5 days for $3, 3 days for $6, or 1 day for $9?");
        logger.info("Select based on the number of days that you want");
        int numOfDays = scanner.nextInt();
        Shipment shipment = new Shipment();
        shipment.setDays(numOfDays);


        // Double variable for the price
        double priceOfPackage;

        // Switch statement used to calculate total using TN state tax
        switch(numOfDays) {
            case 1:
                priceOfPackage = 9 + (9 * 0.07) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            case 3:
                priceOfPackage = 6 + (6 * 0.07) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            case 5:
                priceOfPackage = 3 + (3 * 0.07) + insuranceInfo.getInsurancePrice();
                shipment.setPrice(priceOfPackage);
                break;
            default:
                logger.info("Please select a number from the choices given\n");
                setUpTotal(insuranceInfo);
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

        logger.info("\nName of sender: " + sender.toString());
        logger.info("Address of sender: " + sender.getAddress());
        logger.info("Phone number: " + sender.getPhoneNumber() + "\n");

        logger.info("\nName of recipient: " + recipient.toString());
        logger.info("Address of sender: " + recipient.getAddress());
        logger.info("Phone number: " + recipient.getPhoneNumber() + "\n");

        logger.info("\nPackage number: " + shipment.getPackageNumber());
        logger.info("Insurance number: " + insuranceInfo.getInsuranceNumber());
        logger.info("ETA: " + shipment.getDays() + " Day(s)");

        df.setRoundingMode(RoundingMode.UP);
        logger.info("Complete total: " + df.format(shipment.getPrice()));

        confirmShipping(insuranceInfo, shipment);


    }

    public static void confirmShipping(Insurance insuranceInfo, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nIs this okay? Yes/No? (Not case sensitive)");
        String confirmation = scanner.nextLine().toUpperCase();

        switch(confirmation){
            case "YES":
                        logger.info("\nSending package now!");
                        logger.info("Thank you for your business");
                        company(insuranceInfo, shipment);

                        break;
            case "NO":
                        logger.info("\nPlease try again then");
                        insuranceTotal();
                        break;
            default:
                        try{
                            checkYesOrNo(confirmation);
                        } catch (Exception e) {
                            logger.error("\nA problem occurred " + e);
                        }

                        // logger.info("\nPlease try something other than Yes or No");
                        confirmShipping(insuranceInfo, shipment);

        }
    }

    public static void company(Insurance insuranceInfo, Shipment shipment) {
        // Output for the company and placing everything in one object
        logger.info("\nOrder obtained");

        shipment.setSender(sender);
        shipment.setRecipient(recipient);
        shipment.setInsurance(insuranceInfo);


        String outputTest = shipment.toString();

        logger.info(outputTest + "\n");

        // Create a driver using the enterDriver function and send it to the confirmation
        Driver driver = enterDriver();
        driverConfirm(driver, shipment);


    }

    public static Driver enterDriver() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        logger.info("\nEnter your driver's first name");
        String driverAFirst = scanner.nextLine();
        driver.setFirstName(driverAFirst);

        // Enter the driver's last name
        logger.info("Enter your driver's last name");
        String driverALast = scanner.nextLine();
        driver.setLastName(driverALast);

        long driverNumber = setRandomNumber(10000, 99999);

        driver.setEmployeeNumber(driverNumber);

        // Enter the car's status
        logger.info("How is the car doing?");
        String carStatus = scanner.nextLine();
        driver.setStatus(carStatus);

        logger.info("\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        logger.info("Name: " + fullName);
        logger.info("Number: " + driver.getEmployeeNumber());
        logger.info("Status: " + driver.getStatus());

        return driver;
    }

    public static void driverConfirm(Driver driver, Shipment shipment){
        Scanner scanner = new Scanner(System.in);

        //Driver confirmation output
        logger.info("\nCan you confirm that " + "driver " + driver.getFirstName() + " " + driver.getLastName());
        logger.info(" will take this delivery? Yes or No? (Not case sensitive)");
        String confirmDrive = scanner.nextLine().toUpperCase();

        // Use a switch statement for confirmation
        switch(confirmDrive){
            case "YES":
                logger.info("\nPreparing package drop off now!");
                determinePackageValues(driver, shipment);
                break;
            case "NO":
                logger.info("\nPlease go back to the other menu and enter a different driver");
                company(shipment.getInsurance(), shipment);
                break;
            default:
                try{
                    checkYesOrNo(confirmDrive);
                } catch (Exception e) {
                    logger.error("\nA problem occurred " + e);
                }
                driverConfirm(driver, shipment);
                break;

        }


    }

    public static void determinePackageValues(Driver driver, Shipment shipment){

        // Allow the facility worker to enter the values they need for the package
        Scanner scanner = new Scanner(System.in);
        logger.info("\nEnter the weight of the package in pounds");
        double packageWeight = scanner.nextDouble();
        shipment.setWeight(packageWeight);
        logger.info("Enter the width of the package in inches");
        double packageWidth = scanner.nextDouble();
        logger.info("Enter the height of the package in inches");
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

        logger.info("\nHow many stamps do you have on the envelope?");
        int stampNum = scanner.nextInt();
        envelope.setNumberOfStamps(stampNum);

        // Use an arraylist to set the stamps on an envelope
        ArrayList <Stamp> stampArray = new ArrayList<>();

        for(int i = 0; i < stampNum; i++) {
            Stamp stamp = new Stamp();
            int stampNameInt = i+1;
            stamp.setName("Stamp " + stampNameInt);
            stamp.setPrice(0.75);
            stampArray.add(stamp);

        }

        // Set the array in the envelope
        envelope.setStampArrayList(stampArray);

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
        logger.info("\nIs the package fragile? Type true or false");
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

        logger.info("\nThe weight of the object is " + shipment.getMailing().getWeight());
        logger.info("This is a(n) " + shipment.getMailing().getPackageType());

        // Switch statement to output based on the package type
        switch(shipment.getMailing().getPackageType()){
            case "Box":
                Parcel parcel = (Parcel) shipment.getMailing();
                if (!parcel.getFragility()) {
                    logger.info("It is not fragile");
                } else {
                    logger.info("It is fragile");
                }
                break;
            case "Envelope":
                Envelope envelope = (Envelope) shipment.getMailing();
                logger.info("It needs " + envelope.getNumberOfStamps() + " stamp(s)\n");
                ArrayList <Stamp> stampArray = envelope.getStampArrayList();
                for(int i = 0; i < envelope.getNumberOfStamps(); i++) {
                    logger.info(stampArray.get(i).getName());
                    logger.info(stampArray.get(i).getPrice());
                }
                break;
            default:
                logger.error("This is nothing");
                break;
        }

        logger.info("\nEnter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = scanner.nextDouble();

        logger.info("The weight of the object in the facility is: " + weightAtFacility);

        // Create a hash map for the weight set to check for equals
        Map<String, Double> weightSet = new HashMap<>();
        weightSet.put(senderFullName, shipment.getWeight());
        weightSet.put(driverFullName, weightAtFacility);

        // If the weight isn't the same as the package weight, return to the function
        if (!weightSet.get(senderFullName).equals(weightSet.get(driverFullName))) {

            logger.info("\nThe package is not there. Find the correct package");
            weighForFacility(driver, shipment);

        } else {
            logger.info("\nThe correct package is found.");
            logger.info("ETA is " + shipment.getDays() + " day(s) until delivery");
            logger.info("Entering in vehicle now");
            vehicleChoice(shipment);
        }

    }

    public static void vehicleChoice(Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nWhat vehicle do you want to use? A car or an plane?");
        String choice = scanner.nextLine().toUpperCase();

        // Random element for car/plane number

        long carOrPlaneNum;

        // Use a switch statement to output the correct element
        switch(choice) {
            case "CAR":
                logger.info("\nYou have chosen a car");
                carOrPlaneNum = setRandomNumber(100000, 999999);
                Car car = new Car();
                car.setVehicleName("Car");
                car.setTruckNumber(carOrPlaneNum);
                vehicleOutput(shipment, car);
                break;
            case "PLANE":
                logger.info("\nYou have chosen an airplane");
                carOrPlaneNum = setRandomNumber(1, 1000);
                Plane plane = new Plane();
                plane.setVehicleName("Plane");
                plane.setPlaneNumber(carOrPlaneNum);
                vehicleOutput(shipment, plane);
                break;
            default:
                logger.error("\nPlease choose something else");
                vehicleChoice(shipment);
                break;
        }
    }

    public static void vehicleOutput(Shipment shipment, IVehicle carOrPlane) {

        // Equalize the plane or car object for correct output
        if(carOrPlane.getVehicleName().equals("Car")) {
            Car car = ((Car) carOrPlane);
            logger.info("\nVehicle choice: " + car.getVehicleName());
            logger.info("Number: " + car.getCarNumber());
            logger.info("\nSending package now");
            orderFinished(shipment);

        } else if (carOrPlane.getVehicleName().equals("Plane")) {
            Plane plane = ((Plane) carOrPlane);
            logger.info("\nVehicle choice: " + plane.getVehicleName());
            logger.info("Number: " + plane.getPlaneNumber());
            logger.info("\nSending package now");
            orderFinished(shipment);
        }

    }

    public static void orderFinished(Shipment shipment) {

        // Output everything
        String order;
        logger.info("\nOrder delivered");
        if (shipment.getMailing().getPackageType().equals("Box")) {
            Parcel parcel = (Parcel) shipment.getMailing();
            logger.info("\n" + parcel.getPackageType() + " received");
            order = shipment.toString();
            logger.info(order);
            moreOptions();

        } else if (shipment.getMailing().getPackageType().equals("Envelope")) {
            Envelope envelope = (Envelope) shipment.getMailing();
            logger.info("\n" + envelope.getPackageType() + " received");
            order = shipment.toString();
            logger.info(order);
            moreOptions();
        }
    }

    public static void moreOptions() {
        // More options

        Scanner scanner = new Scanner(System.in);
        logger.info("\nMore options");
        logger.info("1. Take our 3 question survey");
        logger.info("2. Get a small factoid of the mail while leaving");
        logger.info("3. Buy stamps. 0.75 per stamp");
        logger.info("4. Sign up for our membership");
        logger.info("0. End");

        // Use integer for output
        int optionNum = scanner.nextInt();

        // Switch for more options
        switch (optionNum) {
            case 0:
                    logger.info("Thank you for shopping here");
                    System.exit(0);
                    break;
            case 1:
                    survey();
                    break;
            case 2:
                    factoid();
                    break;
            case 3:
                    buyStamps();
                    break;
            case 4:
                    membership();
                    break;
            default:
                    logger.error("You did not enter a choice given. Try again");
                    moreOptions();
                    break;
        }

    }

    public static void survey() {
        Scanner scanner = new Scanner(System.in);

        // Use the surveyor variable to grab the answers
        Survey surveyor = new Survey();
        logger.info("\nRate from 1-10. How did you like our service?");
        int choiceNum = scanner.nextInt();
        surveyor.setServiceNum(choiceNum);
        logger.info("Rate from 1-10. How efficient was our service?");
        choiceNum = scanner.nextInt();
        surveyor.setEfficiencyNum(choiceNum);
        logger.info("Rate from 1-10. How friendly was our staff?");
        choiceNum = scanner.nextInt();
        surveyor.setFriendlinessNum(choiceNum);
        logger.info("\nYou answers were: " +
                surveyor.getServiceNum() + ", " + surveyor.getEfficiencyNum() +
                ", and " + surveyor.getFriendlinessNum());

        survey2();
    }

    public static void survey2() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                logger.info("\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
            case "NO":
                logger.info("Please select your choices again");
                survey();
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch (Exception e) {
                    logger.error("\nA problem occurred " + e);
                }
                survey2();
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
        final DecimalFormat df = new DecimalFormat("0.00");
        Stamp stamp = new Stamp();
        df.setRoundingMode(RoundingMode.UP);
        Scanner scanner = new Scanner(System.in);
        logger.info("\nHow many stamps would you like to buy? 0.75 per stamp");
        int numOfStamps = scanner.nextInt();

        // Calculate the number of stamps
        stamp.setPrice(0.75);
        double completeTotal = stamp.getPrice() * numOfStamps;


        logger.info("\nYou bought " + numOfStamps +
                " stamps for $" + df.format(completeTotal));
        logger.info("Thank you!");

        System.exit(0);

    }

    public static void membership() {
        Scanner scanner = new Scanner(System.in);
        MembershipInformation membershipDetails = new MembershipInformation();

        Person person = new Person();
        membershipDetails.setPerson(person);

        logger.info("\nEnter your first name");
        String memberFirstName = scanner.nextLine();
        membershipDetails.getPerson().setFirstName(memberFirstName);

        logger.info("Enter your last name");
        String memberLastName = scanner.nextLine();
        membershipDetails.getPerson().setLastName(memberLastName);

        // Get the email for the membership
        logger.info("What is your email?");
        String email = scanner.nextLine();
        membershipDetails.getPerson().setEmail(email);

        logger.info("What is your age?");
        int age = scanner.nextInt();
        membershipDetails.getPerson().setAge(age);

        membership2(membershipDetails);

    }

    public static void membership2(MembershipInformation membershipDetails){
        Scanner scanner = new Scanner(System.in);
        // If they want special offers, have them choose
        logger.info("\nWould you like information on our special offers and coupons? Yes/No?");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                logger.info("You will receive offers and coupons");
                membershipDetails.setOfferStatus(true);
                membership3(membershipDetails);
                break;
            case "NO":
                logger.info("You will not be sent offers");
                membershipDetails.setOfferStatus(false);
                membership3(membershipDetails);
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch (Exception e) {
                    logger.error("\nA problem occurred " + e);
                }
                membership2(membershipDetails);
                break;
        }
    }
    public static void membership3(MembershipInformation membershipDetails){

        // Use a long for a random membership number
        long membershipNumber = setRandomNumber(999999999, 100000000);

        membershipDetails.setMembershipNumber(membershipNumber);


        // Output for email correction
        logger.info("\nYour name is: " + membershipDetails.getPerson().toString());
        logger.info("Your email is: " + membershipDetails.getPerson().getEmail());
        logger.info("Your membership status is: " + membershipDetails.getOfferStatus());
        logger.info("Your membership number is: " + membershipDetails.getMembershipNumber());
        logger.info("Your age is: " + membershipDetails.getPerson().getAge());

        // Use this for choice
        Scanner scanner = new Scanner(System.in);
        logger.info("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                if(membershipDetails.getPerson().getAge() <= 17) {
                    logger.info("\nI'm sorry, but you must be 18 or older to sign up");
                    logger.info("Please enter your information again");
                    membership();
                } else {
                    logger.info("\nThank you for information and welcome to our membership");
                    System.exit(0);
                }
                break;
            case "NO":
                logger.info("\nPlease enter your information again");
                membership();
                break;
            default:
                try{
                    checkYesOrNo(choice);
                } catch (Exception e) {
                    logger.error("\nA problem occurred " + e);
                }
                membership3(membershipDetails);
                break;
        }

    }

    public static void submitComplaint(){
        // Use scanner for the user to input their name and type of complaint
        Scanner scanner = new Scanner(System.in);

        logger.info("\nWhat is your first name?");
        String complaintFirstName = scanner.nextLine();


        logger.info("\nWhat is your last name?");
        String complaintLastName = scanner.nextLine();

        logger.info("\nWhat type of complaint is it?");
        logger.info("1. Issue with a package");
        logger.info("2. An employee experience");
        logger.info("3. Other");
        logger.info("0. Exit");

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
                logger.info("\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
        }

    }

    public static void complaintOfPackage(PackageComplaint packageComplaint) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        // Have the user set the number of the package and the complaint
        logger.info("\nWhat is the number of your package?");
        Shipment shipment = new Shipment();
        packageComplaint.setShipment(shipment);
        long numberOfPackage = scanner.nextLong();
        // packageComplaint.setPackageNumber(numberOfPackage);
        packageComplaint.getShipment().setPackageNumber(numberOfPackage);

        logger.info("\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        packageComplaint.setComplaint(complaint);

        logger.info("\nYour information");
        logger.info("Name: " + packageComplaint.getPerson().toString());
        logger.info("Complaint Number: " + packageComplaint.getComplaintNumber());
        logger.info("Complaint Type: " + packageComplaint.getBaseComplaintType());
        logger.info("Number of Package: " + packageComplaint.getShipment().getPackageNumber());
        logger.info("Complaint: " + packageComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfEmployee(EmployeeComplaint employeeComplaint) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Employee employee = new Employee();

        employeeComplaint.setEmployee(employee);

        // Have the user set the name of the employee and the complaint
        logger.info("\nWhat is the first name of the employee who served you?");
        String employeeFirst = scanner.nextLine();
        employeeComplaint.getEmployee().setFirstName(employeeFirst);

        logger.info("\nWhat is the last name of the employee who served you?");
        String employeeLast = scanner.nextLine();
        employeeComplaint.getEmployee().setLastName(employeeLast);

        logger.info("\nWhat is the number of the employee? Between 10000 and 99999");
        int employeeNum = scanner.nextInt();
        employeeComplaint.getEmployee().setEmployeeNumber(employeeNum);


        logger.info("\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        employeeComplaint.setComplaint(complaint);

        logger.info("\nYour information");
        logger.info("Name: " + employeeComplaint.getPerson().toString());
        logger.info("Complaint Number: " + employeeComplaint.getComplaintNumber());
        logger.info("Complaint Type: " + employeeComplaint.getBaseComplaintType());
        logger.info("Name of Employee: " + employeeComplaint.getEmployee().toString());
        logger.info("Complaint: " + employeeComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfOther(OtherComplaint otherComplaint) {

        Scanner scanner = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        logger.info("\nWhat is the other type of complaint you would like to make?");
        String typeOfComplaint = scanner.nextLine();
        otherComplaint.setOtherComplaintType(typeOfComplaint);
        logger.info("\nWhat is your complaint?");
        String complaint = scanner.nextLine();
        otherComplaint.setComplaint(complaint);

        logger.info("\nYour information");
        logger.info("Name: " + otherComplaint.getPerson().toString());
        logger.info("Complaint Number: " + otherComplaint.getComplaintNumber());
        logger.info("Complaint Type: " + otherComplaint.getBaseComplaintType());
        logger.info("Type of Complaint: " + otherComplaint.getOtherComplaintType());
        logger.info("Complaint: " + otherComplaint.getComplaint());

        complaintCheck();


    }
    public static void complaintCheck() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                logger.info("\nThank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                logger.info("\nPlease enter your information again");
                submitComplaint();
            default:
                try{
                    checkYesOrNo(choice);
                } catch (Exception e) {
                    logger.error("\nA problem occurred " + e);
                }
                complaintCheck();
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

}