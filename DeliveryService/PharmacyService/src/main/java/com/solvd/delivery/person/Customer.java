package com.solvd.delivery.person;

public class Customer extends Person {

    private String address;
    private String phoneNumber;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return (getFirstName() + ", " + getLastName()
                + "\n" + "Address: " + address +
                "\n" + "Phone number: " + phoneNumber);
    }
}
