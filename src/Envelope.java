class Envelope extends PackageType {
    private int numOfStamps;

    public void setNumOfStamps(int numOfStamps) {
        this.numOfStamps = numOfStamps;
    }

    public int getNumOfStamps() {
        return this.numOfStamps;
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
