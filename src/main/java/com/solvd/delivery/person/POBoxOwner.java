package com.solvd.delivery.person;

public class POBoxOwner extends Customer{
    private String poBox;

    public void setPOBox(String poBox) {
        this.poBox = poBox;
    }

    public String getPOBox(){
        return this.poBox;
    }

    @Override
    public String toString() {
        return (this.getLastName() + ", " + this.getFirstName() + "\n" +
                this.poBox);
    }
}
