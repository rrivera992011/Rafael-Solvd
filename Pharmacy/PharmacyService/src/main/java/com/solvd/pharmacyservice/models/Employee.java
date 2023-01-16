package com.solvd.pharmacyservice.models;

public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String employee_number;
    private int employee_type_id;

    public int getEmployeeId() {
        return this.employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmployeeNumber() {
        return this.employee_number;
    }

    public void setEmployeeNumber(String employee_number) {
        this.employee_number = employee_number;
    }

    public int getEmployeeTypeId() {
        return this.employee_type_id;
    }

    public void setEmployeeTypeId(int employee_type_id) {
        this.employee_type_id = employee_type_id;
    }
}
