import java.util.*;

public class Main {

    static Scanner myObj = new Scanner(System.in); // Scanner for user input
    static Scanner myObj2 = new Scanner(System.in);
    static Scanner myObj3 = new Scanner(System.in);
    static Delivery delivery = new Delivery();
    static PriceDetails priceInfo = new PriceDetails();
    static FacilityToA aToFac = new FacilityToA();
    static LocationACheck locA = new LocationACheck();
    static LocationACheck facility = new LocationACheck();

    static FacilityCheck transferData1 = new FacilityCheck();
    static FacilityToB facToB = new FacilityToB();

    static LocationBCheck locB = new LocationBCheck();

    static PrepareReturn endingRoute = new PrepareReturn();

    public static void main(String[] args) {

        delivery();
        priceDetails();

        // Using random to generate a barcode
        Random r = new Random();
        int low = 1;
        int high = 100;
        int barCode = r.nextInt(high-low) + low;

        // Output everything
        System.out.println("\nNames and Addresses");
        System.out.println(delivery.getName1() + " -> " + delivery.getAddress1());
        System.out.println(delivery.getName2() + " -> " + delivery.getAddress2());
        System.out.println("ETA is " + priceInfo.getDays() + " day(s)");
        System.out.println("Your total is $" + priceInfo.getPrice());

        if (priceInfo.getPrice() == 0) {
            System.out.println("\nNo money entered. Pleased try again");
            System.exit(0);
        }

        System.out.println("Use this bar code on your package: " + barCode + "\n");

        facilityToA(); // Method to manage the drive from the facility

        System.out.println("Dispatching now");

        locationACheck(barCode);
        locAToFacility();
        checkForPackage(priceInfo.getDays());
        facilityToLocB();

        System.out.println("\nYou have arrived at " + delivery.getAddress2());

        locationBCheck(r, low, high);
        confirmDelivery();
        prepareReturn();

        System.out.println("\nMapping return to facility");
        System.out.println("Welcome back " + facToB.getDriverFirstB() + " " + facToB.getDriverLastB());


    }


