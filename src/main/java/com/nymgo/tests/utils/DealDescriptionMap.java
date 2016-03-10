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

//		DealPricesDescription(Float usdPrice, int audPrice, int cadPrice, int eurPrice, int inrPrice, 
//								int nzdPrice, int qarPrice, int sarPrice, int aedPrice, int gbpPrice,  
//								int kwdPrice, int myrPrice, int sgdPrice, int aoaPrice, int bndPrice, CURRENCY_SIGNS currencySign, int minutes)

//		dealMap.put(LOCALE_CONST.INDIA_DEAL, new DealDescription(			(float) 14.99, 	(float) 22, (float) 22, (float) 14, (float) 1014, (float) 24, (float) 55, (float) 57, (float) 56, (float) 11, 	
//				(float) 4.5, (float) 66, (float) 22, (float) 2321, (float) 22, CURRENCY_SIGNS.INR, 1000, 200));
		dealMap.put(LOCALE_CONST.INDIA_DEAL_350, new DealDescription(		(float) 7.99, (float) 10.7, (float) 10.6, (float) 7.3, (float) 537.5, 
				(float) 11.8, (float) 29.1, (float) 30.0, (float) 29.3, (float) 5.6, 		
				(float) 2.4, (float) 32.8, (float) 11.0, (float) 1263.7, (float) 10.9, CURRENCY_SIGNS.INR, 350, 200));
////		dealMap.put(LOCALE_CONST.INDIA_DEAL_550, new DealDescription(		(float) 9.99, 	14, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1547, 14, CURRENCY_SIGNS.INR, 550, 200));		
////		dealMap.put(LOCALE_CONST.INDIA_DEAL_800, new DealDescription(		(float) 11.99, 	17, 18, 12, 812, 19, 44, 45, 45, 9, 	(float) 3.6, 52, 18, 1857, 17, CURRENCY_SIGNS.INR, 800, 200));
//		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_150, new DealDescription(	(float) 5.99, 	9, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.BDT, 600, 200));
//		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_360, new DealDescription(	(float) 9.99, 	14, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.BDT, 600, 200));
//		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_600, new DealDescription(	(float) 15, 	22, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.BDT, 600, 200));
//		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_1120, new DealDescription(	(float) 22.99, 	31, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.BDT, 600, 200));
		dealMap.put(LOCALE_CONST.BANGLADESH_DEAL_1150, new DealDescription(	(float) 22.99, (float) 30.8, (float) 30.6, (float) 20.9, (float) 1546.5, 
				(float) 34.0, (float) 83.7, (float) 86.2, (float) 84.4, (float) 16.1, 	
				(float) 6.9, (float) 94.5, (float) 31.7, (float) 3636.1, (float) 31.3, CURRENCY_SIGNS.BDT, 1150, 200));

//		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_70, new DealDescription(	(float) 5.99, 	9, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.IDR, 300, 20000));
//		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_200, new DealDescription(	(float) 10.99, 	15, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.IDR, 300, 20000));
//		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_300, new DealDescription(	(float) 15, 	22, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.IDR, 300, 20000));
//		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_480, new DealDescription(	(float) 20.49, 	28, 22, 14, 1016, 24, 54, 57, 56, 11, 	(float) 4.5, 64, 22, 2323, 21, CURRENCY_SIGNS.IDR, 300, 20000));
		dealMap.put(LOCALE_CONST.INDONESIA_DEAL_540, new DealDescription(	(float) 19.99, (float) 26.8, (float) 26.6, (float) 18.2, (float) 1344.7, 
				(float) 29.6, (float) 72.8, (float) 75.0, (float) 73.4, (float) 14.0, 	
				(float) 6.0, (float) 82.2, (float) 27.6, (float) 3161.6, (float) 27.2, CURRENCY_SIGNS.IDR, 540, 20000));

