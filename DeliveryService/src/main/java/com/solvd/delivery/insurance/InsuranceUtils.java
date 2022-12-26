package com.solvd.delivery.insurance;

import com.solvd.delivery.enums.InsuranceType;
import com.solvd.delivery.enums.StateTax;

import static com.solvd.delivery.Main.getRandomNumber;

public class InsuranceUtils {

    public static double calculateInsurance(InsuranceType insuranceType, StateTax stateTax) {
        return (insuranceType.getPriceOfInsurance() * (1 + stateTax.getPercentOfTax()));
    }

    public static int getInsuranceNumber() {
        return getRandomNumber(10000, 999999);
    }
}