    public static void delivery() {
        // Allow the user to enter their name
        System.out.println("Enter your name");
        String mainName = myObj.nextLine();
        delivery.setName1(mainName);

        // Allow the user to enter their address
        System.out.println("Enter your address");
        String mainAddress = myObj.nextLine();
        delivery.setAddress1(mainAddress);

        // Allow the user to enter the receiving person's name
        System.out.println("Enter receiving person's name");
        String mainName2 = myObj.nextLine();
        delivery.setName2(mainName2);

        // Allow the user to enter the receiving person's address
        System.out.println("Enter the receiving person's address");
        String mainAddress2 = myObj.nextLine();
        delivery.setAddress2(mainAddress2);

    }
    public static void priceDetails() {
    // Allow the user to calculate the plan they want to use
        System.out.println("Which plan do you want? 5 days for $10, 3 days for $30, or 1 day for $50?");
        int numOfDays = Integer.parseInt(myObj.nextLine());

        // Double variable for the price
        double priceValue;

        // Switch statement used to calculate total using TN state tax
        switch(numOfDays) {

            case 1:
                priceValue = 50 + (50 * 0.07);
                break;
            case 3:
                priceValue = 30 + (30 * 0.07);
                break;
            case 5:
                priceValue = 10 + (10 * 0.07);
                break;
            default:
                priceValue = 0;
                break;
        }

        priceInfo.setPrice(priceValue);
        priceInfo.setDays(numOfDays);

    }
    public static void facilityToA() {

        // Enter the driver's first name
        System.out.println("Order received. Enter your driver's first name");
        String driverAFirst = myObj.nextLine();
        aToFac.setDriverFirstA(driverAFirst);

        // Enter the driver's last name
        System.out.println("Enter your driver's last name");
        String driverALast = myObj.nextLine();
        aToFac.setDriverLastA(driverALast);

        // Enter the car's status
        System.out.println("How is the car doing?");
        String carStatus = myObj.nextLine();
        aToFac.setStatus(carStatus);

        System.out.println("\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        System.out.println("Name: " + aToFac.toString());
        System.out.println("Status: " + aToFac.getStatus());

    }
    public static void locationACheck(int facilityBar) {

        // User boolean input for package availability
        System.out.println("\nYou have arrived to " + delivery.getAddress1());
        System.out.println("Is there a package? Type true or false");
        boolean isPackageThere = myObj.nextBoolean();

        // If package is not there, exit the program
        if (!isPackageThere) {
            System.out.println("No package. Return to the facility");
            System.exit(0);
        }

        System.out.println("There is a package\n");

        // Ask the user about the bar code on the package
        System.out.println("Type in the barcode of the package that appears in location A");
        System.out.println("The generated bar code is " + facilityBar);
        int barCodeSpotted = myObj.nextInt();
        facility.setBarCode(facilityBar);
        locA.setBarCode(barCodeSpotted);

        // If bar codes aren't equal, return to the facility and exit the program
        if ( facility.getBarCode() != locA.getBarCode() ){
            System.out.println("No package. Return to the facility");
            System.exit(0);
        }

        System.out.println("Correct package. Pick it up and return to the facility with it");

    }

    public static void locAToFacility() {

        System.out.println("\nMapped route from " + delivery.getAddress1() + " to facility");
        // Weigh the package and send it to the facility
        System.out.println("Insert the weight of the package in pounds");
        int packageWeight = myObj.nextInt();
        transferData1.setWeight(packageWeight);

        // Output the weight
        System.out.println("The package weighs " + packageWeight + " pounds.");
        System.out.println("Sending to the facility now");

    }

    public static void checkForPackage(int days) {
        System.out.println("\nYou have arrived to the facility");
        int weightFromA = transferData1.getWeight();
        System.out.println("What is the weight now?");
        int currentWeight = myObj.nextInt();

        String fullDriverName = aToFac.getDriverFirstA() + " " + aToFac.getDriverLastA();


        // Use a hashmap and fill it with the elements
        Map<String, Integer> weightSet = new HashMap<>();
        CheckForPackageFac fromLocation = new CheckForPackageFac(delivery.getName1(),weightFromA);
        CheckForPackageFac fromFacility = new CheckForPackageFac(fullDriverName,currentWeight);
        weightSet.put(fromLocation.getNameForCheck(), fromLocation.getWeight());
        weightSet.put(fromFacility.getNameForCheck(), fromFacility.getWeight());

        // If the weight isn't the same as the package weight, return to
        if (!weightSet.get(fromLocation.getNameForCheck()).equals(weightSet.get(fromFacility.getNameForCheck()))) {

            System.out.println("The package is not there. Find the correct package");

        }

        System.out.println("The correct package is found. ETA is " + days + " day(s) until delivery");
    }

    public static void facilityToLocB() {
        // Enter the driver's first name
        System.out.println("\nDispatching soon. Enter your driver's first name");
        String driverBFirst = myObj2.nextLine();
        facToB.setDriverFirstB(driverBFirst);

        // Enter the driver's last name
        System.out.println("Enter your driver's last name");
        String driverBLast = myObj2.nextLine();
        facToB.setDriverLastB(driverBLast);

        // Enter the car's status
        System.out.println("How is the car doing?");
        String carStatusB = myObj3.nextLine();
        facToB.setStatusB(carStatusB);

        System.out.println("\nDriver information");
        // Using the overridden toString to output in LastName, FirstName format
        System.out.println("Name: " + facToB.toString());
        System.out.println("Status: " + facToB.getStatusB());

    }
    public static void locationBCheck(Random r, int low, int high) {

        int barCodeB = r.nextInt(high-low) + low;

        locB.setBBarCode(barCodeB);
        System.out.println("\nThe new bar code for location B is " + locB.getBBarCode());
        System.out.println("Leave the package on the floor");

    }

    public static void confirmDelivery() {
        System.out.println("\nHas the package been delivered? Type true or false");
        boolean delivered = myObj.nextBoolean();

        ConfirmDelivery confirm = new ConfirmDelivery();
        confirm.setConfirmation(delivered);

        if(!confirm.getConfirmation()) {
            System.out.println("Package is not delivered for any circumstance");
            System.out.println("Try again later or ask the person to pick it up");
            System.exit(0);
        }

        System.out.println("Package delivered");

    }

    public static void prepareReturn() {

        System.out.println("\nPreparing route from " + delivery.getAddress2() + " to facility");

        System.out.println("Enter car status");
        String carStatusC = myObj2.nextLine();
        endingRoute.setStatusC(carStatusC);

        System.out.println("\nDriver: " + facToB.toString());
        System.out.println("Status: " + endingRoute.getStatusC());

    }

}

