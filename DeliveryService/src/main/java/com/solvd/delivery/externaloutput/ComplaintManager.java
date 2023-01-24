package com.solvd.delivery.externaloutput;
import com.solvd.delivery.complaint.*;
import com.solvd.delivery.exceptions.*;
import com.solvd.delivery.person.*;
import org.apache.logging.log4j.*;

import java.util.Scanner;

public class ComplaintManager {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    public static void submitComplaint() {
        // Use scanner for the user to input their name and type of complaint
        Scanner scanner = new Scanner(System.in);

        LOGGER.log(MENU_LOG, "\nWhat is your first name?");
        String complaintFirstName = scanner.nextLine();

        LOGGER.log(MENU_LOG, "\nWhat is your last name?");
        String complaintLastName = scanner.nextLine();

        LOGGER.log(MENU_LOG, "\nWhat type of complaint is it?");
        LOGGER.log(MENU_LOG, "1. Issue with a package");
        LOGGER.log(MENU_LOG, "2. An employee experience");
        LOGGER.log(MENU_LOG, "3. Miscellaneous complaint");
        LOGGER.log(MENU_LOG, "0. Exit");

        int complaintType = scanner.nextInt();

        Person person = new Person();

        // Use this random to set a complaint number
        String complaintNumber = String.valueOf(RandomOperations.getRandomNumber(1, 99999));

        // Switch to select what type of complaint someone wants
        switch (complaintType) {
            case 1:
                PackageComplaint packageComplaint = new PackageComplaint();
                packageComplaint.setPerson(person);
                packageComplaint.getPerson().setFirstName(complaintFirstName);
                packageComplaint.getPerson().setLastName(complaintLastName);
                packageComplaint.setComplaintNumber(complaintNumber);
                complaintOfPackage(packageComplaint, Complaint.ComplaintType.PACKAGE_COMPLAINT.getTypeOfComplaint());
                break;
            case 2:
                EmployeeComplaint employeeComplaint = new EmployeeComplaint();
                employeeComplaint.setPerson(person);
                employeeComplaint.getPerson().setFirstName(complaintFirstName);
                employeeComplaint.getPerson().setLastName(complaintLastName);
                employeeComplaint.setComplaintNumber(complaintNumber);
                complaintOfEmployee(employeeComplaint, Complaint.ComplaintType.EMPLOYEE_COMPLAINT.getTypeOfComplaint());
                break;
            case 3:
                MiscComplaint miscComplaint = new MiscComplaint();
                miscComplaint.setPerson(person);
                miscComplaint.getPerson().setFirstName(complaintFirstName);
                miscComplaint.getPerson().setLastName(complaintLastName);
                miscComplaint.setComplaintNumber(complaintNumber);
                complaintOfMisc(miscComplaint, Complaint.ComplaintType.MISC_COMPLAINT.getTypeOfComplaint());
                break;
            case 0:
                LOGGER.log(MENU_LOG, "\nThank you for your assistance. Goodbye");
                System.exit(0);
                break;
        }


    }

    public static void complaintOfPackage(PackageComplaint packageComplaint, String complaintName) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Have the user set the number of the package and the complaint
        LOGGER.log(MENU_LOG, "\nWhat is the number of your package?");
        String numberOfPackage = scanner.nextLine();
        packageComplaint.setPackageNumber(numberOfPackage);

        LOGGER.log(MENU_LOG, "\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        packageComplaint.setDescription(complaint);

        LOGGER.log(MENU_LOG, "\nYour information");
        LOGGER.log(MENU_LOG, "Name: " + packageComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG, "Complaint Type: " + complaintName);
        LOGGER.log(MENU_LOG, packageComplaint);
        finalizeComplaint();
    }

    public static void complaintOfEmployee(EmployeeComplaint employeeComplaint, String complaintName) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Employee employee = new Employee();

        employeeComplaint.setEmployee(employee);

        // Have the user set the name of the employee and the complaint
        LOGGER.log(MENU_LOG, "\nWhat is the first name of the employee who served you?");
        String employeeFirst = scanner.nextLine();
        employeeComplaint.getEmployee().setFirstName(employeeFirst);

        LOGGER.log(MENU_LOG, "\nWhat is the last name of the employee who served you?");
        String employeeLast = scanner.nextLine();
        employeeComplaint.getEmployee().setLastName(employeeLast);

        LOGGER.log(MENU_LOG, "\nWhat is the number of the employee? Between 10000 and 99999");
        int employeeNum = scanner.nextInt();
        employeeComplaint.getEmployee().setIdNumber(String.valueOf(employeeNum));


        LOGGER.log(MENU_LOG, "\nWhat is your complaint?");
        String complaint = scanner2.nextLine();
        employeeComplaint.setDescription(complaint);

        LOGGER.log(MENU_LOG, "\nYour information");
        LOGGER.log(MENU_LOG, "Name: " + employeeComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG, "Complaint Type: " + complaintName);
        LOGGER.log(MENU_LOG, employeeComplaint);

        finalizeComplaint();
    }

    public static void complaintOfMisc(MiscComplaint miscComplaint, String complaintName) {

        Scanner scanner = new Scanner(System.in);

        // Have the user set the name of the employee and the complaint
        LOGGER.log(MENU_LOG, "\nWhat is the miscellaneous type of complaint you would like to make?");
        String typeOfComplaint = scanner.nextLine();
        miscComplaint.setMiscDescription(typeOfComplaint);
        LOGGER.log(MENU_LOG, "\nWhat is your complaint?");
        String complaint = scanner.nextLine();
        miscComplaint.setDescription(complaint);

        LOGGER.log(MENU_LOG, "\nYour information");
        LOGGER.log(MENU_LOG, "Name: " + miscComplaint.getPerson().toString());
        LOGGER.log(MENU_LOG, "Complaint Type: " + complaintName);
        LOGGER.log(MENU_LOG, miscComplaint);
        finalizeComplaint();

    }

    public static void finalizeComplaint() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(MENU_LOG, "\nIs this correct? Yes or No? (Not case sensitive)");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "YES":
                LOGGER.log(MENU_LOG, "\nThank you for your assistance. Goodbye");
                System.exit(0);
            case "NO":
                LOGGER.log(MENU_LOG, "\nPlease enter your information again");
                submitComplaint();
            default:
                try {
                    ExceptionManager.checkYesOrNo(choice);
                } catch (InvalidInputException e) {
                    LOGGER.error("\nA problem occurred ", e);
                }
                finalizeComplaint();
        }
    }

}
