
import complaint.*;
import factoid.FactoidOutput;
import membership.Email;
import packageType.*;
import stamps.StampTotal;
import survey.SurveyAnswers;
import vehicle.*;

import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main {

    static Person sender = new Person();
    static Person recipient = new Person();

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
        System.out.println("4. Only buy stamps");
        System.out.println("5. File a complaint");
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
            case 4:
                buyStamps();
                break;
            case 5:
                submitComplaint();
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
        String phoneNumber = myObj.nextLine();
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
        String phoneNumber = myObj.nextLine();
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
        System.out.println(" will take this delivery? Yes or No? (Not case sensitive)");
        String confirmDrive = myObj.nextLine().toUpperCase();

        // Use a switch statement for confirmation
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

        // Allow the facility worker to enter the values they need for the package
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEnter the weight of the package in pounds");
        double packageWeight = myObj.nextDouble();
        System.out.println("Enter the width of the package");
        double packageWidth = myObj.nextDouble();
        System.out.println("Enter the height of the package");
        double packageHeight = myObj.nextDouble();

        setupForDelivery(packageWeight, packageWidth, packageHeight, driver, shipment);




    }

    public static Envelope envelopeFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner myObj = new Scanner(System.in);

        // Put all the elements into a single box object
        Envelope envelope = new Envelope();
        envelope.setWeight(packageWeight);
        envelope.setHeight(packageHeight);
        envelope.setWidth(packageWidth);
        envelope.setPackageType("packageType.Envelope");

        // Int number for all the stamps
        System.out.println("\nHow many stamps do you want on the envelope?");
        int stampNum = myObj.nextInt();
        envelope.getStamps().setStampNum(stampNum);

        return envelope;

    }

    public static Box boxFunction (double packageWeight, double packageWidth, double packageHeight) {
        Scanner myObj = new Scanner(System.in);

        // Put all the elements into a single box object
        Box box = new Box();
        box.setWeight(packageWeight);
        box.setHeight(packageHeight);
        box.setWidth(packageWidth);
        box.setPackageType("packageType.Box");

        //Boolean used to detect whether a package is fragile or not
        System.out.println("\nIs the package fragile? Type true or false");
        boolean confirmDrive = myObj.nextBoolean();

        box.setFragility(confirmDrive);

        return box;

    }

    public static void setupForDelivery(double packageWeight, double packageWidth, double packageHeight,
                                        Driver driver, Shipment shipment) {
        // If package weight is less than 10 pounds, put it in a box. Else, put it in an envelope
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

        // packageType.Envelope envelope = (packageType.Envelope) boxOrLetter;

        System.out.println("\nThe weight of the object is " + boxOrLetter.getWeight());
        System.out.println("This is a(n) " + boxOrLetter.getPackageType());

        switch(boxOrLetter.getPackageType()){
            case "packageType.Box":
                Box box = (Box) boxOrLetter;
                if (!box.getFragility()) {
                    System.out.println("It is not fragile");
                } else {
                    System.out.println("It is fragile");
                }
                break;
            case "packageType.Envelope":
                Envelope envelope = (Envelope) boxOrLetter;
                System.out.println("It needs " + envelope.getStamps().getStampNum() + " stamps");
                break;
            default:
                System.out.println("This is nothing");
                break;
        }

        System.out.println("\nEnter the weight again in facility to make sure it's the correct object");
        double weightAtFacility = myObj.nextDouble();

        System.out.println("The weight of the object in the facility is: " + weightAtFacility);

        Map<String, Double> weightSet = new HashMap<>();
        PressureWeight fromLocation = new PressureWeight(shipment.getSender().getName(), packageWeight);
        PressureWeight fromFacility = new PressureWeight(driverFullName, weightAtFacility);
        weightSet.put(fromLocation.getCheckingName(), fromLocation.getWeight());
        weightSet.put(fromFacility.getCheckingName(), fromFacility.getWeight());

        // If the weight isn't the same as the package weight, return to
        if (!weightSet.get(fromLocation.getCheckingName()).equals(weightSet.get(fromFacility.getCheckingName()))) {

            System.out.println("\nThe package is not there. Find the correct package");
            weighForFacility(boxOrLetter, driver, shipment, packageWeight);

        } else {
            System.out.println("\nThe correct package is found.");
            System.out.println("ETA is " + shipment.getPrice().getDays() + " day(s) until delivery");
            System.out.println("Entering in vehicle now");
            vehicleChoice(boxOrLetter, shipment);
        }

    }

    public static void vehicleChoice(PackageType boxOrLetter, Shipment shipment) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nWhat vehicle do you want to use? A car or an plane?");
        String choice = myObj.nextLine().toUpperCase();

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
                car.setVehicleName("vehicle.Car");
                car.setTruckNumber(carOrPlaneNum);
                vehicleOutput(boxOrLetter, shipment, car);
                break;
            case "PLANE":
                System.out.println("\nYou have chosen an airplane");
                low = 1;
                high = 500;
                carOrPlaneNum = r.nextInt(high-low) + low;
                Plane plane = new Plane();
                plane.setVehicleName("vehicle.Plane");
                plane.setPlaneNumber(carOrPlaneNum);
                vehicleOutput(boxOrLetter, shipment, plane);
                break;
            default:
                System.out.println("\nPlease choose something else");
                vehicleChoice(boxOrLetter, shipment);
                break;
        }
    }

    public static void vehicleOutput(PackageType boxOrLetter, Shipment shipment, IVehicle carOrPlane) {

        // Equalize the plane or car object for correct output
        if(carOrPlane.getVehicleName().equals("vehicle.Car")) {
            Car car = ((Car) carOrPlane);
            System.out.println("\nVehicle choice: " + car.getVehicleName());
            System.out.println("Number: " + car.getTruckNumber());
            System.out.println("\nSending package now");
            orderFinished(boxOrLetter, shipment);

        } else if (carOrPlane.getVehicleName().equals("vehicle.Plane")) {
            Plane plane = ((Plane) carOrPlane);
            System.out.println("\nVehicle choice: " + plane.getVehicleName());
            System.out.println("Number: " + plane.getPlaneNumber());
            System.out.println("\nSending package now");
            orderFinished(boxOrLetter, shipment);
        }

    }

    public static void orderFinished(PackageType boxOrLetter, Shipment shipment) {

        // Output everything
        System.out.println("\nOrder delivered");
        if (boxOrLetter.getPackageType().equals("packageType.Box")) {
            Box box = (Box) boxOrLetter;
            System.out.println("\n" + box.getPackageType() + " received");
            System.out.println(shipment.toString());
            moreOptions();
            System.exit(0);

        } else if (boxOrLetter.getPackageType().equals("Letter")) {
            Envelope envelope = (Envelope) boxOrLetter;
            System.out.println("\n" + envelope.getPackageType() + " received");
            System.out.println(shipment.toString());
            System.exit(0);
        }
    }

    public static void moreOptions() {
        // More options

        Scanner myObj = new Scanner(System.in);
        System.out.println("\nMore options");
        System.out.println("1. Take our 3 question survey");
        System.out.println("2. Get a small factoid of the mail while leaving");
        System.out.println("3. Buy stamps. 0.75 per stamp");
        System.out.println("4. Sign up for our membership");
        System.out.println("0. End");

        // Use integer for output
        int optionNum = myObj.nextInt();

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
        Scanner myObj = new Scanner(System.in);

        // Use the surveyor variable to grab the answers
        SurveyAnswers surveyor = new SurveyAnswers();
        System.out.println("Rate from 1-10. How did you like our service?");
        int choiceNum = myObj.nextInt();
        surveyor.setServiceNum(choiceNum);
        System.out.println("Rate from 1-10. How efficient was our service?");
        choiceNum = myObj.nextInt();
        surveyor.setEfficiencyNum(choiceNum);
        System.out.println("Rate from 1-10. How friendly was our staff?");
        choiceNum = myObj.nextInt();
        surveyor.setStaffNum(choiceNum);
        System.out.println("You answers were: " +
                surveyor.getServiceNum() + ", " + surveyor.getEfficiencyNum() +
                ", and " + surveyor.getStaffNum());

        survey2();
    }

    public static void survey2() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = myObj.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                System.out.println("Thank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                System.out.println("Please select your choices again");
                survey();
            default:
                System.out.println("Please pick Yes or No");
                survey2();
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
        StampTotal stamps = new StampTotal();
        df.setRoundingMode(RoundingMode.UP);
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nHow many stamps would you like to buy? 0.75 per stamp");
        int numStamps = myObj.nextInt();

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
        Scanner myObj = new Scanner(System.in);
        Email emailAddress = new Email();
        // Get the email for the membership
        System.out.println("\nWhat is your email?");
        String email = myObj.nextLine();
        emailAddress.setEmail(email);

        // Output for email correction
        System.out.println("\nYour email is : " + emailAddress.getEmail());

        membership2();
    }
    public static void membership2(){
        // Use this for choice
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = myObj.nextLine().toUpperCase();

        switch (choice){
            case "YES":
                System.out.println("\nThank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                System.out.println("\nPlease enter your email again");
                membership();
            default:
                System.out.println("Please pick Yes or No");
                membership2();
        }

    }

    public static void submitComplaint(){
        // Use scanner for the user to input their name and type of complaint
        Scanner myObj = new Scanner(System.in);

        System.out.println("\nWhat is your name?");
        String complaintName = myObj.nextLine();

        System.out.println("\nWhat type of complaint is it?");
        System.out.println("1. Issue with a package");
        System.out.println("2. An employee experience");
        System.out.println("3. Other");
        System.out.println("0. Exit");

        int complaintType = myObj.nextInt();

        Random r = new Random();
        int low = 1;
        int high = 999999;
        int complaintNumber = r.nextInt(high-low) + low;

        switch (complaintType){
            case 1:
                PackageComplaint packageComplaint = new PackageComplaint();
                packageComplaint.setComplaintName(complaintName);
                packageComplaint.setComplaintNumber(complaintNumber);
                packageComplaint.setBaseComplaintType("Package");
                complaintOfPackage(packageComplaint);
                break;
            case 2:
                EmployeeComplaint employeeComplaint = new EmployeeComplaint();
                employeeComplaint.setComplaintName(complaintName);
                employeeComplaint.setComplaintNumber(complaintNumber);
                employeeComplaint.setBaseComplaintType("Employee");
                complaintOfEmployee(employeeComplaint);
                break;
            case 3:
                OtherComplaint otherComplaint = new OtherComplaint();
                otherComplaint.setComplaintName(complaintName);
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
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);

        // Have the user set the number of the package and the complaint
        System.out.println("\nWhat is the number of your package?");
        int numberOfPackage = myObj.nextInt();
        packageComplaint.setPackageNumber(numberOfPackage);

        System.out.println("\nWhat is your complaint?");
        String complaint = myObj2.nextLine();
        packageComplaint.setComplaint(complaint);

        System.out.println("\nYour information:");
        System.out.println("Name: " + packageComplaint.getComplaintName());
        System.out.println("Complaint Number: " + packageComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + packageComplaint.getBaseComplaintType());
        System.out.println("Number of Package: " + packageComplaint.getPackageNumber());
        System.out.println("Complaint: " + packageComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfEmployee(EmployeeComplaint employeeComplaint) {

        Scanner myObj = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        System.out.println("\nWhat is the name of the employee who served you?");
        String employee = myObj.nextLine();
        employeeComplaint.setEmployeeName(employee);
        System.out.println("\nWhat is your complaint?");
        String complaint = myObj.nextLine();
        employeeComplaint.setComplaint(complaint);

        System.out.println("\nYour information:");
        System.out.println("Name: " + employeeComplaint.getComplaintName());
        System.out.println("Complaint Number: " + employeeComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + employeeComplaint.getBaseComplaintType());
        System.out.println("Name of Employee: " + employeeComplaint.getEmployeeName());
        System.out.println("Complaint: " + employeeComplaint.getComplaint());

        complaintCheck();

    }

    public static void complaintOfOther(OtherComplaint otherComplaint) {

        Scanner myObj = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        System.out.println("\nWhat is the name of the employee who served you?");
        String typeOfComplaint = myObj.nextLine();
        otherComplaint.setOtherComplaintType(typeOfComplaint);
        System.out.println("\nWhat is your complaint?");
        String complaint = myObj.nextLine();
        otherComplaint.setComplaint(complaint);

        System.out.println("\nYour information:");
        System.out.println("Name: " + otherComplaint.getComplaintName());
        System.out.println("Complaint Number: " + otherComplaint.getComplaintNumber());
        System.out.println("Complaint Type: " + otherComplaint.getBaseComplaintType());
        System.out.println("Type of Complaint: " + otherComplaint.getOtherComplaintType());
        System.out.println("Complaint: " + otherComplaint.getComplaint());

        complaintCheck();


    }
    public static void complaintCheck() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = myObj.nextLine().toUpperCase();

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