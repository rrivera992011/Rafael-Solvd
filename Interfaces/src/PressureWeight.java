class PressureWeight {
    private String checkingName;
    private double weight;

    public PressureWeight(String checkingName, double weight) {
        this.weight = weight;
        this.checkingName = checkingName;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }

    public void setCheckingName(String checkingName) {
        this.checkingName = checkingName;
    }

    public String getCheckingName() {
        return this.checkingName;
    }
    @Override
    public boolean equals(Object obj) {
        PressureWeight packWeight = (PressureWeight) obj;
        return (this.getWeight() == packWeight.getWeight());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
