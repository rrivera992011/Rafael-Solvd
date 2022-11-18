import java.util.Scanner; // Import scanner class

public class Main {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();

        Scanner myObj = new Scanner(System.in); // Scanner for user input

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
        int numOfDays = myObj.nextInt();

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

        // Output everything
        System.out.println("\nNames and Addresses");
        System.out.println(delivery.getName1() + " -> " + delivery.getAddress1());
        System.out.println(delivery.getName2() + " -> " + delivery.getAddress2());
        System.out.println("ETA is " + numOfDays + " days");
        System.out.println("Your total is $" + delivery.getPrice());

        facilityToADrive(delivery);

    }

    public static void facilityToADrive(Delivery delivery) {

        System.out.println("\n" + delivery.getName1());
    }
}

