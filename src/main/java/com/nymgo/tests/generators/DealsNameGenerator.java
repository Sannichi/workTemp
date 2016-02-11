package com.nymgo.tests.generators;

import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.enums.LOCALE_CONST;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class DealsNameGenerator {

	public DealsNameGenerator() {
		// TODO Auto-generated constructor stub
	}

	public static String getDealKeyBySign(String dealCurrencySign){
		
		CURRENCY_SIGNS CURR_SIGN = CURRENCY_SIGNS.valueOf(dealCurrencySign);
		return getDealKey(CURR_SIGN);
	}
   
	private static String getDealKey(CURRENCY_SIGNS dealSignKey){

		switch (dealSignKey)
		{
			case INR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDIA_DEAL);
			case BDT:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.BANGLADESH_DEAL);
			case IDR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDONESIA_DEAL);
			case PKR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.PAKISTAN_DEAL);
			case YER:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.YEMEN_DEAL);
			case SYP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.SYRIA_DEAL);
			case EGP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.EGYPT_DEAL);
			case NGN:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.NIGERIA_DEAL);
			case KES:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.KENYA_DEAL);
			case NPR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.NEPAL_DEAL);
			case LKR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.SRI_LANKA_DEAL);
			case PHP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.PHILIPPINES_DEAL);
			default:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDIA_DEAL);
		}
	}

}
