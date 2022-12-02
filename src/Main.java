
import complaint.*;
import factoid.FactoidOutput;
import insurance.*;
import membership.MembershipInformation;
import packageType.*;
import person.Customer;
import person.Driver;
import person.Employee;
import person.Person;
import shipment.*;
import stamp.Stamp;
import survey.Survey;
import vehicle.*;


import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main {

    static Customer sender = new Customer();
    static Customer recipient = new Customer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the delivery system. ");
        System.out.println("Please choose from one of the following options: ");
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
            System.out.println("\nName of sender: " + sender.toString());
            System.out.println("Address of sender: " + sender.getAddress());
            System.out.println("Phone number: " + sender.getPhoneNumber() + "\n");
        }

        if(!recipient.getFirstName().equals("")) {
            System.out.println("\nName of recipient: " + recipient.toString());
            System.out.println("Address of recipient: " + recipient.getAddress());
            System.out.println("Phone number: " + recipient.getPhoneNumber() + "\n");
        }

        System.out.println("1. Enter the sender");
        System.out.println("2. Enter the recipient");
        System.out.println("3. Send a package");
        System.out.println("4. Only buy stamps");
        System.out.println("5. File a complaint");
        System.out.println("6. Sign up for our membership");
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
                if(sender.getFirstName().equals("") || recipient.getFirstName().equals("")) {
                    System.out.println("\nPlease enter both a sender and a recipient");
                    menuOptions();
                } else {
                    insuranceTotal();
                }
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
                System.out.println("Please choose one of these options\n");
                menuOptions();
                break;
        }
    }

    public static void createASender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your first name");
        String senderFirstName = scanner.nextLine();
        sender.setFirstName(senderFirstName);

        System.out.println("Enter your last name");
        String senderLastName = scanner.nextLine();
        sender.setLastName(senderLastName);

        System.out.println("Enter your address");
        String senderAddress = scanner.nextLine();
        sender.setAddress(senderAddress);

        System.out.println("Enter your phone number");
        String phoneNumber = scanner.nextLine();
        sender.setPhoneNumber(phoneNumber);


    }

    public static void createARecipient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the recipient's first name");
        String recipientFirstName = scanner.nextLine();
        recipient.setFirstName(recipientFirstName);

        System.out.println("Enter the recipient's last name");
        String recipientLastName = scanner.nextLine();
        recipient.setLastName(recipientLastName);

        System.out.println("Enter the recipient's address");
        String recipientAddress = scanner.nextLine();
        recipient.setAddress(recipientAddress);

        System.out.println("Enter the recipient's phone number");
        String phoneNumber = scanner.nextLine();
        recipient.setPhoneNumber(phoneNumber);



    }

    public static void contDelivery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTo return to operation, press 1");
        System.out.println("To exit the operation, press 0\n");
        int option = scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);

        // Insurance range
        System.out.println("\nDo you want insurance? Select from our plans");
        System.out.println("1. $10 coverage");
        System.out.println("2. $30 coverage");
        System.out.println("3. $50 coverage");
        System.out.println("0. No insurance");
        int insuranceSelection = scanner.nextInt();

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich delivery plan do you want? 5 days for $3, 3 days for $6, or 1 day for $9?");
        System.out.println("Select based on the number of days that you want");
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
                System.out.println("Please select a number from the choices given\n");
                totalFunction(insuranceInfo);
                break;
        }



        totalOutput(insuranceInfo, shipment);

    }
    public static void totalOutput(Insurance insuranceInfo, Shipment shipment) {
        // Output for ending
        final DecimalFormat df = new DecimalFormat("0.00");

        // Use a long to get a random package number
        Random r = new Random();
        long low = 100000000;
        long high = 999999999;
        long packageNumber = r.nextLong(high-low) + low;

        shipment.setPackageNumber(packageNumber);

        System.out.println("\nName of sender: " + sender.toString());
        System.out.println("Address of sender: " + sender.getAddress());
        System.out.println("Phone number: " + sender.getPhoneNumber() + "\n");

        System.out.println("\nName of recipient: " + recipient.toString());
        System.out.println("Address of sender: " + recipient.getAddress());
        System.out.println("Phone number: " + recipient.getPhoneNumber() + "\n");

        System.out.println("\nPackage number: " + shipment.getPackageNumber());
        System.out.println("Insurance number: " + insuranceInfo.getInsuranceNumber());
        System.out.println("ETA: " + shipment.getDays() + " Day(s)");

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("Complete total: " + df.format(shipment.getPrice()));

        confirmationFunc(insuranceInfo, shipment);


    }

    public static void confirmationFunc(Insurance insuranceInfo, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIs this okay? Yes/No? (Not case sensitive)");
        String confirmation = scanner.nextLine().toUpperCase();

        switch(confirmation){
            case "YES":
                        System.out.println("\nSending package now!");
                        System.out.println("Thank you for your business");
                        company(insuranceInfo, shipment);

                        break;
            case "NO":
                        System.out.println("\nPlease try again then");
                        insuranceTotal();
                        break;
            default:
                        System.out.println("\nPlease try something other than Yes or No");
                        confirmationFunc(insuranceInfo, shipment);

        }
    }

    public static void company(Insurance insuranceInfo, Shipment shipment) {
        // Output for the company and placing everything in one object
        System.out.println("\nOrder obtained");

        shipment.setSender(sender);
        shipment.setRecipient(recipient);
        shipment.setInsurance(insuranceInfo);


        String outputTest = shipment.toString();

        System.out.print(outputTest + "\n");

        // Create a driver using the enterDriver function and send it to the confirmation
        Driver driver = enterDriver();
        driverConfirm(driver, shipment);


    }

    public static Driver enterDriver() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your driver's first name");
        String driverAFirst = scanner.nextLine();
        driver.setFirstName(driverAFirst);

        // Enter the driver's last name
        System.out.println("Enter your driver's last name");
        String driverALast = scanner.nextLine();
        driver.setLastName(driverALast);

        Random r = new Random();
        int low = 10000;
        int high = 99999;
        int driverNumber = r.nextInt(high-low) + low;

        driver.setEmployeeNumber(driverNumber);

        // Enter the car's status
        System.out.println("How is the car doing?");
        String carStatus = scanner.nextLine();
        driver.setStatus(carStatus);

        System.out.println("\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        String fullName = driver.toString();
        System.out.println("Name: " + fullName);
        System.out.println("Number: " + driver.getEmployeeNumber());
        System.out.println("Status: " + driver.getStatus());

        return driver;
    }

    public static void driverConfirm(Driver driver, Shipment shipment){
        Scanner scanner = new Scanner(System.in);

        //person.Driver confirmation output
        System.out.print("\nCan you confirm that " + "driver " + driver.getFirstName() + " " + driver.getLastName());
        System.out.println(" will take this delivery? Yes or No? (Not case sensitive)");
        String confirmDrive = scanner.nextLine().toUpperCase();

        // Use a switch statement for confirmation
        switch(confirmDrive){
            case "YES":
                System.out.println("\nPreparing package drop off now!");
                determinePackageValues(driver, shipment);
                break;
            case "NO":
                System.out.println("\nPlease go back to the other menu and enter a different driver");
                company(shipment.getInsurance(), shipment);
                break;
            default:
                System.out.println("\nEntered something other than Yes or No. Please try again");
                driverConfirm(driver, shipment);
                break;

        }


    }

    public static void determinePackageValues(Driver driver, Shipment shipment){

        // Allow the facility worker to enter the values they need for the package
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the weight of the package in pounds");
        double packageWeight = scanner.nextDouble();
        shipment.setWeight(packageWeight);
        System.out.println("Enter the width of the package");
        double packageWidth = scanner.nextDouble();
        System.out.println("Enter the height of the package");
        double packageHeight = scanner.nextDouble();

        setupForDelivery(packageWeight, packageWidth, packageHeight, driver, shipment);




    }

    public static Envelope envelopeFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);

        // Put all the elements into a single box object
        Envelope envelope = new Envelope();
        envelope.setWeight(packageWeight);
        envelope.setHeight(packageHeight);
        envelope.setWidth(packageWidth);
        envelope.setPackageType("Envelope");

        Stamp stamp = new Stamp();
        envelope.setStamp(stamp);
        // Int number for all the stamps
        System.out.println("\nHow many stamps do you want on the envelope?");
        int stampNum = scanner.nextInt();
        envelope.getStamp().setStampNum(stampNum);

        return envelope;

    }

    public static Parcel boxFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner scanner = new Scanner(System.in);

        // Put all the elements into a single box object
        Parcel parcel = new Parcel();
        parcel.setWeight(packageWeight);
        parcel.setHeight(packageHeight);
        parcel.setWidth(packageWidth);
        parcel.setPackageType("Box");

        //Boolean used to detect whether a package is fragile or not
        System.out.println("\nIs the package fragile? Type true or false");
        boolean confirmDrive = scanner.nextBoolean();

        parcel.setFragility(confirmDrive);

        return parcel;

    }

    public static void setupForDelivery(double packageWeight, double packageWidth, double packageHeight,
                                        Driver driver, Shipment shipment) {
        // If package weight is less than 10 pounds, put it in a box. Else, put it in an envelope
        if (packageWeight < 10)
        {
            Envelope envelope = envelopeFunction(packageWeight,packageWidth, packageHeight);
            weighForFacility(envelope, driver, shipment);

        } else {
            Parcel box = boxFunction(packageWeight, packageWidth, packageHeight);
            weighForFacility(box, driver, shipment);
        }


    }

    public static void weighForFacility(Mailing boxOrLetter, Driver driver, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        String driverFullName = driver.getFirstName() + " " + driver.getLastName();
        String senderFullName = shipment.getSender().getFirstName() + " " + shipment.getSender().getLastName();

        System.out.println("\nThe weight of the object is " + boxOrLetter.getWeight());
        System.out.println("This is a(n) " + boxOrLetter.getPackageType());

        // Switch statement to output based on the package type
        switch(boxOrLetter.getPackageType()){
            case "Box":
                Parcel parcel = (Parcel) boxOrLetter;
                if (!parcel.getFragility()) {
                    System.out.println("It is not fragile");
                } else {
                    System.out.println("It is fragile");
                }
                break;
            case "Envelope":
                Envelope envelope = (Envelope) boxOrLetter;
                System.out.println("It needs " + envelope.getStamp().getStampNum() + " stamp(s)");
                break;
            default:
                System.out.println("This is nothing");
                break;
        }

        System.out.println("\nEnter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = scanner.nextDouble();

        System.out.println("The weight of the object in the facility is: " + weightAtFacility);

        // Create a hash map for the weight set to check for equals
        Map<String, Double> weightSet = new HashMap<>();
        weightSet.put(senderFullName, shipment.getWeight());
        weightSet.put(driverFullName, weightAtFacility);

        // If the weight isn't the same as the package weight, return to the function
        if (!weightSet.get(senderFullName).equals(weightSet.get(driverFullName))) {

            System.out.println("\nThe package is not there. Find the correct package");
            weighForFacility(boxOrLetter, driver, shipment);

        } else {
            System.out.println("\nThe correct package is found.");
            System.out.println("ETA is " + shipment.getDays() + " day(s) until delivery");
            System.out.println("Entering in vehicle now");
            vehicleChoice(boxOrLetter, shipment);
        }

    }

    public static void vehicleChoice(Mailing boxOrLetter, Shipment shipment) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat vehicle do you want to use? A car or an plane?");
        String choice = scanner.nextLine().toUpperCase();

        // Random element for car/plane number
        Random r = new Random();
        int low;
        int high;
        int carOrPlaneNum;

        // Use a switch statement to output the correct element
        switch(choice) {
            case "CAR":
                System.out.println("\nYou have chosen a car");
                low = 100000;
                high = 999999;
                carOrPlaneNum = r.nextInt(high-low) + low;
                Car car = new Car();
                car.setVehicleName("Car");
                car.setTruckNumber(carOrPlaneNum);
                vehicleOutput(boxOrLetter, shipment, car);
                break;
            case "PLANE":
                System.out.println("\nYou have chosen an airplane");
                low = 1;
                high = 500;
                carOrPlaneNum = r.nextInt(high-low) + low;
                Plane plane = new Plane();
                plane.setVehicleName("Plane");
                plane.setPlaneNumber(carOrPlaneNum);
                vehicleOutput(boxOrLetter, shipment, plane);
                break;
            default:
                System.out.println("\nPlease choose something else");
                vehicleChoice(boxOrLetter, shipment);
                break;
        }
    }

    public static void vehicleOutput(Mailing boxOrLetter, Shipment shipment, IVehicle carOrPlane) {

        // Equalize the plane or car object for correct output
        if(carOrPlane.getVehicleName().equals("Car")) {
            Car car = ((Car) carOrPlane);
            System.out.println("\nVehicle choice: " + car.getVehicleName());
            System.out.println("Number: " + car.getCarNumber());
            System.out.println("\nSending package now");
            orderFinished(boxOrLetter, shipment);

        } else if (carOrPlane.getVehicleName().equals("Plane")) {
            Plane plane = ((Plane) carOrPlane);
            System.out.println("\nVehicle choice: " + plane.getVehicleName());
            System.out.println("Number: " + plane.getPlaneNumber());
            System.out.println("\nSending package now");
            orderFinished(boxOrLetter, shipment);
        }

    }

    public static void orderFinished(Mailing boxOrLetter, Shipment shipment) {

        // Output everything
        System.out.println("\nOrder delivered");
        if (boxOrLetter.getPackageType().equals("Box")) {
            Parcel parcel = (Parcel) boxOrLetter;
            System.out.println("\n" + parcel.getPackageType() + " received");
            System.out.println(shipment.toString());
            moreOptions();

        } else if (boxOrLetter.getPackageType().equals("Envelope")) {
            Envelope envelope = (Envelope) boxOrLetter;
            System.out.println("\n" + envelope.getPackageType() + " received");
            System.out.println(shipment.toString());
            moreOptions();
        }
    }

    public static void moreOptions() {
        // More options

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMore options");
        System.out.println("1. Take our 3 question survey");
        System.out.println("2. Get a small factoid of the mail while leaving");
        System.out.println("3. Buy stamps. 0.75 per stamp");
        System.out.println("4. Sign up for our membership");
        System.out.println("0. End");

        // Use integer for output
        int optionNum = scanner.nextInt();

        // Switch for more options
        switch (optionNum) {
            case 0:
                    System.out.println("Thank you for shopping here");
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
                    System.out.println("You did not enter a choice given. Try again");
                    moreOptions();
                    break;
        }

    }

    public static void survey() {
        Scanner scanner = new Scanner(System.in);

        // Use the surveyor variable to grab the answers
        Survey surveyor = new Survey();
        System.out.println("\nRate from 1-10. How did you like our service?");
        int choiceNum = scanner.nextInt();
        surveyor.setServiceNum(choiceNum);
        System.out.println("Rate from 1-10. How efficient was our service?");
        choiceNum = scanner.nextInt();
        surveyor.setEfficiencyNum(choiceNum);
        System.out.println("Rate from 1-10. How friendly was our staff?");
        choiceNum = scanner.nextInt();
        surveyor.setStaffNum(choiceNum);
        System.out.println("\nYou answers were: " +
                surveyor.getServiceNum() + ", " + surveyor.getEfficiencyNum() +
                ", and " + surveyor.getStaffNum());

        survey2();
    }

    public static void survey2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                System.out.println("\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
            case "NO":
                System.out.println("Please select your choices again");
                survey();
                break;
            default:
                System.out.println("Please pick Yes or No");
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
        Stamp stamps = new Stamp();
        df.setRoundingMode(RoundingMode.UP);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHow many stamps would you like to buy? 0.75 per stamp");
        int numStamps = scanner.nextInt();

        // Calculate the number of stamps
        stamps.setStampNum(numStamps);
        double completeTotal = (0.75 * numStamps);
        stamps.setStampTotal(completeTotal);

        System.out.println("\nYou bought " + stamps.getStampNum() +
                " stamps for $" + df.format(stamps.getStampTotal()));
        System.out.println("Thank you!");

        System.exit(0);

    }

    public static void membership() {
        Scanner scanner = new Scanner(System.in);
        MembershipInformation membershipDetails = new MembershipInformation();

        Person person = new Person();
        membershipDetails.setPerson(person);

        System.out.println("\nEnter your first name");
        String memberFirstName = scanner.nextLine();
        membershipDetails.getPerson().setFirstName(memberFirstName);

        System.out.println("Enter your last name");
        String memberLastName = scanner.nextLine();
        membershipDetails.getPerson().setLastName(memberLastName);

        // Get the email for the membership
        System.out.println("What is your email?");
        String email = scanner.nextLine();
        membershipDetails.getPerson().setEmail(email);

        System.out.println("What is your age?");
        int age = scanner.nextInt();
        membershipDetails.getPerson().setAge(age);

        membership2(membershipDetails);

    }

    public static void membership2(MembershipInformation membershipDetails){
        Scanner scanner = new Scanner(System.in);
        // If they want
        System.out.println("\nWould you like information on our special offers and coupons? Yes/No?");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                System.out.println("You will receive offers and coupons");
                membershipDetails.setOfferStatus(true);
                membership3(membershipDetails);
                break;
            case "NO":
                System.out.println("You will not be sent offers");
                membershipDetails.setOfferStatus(false);
                membership3(membershipDetails);
                break;
            default:
                System.out.println("\nPlease pick Yes or No");
                membership2(membershipDetails);
                break;
        }
    }
    public static void membership3(MembershipInformation membershipDetails){

        // Use a long for a random membership number
        Random r = new Random();
        long low = 100000000;
        long high = 999999999;
        long membershipNumber = r.nextLong(high-low) + low;

        membershipDetails.setMembershipNumber(membershipNumber);


        // Output for email correction
        System.out.println("\nYour name is: " + membershipDetails.getPerson().toString());
        System.out.println("Your email is: " + membershipDetails.getPerson().getEmail());
        System.out.println("Your membership status is: " + membershipDetails.getOfferStatus());
        System.out.println("Your membership number is: " + membershipDetails.getMembershipNumber());
        System.out.println("Your age is: " + membershipDetails.getPerson().getAge());

        // Use this for choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                if(membershipDetails.getPerson().getAge() <= 17) {
                    System.out.println("\nI'm sorry, but you must be 18 or older to sign up");
                    System.out.println("Please enter your information again");
                    membership();
                } else {
                    System.out.println("\nThank you for information and welcome to our membership");
                    System.exit(0);
                }
                break;
            case "NO":
                System.out.println("\nPlease enter your information again");
                membership();
                break;
            default:
                System.out.println("\nPlease pick Yes or No");
                membership3(membershipDetails);
                break;
        }

    }

    public static void submitComplaint(){
        // Use scanner for the user to input their name and type of complaint
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat is your first name?");
        String complaintFirstName = scanner.nextLine();


        System.out.println("\nWhat is your last name?");
        String complaintLastName = scanner.nextLine();

        System.out.println("\nWhat type of complaint is it?");
        System.out.println("1. Issue with a package");
        System.out.println("2. An employee experience");
        System.out.println("3. Other");
        System.out.println("0. Exit");

        int complaintType = scanner.nextInt();

        Person person = new Person();

        // Use this random to set a complaint number
        Random r = new Random();
        int low = 1;
        int high = 999999;
        int complaintNumber = r.nextInt(high-low) + low;

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
                System.out.println("\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
        }

    }

    public static void complaintOfPackage(PackageComplaint packageComplaint) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        // Have the user set the number of the package and the complaint
        System.out.println("\nWhat is the number of your package?");
        Shipment shipment = new Shipment();
        packageComplaint.setShipment(shipment);
        long numberOfPackage = scanner.nextLong();
        // packageComplaint.setPackageNumber(numberOfPackage);
        packageComplaint.getShipment().setPackageNumber(numberOfPackage);

        System.out.println("\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        packageComplaint.setComplaint(complaint);

        System.out.println("\nYour information");
        System.out.println("Name: " + packageComplaint.getPerson().toString());
        System.out.println("Complaint Number: " + packageComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + packageComplaint.getBaseComplaintType());
        System.out.println("Number of Package: " + packageComplaint.getShipment().getPackageNumber());
        System.out.println("Complaint: " + packageComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfEmployee(EmployeeComplaint employeeComplaint) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Employee employee = new Employee();

        employeeComplaint.setEmployee(employee);

        // Have the user set the name of the employee and the complaint
        System.out.println("\nWhat is the first name of the employee who served you?");
        String employeeFirst = scanner.nextLine();
        employeeComplaint.getEmployee().setFirstName(employeeFirst);

        System.out.println("\nWhat is the last name of the employee who served you?");
        String employeeLast = scanner.nextLine();
        employeeComplaint.getEmployee().setLastName(employeeLast);

        System.out.println("\nWhat is the number of the employee? Between 10000 and 99999");
        int employeeNum = scanner.nextInt();
        employeeComplaint.getEmployee().setEmployeeNumber(employeeNum);


        System.out.println("\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        employeeComplaint.setComplaint(complaint);

        System.out.println("\nYour information");
        System.out.println("Name: " + employeeComplaint.getPerson().toString());
        System.out.println("Complaint Number: " + employeeComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + employeeComplaint.getBaseComplaintType());
        System.out.println("Name of Employee: " + employeeComplaint.getEmployee().toString());
        System.out.println("Complaint: " + employeeComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfOther(OtherComplaint otherComplaint) {

        Scanner scanner = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        System.out.println("\nWhat is the other type of complaint you would like to make?");
        String typeOfComplaint = scanner.nextLine();
        otherComplaint.setOtherComplaintType(typeOfComplaint);
        System.out.println("\nWhat is your complaint?");
        String complaint = scanner.nextLine();
        otherComplaint.setComplaint(complaint);

        System.out.println("\nYour information");
        System.out.println("Name: " + otherComplaint.getPerson().toString());
        System.out.println("Complaint Number: " + otherComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + otherComplaint.getBaseComplaintType());
        System.out.println("Type of Complaint: " + otherComplaint.getOtherComplaintType());
        System.out.println("Complaint: " + otherComplaint.getComplaint());

        complaintCheck();


    }
    public static void complaintCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                System.out.println("\nThank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                System.out.println("\nPlease enter your information again");
                submitComplaint();
            default:
                System.out.println("\nPlease pick Yes or No");
                complaintCheck();
        }
    }
}