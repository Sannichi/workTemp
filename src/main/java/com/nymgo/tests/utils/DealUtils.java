package com.nymgo.tests.utils;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.DealsCountryNameGenerator;
import com.nymgo.tests.generators.LocaleGenerator;

/**
 * Created by Iuliia Khikmatova on Apr 05, 2016
 */
public class DealUtils {

	public static String getFullDealName(String dealName, String dealCurrency){
		
		DealDescription dealDescription = DealDescriptionMap.getDealDescriptionByName(dealName);
		String countryName = DealsCountryNameGenerator.getDealKeyBySign(dealCurrency); 
		if (countryName.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.SYRIA))){
			countryName = countryName + " " + LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE);
		}
		
		return countryName + " (" + dealDescription.getMinutes() + " mins)";
	}
}
