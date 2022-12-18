package com.solvd.delivery.enums;

public enum StateTax {
    STATE_TAX(0.07);

    private final double TN_STATE_TAX;

    StateTax(double TN_STATE_TAX){
        this.TN_STATE_TAX = TN_STATE_TAX;
    }

    public double getPercentOfTax(){
        return this.TN_STATE_TAX;
    }
}
