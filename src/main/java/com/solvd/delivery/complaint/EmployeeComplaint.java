package com.solvd.delivery.complaint;

import com.solvd.delivery.person.Employee;

public class EmployeeComplaint extends Complaint {
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
