class CheckForPackageFac {
    private String nameForCheck;
    private int weight;

    public CheckForPackageFac(String nameForCheck, int weight) {
        this.weight = weight;
        this.nameForCheck = nameForCheck;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return this.weight;
    }

    public void setNameForCheck(String nameForCheck) {
        this.nameForCheck = nameForCheck;
    }

    public String getNameForCheck() {
        return this.nameForCheck;
    }
    @Override
    public boolean equals(Object obj) {
        CheckForPackageFac packWeight = (CheckForPackageFac) obj;
        return (this.getWeight() == packWeight.getWeight());
    }

    @Override
    public int hashCode() {
        return 10;
    }


}
