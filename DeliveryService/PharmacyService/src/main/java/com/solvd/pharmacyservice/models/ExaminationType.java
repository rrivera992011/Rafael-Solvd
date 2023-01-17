package com.solvd.pharmacyservice.models;

public class ExaminationType {
    private int examinationTypeId;
    private String examinationType;

    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    public void setExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    public String getExaminationType() {
        return this.examinationType;
    }

    public void setExaminationType(String examinationType) {
        this.examinationType = examinationType;
    }
}
