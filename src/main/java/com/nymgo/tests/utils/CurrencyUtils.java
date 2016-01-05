package com.nymgo.tests.utils;

import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.generators.CurrencyConversionRateGenerator;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyUtils {

	public static String getMinNormalUserBuyCurrencyValue(String paymentCurrency){
		
		return String.valueOf(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getFirstNormalValue());
	}
	
	public static String getMinResellerBuyCurrencyValue(String paymentCurrency){
		
		return String.valueOf(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getFirstReselerValue());
	}
	
	public static String getSecondNormalUserBuyCurrencyValue(String paymentCurrency){
		
		return String.valueOf(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getSecondNormalValue());
	}
	
	public static String getSecondResellerBuyCurrencyValue(String paymentCurrency){
		
		return String.valueOf(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getSecondReselerValue());
	}
	
	public static String getConversionRateByCurrencyName(String paymentCurrency){
		
		CURRENCY_SIGNS currencySign = CURRENCY_SIGNS.valueOf(paymentCurrency);
		return CurrencyConversionRateGenerator.getConversionRate(currencySign);
	}

	public static String getConversionRate(CURRENCY_SIGNS currencySign){
		
		return CurrencyConversionRateGenerator.getConversionRate(currencySign);
	}

	public static String getStringCurrencyValueFromFloat(Float amount){
		
		String stringValue = Float.toString(amount);
		String[] fullAray = stringValue.split("\\.");
		String beforeDot = fullAray[0];
		String afterDot = fullAray[1];
		char[] charArray = afterDot.toCharArray();
		for (char a : charArray){
			if (a != '0'){
				return stringValue;
			}
		}
		return beforeDot;
	}
}
