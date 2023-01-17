package com.solvd.pharmacyservice.models;

public class Inventory {
    private int inventoryId;
    private String medicineName;
    private int amountLeft;
    private int amountTaken;
    private int categoryId;
    private double priceOfMedicine;

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getAmountLeft() {
        return this.amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public int getAmountTaken() {
        return this.amountTaken;
    }

    public void setAmountTaken(int amountTaken) {
        this.amountTaken = amountTaken;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPriceOfMedicine() {
        return this.priceOfMedicine;
    }

    public void setPriceOfMedicine(double priceOfMedicine) {
        this.priceOfMedicine = priceOfMedicine;
    }
}
