package com.solvd.pharmacyservice;

import com.solvd.pharmacyservice.models.*;
import com.solvd.pharmacyservice.sql.jdbc.*;
import org.apache.logging.log4j.*;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    public static void main(String[] args) {



        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAll();
        LOGGER.log(MENU_LOG, customers);

        CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
        List<CustomerOrder> customerOrders = customerOrderDAO.getAll();
        LOGGER.log(MENU_LOG, customerOrders);

        AppointmentDAO appointmentDAO = new AppointmentDAO();
        List<Appointment> appointments = appointmentDAO.getAll();
        LOGGER.log(MENU_LOG, appointments);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getAll();
        LOGGER.log(MENU_LOG, employees);

        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        List<Prescription> prescriptions = prescriptionDAO.getAll();
        LOGGER.log(MENU_LOG, prescriptions);

        InventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> inventory = inventoryDAO.getAll();
        LOGGER.log(MENU_LOG, inventory);

        RecipeDAO recipeDAO = new RecipeDAO();
        List<Recipe> recipes = recipeDAO.getAll();
        LOGGER.log(MENU_LOG, recipes);

        ExaminationDAO examinationDAO = new ExaminationDAO();
        List<Examination> examinations = examinationDAO.getAll();
        LOGGER.log(MENU_LOG, examinations);

        PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, paymentTypes);

        ExaminationTypeDAO examinationTypeDAO = new ExaminationTypeDAO();
        List<ExaminationType> examinationTypes = examinationTypeDAO.getAll();
        LOGGER.log(MENU_LOG, examinationTypes);

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAll();
        LOGGER.log(MENU_LOG, categories);

        AppointmentTypeDAO appointmentTypeDAO = new AppointmentTypeDAO();
        List<AppointmentType> appointmentTypes = appointmentTypeDAO.getAll();
        LOGGER.log(MENU_LOG, appointmentTypes);

        EmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
        List<EmployeeType> employeeTypes = employeeTypeDAO.getAll();
        LOGGER.log(MENU_LOG, employeeTypes);

    }
}