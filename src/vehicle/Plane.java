package vehicle;

public class Plane implements IVehicle {
    private String vehicleName;
    private long planeNumber;

    public long getPlaneNumber() {
        return this.planeNumber;
    }

    public void setPlaneNumber(long planeNumber) {
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
