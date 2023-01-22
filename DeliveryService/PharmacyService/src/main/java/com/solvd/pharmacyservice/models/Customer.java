package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
@XmlType(propOrder = {"customerId", "firstName", "lastName", "phoneNumber", "age", "address"})
public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String address;

    public Customer(int customerId, String firstName, String lastName, String phoneNumber, int age, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return this.customerId;
    }

    @XmlAttribute(name = "customerId")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @XmlElement(name = "phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    @XmlElement(name = "age")
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nCustomer ID = " + customerId +
                ", First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", Phone Number = '" + phoneNumber + '\'' +
                ", Age = " + age +
                ", Address = '" + address + '\'';
    }
}
