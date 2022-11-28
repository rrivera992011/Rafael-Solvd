class Car implements IVehicle{
    private String vehicleName;
    private int truckNumber;


    public int getTruckNumber() {
        return this.truckNumber;
    }

    public void setTruckNumber(int truckNumber) {
        this.truckNumber = truckNumber;
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