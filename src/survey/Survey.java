package survey;


public class Survey implements ISurvey {
    private int serviceNum;
    private int efficiencyNum;
    private int staffNum;

    @Override
    public int getServiceNum() {
        return this.serviceNum;
    }

    @Override
    public void setServiceNum(int serviceNum) {
        this.serviceNum = serviceNum;
    }

    @Override
    public int getEfficiencyNum() {
        return this.efficiencyNum;
    }

    @Override
    public void setEfficiencyNum(int efficiencyNum) {
        this.efficiencyNum = efficiencyNum;
    }

    @Override
    public int getStaffNum() {
        return this.staffNum;
    }

    @Override
    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }
}