//		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_70, new DealDescription(		(float) 4.99, 	7, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.PKR, 300, 300));
//		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_240, new DealDescription(	(float) 8.49, 	12, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.PKR, 300, 300));
		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_250, new DealDescription(	(float) 6.99, (float) 9.4, (float) 9.3, (float) 6.4, (float) 470.2, 
				(float) 10.3, (float) 25.4, (float) 26.2, (float) 25.7, (float) 4.9, 	
				(float) 2.1, (float) 28.7, (float) 9.6, (float) 1105.5, (float) 9.5, CURRENCY_SIGNS.PKR, 250, 250));

//		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_300, new DealDescription(	(float) 10, 	15, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.PKR, 300, 300));
//		dealMap.put(LOCALE_CONST.PAKISTAN_DEAL_600, new DealDescription(	(float) 15.49, 	21, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.PKR, 300, 300));
//		dealMap.put(LOCALE_CONST.YEMEN_DEAL_30, new DealDescription(		(float) 6.99, 	10, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.YER, 175, 600));
//		dealMap.put(LOCALE_CONST.YEMEN_DEAL_75, new DealDescription(		(float) 11.99, 	17, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.YER, 175, 600));
//		dealMap.put(LOCALE_CONST.YEMEN_DEAL_175, new DealDescription(		(float) 25, 	36, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.YER, 175, 600));

//		DealPricesDescription(Float usdPrice, int audPrice, int cadPrice, int eurPrice, int inrPrice, 
//		int nzdPrice, int qarPrice, int sarPrice, int aedPrice, int gbpPrice,  
//		int kwdPrice, int myrPrice, int sgdPrice, int aoaPrice, int bndPrice, CURRENCY_SIGNS currencySign, int minutes)

		dealMap.put(LOCALE_CONST.YEMEN_DEAL_260, new DealDescription(		(float) 29.99, (float) 40.2, (float) 39.9, (float) 27.3, (float) 2017.4, 
				(float) 44.4, (float) 109.2, (float) 112.5, (float) 110.1, (float) 21.0, 	
				(float) 9.0, (float) 123.3, (float) 41.4, (float) 4743.2, (float) 40.8, CURRENCY_SIGNS.YER, 260, 345));

//		dealMap.put(LOCALE_CONST.SYRIA_DEAL_20, new DealDescription(		(float) 4.9, 	6, 29, 19, 1354, 31, 72, 75, 74, 14, 	(float) 6.0, 86, 29, 3097, 28, CURRENCY_SIGNS.SYP, 200, 300));		
//		dealMap.put(LOCALE_CONST.SYRIA_DEAL_60, new DealDescription(		(float) 7.99, 	11, 29, 19, 1354, 31, 72, 75, 74, 14, 	(float) 6.0, 86, 29, 3097, 28, CURRENCY_SIGNS.SYP, 200, 300));		
//		dealMap.put(LOCALE_CONST.SYRIA_DEAL_120, new DealDescription(		(float) 12.99, 	18, 29, 19, 1354, 31, 72, 75, 74, 14, 	(float) 6.0, 86, 29, 3097, 28, CURRENCY_SIGNS.SYP, 200, 300));		
		dealMap.put(LOCALE_CONST.SYRIA_DEAL_180, new DealDescription(		(float) 13.99, (float) 18.7, (float) 18.6, (float) 12.7, (float) 941.1, 
				(float) 20.7, (float) 50.9, (float) 52.5, (float) 51.3, (float) 9.8, 	
				(float) 4.2, (float) 57.5, (float) 19.3, (float) 2212.7, (float) 19.0, CURRENCY_SIGNS.SYP, 180, 300));		

