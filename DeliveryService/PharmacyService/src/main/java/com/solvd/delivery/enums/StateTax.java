package com.solvd.delivery.enums;

public enum StateTax {
    TN_STATE_TAX(0.07),
    CA_STATE_TAX(7.25),
    KY_STATE_TAX(6),
    AL_STATE_TAX(4),
    AR_STATE_TAX(6.50);

    private double percentOfTax;

    StateTax(double percentOfTax){
        this.percentOfTax = percentOfTax;
    }

    public double getPercentOfTax(){
        return this.percentOfTax;
    }
}
