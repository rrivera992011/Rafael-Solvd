package com.solvd.delivery.complaint;

public class MiscComplaint extends Complaint {

    private String miscDescription;

    public void setMiscDescription(String miscDescription) {

        this.miscDescription = miscDescription;
    }

    public String getMiscDescription() {
        return this.miscDescription;
    }

    @Override
    public String toString(){
        return ("Complaint Number: " + getComplaintNumber() +
                "\nType of Misc Complaint (None from any of the other choices):" + getMiscDescription() +
                "\nComplaint: " + getDescription());
    }
}
