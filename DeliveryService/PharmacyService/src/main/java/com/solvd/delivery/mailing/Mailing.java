package com.solvd.delivery.mailing;

public abstract class Mailing {
    protected String packageType;
    protected double height;
    protected double width;
    protected double weight;

    public abstract String getPackageType();
    public abstract double getWeight();

}
