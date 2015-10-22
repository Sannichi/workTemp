package nymgoAutomation.tests.utils;

import nymgoAutomation.tests.enums.CURRENCY_SIGNS;
import nymgoAutomation.tests.generators.CurrencyConversionRateGenerator;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyUtils {

	public static String getMinBuyCurrencyValue(String paymentCurrency){
		
		return String.valueOf(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getFirstValue());
	}
	
	public static String getConversionRateByCurrencyName(String paymentCurrency){
		
		CURRENCY_SIGNS currencySign = CURRENCY_SIGNS.valueOf(paymentCurrency);
		return CurrencyConversionRateGenerator.getConversionRate(currencySign);
	}

	public static String getConversionRate(CURRENCY_SIGNS currencySign){
		
		return CurrencyConversionRateGenerator.getConversionRate(currencySign);
	}
}
