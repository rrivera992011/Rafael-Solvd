package com.solvd.delivery.enums;

public enum Days {
    MONDAY ("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    final String DAY_OF_THE_WEEK;

    Days(String DAY_OF_THE_WEEK){
        this.DAY_OF_THE_WEEK = DAY_OF_THE_WEEK;
    }
    public String getDays() {
        return this.DAY_OF_THE_WEEK;
    }
}
