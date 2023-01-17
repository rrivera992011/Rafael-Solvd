package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Employee;

public interface IEmployeeDAO extends IBaseDAO<Employee>{
    Employee getEntityById(int id);
}
