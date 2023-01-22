package com.solvd.pharmacyservice.models;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private int employeeTypeId;

    public Employee(int employeeId, String firstName, String lastName, String employeeNumber, int employeeTypeId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.employeeTypeId = employeeTypeId;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    @Override
    public String toString() {
        return "\nEmployee ID = " + employeeId +
                ", First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", Employee Number = '" + employeeNumber + '\'' +
                ", Employee Type ID = " + employeeTypeId;
    }
}
