package com.nymgo.tests.utils;

import java.util.EnumMap;

import com.nymgo.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyDescriptionMap {

	private static final EnumMap<CURRENCY_SIGNS, CurrencyDescription> currencyMap = new EnumMap<CURRENCY_SIGNS, CurrencyDescription>(CURRENCY_SIGNS.class);
	
	static {
		
		currencyMap.put(CURRENCY_SIGNS.USD, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.USD)));
		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(8, 15, 29, 71, 85, 177, 423, 564, 846, 1128, 1692, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 19, 46, 55, 114, 273, 364, 546, 728, 1092, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(350, 700, 1500, 3500, 4000, 8500, 20000, 27000, 40000, 55000, 80000, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(8, 16, 31, 77, 92, 192, 459, 612, 918, 1224, 1836, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(19, 37, 73, 182, 218, 454, 1089, 1452, 2178, 2904, 4356, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(19, 38, 75, 188, 225, 469, 1125, 1500, 2250, 3000, 4500, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(19, 37, 74, 184, 221, 459, 1101, 1468, 2202, 2936, 4404, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(4, 7, 14, 35, 42, 87, 207, 276, 414, 552, 828, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(2, 3, 6, 15, 18, 38, 90, 120, 180, 240, 360, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(21, 42, 84, 210, 252, 525, 1260, 1680, 2520, 3360, 5040, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
		currencyMap.put(CURRENCY_SIGNS.SGD, new CurrencyDescription(8, 15, 29, 71, 86, 178, 426, 568, 852, 1136, 1704, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SGD)));
		currencyMap.put(CURRENCY_SIGNS.AOA, new CurrencyDescription(775, 1549, 3097, 7742, 9291, 19355, 46452, 61936, 92904, 123872, 185808, "Kz", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AOA)));
		currencyMap.put(CURRENCY_SIGNS.BND, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.BND)));
	}
	
	public static CurrencyDescription getCurrencyDescriptionByKey(CURRENCY_SIGNS currencySign){
		
		return currencyMap.get(currencySign);
	}

	public static CurrencyDescription getCurrencyDescriptionBySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		return currencyMap.get(currencySignKey);
	}
}
