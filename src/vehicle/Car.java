package vehicle;

public class Car implements IVehicle {
    private String vehicleName;
    private long carNumber;


    public long getCarNumber() {
        return this.carNumber;
    }

    public void setTruckNumber(long truckNumber) {
        this.carNumber = truckNumber;
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