package shipment;

import insurance.*;
import mailing.*;
import person.*;

final public class Shipment {
    private Customer sender;
    private Customer recipient;
    private Insurance insurance;
    private double price;
    private double weight;
    private int days;
    private long packageNumber;

    private Mailing mailing;

    public Shipment(){

    }
    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Person getSender() {
        return this.sender;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public Person getRecipient() {
        return this.recipient;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDays(int days) {
        this.days = days;
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

    public void setPackageNumber(long packageNumber) {
        this.packageNumber = packageNumber;
    }

    public long getPackageNumber() {
        return this.packageNumber;
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
        return ("\nName of sender: " + sender.toString() +
                "\nAddress of sender: " + sender.getAddress() +
                "\nPhone number: " + sender.getPhoneNumber() +
                "\n\nName of recipient: " + recipient.toString() +
                "\nAddress of sender: " + recipient.getAddress() +
                "\nPhone number: " + recipient.getPhoneNumber() +
                "\n\nInsurance number: " + insurance.getInsuranceNumber() +
                "\n\nETA: " + this.getDays() + " Day(s)");
    }
}
