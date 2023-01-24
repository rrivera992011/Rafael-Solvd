package com.solvd.delivery.insurance;

import com.solvd.delivery.enums.InsuranceType;
import com.solvd.delivery.enums.StateTax;
import com.solvd.delivery.externaloutput.RandomOperations;

public class InsuranceUtils {

    public static double calculateInsurance(InsuranceType insuranceType, StateTax stateTax) {
        return (insuranceType.getPriceOfInsurance() * (1 + stateTax.getPercentOfTax()));
    }

    public static String getInsuranceNumber() {
        return String.valueOf(RandomOperations.getRandomNumber(10000, 999999));
    }
}