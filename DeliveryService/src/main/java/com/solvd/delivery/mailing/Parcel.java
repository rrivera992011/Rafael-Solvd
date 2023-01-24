package com.solvd.delivery.mailing;

public class Parcel extends Mailing {
    private boolean fragility;

    public Parcel(double weight, double height, double width, String packageType, boolean fragility){
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.packageType = packageType;
        this.fragility = fragility;
    }

    public boolean getFragility(){
        return this.fragility;
    }

    @Override
    public String getPackageType() {
        return this.packageType;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

}