//		dealMap.put(LOCALE_CONST.SYRIA_DEAL_200, new DealDescription(		(float) 20, 	29, 29, 19, 1354, 31, 72, 75, 74, 14, 	(float) 6.0, 86, 29, 3097, 28, CURRENCY_SIGNS.SYP, 200, 300));		
//		dealMap.put(LOCALE_CONST.EGYPT_DEAL_60, new DealDescription(		(float) 5.49, 	8, 16, 11, 745, 17, 40, 42, 41, 8, 	(float) 3.3, 47, 16, 1704, 16, CURRENCY_SIGNS.EGP, 200, 20));
//		dealMap.put(LOCALE_CONST.EGYPT_DEAL_110, new DealDescription(		(float) 7.49, 	11, 16, 11, 745, 17, 40, 42, 41, 8, 	(float) 3.3, 47, 16, 1704, 16, CURRENCY_SIGNS.EGP, 200, 20));
//		dealMap.put(LOCALE_CONST.EGYPT_DEAL_200, new DealDescription(		(float) 11, 	16, 16, 11, 745, 17, 40, 42, 41, 8, 	(float) 3.3, 47, 16, 1704, 16, CURRENCY_SIGNS.EGP, 200, 20));
//		dealMap.put(LOCALE_CONST.EGYPT_DEAL_320, new DealDescription(		(float) 9.25, 	21, 16, 11, 745, 17, 40, 42, 41, 8, 	(float) 3.3, 47, 16, 1704, 16, CURRENCY_SIGNS.EGP, 200, 20));
		dealMap.put(LOCALE_CONST.EGYPT_DEAL_420, new DealDescription(		(float) 14.99, (float) 20.1, (float) 19.9, (float) 13.6, (float) 1008.4, 
				(float) 22.2, (float) 54.6, (float) 56.2, (float) 55.0, (float) 10.5, 	
				(float) 4.5, (float) 61.6, (float) 20.7, (float) 2370.8, (float) 20.4, CURRENCY_SIGNS.EGP, 420, 20));

		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_40, new DealDescription(		(float) 3.99, (float) 5.3, (float) 5.3, (float) 3.6, (float) 268.4, 
				(float) 5.9, (float) 14.5, (float) 15.0, (float) 14.6, (float) 2.8, 	
				(float) 1.2, (float) 16.4, (float) 5.5, (float) 631.1, (float) 5.4, CURRENCY_SIGNS.NGN, 40, 500));

//		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_90, new DealDescription(		(float) 5.99, 	9, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.NGN, 200, 500));
//		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_180, new DealDescription(		(float) 8.49, 	12, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.NGN, 200, 500));
//		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_200, new DealDescription(		(float) 10, 	15, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.NGN, 200, 500));
//		dealMap.put(LOCALE_CONST.NIGERIA_DEAL_640, new DealDescription(		(float) 18.99, 	26, 15, 10, 677, 16, 36, 38, 37, 7, 	(float) 3.0, 43, 15, 1549, 14, CURRENCY_SIGNS.NGN, 200, 500));
//		dealMap.put(LOCALE_CONST.KENYA_DEAL_25, new DealDescription(		(float) 6.49, 	9, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.KES, 200, 300));
//		dealMap.put(LOCALE_CONST.KENYA_DEAL_55, new DealDescription(		(float) 9.49, 	13, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.KES, 200, 300));
//		dealMap.put(LOCALE_CONST.KENYA_DEAL_200, new DealDescription(		(float) 25, 	36, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.KES, 200, 300));
//		dealMap.put(LOCALE_CONST.KENYA_DEAL_300, new DealDescription(		(float) 33.49, 	45, 36, 23, 1693, 39, 90, 94, 92, 18, 	(float) 7.5, 107, 36, 3871, 35, CURRENCY_SIGNS.KES, 200, 300));

//		DealPricesDescription(Float usdPrice, int audPrice, int cadPrice, int eurPrice, int inrPrice, 
//		int nzdPrice, int qarPrice, int sarPrice, int aedPrice, int gbpPrice,  
//		int kwdPrice, int myrPrice, int sgdPrice, int aoaPrice, int bndPrice, CURRENCY_SIGNS currencySign, int minutes)

		dealMap.put(LOCALE_CONST.KENYA_DEAL_320, new DealDescription(		(float) 32.99, (float) 44.2, (float) 43.9, (float) 30.0, (float) 2219.2, 
				(float) 48.8, (float) 120.1, (float) 123.7, (float) 121.1, (float) 23.1, 	
				(float) 9.9, (float) 135.6, (float) 45.5, (float) 5217.7, (float) 44.9, CURRENCY_SIGNS.KES, 320, 300));

