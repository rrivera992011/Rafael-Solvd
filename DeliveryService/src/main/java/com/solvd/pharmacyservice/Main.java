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
        EmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Customer adam = new Customer(1, "Adam", "Jones", "5467896543", 17,
                "12 Easy Street" );
        customerDAO.createEntity(adam);
        adam.setAddress("12 East Road");
        customerDAO.updateEntity(adam);
        List<Customer> customers = customerDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + customers);
        LOGGER.log(MENU_LOG, "Testing out id" + customerDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out last name" + customerDAO.getCustomerByLastName("Jones"));

        EmployeeType clerk = new EmployeeType(1, "Clerk");
        employeeTypeDAO.createEntity(clerk);
        clerk.setEmployeeTypeName("Counter clerk");
        employeeTypeDAO.updateEntity(clerk);
        List<EmployeeType> employeeTypes = employeeTypeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employeeTypes);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeTypeDAO.getEntityById(1));

        Employee michael = new Employee(1, "Michael", "Morris",
                "123443223", 1);
        employeeDAO.createEntity(michael);
        List<Employee> employees = employeeDAO.getAll();
        LOGGER.log(MENU_LOG, "Testing out get all " + employees);
        LOGGER.log(MENU_LOG, "Testing out id" + employeeDAO.getEntityById(1));

        employeeDAO.removeEntity(1);
        employeeTypeDAO.removeEntity(1);
        customerDAO.removeEntity(1);

        LOGGER.log(MENU_LOG, "Testing out id" + employeeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + employeeTypeDAO.getEntityById(1));
        LOGGER.log(MENU_LOG, "Testing out id" + customerDAO.getEntityById(1));
    }
}