package insurance;

public class Insurance{
    private double insurancePrice = 0;
    private long insuranceNumber = 0;
    public Insurance() {

    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public double getInsurancePrice() {
        return this.insurancePrice;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public long getInsuranceNumber() {
        return this.insuranceNumber;
    }


}
