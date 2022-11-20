class LocationACheck {
    private int barCode;

    public LocationACheck() {

    }

    public void setBarCode (int barCode) {
        this.barCode = barCode;
    }

    public int getBarCode () {
        return this.barCode;
    }

    @Override
    public boolean equals(Object obj) {
        LocationACheck bar = (LocationACheck) obj;
        return (this.getBarCode() == bar.getBarCode());
    }
}
