package com.solvd.delivery.mailing;

import com.solvd.delivery.stamp.*;

import java.util.ArrayList;

public class Envelope extends Mailing {
    private ArrayList<Stamp> stamps = new ArrayList<>();
    int numberOfStamps;

    public void setStampArrayList(ArrayList<Stamp> stamps) {
        this.stamps = stamps;
    }

    public ArrayList<Stamp> getStampArrayList() {
        return this.stamps;
    }

    public void setNumberOfStamps(int numberOfStamps) {
        this.numberOfStamps = numberOfStamps;
    }

    public int getNumberOfStamps() {
        return this.numberOfStamps;
    }

    @Override
    public String getPackageType() {
        return this.packageType;
    }

    @Override
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
