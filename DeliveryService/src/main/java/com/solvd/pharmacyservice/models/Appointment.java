package com.solvd.pharmacyservice.models;
import java.sql.Date;

public class Appointment {

    private int appointmentId;
    private Date appointmentDate;
    private int customerId;
    private int employeeId;
    private int appointmentTypeId;

    public Appointment(){

    }

    public Appointment(int appointmentId, Date appointmentDate, int customerId, int employeeId, int appointmentTypeId) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.appointmentTypeId = appointmentTypeId;
    }

    public int getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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
                ", Appointment Date = " + appointmentDate +
                ", Customer ID = " + customerId +
                ", Employee Id = " + employeeId +
                ", Appointment Type ID = " + appointmentTypeId;
    }
}
