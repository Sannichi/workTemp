package com.nymgo.tests.utils;

import java.util.EnumMap;

import com.nymgo.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyDescriptionMap {

	private static final EnumMap<CURRENCY_SIGNS, CurrencyDescription> currencyMap = new EnumMap<CURRENCY_SIGNS, CurrencyDescription>(CURRENCY_SIGNS.class);
	
	static {
		
//		currencyMap.put(CURRENCY_SIGNS.USD, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.USD)));
//		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(7, 14, 28, 70, 84, 174, 417, 556, 834, 1112, 1668, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
//		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(7, 14, 28, 69, 83, 172, 411, 548, 822, 1096, 1644, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
//		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 9, 18, 45, 54, 112, 267, 356, 534, 712, 1068, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
//		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(350, 700, 1500, 3500, 4000, 8500, 20000, 27000, 40000, 55000, 80000, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
//		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(8, 15, 30, 75, 90, 188, 450, 600, 900, 1200, 1800, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
//		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(19, 37, 73, 182, 219, 455, 1092, 1456, 2184, 2912, 4368, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
//		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(19, 38, 75, 188, 225, 469, 1125, 1500, 2250, 3000, 4500, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
//		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(19, 37, 74, 184, 221, 459, 1101, 1468, 2202, 2936, 4404, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
//		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(4, 7, 14, 35, 42, 87, 207, 276, 414, 552, 828, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
//		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(2, 3, 6, 15, 18, 38, 90, 120, 180, 240, 360, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
//		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(21, 42, 84, 210, 252, 525, 1260, 1680, 2520, 3360, 5040, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
//		currencyMap.put(CURRENCY_SIGNS.SGD, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SGD)));
//		currencyMap.put(CURRENCY_SIGNS.AOA, new CurrencyDescription(791, 1582, 3163, 7908, 9489, 19769, 47445, 63260, 94890, 126520, 189780, "Kz", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AOA)));
//		currencyMap.put(CURRENCY_SIGNS.BND, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.BND)));
		currencyMap.put(CURRENCY_SIGNS.USD, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.USD)));
		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(7, 14, 30, 65, 80, 160, 400, 500, 800, 1000, 1500, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(7, 14, 30, 65, 80, 170, 400, 500, 800, 1000, 1500, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 19, 46, 55, 114, 273, 364, 546, 728, 1092, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(350, 700, 1500, 3500, 4000, 8500, 20000, 27000, 40000, 55000, 80000, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(8, 16, 32, 80, 90, 200, 450, 600, 900, 1200, 1800, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(20, 40, 75, 200, 250, 500, 1125, 1500, 2250, 3000, 4500, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(20, 40, 75, 200, 250, 470, 1125, 1500, 2250, 3000, 4500, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(20, 40, 75, 200, 250, 470, 1125, 1500, 2250, 3000, 4500, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(2, 4, 6, 15, 20, 40, 90, 120, 180, 240, 360, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(20, 40, 80, 200, 230, 500, 1150, 1500, 2300, 3000, 4500, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
		currencyMap.put(CURRENCY_SIGNS.SGD, new CurrencyDescription(8, 15, 29, 72, 90, 175, 450, 576, 864, 1152, 1728, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SGD)));
		currencyMap.put(CURRENCY_SIGNS.AOA, new CurrencyDescription(774, 1548, 3096, 7740, 9288, 19350, 46440, 61920, 92880, 123840, 185760, "Kz", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AOA)));
		currencyMap.put(CURRENCY_SIGNS.BND, new CurrencyDescription(8, 15, 29, 71, 85, 177, 423, 564, 846, 1128, 1692, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.BND)));
	}
	
	public static CurrencyDescription getCurrencyDescriptionByKey(CURRENCY_SIGNS currencySign){
		
		return currencyMap.get(currencySign);
	}

	public static CurrencyDescription getCurrencyDescriptionBySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		return currencyMap.get(currencySignKey);
	}
}
