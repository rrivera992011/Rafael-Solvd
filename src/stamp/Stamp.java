package stamp;

public class Stamp implements IStamp {
    private int stampNum;
    private double stampTotal;

    @Override
    public void setStampNum(int stampNum) {
        this.stampNum = stampNum;
    }

    @Override
    public int getStampNum() {
        return this.stampNum;
    }

    @Override
    public void setStampTotal(double stampTotal) {
        this.stampTotal = stampTotal;
    }

    @Override
    public double getStampTotal() {
        return this.stampTotal;
    }
}
