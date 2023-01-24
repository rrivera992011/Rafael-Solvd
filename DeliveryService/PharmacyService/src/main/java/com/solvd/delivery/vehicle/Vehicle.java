package com.solvd.delivery.vehicle;

public class Vehicle {

    public Vehicle(String name, String number){
        this.name = name;
        this.number = number;
    }

    private String name;
    private String number;
    public String getNumber() {
        return this.number;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return ( "\nVehicle name: " + name
        + "\n" + "Vehicle number: " + number);
    }

}
