package com.solvd.delivery.person;

public class Driver extends Employee{
    private String licenseNumber;

    public Driver(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }
}
