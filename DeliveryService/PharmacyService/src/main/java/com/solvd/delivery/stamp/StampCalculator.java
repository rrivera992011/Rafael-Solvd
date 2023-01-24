package com.solvd.delivery.stamp;

import com.solvd.delivery.enums.StampType;

public class StampCalculator {

    public static double calculateStamp(StampType stampType, int stampAmount){
        return (stampType.getPrice() * stampAmount);
    }
}
