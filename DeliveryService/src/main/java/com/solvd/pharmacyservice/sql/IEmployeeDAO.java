package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Customer;
import com.solvd.pharmacyservice.models.Employee;

public interface IEmployeeDAO extends IBaseDAO<Employee>{
    void updateEmployeeTypeIDWithLastName(Employee employee);
}
