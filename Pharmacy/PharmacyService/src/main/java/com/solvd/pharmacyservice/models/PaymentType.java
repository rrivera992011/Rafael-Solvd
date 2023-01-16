package com.solvd.pharmacyservice.models;

public class PaymentType {
    private int payment_type_id;
    private String payment_type;

    public int getPaymentTypeId() {
        return this.payment_type_id;
    }

    public void setPaymentTypeId(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getPaymentType() {
        return this.payment_type;
    }

    public void setPaymentType(String payment_type) {
        this.payment_type = payment_type;
    }
}
