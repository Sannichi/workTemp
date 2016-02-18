package com.nymgo.tests.generators;

import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.enums.LOCALE_CONST;

/**
 * Created by Iuliia Khikmatova on Feb 18, 2016
 */
public class DealsCountryNameGenerator {

	public DealsCountryNameGenerator() {
		// TODO Auto-generated constructor stub
	}

	public static String getDealKeyBySign(String dealCurrency){
		
		CURRENCY_SIGNS CURR_SIGN = CURRENCY_SIGNS.valueOf(dealCurrency);
		return getDealKey(CURR_SIGN);
	}
   
	private static String getDealKey(CURRENCY_SIGNS dealSignKey){

		switch (dealSignKey)
		{
			case INR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDIA);
			case BDT:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.BANGLADESH);
			case IDR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDONESIA);
			case PKR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.PAKISTAN);
			case YER:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.YEMEN);
			case SYP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.SYRIA);
			case EGP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.EGYPT);
			case NGN:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.NIGERIA);
			case KES:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.KENYA);
			case NPR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.NEPAL);
			case LKR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.SRI_LANKA);
			case PHP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.PHILIPPINES);
			default:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDIA_DEAL);
		}
	}

}
