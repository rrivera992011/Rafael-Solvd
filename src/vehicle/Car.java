package vehicle;

public class Car implements IVehicle {
    private String vehicleName;
    private int carNumber;


    public int getCarNumber() {
        return this.carNumber;
    }

    public void setTruckNumber(int truckNumber) {
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