package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.EmployeeType;

public interface IEmployeeTypeDAO extends IBaseDAO<EmployeeType>{
    EmployeeType getEmployeeTypeByName(String employeeType);
}
