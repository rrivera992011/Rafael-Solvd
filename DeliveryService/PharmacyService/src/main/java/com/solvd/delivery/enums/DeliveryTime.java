package com.solvd.delivery.enums;

public enum DeliveryTime {
    ONE_DAY(9),
    THREE_DAYS(6),
    FIVE_DAYS(3);

    private double pricePerDay;

    DeliveryTime(double pricePerDay){
        this.pricePerDay = pricePerDay;
    }
    public double getPricePerDay(){
        return this.pricePerDay;
    }
}
