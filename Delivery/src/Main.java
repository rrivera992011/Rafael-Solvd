import java.util.Random;
import java.util.Scanner; // Import scanner class

public class Main {

    static Scanner myObj = new Scanner(System.in); // Scanner for user input
    static Delivery delivery = new Delivery();
    static FacilityToA facToA = new FacilityToA();
    static LocationACheck locA = new LocationACheck();
    static LocationACheck facility = new LocationACheck();

    public static void main(String[] args) {

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

        delivery.setPrice(priceValue);

        // Using random to generate a barcode
        Random r = new Random();
        int low = 1;
        int high = 100;
        int barCode = r.nextInt(high-low) + low;

        // Output everything
        System.out.println("\nNames and Addresses");
        System.out.println(delivery.getName1() + " -> " + delivery.getAddress1());
        System.out.println(delivery.getName2() + " -> " + delivery.getAddress2());
        System.out.println("ETA is " + numOfDays + " day(s)");
        System.out.println("Your total is $" + delivery.getPrice());
        System.out.println("Use this bar code on your package: " + barCode + "\n");

        facilityToA(); // Method to manage the drive from the facility

        System.out.println("Dispatching now");

        locationACheck(barCode);
        locAToFacility();


    }

    public static void facilityToA() {

        // Enter the driver's first name
        System.out.println("Order received. Enter your driver's first name");
        String driverAFirst = myObj.nextLine();
        facToA.setDriverFirstA(driverAFirst);

        // Enter the driver's last name
        System.out.println("Enter your driver's last name");
        String driverALast = myObj.nextLine();
        facToA.setDriverLastA(driverALast);

        // Enter the car's status
        System.out.println("How is the car doing?");
        String carStatus = myObj.nextLine();
        facToA.setStatus(carStatus);

        System.out.println("\nDrive information");
        // Using the overridden toString to output in LastName, FirstName format
        System.out.println("Name: " + facToA.toString());
        System.out.println("Status: " + facToA.getStatus());

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
        System.out.println("Type in the barcode of the package");
        int barCodeSpotted = myObj.nextInt();
        facility.setBarCode(facilityBar);
        locA.setBarCode(barCodeSpotted);

        // LinkedHashSet<LocationACheck> compareBar = new LinkedHashSet<>();
        // compareBar.add(new LocationACheck(delivery.getName1(),locA.getBarCode()));
        // If bar codes aren't equal, return to the facility and exit the program
        if (!locA.equals(facility)){
            System.out.println("No package. Return to the facility");
            System.exit(0);
        }

        System.out.println("Correct package. Pick it up and return to the facility with it");

    }

    public static void locAToFacility() {

        System.out.println("Mapped route from " + delivery.getAddress1() + " to facility");
        System.out.println("Insert the weight of the package in pounds");
        int packageWeight = myObj.nextInt();

    }
}

