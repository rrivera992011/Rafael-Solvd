package com.solvd.delivery.enums;

public enum DayOfTheWeek {
    MONDAY ("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String day;

    DayOfTheWeek(String day){
        this.day = day;
    }
    public String getDays() {
        return this.day;
    }
}
