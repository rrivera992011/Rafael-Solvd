package com.solvd.pharmacyservice.models;

public class Inventory {
    private int inventory_id;
    private String medicine_name;
    private int amount_left;
    private int amount_taken;
    private int category_id;
    private double price_of_medicine;

    public int getInventoryId() {
        return this.inventory_id;
    }

    public void setInventoryId(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getMedicineName() {
        return this.medicine_name;
    }

    public void setMedicineName(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getAmountLeft() {
        return this.amount_left;
    }

    public void setAmountLeft(int amount_left) {
        this.amount_left = amount_left;
    }

    public int getAmountTaken() {
        return this.amount_taken;
    }

    public void setAmountTaken(int amount_taken) {
        this.amount_taken = amount_taken;
    }

    public int getCategoryId() {
        return this.category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public double getPriceOfMedicine() {
        return this.price_of_medicine;
    }

    public void setPriceOfMedicine(double price_of_medicine) {
        this.price_of_medicine = price_of_medicine;
    }
}
