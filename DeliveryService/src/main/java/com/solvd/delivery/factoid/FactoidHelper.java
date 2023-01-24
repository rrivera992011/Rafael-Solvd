package com.solvd.delivery.factoid;

public class FactoidHelper implements IFactoid{

    private String userFactoid;

    public void setUserFactoid(String userFactoid) {
        this.userFactoid = userFactoid;
    }

    public String getUserFactoid() {
        return this.userFactoid;
    }

    @Override
    public void outputFactoid() {

    }
}
