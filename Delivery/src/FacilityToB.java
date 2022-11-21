class FacilityToB {
    private String driverFirstB;
    private String driverLastB;
    private String statusB;

    public FacilityToB() {

    }

    public void setDriverFirstB (String driverFirstB) {
        this.driverFirstB = driverFirstB;
    }

    public String getDriverFirstB() {
        return this.driverFirstB;
    }


    public void setDriverLastB(String driverLastB) {
        this.driverLastB = driverLastB;
    }

    public String getDriverLastB() {
        return this.driverLastB;
    }

    public void setStatusB (String statusB) {
        this.statusB = statusB;
    }

    public String getStatusB () {
        return this.statusB;
    }

    @Override
    public String toString() {
        return this.driverLastB + ", " + this.driverFirstB;
    }


}
