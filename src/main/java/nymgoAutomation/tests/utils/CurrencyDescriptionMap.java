package nymgoAutomation.tests.utils;

import java.util.EnumMap;

import nymgoAutomation.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyDescriptionMap {

	private static final EnumMap<CURRENCY_SIGNS, CurrencyDescription> currencyMap = new EnumMap<CURRENCY_SIGNS, CurrencyDescription>(CURRENCY_SIGNS.class);
	
	static {
		
		currencyMap.put(CURRENCY_SIGNS.USD, new CurrencyDescription(5, 10, 10, 20, 50, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.USD)));
		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(5, 10, 14, 30, 65, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(5, 10, 14, 30, 65, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 10, 20, 50, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(5, 10, 500, 1000, 2500, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(5, 10, 16, 32, 80, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(5, 10, 40, 75, 200, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(5, 10, 40, 75, 200, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(5, 10, 40, 75, 200, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(5, 10, 10, 20, 50, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(5, 10, 4, 6, 15, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(5, 10, 40, 80, 200, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
	}
	
	public static CurrencyDescription getCurrencyDescriptionByKey(CURRENCY_SIGNS currencySign){
		
		return currencyMap.get(currencySign);
	}

	public static CurrencyDescription getCurrencyDescriptionBySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		return currencyMap.get(currencySignKey);
	}
}
