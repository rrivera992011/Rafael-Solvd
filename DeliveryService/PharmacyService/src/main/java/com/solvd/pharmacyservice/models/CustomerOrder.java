package com.solvd.pharmacyservice.models;

import java.util.Date;

public class CustomerOrder {
    private int customerOrderId;
    private double orderTotal;
    private int customerId;
    private Date orderDate;
    private int paymentTypeId;
    private int productId;

    public int getCustomerOrderId() {
        return this.customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public double getOrderTotal() {
        return this.orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "\nCustomer Order ID = " + customerOrderId +
                ", Order Total = " + orderTotal +
                ", Customer ID = " + customerId +
                ", Order Date = " + orderDate +
                ", Payment Type ID=" + paymentTypeId +
                ", Product ID = " + productId;
    }
}
