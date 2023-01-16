package com.solvd.pharmacyservice.models;

public class Examination {
    private int examination_id;
    private String exam_result;
    private int employee_id;
    private int examination_type_id;
    private int customer_id;

    public int getExaminationId() {
        return this.examination_id;
    }

    public void setExaminationId(int examination_id) {
        this.examination_id = examination_id;
    }

    public String getExamResult() {
        return this.exam_result;
    }

    public void setExamResult(String exam_result) {
        this.exam_result = exam_result;
    }

    public int getEmployeeId() {
        return this.employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getExaminationTypeId() {
        return this.examination_type_id;
    }

    public void setExaminationTypeId(int examination_type_id) {
        this.examination_type_id = examination_type_id;
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }
}
