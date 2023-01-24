package com.solvd.delivery.insurance;

import java.util.Map;

public class Insurance{
    private Map<String, Double> insuranceDetails;
    private String insuranceNumber;
    public Insurance() {

    }

    public void setInsuranceDetails(Map<String, Double> insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }
    public Map<String, Double> getInsuranceDetails() {
        return this.insuranceDetails;
    }
    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }
}