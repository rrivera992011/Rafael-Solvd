package packageType;

import stamps.*;

public class Envelope extends PackageType {
    private StampTotal stamps;

    public void setStamps(StampTotal stamps) {
        this.stamps = stamps;
    }

    public StampTotal getStamps() {
        return stamps;
    }

    @Override
    public String getPackageType() {
        return this.packageType;
    }

    @Override
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
