package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@XmlRootElement(name = "prescription")
@XmlType(propOrder = {"prescriptionId", "rxNumber", "priceOfPrescription", "amountOfMedicine", "dateFilled",
        "customerId", "inventoryId", "recipeId"})
public class Prescription {
    private int prescriptionId;
    private String rxNumber;
    private double priceOfPrescription;
    private int amountOfMedicine;
    private Date dateFilled;
    private int customerId;
    private int inventoryId;
    private int recipeId;

    public Prescription(int prescriptionId, String rxNumber, double priceOfPrescription, int amountOfMedicine,
                        Date dateFilled, int customerId, int inventoryId, int recipeId) {
        this.prescriptionId = prescriptionId;
        this.rxNumber = rxNumber;
        this.priceOfPrescription = priceOfPrescription;
        this.amountOfMedicine = amountOfMedicine;
        this.dateFilled = dateFilled;
        this.customerId = customerId;
        this.inventoryId = inventoryId;
        this.recipeId = recipeId;
    }

    public Prescription() {
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    @XmlAttribute(name = "id")
    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getRxNumber() {
        return rxNumber;
    }

    @XmlElement(name = "rxNumber")
    public void setRxNumber(String rxNumber) {
        this.rxNumber = rxNumber;
    }

    public double getPriceOfPrescription() {
        return priceOfPrescription;
    }

    @XmlElement(name = "priceOfPrescription")
    public void setPriceOfPrescription(double priceOfPrescription) {
        this.priceOfPrescription = priceOfPrescription;
    }

    public int getAmountOfMedicine() {
        return amountOfMedicine;
    }

    @XmlElement(name = "amountOfMedicine")
    public void setAmountOfMedicine(int amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }

    public Date getDateFilled() {
        return dateFilled;
    }

    @XmlElement(name = "dateFilled")
    public void setDateFilled(Date dateFilled) {
        this.dateFilled = dateFilled;
    }

    public int getCustomerId() {
        return customerId;
    }

    @XmlElement(name = "customerId")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    @XmlElement(name = "inventoryId")
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    @XmlElement(name = "recipeId")
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "\nPrescription ID = " + prescriptionId +
                ", RX Number = '" + rxNumber + '\'' +
                ", Price Of Prescription = " + priceOfPrescription +
                ", Amount Of Medicine = " + amountOfMedicine +
                ", Date Filled = " + dateFilled +
                ", Customer ID = " + customerId +
                ", Inventory ID = " + inventoryId +
                ", Recipe ID = " + recipeId;
    }
}
