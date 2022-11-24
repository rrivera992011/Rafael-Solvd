import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main {

    static People sender = new People();
    static People recipient = new People();

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to the delivery system. ");
        System.out.println("Please choose from one of the following options: ");
        menuOptions();

        // Loop for menu
        // Do the selection while selection is not 0
        int selection;
        do {
            selection = myObj.nextInt();
            menuSelection(selection);
        } while (selection != 0);
    }

    public static void menuOptions() {

        // Print out the sender and the recipient while it's not empty
        if(!sender.getName().equals("")) {
            System.out.println("\nName of sender: " + sender.getName());
            System.out.println("Address of sender: " + sender.getAddress());
            System.out.println("Phone number: " + sender.getPhoneNumber() + "\n");
        }

        if(!recipient.getName().equals("")) {
            System.out.println("Name of recipient: " + recipient.getName());
            System.out.println("Address of recipient: " + recipient.getAddress());
            System.out.println("Phone number: " + recipient.getPhoneNumber() + "\n");
        }

        System.out.println("1. Enter the sender");
        System.out.println("2. Enter the recipient");
        System.out.println("3. Send a package");
        System.out.println("0. Exit the program");

    }

    public static void menuSelection(int selection) {

        switch (selection) {
            case 0:
                System.out.println("Thank you for your service! Have a great day!");
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
                if(sender.getName().equals("") || recipient.getName().equals("")) {
                    System.out.println("Please enter both a sender and a recipient\n");
                    menuOptions();
                }
                insuranceTotal();
                break;
            default:
                System.out.println("Please choose one of these options\n");
                menuOptions();
                break;
        }
    }

    public static void createASender() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter your name");
        String senderName = myObj.nextLine();
        sender.setName(senderName);

        System.out.println("Enter your address");
        String senderAddress = myObj.nextLine();
        sender.setAddress(senderAddress);

        System.out.println("Enter your phone number");
        int phoneNumber = myObj.nextInt();
        sender.setPhoneNumber(phoneNumber);


    }

    public static void createARecipient() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter the recipient's name");
        String recipientName = myObj.nextLine();
        recipient.setName(recipientName);

        System.out.println("Enter the recipient's address");
        String recipientAddress = myObj.nextLine();
        recipient.setAddress(recipientAddress);

        System.out.println("Enter the recipient's phone number");
        int phoneNumber = myObj.nextInt();
        recipient.setPhoneNumber(phoneNumber);



    }

    public static void contDelivery() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nTo return to operation, press 1");
        System.out.println("To exit the operation, press 0\n");
        int option = myObj.nextInt();
        switch (option) {
            case 0:
                System.out.println("Thank you for your service! Have a great day!");
                System.exit(0);
                break;
            case 1:
                menuOptions();
                break;
            default:
                System.out.println("Please choose one of these options\n");
                contDelivery();
                break;
        }

    }

    public static void insuranceTotal() {
        Scanner myObj = new Scanner(System.in);

        // Insurance range
        System.out.println("\nDo you want insurance? Select from our plans");
        System.out.println("1. $10 coverage");
        System.out.println("2. $30 coverage");
        System.out.println("3. $50 coverage");
        System.out.println("0. No insurance");
        int insuranceSelection = myObj.nextInt();

        Insurance insuranceInfo = new Insurance();

        double priceOfInsurance;

        // Random number generating bar code
        Random r = new Random();
        int low = 1000000;
        int high = 9999999;
        int insuranceNumber = r.nextInt(high-low) + low;
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
                    System.out.println("Please select a number from the choices given\n");
                    insuranceTotal();
                    break;
        }

        totalFunction(insuranceInfo);


    }

    public static void totalFunction(Insurance insuranceInfo) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nWhich delivery plan do you want? 5 days for $3, 3 days for $6, or 1 day for $9?");
        System.out.println("Select based on the number of days that you want");
        int numOfDays = myObj.nextInt();
        TotalPrice priceInfo = new TotalPrice();
        priceInfo.setDays(numOfDays);


        // Double variable for the price
        double priceOfPackage;

        // Switch statement used to calculate total using TN state tax
        switch(numOfDays) {
            case 1:
                priceOfPackage = 9 + (9 * 0.07) + insuranceInfo.getInsurancePrice();
                priceInfo.setPrice(priceOfPackage);
                break;
            case 3:
                priceOfPackage = 6 + (6 * 0.07) + insuranceInfo.getInsurancePrice();
                priceInfo.setPrice(priceOfPackage);
                break;
            case 5:
                priceOfPackage = 3 + (3 * 0.07) + insuranceInfo.getInsurancePrice();
                priceInfo.setPrice(priceOfPackage);
                break;
            default:
                System.out.println("Please select a number from the choices given\n");
                totalFunction(insuranceInfo);
                break;
        }



        totalOutput(insuranceInfo, priceInfo);

    }
    public static void totalOutput(Insurance insuranceInfo, TotalPrice priceInfo) {
        // Output for ending
        final DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("\nName of sender: " + sender.getName());
        System.out.println("Address of sender: " + sender.getAddress());
        System.out.println("Phone number: " + sender.getPhoneNumber() + "\n");

        System.out.println("\nName of recipient: " + recipient.getName());
        System.out.println("Address of sender: " + recipient.getAddress());
        System.out.println("Phone number: " + recipient.getPhoneNumber() + "\n");

        System.out.println("\nInsurance number: " + insuranceInfo.getInsuranceNumber());
        System.out.println("ETA: " + priceInfo.getDays() + " Day(s)");

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("Complete total: " + df.format(priceInfo.getPrice()));

        confirmationFunc(insuranceInfo, priceInfo);


    }

    public static void confirmationFunc(Insurance insuranceInfo, TotalPrice priceInfo) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nIs this okay? Yes/No? (Not case sensitive)");
        String confirmation = myObj.nextLine().toUpperCase();

        switch(confirmation){
            case "YES":
                        System.out.println("\nSending package now!");
                        System.out.println("Thank you for your business");
                        company(insuranceInfo, priceInfo);

                        break;
            case "NO":
                        System.out.println("\nPlease try again then");
                        insuranceTotal();
                        break;
            default:
                        System.out.println("\nPlease try something other than Yes or No");
                        confirmationFunc(insuranceInfo, priceInfo);

        }
    }

    public static void company(Insurance insuranceInfo, TotalPrice priceInfo) {
        // Object used to place everything neatly
        Shipment completeShipment = new Shipment();

        // Output for the company and placing everything in one object
        System.out.println("\nOrder obtained");

        completeShipment.setSender(sender);
        completeShipment.setRecipient(recipient);
        completeShipment.setInsurance(insuranceInfo);
        completeShipment.setPrice(priceInfo);

        String outputTest = completeShipment.toString();

        System.out.print(outputTest + "\n");

        // Create a driver using the enterDriver function and send it to the confirmation
        Driver driver = enterDriver();
        driverConfirm(driver, completeShipment);


        // System.out.println(completeShipment.getSender().getName());


    }

    public static Driver enterDriver() {
        Driver driver = new Driver();
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter your driver's first name");
        String driverAFirst = myObj.nextLine();
        driver.setFirstName(driverAFirst);

        // Enter the driver's last name
        System.out.println("Enter your driver's last name");
        String driverALast = myObj.nextLine();
        driver.setLastName(driverALast);

        // Enter the car's status
        System.out.println("How is the car doing?");
        String carStatus = myObj.nextLine();
        driver.setStatus(carStatus);

        System.out.println("\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        System.out.println("Name: " + fullName);

        System.out.println("Status: " + driver.getStatus());

        return driver;
    }

    public static void driverConfirm(Driver driver, Shipment shipment){
        Scanner myObj = new Scanner(System.in);

        //Driver confirmation output
        System.out.print("\nCan you confirm that " + "driver " + driver.getFirstName() + " " + driver.getLastName());
        System.out.println(" will take this delivery? (Not case sensitive)");
        String confirmDrive = myObj.nextLine().toUpperCase();

        // Use a switch statement
        switch(confirmDrive){
            case "YES":
                System.out.println("\nPreparing package drop off now!");
                determinePackageValues(driver, shipment);
                break;
            case "NO":
                System.out.println("\nPlease go back to the other menu and enter a different driver");
                company(shipment.getInsurance(), shipment.getPrice());
                break;
            default:
                System.out.println("\nEntered something other than Yes or No. Please try again");
                driverConfirm(driver, shipment);

        }


    }

    public static void determinePackageValues(Driver driver, Shipment shipment){

        // Allow the user to enter the values they need for the package
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the weight of the package in pounds");
        double packageWeight = myObj.nextDouble();
        System.out.println("Enter the width of the package");
        double packageWidth = myObj.nextDouble();
        System.out.println("Enter the height of the package");
        double packageHeight = myObj.nextDouble();

        setupForDelivery(packageWeight, packageWidth, packageHeight, driver, shipment);




    }

    public static Envelope envelopeFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner myObj = new Scanner(System.in);
        Envelope envelope = new Envelope();
        envelope.setWeight(packageWeight);
        envelope.setHeight(packageHeight);
        envelope.setWidth(packageWidth);
        envelope.setPackageType("Envelope");

        System.out.println("\nHow many stamps do you want on the envelope?");
        int stampNum = myObj.nextInt();
        envelope.setNumOfStamps(stampNum);

        return envelope;

    }

    public static Box boxFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner myObj = new Scanner(System.in);
        Box box = new Box();
        box.setWeight(packageWeight);
        box.setHeight(packageHeight);
        box.setWidth(packageWidth);
        box.setPackageType("Box");

        System.out.println("\nIs the package fragile? Type true or false");
        boolean confirmDrive = myObj.nextBoolean();

        box.setFragility(confirmDrive);

        return box;

    }

    public static void setupForDelivery(double packageWeight, double packageWidth, double packageHeight,
                                        Driver driver, Shipment shipment) {
        if (packageWeight < 10)
        {
            Envelope envelope = envelopeFunction(packageWeight,packageWidth, packageHeight);
            weighForFacility(envelope, driver, shipment,packageWeight);

        } else {
            Box box = boxFunction(packageWeight, packageWidth, packageHeight);
            weighForFacility(box, driver, shipment, packageWeight);
        }


    }

    public static void weighForFacility(PackageType boxOrLetter, Driver driver, Shipment shipment, double packageWeight) {
        Scanner myObj = new Scanner(System.in);
        String driverFullName = driver.getFirstName() + " " + driver.getLastName();

        // Envelope envelope = (Envelope) boxOrLetter;

        System.out.println("\nThe weight of the object is " + boxOrLetter.getWeight());
        System.out.println("This is a(n) " + boxOrLetter.getPackageType());

        switch(boxOrLetter.getPackageType()){
            case "Box":
                Box box = (Box) boxOrLetter;
                if (!box.getFragility()) {
                    System.out.println("It is not fragile");
                } else {
                    System.out.println("It is fragile");
                }
                break;
            case "Envelope":
                Envelope envelope = (Envelope) boxOrLetter;
                System.out.println("It needs " + envelope.getNumOfStamps() + " stamps");
                break;
            default:
                System.out.println("This is nothing");
                break;
        }

        System.out.println("Enter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = myObj.nextDouble();

        System.out.println("The weight of the object in the facility is: " + weightAtFacility);

        Map<String, Double> weightSet = new HashMap<>();
        PressureWeight fromLocation = new PressureWeight(shipment.getSender().getName(), packageWeight);
        PressureWeight fromFacility = new PressureWeight(driverFullName, weightAtFacility);
        weightSet.put(fromLocation.getCheckingName(), fromLocation.getWeight());
        weightSet.put(fromFacility.getCheckingName(), fromFacility.getWeight());

        // If the weight isn't the same as the package weight, return to
        if (!weightSet.get(fromLocation.getCheckingName()).equals(weightSet.get(fromFacility.getCheckingName()))) {

            System.out.println("The package is not there. Find the correct package");
            weighForFacility(boxOrLetter, driver, shipment, packageWeight);

        } else {
            System.out.println("\nThe correct package is found.");
            System.out.println("ETA is " + shipment.getPrice().getDays() + " day(s) until delivery");
        }



    }




}