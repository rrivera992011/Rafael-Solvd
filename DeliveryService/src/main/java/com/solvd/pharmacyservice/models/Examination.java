package com.solvd.pharmacyservice.models;

public class Examination {
    private int examinationId;
    private String examResult;
    private int employeeId;
    private int examinationTypeId;
    private int customerId;

    public Examination(int examinationId, String examResult, int employeeId, int examinationTypeId, int customerId) {
        this.examinationId = examinationId;
        this.examResult = examResult;
        this.employeeId = employeeId;
        this.examinationTypeId = examinationTypeId;
        this.customerId = customerId;
    }

    public Examination() {
    }

    public int getExaminationId() {
        return this.examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public String getExamResult() {
        return this.examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    public void setExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "\nExamination ID = " + examinationId +
                ", Exam Result = '" + examResult + '\'' +
                ", Employee ID = " + employeeId +
                ", Examination Type ID = " + examinationTypeId +
                ", Customer ID = " + customerId;
    }
}
