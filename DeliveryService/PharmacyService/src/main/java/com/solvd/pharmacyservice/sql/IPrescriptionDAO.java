package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Prescription;

public interface IPrescriptionDAO extends IBaseDAO<Prescription>{
    Prescription getPrescriptionByRxNumber(String rxNumber);
    Prescription getPrescriptionByCustomerId(int customerId);
}
