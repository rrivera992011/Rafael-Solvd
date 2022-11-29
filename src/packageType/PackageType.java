package packageType;

public abstract class PackageType {
    protected String packageType;
    protected double height;
    protected double width;
    protected double weight;

    public PackageType(){

    }

    public abstract String getPackageType();
    public abstract void setPackageType(String packageType);
    public abstract double getHeight();
    public abstract void setHeight(double height);
    public abstract double getWidth();
    public abstract void setWidth(double width);
    public abstract double getWeight();
    public abstract void setWeight(double weight);
}
