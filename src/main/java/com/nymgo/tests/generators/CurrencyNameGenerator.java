package com.nymgo.tests.generators;
import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.enums.LOCALE_CONST;

//import org.apache.log4j.Logger;
/**
 * Created by Iuliia Khikmatova on Oct 15, 2015
 */
public class CurrencyNameGenerator {

	public static String getCurrencyKeyBySign(String currencySign){
		
		CURRENCY_SIGNS CURR_SIGN = CURRENCY_SIGNS.valueOf(currencySign);
		return getCurrencyKey(CURR_SIGN);
	}
   

	public static String getCurrencyKey(CURRENCY_SIGNS currencySignKey){

		switch (currencySignKey)
		{
			case USD:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.AMERICAN_DOLLARS);
			case AUD:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.AUSTRALIAN_DOLLARS);
			case CAD:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.CANADIAN_DOLLARS);
			case EUR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.EUROS);
			case INR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.INDIAN_RUPEES);
			case NZD:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.NEW_ZEALAND_DOLLARS);
			case QAR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.QATAR_RIYALS);
			case SAR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.SAUDI_ARABIA_RIYALS);
			case AED:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.UNITED_ARAB_EMIRATES_DIRHAMS);
			case GBP:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.BRITISH_POUNDS);
			case KWD:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.KUWAIT_DINARS);
			case MYR:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.MALAYSIAN_RINGGIT);
			default:
				return LocaleGenerator.getLocaleKey(LOCALE_CONST.AMERICAN_DOLLARS);
		}
	}

}
