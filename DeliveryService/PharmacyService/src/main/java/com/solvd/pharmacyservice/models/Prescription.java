package com.solvd.pharmacyservice.models;

import java.util.Date;

public class Prescription {
    private int prescriptionId;
    private String rxNumber;
    private double priceOfPrescription;
    private int amountOfMedicine;
    private Date dateFilled;
    private int customerId;
    private int inventoryId;
    private int recipeId;

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getRxNumber() {
        return rxNumber;
    }

    public void setRxNumber(String rxNumber) {
        this.rxNumber = rxNumber;
    }

    public double getPriceOfPrescription() {
        return priceOfPrescription;
    }

    public void setPriceOfPrescription(double priceOfPrescription) {
        this.priceOfPrescription = priceOfPrescription;
    }

    public int getAmountOfMedicine() {
        return amountOfMedicine;
    }

    public void setAmountOfMedicine(int amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }

    public Date getDateFilled() {
        return dateFilled;
    }

    public void setDateFilled(Date dateFilled) {
        this.dateFilled = dateFilled;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
