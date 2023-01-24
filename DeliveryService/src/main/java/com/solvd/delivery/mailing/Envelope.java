package com.solvd.delivery.mailing;

import com.solvd.delivery.stamp.*;

import java.util.ArrayList;

public class Envelope extends Mailing {
    private ArrayList<Stamp> stamps;
    public Envelope(double weight, double height, double width, String packageType, ArrayList<Stamp> stamps){
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.packageType = packageType;
        this.stamps = stamps;
    }

    public ArrayList<Stamp> getStampArrayList() {
        return this.stamps;
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
