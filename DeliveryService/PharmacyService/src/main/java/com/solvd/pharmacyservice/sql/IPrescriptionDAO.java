package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Prescription;

public interface IPrescriptionDAO extends IBaseDAO<Prescription>{
    Prescription getEntityById(int id);
}
