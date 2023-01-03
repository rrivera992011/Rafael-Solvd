package com.solvd.delivery.shipment;

import com.solvd.delivery.insurance.*;
import com.solvd.delivery.mailing.*;
import com.solvd.delivery.person.*;

final public class Shipment {
    private Customer sender;
    private Customer recipient;
    private Insurance insurance;
    private double price;
    private double weight;
    private int days;
    private String packageNumber;

    private Mailing mailing;

    public Shipment(Customer sender, Customer recipient, Insurance insurance, double price, int days, String packageNumber){
        this.sender = sender;
        this.recipient = recipient;
        this.insurance = insurance;
        this.price = price;
        this.days = days;
        this.packageNumber = packageNumber;

    }
    public Person getSender() {
        return this.sender;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }

    public int getDays() {
        return this.days;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }


    public void setMailing(Mailing mailing) {
        this.mailing = mailing;
    }

    public Mailing getMailing() {
        return this.mailing;
    }

    public boolean equals(Object obj) {
        Shipment shipment = (Shipment) obj;
        return (this.getWeight() == shipment.getWeight());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return ("\nSender information: " + sender.toString() +
                "\nRecipient information: " + recipient.toString() +
                "\n\nInsurance number: " + insurance.getInsuranceNumber() +
                "\nTotal: " + this.price +
                "\nPackage number: " + this.packageNumber +
                "\n\nETA: " + this.days + " Day(s)");
    }
}
