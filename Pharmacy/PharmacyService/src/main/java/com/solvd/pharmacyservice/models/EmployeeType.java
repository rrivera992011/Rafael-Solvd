package com.solvd.pharmacyservice.models;

public class EmployeeType {
    private int employee_type_id;
    private String employee_type;

    public int getEmployeeTypeId() {
        return this.employee_type_id;
    }

    public void setEmployeeTypeId(int employee_type_id) {
        this.employee_type_id = employee_type_id;
    }

    public String getEmployeeType() {
        return this.employee_type;
    }

    public void setEmployeeType(String employee_type) {
        this.employee_type = employee_type;
    }
}
