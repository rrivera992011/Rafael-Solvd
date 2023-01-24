package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "inventory")
@XmlType(propOrder = {"inventoryId", "medicineName", "amountLeft", "amountTaken", "categoryId", "priceOfMedicine"})
public class Inventory {
    private int inventoryId;
    private String medicineName;
    private int amountLeft;
    private int amountTaken;
    private int categoryId;
    private double priceOfMedicine;

    public Inventory(int inventoryId, String medicineName, int amountLeft, int amountTaken, int categoryId, double priceOfMedicine) {
        this.inventoryId = inventoryId;
        this.medicineName = medicineName;
        this.amountLeft = amountLeft;
        this.amountTaken = amountTaken;
        this.categoryId = categoryId;
        this.priceOfMedicine = priceOfMedicine;
    }

    public Inventory() {
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    @XmlAttribute(name = "id")
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    @XmlElement(name = "medicineName")
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getAmountLeft() {
        return this.amountLeft;
    }

    @XmlElement(name = "amountLeft")
    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public int getAmountTaken() {
        return this.amountTaken;
    }

    @XmlElement(name = "amountTaken")
    public void setAmountTaken(int amountTaken) {
        this.amountTaken = amountTaken;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    @XmlElement(name = "categoryId")
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPriceOfMedicine() {
        return this.priceOfMedicine;
    }

    @XmlElement(name = "priceOfMedicine")
    public void setPriceOfMedicine(double priceOfMedicine) {
        this.priceOfMedicine = priceOfMedicine;
    }

    @Override
    public String toString() {
        return "\nInventory ID = " + inventoryId +
                ", Medicine Name = '" + medicineName + '\'' +
                ", Amount Left = " + amountLeft +
                ", Amount Taken = " + amountTaken +
                ", Category ID = " + categoryId +
                ", Price Of Medicine = " + priceOfMedicine;
    }
}
