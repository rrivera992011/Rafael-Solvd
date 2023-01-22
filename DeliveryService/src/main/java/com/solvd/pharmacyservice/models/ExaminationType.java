package com.solvd.pharmacyservice.models;

public class ExaminationType {
    private int examinationTypeId;
    private String examinationTypeName;

    public ExaminationType(int examinationTypeId, String examinationTypeName) {
        this.examinationTypeId = examinationTypeId;
        this.examinationTypeName = examinationTypeName;
    }

    public ExaminationType() {
    }

    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    public void setExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    public String getExaminationTypeName() {
        return this.examinationTypeName;
    }

    public void setExaminationTypeName(String examinationTypeName) {
        this.examinationTypeName = examinationTypeName;
    }

    @Override
    public String toString() {
        return "\nExamination Type ID = " + examinationTypeId +
                ", Examination Type Name = '" + examinationTypeName + '\'';
    }
}
