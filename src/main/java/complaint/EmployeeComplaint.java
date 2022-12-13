package main.java.complaint;

import main.java.person.Employee;

public class EmployeeComplaint extends Complaint {
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
