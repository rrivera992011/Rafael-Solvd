package com.solvd.delivery.enums;

public enum InsuranceData {
    LIGHT("Light insurance", 10),
    MEDIUM("Medium insurance", 30),
    HEAVY("Heavy insurance", 50),
    NONE("No insurance", 0);

    private final String NAME_OF_INSURANCE;
    private final double PRICE_OF_INSURANCE;

    InsuranceData(String NAME_OF_INSURANCE, double PRICE_OF_INSURANCE) {
        this.NAME_OF_INSURANCE = NAME_OF_INSURANCE;
        this.PRICE_OF_INSURANCE = PRICE_OF_INSURANCE;
    }

    public String getNameOfInsurance() {
        return this.NAME_OF_INSURANCE;
    }

    public double getPriceOfInsurance() {
        return this.PRICE_OF_INSURANCE;
    }

}
