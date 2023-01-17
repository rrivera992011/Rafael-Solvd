package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.CustomerOrder;

public interface ICustomerOrderDAO extends IBaseDAO<CustomerOrder> {
    CustomerOrder getEntityById(int id);
}
