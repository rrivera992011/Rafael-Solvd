package com.solvd.pharmacyservice.models;

public class EmployeeType {
    private int employeeTypeId;
    private String employeeType;

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "\nEmployee Type ID = " + employeeTypeId +
                ", Employee Type = '" + employeeType + '\'';
    }

}
