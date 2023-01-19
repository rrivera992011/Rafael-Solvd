package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Appointment;

public interface IAppointmentDAO extends IBaseDAO<Appointment>{
    Appointment getAppointmentByFirstName(String firstName);
    void deleteAppointmentByLastName(String lastName);
}
