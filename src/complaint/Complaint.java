package complaint;

public class Complaint {
    private String complaintName;
    private int complaintNumber;
    private String baseComplaintType;

    private String complaint;

    public String getComplaintName() {
        return this.complaintName;
    }

    public int getComplaintNumber() {
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

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    public void setComplaintNumber(int complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public void setBaseComplaintType(String baseComplaintType) {
        this.baseComplaintType = baseComplaintType;
    }
}
