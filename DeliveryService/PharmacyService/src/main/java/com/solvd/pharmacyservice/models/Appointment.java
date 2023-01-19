package com.solvd.pharmacyservice.models;
import java.util.Date;

public class Appointment {

    private int appointmentId;
    private Date dateAndTime;
    private int customerId;
    private int employeeId;
    private int appointmentTypeId;

    public int getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDateAndTime() {
        return this.dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAppointmentTypeId() {
        return this.appointmentTypeId;
    }

    public void setAppointmentTypeId(int appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    @Override
    public String toString() {
        return "\nAppointment ID = " + appointmentId +
                ", Date and Time = " + dateAndTime +
                ", Customer ID = " + customerId +
                ", Employee Id = " + employeeId +
                ", Appointment Type ID = " + appointmentTypeId;
    }
}
