package com.solvd.delivery.enums;

public enum StampType{

    BLUE("Blue", 0.70),
    RED("Red", 0.75),
    GREEN("Green", 0.80),
    ORANGE("Orange", 0.85);

    private String colorOfStamp;
    private double priceOfStamp;

    StampType(String colorOfStamp, double priceOfStamp) {
        this.colorOfStamp = colorOfStamp;
        this.priceOfStamp = priceOfStamp;
    }

    public String getColorName() {
        return this.colorOfStamp;
    }

    public double getPrice() {
        return this.priceOfStamp;
    }
}
