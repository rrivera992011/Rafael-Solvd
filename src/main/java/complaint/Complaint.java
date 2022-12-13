package main.java.complaint;

import main.java.person.Person;

public class Complaint {
    private Person person;
    private long complaintNumber;
    private String baseComplaintType;

    private String complaint;

    public Person getPerson() {
        return this.person;
    }

    public long getComplaintNumber() {
        return this.complaintNumber;
    }

    public String getBaseComplaintType() {
        return this.baseComplaintType;
    }

    public String getComplaint() {
        return this.complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setComplaintNumber(long complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public void setBaseComplaintType(String baseComplaintType) {
        this.baseComplaintType = baseComplaintType;
    }
}
