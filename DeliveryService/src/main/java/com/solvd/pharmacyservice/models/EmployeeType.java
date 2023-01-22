package com.solvd.pharmacyservice.models;

public class EmployeeType{
    private int employeeTypeId;
    private String employeeTypeName;

    public EmployeeType() {
    }

    public EmployeeType(int employeeTypeId, String employeeTypeName) {
        this.employeeTypeId = employeeTypeId;
        this.employeeTypeName = employeeTypeName;
    }

    public int getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return this.employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName= employeeTypeName;
    }

    @Override
    public String toString() {
        return "\nEmployee Type ID = " + employeeTypeId +
                ", Employee Type Name = '" + employeeTypeName + '\'';
    }

}
