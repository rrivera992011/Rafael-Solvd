package com.solvd.delivery.shipment;

public class ShipmentCalculator {

    private double pricePerDay;
    private double stateTax;
    private double insurancePrice;

    public ShipmentCalculator(double pricePerDay, double stateTax, double insurancePrice){
        this.pricePerDay = pricePerDay;
        this.stateTax = stateTax;
        this.insurancePrice = insurancePrice;
    }

    public double calculatePackage(){
        return ((pricePerDay + (pricePerDay * stateTax)) + insurancePrice);
    }
}
