package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "examination")
@XmlType(propOrder = {"examinationId", "examResult", "employeeId", "examinationTypeId", "customerId"})
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

    @XmlAttribute(name = "examinationId")
    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public String getExamResult() {
        return this.examResult;
    }

    @XmlElement(name = "examResult")
    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    @XmlElement(name = "employeeId")
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExaminationTypeId() {
        return this.examinationTypeId;
    }

    @XmlElement(name = "examinationTypeId")
    public void setExaminationTypeId(int examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    @XmlElement(name = "customerId")
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
