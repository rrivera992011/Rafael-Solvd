package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employeeType")
@XmlType(propOrder = {"employeeTypeId", "employeeTypeName"})
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

    @XmlAttribute(name = "employeeTypeId")
    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return this.employeeTypeName;
    }

    @XmlElement(name = "employeeTypeName")
    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName= employeeTypeName;
    }

    @Override
    public String toString() {
        return "\nEmployee Type ID = " + employeeTypeId +
                ", Employee Type Name = '" + employeeTypeName + '\'';
    }

}
