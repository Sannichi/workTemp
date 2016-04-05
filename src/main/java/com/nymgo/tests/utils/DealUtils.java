package com.nymgo.tests.utils;

import com.nymgo.tests.generators.DealsCountryNameGenerator;

/**
 * Created by Iuliia Khikmatova on Apr 05, 2016
 */
public class DealUtils {

	public static String getFullDealName(String dealName, String dealCurrency){
		
		DealDescription dealDescription = DealDescriptionMap.getDealDescriptionByName(dealName);
		String countryName = DealsCountryNameGenerator.getDealKeyBySign(dealCurrency); 
		
		return countryName + " (" + dealDescription.getMinutes() + " mins)";
	}
}
