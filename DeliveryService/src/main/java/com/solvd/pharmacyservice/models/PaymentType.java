package com.solvd.pharmacyservice.models;

public class PaymentType {
    private int paymentTypeId;
    private String paymentTypeName;

    public PaymentType(int paymentTypeId, String paymentTypeName) {
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    public PaymentType() {
    }

    public int getPaymentTypeId() {
        return this.paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return this.paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "\nPayment Type ID = " + paymentTypeId +
                ", Payment Type = '" + paymentTypeName + '\'';
    }
}
