package com.solvd.pharmacyservice.models;

import java.util.Date;

public class Prescription {
    private int prescription_id;
    private String rx_number;
    private double price_of_prescription;
    private int amount_of_medicine;
    private Date date_filled;
    private int customer_id;
    private int inventory_id;
    private int recipe_id;

    public int getPrescriptionId() {
        return prescription_id;
    }

    public void setPrescriptionId(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getRxNumber() {
        return rx_number;
    }

    public void setRxNumber(String rx_number) {
        this.rx_number = rx_number;
    }

    public double getPriceOfPrescription() {
        return price_of_prescription;
    }

    public void setPriceOfPrescription(double price_of_prescription) {
        this.price_of_prescription = price_of_prescription;
    }

    public int getAmountOfMedicine() {
        return amount_of_medicine;
    }

    public void setAmountOfMedicine(int amount_of_medicine) {
        this.amount_of_medicine = amount_of_medicine;
    }

    public Date getDateFilled() {
        return date_filled;
    }

    public void setDateFilled(Date date_filled) {
        this.date_filled = date_filled;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getInventoryId() {
        return inventory_id;
    }

    public void setInventoryId(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getRecipeId() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }
}
