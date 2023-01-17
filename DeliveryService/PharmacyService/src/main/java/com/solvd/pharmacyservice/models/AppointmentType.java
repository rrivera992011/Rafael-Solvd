package com.solvd.pharmacyservice.models;

public class AppointmentType {
    private int appointmentTypeId;
    private String appointmentType;

    public int getAppointmentTypeId() {
        return this.appointmentTypeId;
    }

    public void setAppointmentTypeId(int appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public String getAppointmentType() {
        return this.appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
