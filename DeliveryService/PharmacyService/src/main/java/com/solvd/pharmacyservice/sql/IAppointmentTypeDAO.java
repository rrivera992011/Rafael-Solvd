package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.AppointmentType;

public interface IAppointmentTypeDAO extends IBaseDAO<AppointmentType>{
    AppointmentType getEntityById(int id);
}
