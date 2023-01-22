package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@XmlRootElement(name = "customer")
@XmlType(propOrder = {"customerOrderId", "orderTotal", "customerId", "orderDate", "paymentTypeId", "productId"})

public class CustomerOrder {
    private int customerOrderId;
    private double orderTotal;
    private int customerId;
    private Date orderDate;
    private int paymentTypeId;
    private int productId;

    public CustomerOrder(int customerOrderId, double orderTotal, int customerId, Date orderDate, int paymentTypeId,
                         int productId) {
        this.customerOrderId = customerOrderId;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paymentTypeId = paymentTypeId;
        this.productId = productId;
    }

    public CustomerOrder() {
    }

    public int getCustomerOrderId() {
        return this.customerOrderId;
    }

    @XmlAttribute(name = "customerOrderId")
    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public double getOrderTotal() {
        return this.orderTotal;
    }

    @XmlElement(name = "orderTotal")
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    @XmlElement(name = "customerId")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    @XmlElement(name = "orderDate")
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    @XmlElement(name = "paymentTypeId")
    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getProductId() {
        return this.productId;
    }

    @XmlElement(name = "productId")
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
