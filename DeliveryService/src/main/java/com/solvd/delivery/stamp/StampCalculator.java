package com.solvd.delivery.stamp;

public class StampCalculator {
    private double priceOfStamp;
    private int stampAmount;

    public StampCalculator(double priceOfStamp, int stampAmount){
        this.priceOfStamp = priceOfStamp;
        this.stampAmount = stampAmount;

    }

    public double calculateStamp(){
        return (priceOfStamp * stampAmount);
    }
}
