package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer> {
    Customer getEntityById(int id);
}
