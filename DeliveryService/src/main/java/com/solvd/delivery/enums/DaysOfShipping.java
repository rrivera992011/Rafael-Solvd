package com.solvd.delivery.enums;

public enum DaysOfShipping {
    ONE_DAY(9),
    THREE_DAYS(6),
    FIVE_DAYS(3);

    private final double PRICE_PER_DAY;

    DaysOfShipping(double PRICE_PER_DAY){
        this.PRICE_PER_DAY = PRICE_PER_DAY;
    }

    public double getPricePerDay(){
        return this.PRICE_PER_DAY;
    }
}
