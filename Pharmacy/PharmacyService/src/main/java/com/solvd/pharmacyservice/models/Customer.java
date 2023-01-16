package com.solvd.pharmacyservice.models;

public class Customer {

    private int customer_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private int age;
    private String address;

    public int getCustomerId() {
        return this.customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
