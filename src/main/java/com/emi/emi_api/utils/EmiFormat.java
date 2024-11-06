package com.emi.emi_api.utils;

import java.text.DecimalFormat;

public class EmiFormat {

     public static double roundToTwoDecimals(double value) {       
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(value));
    }
}
