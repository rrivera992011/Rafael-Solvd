package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.ExaminationType;

public interface IExaminationTypeDAO extends IBaseDAO<ExaminationType> {
    ExaminationType getExaminationTypeByName(String examinationTypeName);
}
