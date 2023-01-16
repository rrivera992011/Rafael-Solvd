package com.solvd.pharmacyservice.models;
import java.util.Date;

public class Appointment {

    private int appointment_id;
    private Date date;
    private int customer_id;
    private int employee_id;
    private int appointment_type_id;

    public int getAppointmentId() {
        return this.appointment_id;
    }

    public void setAppointmentId(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployeeId() {
        return this.employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getAppointmentTypeId() {
        return this.appointment_type_id;
    }

    public void setAppointmentTypeId(int appointment_type_id) {
        this.appointment_type_id = appointment_type_id;
    }
}
