package com.nymgo.tests.utils;

import java.util.HashMap;
import java.util.Map;

import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.LocaleGenerator;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class DealDescriptionMap {

//	private static final EnumMap<DEAL_NAMES, DealDescription> dealMap = new EnumMap<DEAL_NAMES, DealDescription>(DEAL_NAMES.class);
	private static final Map<LOCALE_CONST, DealDescription> dealMap = new HashMap<LOCALE_CONST, DealDescription>();	
	
	static {

//		DealPricesDescription(Float usdPrice, int audPrice, int cadPrice, int eurPrice, int inrPrice, int nzdPrice, int qarPrice, int sarPrice, 
//				int aedPrice, int gbpPrice, int kwdPrice, int myrPrice, int sgdPrice, int aoaPrice, int bndPrice, CURRENCY_SIGNS currencySign, int minutes)
		
//		dealMap.put(CURRENCY_SIGNS.INR, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.BDT, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.IDR, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.PKR, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.YER, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.SYP, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));		
//		dealMap.put(CURRENCY_SIGNS.EGP, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.NGN, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.KES, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.NPR, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.LKR, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));
//		dealMap.put(CURRENCY_SIGNS.PHP, new DealPricesDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22));

//		dealMap.put(DEAL_NAMES.INDIA_DEAL_600, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, 600));
//		dealMap.put(DEAL_NAMES.INDIA_DEAL_UNLIMITED, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, -1));
//		dealMap.put(DEAL_NAMES.INDIA_DEAL_400, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, 400));
//		dealMap.put(DEAL_NAMES.BANGLADESH_DEAL_600, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.BDT, 600));
//		dealMap.put(DEAL_NAMES.INDONESIA_DEAL_300, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.IDR, 300));
//		dealMap.put(DEAL_NAMES.PAKISTAN_DEAL_300, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.PKR, 300));
//		dealMap.put(DEAL_NAMES.YEMEN_DEAL_175, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.YER, 175));
//		dealMap.put(DEAL_NAMES.SYRIA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.SYP, 200));		
//		dealMap.put(DEAL_NAMES.EGYPT_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.EGP, 200));
//		dealMap.put(DEAL_NAMES.NIGERIA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.NGN, 200));
//		dealMap.put(DEAL_NAMES.KENYA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.KES, 200));
//		dealMap.put(DEAL_NAMES.NEPAL_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.NPR, 200));
//		dealMap.put(DEAL_NAMES.SRI_LANKA_DEAL_100, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.LKR, 100));
//		dealMap.put(DEAL_NAMES.PHILIPPINES_DEAL_100, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.PHP, 100));

		dealMap.put(LOCALE_CONST.INDIA_DEAL_600, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, 600));
		dealMap.put(LOCALE_CONST.INDIA_DEAL_UNLIMITED, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, -1));
		dealMap.put(LOCALE_CONST.INDIA_DEAL_400, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.INR, 400));
		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_600, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.BDT, 600));
		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_300, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.IDR, 300));
		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_300, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.PKR, 300));
		dealMap.put(LOCALE_CONST.YEMEN_DEAL_175, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.YER, 175));
		dealMap.put(LOCALE_CONST.SYRIA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.SYP, 200));		
		dealMap.put(LOCALE_CONST.EGYPT_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.EGP, 200));
		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.NGN, 200));
		dealMap.put(LOCALE_CONST.KENYA_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.KES, 200));
		dealMap.put(LOCALE_CONST.NEPAL_DEAL_200, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.NPR, 200));
		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_100, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.LKR, 100));
		dealMap.put(LOCALE_CONST.PHILIPPINES_DEAL_100, new DealDescription((float) 14.99, 22, 22, 14, 1014, 24, 55, 57, 56, 11, 5, 66, 22, 2321, 22, CURRENCY_SIGNS.PHP, 100));
	}
	
//	public static DealDescription getDealDescriptionByKey(CURRENCY_SIGNS currencySign){
//		
//		return dealMap.get(currencySign);
//	}
//
//	public static DealDescription getDealDescriptionBySign(String currencySign){
//		
//		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
//		return dealMap.get(currencySignKey);
//	}

//	private static DealDescription getDealDescriptionByNameKey(DEAL_NAMES dealNameKey){
//		
//		return dealMap.get(dealNameKey);
//	}

	public static DealDescription getDealDescriptionByName(String dealName){
		
//		DEAL_NAMES dealNameKey = DEAL_NAMES.valueOf(dealName);
//		return getDealDescriptionByNameKey(dealNameKey);

		String localeName = LocaleGenerator.getLocaleKeyNameByValue(dealName);
		LOCALE_CONST dealNameKey = LOCALE_CONST.valueOf(localeName);
		return dealMap.get(dealNameKey);
	}

	public static DealDescription getFirstDealDescriptionByCurrencySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		for(int i = 0; i < dealMap.size(); i++){
			if(dealMap.get(i).getCurrencySign().equals(currencySignKey))
				return dealMap.get(i);
		}
		return null;
	}
}
