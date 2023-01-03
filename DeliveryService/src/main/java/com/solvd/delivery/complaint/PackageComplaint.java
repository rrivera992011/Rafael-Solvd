package com.solvd.delivery.complaint;


public class PackageComplaint extends Complaint {
    private String packageNumber;

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    @Override
    public String toString(){
        return ("Complaint Number: " + getComplaintNumber() +
                "\nNumber of Package: " + packageNumber +
                "\nComplaint: " + getDescription());
    }
}