//		dealMap.put(LOCALE_CONST.NEPAL_DEAL_25, new DealDescription(		(float) 4.49, 	7, 32, 21, 1490, 34, 80, 83, 81, 16, 	(float) 6.6, 94, 32, 3407, 31, CURRENCY_SIGNS.NPR, 200, 200));
//		dealMap.put(LOCALE_CONST.NEPAL_DEAL_60, new DealDescription(		(float) 7.99, 	11, 32, 21, 1490, 34, 80, 83, 81, 16, 	(float) 6.6, 94, 32, 3407, 31, CURRENCY_SIGNS.NPR, 200, 200));
//		dealMap.put(LOCALE_CONST.NEPAL_DEAL_200, new DealDescription(		(float) 22, 	32, 32, 21, 1490, 34, 80, 83, 81, 16, 	(float) 6.6, 94, 32, 3407, 31, CURRENCY_SIGNS.NPR, 200, 200));
//		dealMap.put(LOCALE_CONST.NEPAL_DEAL_240, new DealDescription(		(float) 23.99, 	33, 32, 21, 1490, 34, 80, 83, 81, 16, 	(float) 6.6, 94, 32, 3407, 31, CURRENCY_SIGNS.NPR, 200, 200));
		dealMap.put(LOCALE_CONST.NEPAL_DEAL_260, new DealDescription(		(float) 22.99, (float) 30.8, (float) 30.6, (float) 20.9, (float) 1546.5, 
				(float) 34.0, (float) 83.7, (float) 86.2, (float) 84.4, (float) 16.1, 	
				(float) 6.9, (float) 94.5, (float) 31.7, (float) 3636.1, (float) 31.3, CURRENCY_SIGNS.NPR, 260, 200));

//		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_10, new DealDescription(	(float) 3.49, 	5, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.LKR, 100, 200));
//		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_30, new DealDescription(	(float) 6.49, 	9, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.LKR, 100, 200));
//		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_100, new DealDescription(	(float) 17, 	25, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.LKR, 100, 200));
//		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_130, new DealDescription(	(float) 20.99, 	29, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.LKR, 100, 200));
		dealMap.put(LOCALE_CONST.SRI_LANKA_DEAL_180, new DealDescription(	(float) 22.99, (float) 30.8, (float) 30.6, (float) 20.9, (float) 1546.5, 
				(float) 34.0, (float) 83.7, (float) 86.2, (float) 84.4, (float) 16.1, 	
				(float) 6.9, (float) 94.5, (float) 31.7, (float) 3636.1, (float) 31.3, CURRENCY_SIGNS.LKR, 180, 200));

//		dealMap.put(LOCALE_CONST.PHILIPPINES_DEAL_20, new DealDescription(	(float) 9.25, 	13, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.PHP, 100, 300));
//		dealMap.put(LOCALE_CONST.PHILIPPINES_DEAL_50, new DealDescription(	(float) 12.29, 	17, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.PHP, 100, 300));
//		dealMap.put(LOCALE_CONST.PHILIPPINES_DEAL_100, new DealDescription(	(float) 17, 	25, 25, 16, 1151, 27, 62, 64, 63, 12, 	(float) 5.1, 73, 25, 2633, 24, CURRENCY_SIGNS.PHP, 100, 300));
		dealMap.put(LOCALE_CONST.PHILIPPINES_DEAL_150, new DealDescription(	(float) 16.99, (float) 22.8, (float) 22.6, (float) 15.5, (float) 1142.9, 
				(float) 25.1, (float) 61.8, (float) 63.7, (float) 62.4, (float) 11.9, 	
				(float) 5.1, (float) 69.8, (float) 23.4, (float) 2687.1, (float) 23.1, CURRENCY_SIGNS.PHP, 150, 100));
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

	public static String getFirstDealLocaleNameByCurrencySign(String currencySign){
		
		CURRENCY_SIGNS currencySignKey = CURRENCY_SIGNS.valueOf(currencySign);
		for(LOCALE_CONST dealName : dealMap.keySet()){
			if(dealMap.get(dealName).getCurrencySign().equals(currencySignKey))
				return LocaleGenerator.getLocaleKey(dealName);
		}
		return null;
	}
}
