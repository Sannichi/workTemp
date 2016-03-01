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
//		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
//		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(7, 14, 27, 68, 81, 169, 405, 540, 810, 1080, 1620, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
//		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 19, 46, 55, 114, 273, 364, 546, 728, 1092, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
//		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(350, 700, 1500, 3500, 4000, 8500, 20000, 27000, 40000, 55000, 80000, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
//		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(8, 15, 30, 75, 90, 188, 450, 600, 900, 1200, 1800, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
//		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(19, 37, 73, 182, 219, 455, 1092, 1456, 2184, 2912, 4368, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
//		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(19, 38, 75, 188, 225, 469, 1125, 1500, 2250, 3000, 4500, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
//		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(19, 37, 74, 184, 221, 459, 1101, 1468, 2202, 2936, 4404, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
//		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(4, 8, 15, 36, 44, 90, 216, 288, 432, 576, 864, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
//		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(2, 3, 6, 15, 18, 38, 90, 120, 180, 240, 360, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
//		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(22, 43, 85, 211, 254, 528, 1266, 1688, 2532, 3376, 5064, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
//		currencyMap.put(CURRENCY_SIGNS.SGD, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SGD)));
//		currencyMap.put(CURRENCY_SIGNS.AOA, new CurrencyDescription(791, 1582, 3163, 7908, 9489, 19769, 47445, 63260, 94890, 126520, 189780, "Kz", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AOA)));
//		currencyMap.put(CURRENCY_SIGNS.BND, new CurrencyDescription(7, 14, 28, 70, 84, 175, 420, 560, 840, 1120, 1680, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.BND)));
		currencyMap.put(CURRENCY_SIGNS.USD, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.USD)));
		currencyMap.put(CURRENCY_SIGNS.AUD, new CurrencyDescription(7, 14, 30, 65, 80, 160, 400, 500, 800, 1000, 1500, "AU", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AUD)));
		currencyMap.put(CURRENCY_SIGNS.CAD, new CurrencyDescription(7, 14, 30, 65, 80, 170, 400, 500, 800, 1000, 1500, "C$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.CAD)));
		currencyMap.put(CURRENCY_SIGNS.EUR, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "€", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.EUR)));
		currencyMap.put(CURRENCY_SIGNS.INR, new CurrencyDescription(350, 700, 1500, 3500, 4100, 8500, 20000, 27000, 40000, 55000, 80000, "₹", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.INR)));
		currencyMap.put(CURRENCY_SIGNS.NZD, new CurrencyDescription(8, 16, 32, 80, 90, 200, 450, 600, 900, 1200, 1800, "N$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.NZD)));
		currencyMap.put(CURRENCY_SIGNS.QAR, new CurrencyDescription(20, 40, 75, 200, 250, 500, 1125, 1500, 2250, 3000, 4500, "QR", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.QAR)));
		currencyMap.put(CURRENCY_SIGNS.SAR, new CurrencyDescription(20, 40, 75, 200, 250, 500, 1125, 1500, 2250, 3000, 4500, "﷼", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SAR)));
		currencyMap.put(CURRENCY_SIGNS.AED, new CurrencyDescription(20, 40, 75, 200, 250, 500, 1125, 1500, 2250, 3000, 4500, "DH", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AED)));
		currencyMap.put(CURRENCY_SIGNS.GBP, new CurrencyDescription(5, 10, 20, 50, 60, 125, 300, 400, 600, 800, 1200, "£", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.GBP)));
		currencyMap.put(CURRENCY_SIGNS.KWD, new CurrencyDescription(2, 4, 6, 15, 20, 40, 95, 125, 185, 245, 365, "KD", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.KWD)));
		currencyMap.put(CURRENCY_SIGNS.MYR, new CurrencyDescription(20, 40, 80, 200, 260, 550, 1300, 1750, 2550, 3500, 5100, "RM", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.MYR)));
		currencyMap.put(CURRENCY_SIGNS.SGD, new CurrencyDescription(8, 15, 30, 70, 90, 175, 450, 600, 900, 1200, 1800, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.SGD)));
		currencyMap.put(CURRENCY_SIGNS.AOA, new CurrencyDescription(750, 1550, 3100, 8000, 8500, 19375, 46500, 62000, 93000, 124000, 186000, "Kz", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.AOA)));
		currencyMap.put(CURRENCY_SIGNS.BND, new CurrencyDescription(8, 15, 29, 71, 90, 175, 450, 600, 900, 1200, 1800, "$", CurrencyUtils.getConversionRate(CURRENCY_SIGNS.BND)));
	}
	
	public static CurrencyDescription getCurrencyDescriptionByKey(CURRENCY_SIGNS currencySign){
		
		return currencyMap.get(currencySign);
	}

	public static CurrencyDescription getCurrencyDescriptionBySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		return currencyMap.get(currencySignKey);
	}
}
