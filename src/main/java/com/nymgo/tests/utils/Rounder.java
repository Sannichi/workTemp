package com.nymgo.tests.utils;

import java.math.BigDecimal;

/**
 * Created by Iuliia Khikmatova on Feb 19, 2016
 */
public class Rounder {

	/**
     * Round to certain number of decimals
     * 
     * @param d
     * @param decimalPlace
     * @return
     */
    public static float roundFloat(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
}
