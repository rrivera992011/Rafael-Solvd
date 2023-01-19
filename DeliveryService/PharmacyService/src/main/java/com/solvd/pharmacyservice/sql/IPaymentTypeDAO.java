package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.PaymentType;

public interface IPaymentTypeDAO extends IBaseDAO<PaymentType>{
    PaymentType getPaymentTypeWithPaymentType(String paymentTypeName);
}
