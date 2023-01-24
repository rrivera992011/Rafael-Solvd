package com.solvd.delivery.complaint;

import com.solvd.delivery.person.Person;

public class Complaint {
    private Person person;
    private String complaintNumber;

    public enum ComplaintType{
        PACKAGE_COMPLAINT("Package complaint"),
        EMPLOYEE_COMPLAINT("Employee complaint"),
        MISC_COMPLAINT("Misc complaint");

        private String typeOfComplaint;

        ComplaintType(String typeOfComplaint){
            this.typeOfComplaint = typeOfComplaint;
        }

        public String getTypeOfComplaint() {
            return this.typeOfComplaint;
        }
    }

    private String description;

    public Person getPerson() {
        return this.person;
    }

    public String getComplaintNumber() {
        return this.complaintNumber;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setComplaintNumber(String complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

}
