package com.solvd.delivery.enums;

public enum TypesOfStamps{

    BLUE("Blue", 0.70),
    RED("Red", 0.75),
    GREEN("Green", 0.80),
    ORANGE("Orange", 0.85);

    private final String COLOR_OF_STAMP;
    private final double PRICE_OF_STAMP;

    TypesOfStamps(String COLOR_OF_STAMP, double PRICE_OF_STAMP) {
        this.COLOR_OF_STAMP = COLOR_OF_STAMP;
        this.PRICE_OF_STAMP = PRICE_OF_STAMP;
    }

    public String getColorOfStamp() {
        return this.COLOR_OF_STAMP;
    }

    public double getPriceOfStamp() {
        return this.PRICE_OF_STAMP;
    }
}
