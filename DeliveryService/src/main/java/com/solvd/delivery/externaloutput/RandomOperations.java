package com.solvd.delivery.externaloutput;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomOperations {
    public static int getRandomNumber(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }

    public static DecimalFormat getDecimalFormat(String pattern){
        final DecimalFormat df = new DecimalFormat(pattern);
        df.setRoundingMode(RoundingMode.UP);
        return df;
    }
}
