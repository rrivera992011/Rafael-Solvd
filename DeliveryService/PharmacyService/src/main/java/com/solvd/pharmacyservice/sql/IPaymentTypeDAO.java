package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.PaymentType;

public interface IPaymentTypeDAO extends IBaseDAO<PaymentType>{
    PaymentType getEntityById(int id);
}
