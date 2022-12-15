package com.solvd.delivery.insurance;

import java.util.Map;

public class Insurance{
    private Map<String, Double> insuranceDetails;
    private long insuranceNumber = 0;
    public Insurance() {

    }

    public void setInsuranceDetails(Map<String, Double> insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public Map<String, Double> getInsuranceDetails() {
        return this.insuranceDetails;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public long getInsuranceNumber() {
        return this.insuranceNumber;
    }


}
