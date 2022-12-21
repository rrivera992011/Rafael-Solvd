package com.solvd.delivery.insurance;

public class InsuranceCalculator {

    private double insurancePrice;
    private double stateTax;

    public InsuranceCalculator(double insurancePrice, double stateTax){
        this.insurancePrice = insurancePrice;
        this.stateTax = stateTax;
    }

    public double calculateInsurance(){
        return (insurancePrice + (insurancePrice * stateTax));
    }
}