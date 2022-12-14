package com.solvd.delivery.survey;


public class Survey implements ISurvey {
    private int serviceNum;
    private int efficiencyNum;
    private int friendlinessNum;

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
    public void setFriendlinessNum(int friendlinessNum) {
        this.friendlinessNum = friendlinessNum;
    }

    @Override
    public int getFriendlinessNum() {
        return this.friendlinessNum;
    }

}
