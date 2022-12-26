package com.solvd.delivery.enums;

public enum InsuranceType {
    LIGHT("Light insurance", 10),
    MEDIUM("Medium insurance", 30),
    HEAVY("Heavy insurance", 50),
    NONE("No insurance", 0);

    private String nameOfInsurance;
    private double priceOfInsurance;

    InsuranceType(String nameOfInsurance, double priceOfInsurance) {
        this.nameOfInsurance = nameOfInsurance;
        this.priceOfInsurance = priceOfInsurance;
    }

    public String getNameOfInsurance() {
        return this.nameOfInsurance;
    }

    public double getPriceOfInsurance() {
        return this.priceOfInsurance;
    }

}
