package com.solvd.pharmacyservice;

import com.solvd.pharmacyservice.models.*;
import org.apache.logging.log4j.*;

import javax.xml.bind.*;
import java.io.File;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class JAXBMain {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) throws ParseException {
        List<Customer> customers = new ArrayList<>();
        List<EmployeeType> employeeTypes = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<AppointmentType> appointmentTypes = new ArrayList<>();
        List<ExaminationType> examinationTypes = new ArrayList<>();
        List<PaymentType> paymentTypes = new ArrayList<>();
        List<Recipe> recipes = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<Inventory> inventories = new ArrayList<>();
        List<CustomerOrder> customerOrders = new ArrayList<>();
        List<Prescription> prescriptions = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        List<Examination> examinations = new ArrayList<>();

        Customer daniel = new Customer(1, "Daniel", "Andrews","12343234123",
                25, "12 Main Ave");
        Customer adam = new Customer(2, "Adam", "Jones", "5467896543", 17,
                "12 Easy Street" );

        customers.add(daniel);
        customers.add(adam);

        EmployeeType clerk = new EmployeeType(1, "Clerk");
        EmployeeType doctor = new EmployeeType(2, "Doctor");

        employeeTypes.add(clerk);
        employeeTypes.add(doctor);

        Employee michael = new Employee(1, "Michael", "Morris",
                "123443223", 1);
        Employee antonio = new Employee(2, "Antonio", "Mayor",
                "212344553", 2);

        employees.add(michael);
        employees.add(antonio);

        AppointmentType vaccine = new AppointmentType(1, "Vaccine");
        AppointmentType recommendation = new AppointmentType(2, "Recommendation");

        appointmentTypes.add(vaccine);
        appointmentTypes.add(recommendation);

        ExaminationType covidTest = new ExaminationType(1, "COVID Test");
        ExaminationType measlesTest = new ExaminationType(2, "Measles Test");

        examinationTypes.add(covidTest);
        examinationTypes.add(measlesTest);

        PaymentType cash = new PaymentType(1, "Cash");
        PaymentType creditCard = new PaymentType(2, "Credit Card");

        paymentTypes.add(cash);
        paymentTypes.add(creditCard);

        Recipe levofloxacin = new Recipe(1, 20);
        Recipe genpril = new Recipe(2, 100);

        recipes.add(levofloxacin);
        recipes.add(genpril);

        Category antibiotic = new Category(1, "Antibiotic");
        Category betaBlocker = new Category(2, "Beta blocker");

        categories.add(antibiotic);
        categories.add(betaBlocker);

        Inventory atenolol = new Inventory(1, "Atenolol", 2, 100,
                2, 8.25);
        Inventory amoxil = new Inventory(2, "Amoxil", 1, 99,
                1, 12.99);

        inventories.add(atenolol);
        inventories.add(amoxil);

        CustomerOrder orderForDaniel = new CustomerOrder(1, 18.25, 1,
                Date.valueOf("2022-12-24"), 1, 1);
        CustomerOrder orderForAdam = new CustomerOrder(2, 13.57, 2,
                Date.valueOf("2023-01-19"), 2, 2);

        customerOrders.add(orderForDaniel);
        customerOrders.add(orderForAdam);

        Prescription prescriptionForDaniel = new Prescription(1, "1234543", 25.13,
                50, Date.valueOf("2022-12-24"), 1, 1, 1);
        Prescription prescriptionForAdam = new Prescription(2, "12343432", 30.79,
                100, Date.valueOf("2023-01-19"), 2, 2, 2);

        prescriptions.add(prescriptionForDaniel);
        prescriptions.add(prescriptionForAdam);

        Appointment danielAppointment = new Appointment(1,
                Date.valueOf("2022-12-27"), 1, 2,
                1);
        Appointment adamAppointment = new Appointment(2,
                Date.valueOf("2023-01-3"), 2, 2,
                1);

        appointments.add(danielAppointment);
        appointments.add(adamAppointment);

        Examination danielExamination = new Examination(1, "Positive", 2,
                1, 1);
        Examination adamExamination = new Examination(2, "Positive", 2,
                2, 2);

        examinations.add(danielExamination);
        examinations.add(adamExamination);

        Pharmacy pharmacy = new Pharmacy(customers, employeeTypes, employees, appointmentTypes, examinationTypes,
                paymentTypes, recipes, categories, inventories, customerOrders, prescriptions, appointments,
                examinations);

        try{
            JAXBContext context = JAXBContext.newInstance(Pharmacy.class, Customer.class, EmployeeType.class,
                    Employee.class, AppointmentType.class, PaymentType.class, Recipe.class, Category.class,
                    Inventory.class, CustomerOrder.class, Prescription.class, Appointment.class, Examination.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(pharmacy, new File(System.getProperty("user.dir") + "/src/main/resources/pharmacy_output.xml"));
            LOGGER.log(MENU_LOG, "Marshalling complete");
        } catch (JAXBException e) {
            LOGGER.error(e);
        }

        // Pharmacy pharmacy1 = unmarshall();
        // LOGGER.log(MENU_LOG, pharmacy1);

    }

    public static Pharmacy unmarshall() {
        Pharmacy pharmacy = new Pharmacy();

        try{
            JAXBContext context = JAXBContext.newInstance(Pharmacy.class, Customer.class, EmployeeType.class,
                    Employee.class, AppointmentType.class, PaymentType.class, Recipe.class, Category.class,
                    Inventory.class, CustomerOrder.class, Prescription.class, Appointment.class, Examination.class);
            pharmacy = (Pharmacy) context.createUnmarshaller().unmarshal(new File(System.getProperty("user.dir") +
                    "/src/main/resources/pharmacy_output.xml"));
            LOGGER.log(MENU_LOG, "Unmarshalling complete");
        } catch (JAXBException e) {
            LOGGER.error(e);
        }

        return pharmacy;
    }
}
