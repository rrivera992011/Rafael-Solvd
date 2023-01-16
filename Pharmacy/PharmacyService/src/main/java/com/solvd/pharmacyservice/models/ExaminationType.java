package com.solvd.pharmacyservice.models;

public class ExaminationType {
    private int examination_type_id;
    private String examination_type;

    public int getExaminationTypeId() {
        return this.examination_type_id;
    }

    public void setExaminationTypeId(int examination_type_id) {
        this.examination_type_id = examination_type_id;
    }

    public String getExaminationType() {
        return this.examination_type;
    }

    public void setExaminationType(String examination_type) {
        this.examination_type = examination_type;
    }
}
