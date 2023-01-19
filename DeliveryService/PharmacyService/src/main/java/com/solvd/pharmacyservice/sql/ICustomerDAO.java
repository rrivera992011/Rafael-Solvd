package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer> {
    Customer getCustomerByLastName(String lastName);
}
