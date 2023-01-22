package com.solvd.pharmacyservice.models;

public class AppointmentType {
    private int appointmentTypeId;
    private String appointmentTypeName;

    public AppointmentType(int appointmentTypeId, String appointmentTypeName) {
        this.appointmentTypeId = appointmentTypeId;
        this.appointmentTypeName = appointmentTypeName;
    }

    public AppointmentType() {

    }

    public int getAppointmentTypeId() {
        return this.appointmentTypeId;
    }

    public void setAppointmentTypeId(int appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public String getAppointmentTypeName() {
        return this.appointmentTypeName;
    }

    public void setAppointmentTypeName(String appointmentTypeName) {
        this.appointmentTypeName = appointmentTypeName;
    }

    @Override
    public String toString() {
        return "\nAppointment Type ID = " + appointmentTypeId +
                ", Appointment Type Name = '" + appointmentTypeName + '\'';
    }
}
