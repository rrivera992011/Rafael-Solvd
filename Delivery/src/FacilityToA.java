class FacilityToA {
    private String driverFirstA;
    private String driverLastA;
    private String status;

    public FacilityToA() {

    }

    public void setDriverFirstA (String driverFirstA) {
        this.driverFirstA = driverFirstA;
    }

    public String getDriverFirstA () {
        return this.driverFirstA;
    }


    public void setDriverLastA (String driverLastA) {
        this.driverLastA = driverLastA;
    }

    public String getDriverLastA () {
        return this.driverLastA;
    }
    public void setStatus (String status) {
        this.status = status;
    }

    public String getStatus () {
        return this.status;
    }

    @Override
    public String toString() {

        return this.driverLastA + ", " + this.driverFirstA;
    }


}
