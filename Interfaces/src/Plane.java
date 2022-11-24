class Plane implements Vehicle{

    private String vehicleName;
    private int planeNumber;

    public int getPlaneNumber() {
        return this.planeNumber;
    }

    public void setPlaneNumber(int planeNumber) {
        this.planeNumber = planeNumber;
    }

    @Override
    public String getVehicleName() {
        return this.vehicleName;
    }

    @Override
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

}
