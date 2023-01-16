package com.solvd.pharmacyservice.models;

import java.util.Date;

public class CustomerOrder {
    private int customer_order_id;
    private double order_total;
    private int customer_id;
    private Date order_date;
    private int payment_type_id;
    private int product_id;

    public int getCustomerOrderId() {
        return this.customer_order_id;
    }

    public void setCustomerOrderId(int customer_order_id) {
        this.customer_order_id = customer_order_id;
    }

    public double getOrderTotal() {
        return this.order_total;
    }

    public void setOrderTotal(double order_total) {
        this.order_total = order_total;
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrderDate() {
        return this.order_date;
    }

    public void setOrderDate(Date order_date) {
        this.order_date = order_date;
    }

    public int getPaymentTypeId() {
        return this.payment_type_id;
    }

    public void setPaymentTypeId(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public int getProductId() {
        return this.product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
}
