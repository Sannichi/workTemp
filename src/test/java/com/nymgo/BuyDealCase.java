package com.nymgo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditNormalDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditResellerDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.utils.CurrencyUtils;
import com.nymgo.tests.utils.DealDescriptionMap;
import com.nymgo.tests.utils.Rounder;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class BuyDealCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		Float dealVATValue = Float.valueOf(buyCreditNormalDealPage.getDealVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditNormalDealPage.clickContinueDealToGlobalCollect();		

		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
		
		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, dealVATPercent, CurrencyUtils.getStringCurrencyValueFromFloat((Rounder.roundFloat(price, 2) + Rounder.roundFloat(dealVATValue, 2))));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, dealVATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Rounder.roundFloat(price, 2) + Rounder.roundFloat(dealVATValue, 2)));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
		softAssert.assertAll();
    }
    	
    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditNormalDealPage.clickContinueDealToWorldpay();		
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
		softAssert.assertAll();
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditNormalDealPage.clickContinueDealToAdyen();		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
		softAssert.assertAll();
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();	

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		Float dealVATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());		
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		

		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
		
		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, dealVATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Rounder.roundFloat(price, 2) * Integer.valueOf(dealQuantity) + Rounder.roundFloat(dealVATValue, 2)));				
		
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, dealVATPercent, String.valueOf(Rounder.roundFloat(price, 2) * Integer.valueOf(dealQuantity) + Rounder.roundFloat(dealVATValue, 2)));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
		softAssert.assertAll();
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();		

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
		softAssert.assertAll();
    }

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedEuroResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
		
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
		softAssert.assertAll();
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditNormalDealPage.clickContinueDealToGlobalCollect();

		buyCreditProceedPage.verifyDefaultInternationalData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount)));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyInternationalDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount)));	
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);

	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditNormalDealPage.clickContinueDealToWorldpay();

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountDealsValue = normalAccountPage.getMyDealsCounter();
		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditNormalDealPage.clickContinueDealToAdyen();		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		

		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		

		
		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
		
		buyCreditProceedPage.verifyDefaultInternationalData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, String.valueOf(Rounder.roundFloat(price, 2)));				
		
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyInternationalDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, CurrencyUtils.getStringCurrencyValueFromFloat(Rounder.roundFloat(price, 2)));	
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		

		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
    }

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		

		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();
		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
//    	
//    	LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
//		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		Float dealVATValue = Float.valueOf(buyCreditNormalDealPage.getDealVATValue());
//		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditNormalDealPage.clickContinueDealToGlobalCollect();		
//
//		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
//		
//		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, dealVATPercent, String.valueOf(Rounder.roundFloat(price, 2) + Rounder.roundFloat(dealVATValue, 2)));				
//		if(countryOfCredit == null){
//			countryOfCredit = fullUserEntity.getCountryOfResidence();
//		}
//		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
//		
//		@SuppressWarnings("unused")
//		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
//				cardType, countryOfCredit,
//				currencyAmount, dealVATPercent, String.valueOf(Rounder.roundFloat(price, 2) + Rounder.roundFloat(dealVATValue, 2)));				
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//		softAssert.assertAll();
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
//		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditNormalDealPage.clickContinueDealToWorldpay();		
//		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//		softAssert.assertAll();
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDealAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName);
//		String dealVATPercent = buyCreditNormalDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditNormalDealPage.clickContinueDealToAdyen();		
//		buyCredit3DSProceedPageAdyen.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//		softAssert.assertAll();
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller(); 
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
//
//		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		Float dealVATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());		
//		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		
//
//		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
//		
//		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, dealVATPercent, String.valueOf(Rounder.roundFloat(price, 2) * Integer.valueOf(dealQuantity) + Rounder.roundFloat(dealVATValue, 2)));				
//		
//		if(countryOfCredit == null){
//			countryOfCredit = fullUserEntity.getCountryOfResidence();
//		}
//		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
//		
//		@SuppressWarnings("unused")
//		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
//				cardType, countryOfCredit,
//				currencyAmount, dealVATPercent, String.valueOf(Rounder.roundFloat(price, 2) * Integer.valueOf(dealQuantity) + Rounder.roundFloat(dealVATValue, 2)));				
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//		softAssert.assertAll();
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller(); 
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
//		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		
//		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();		
//
//		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//		softAssert.assertAll();
//    }
//
//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedEuroResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller(); 
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();
//
//		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		String dealVATPercent = buyCreditDealPage.getDealVATPercent();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(dealVATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" +
//				dealVATPercent + "' should be '" + fullUserEntity.getVat() + "'");
//		
//		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();		
//		buyCredit3DSProceedPageAdyen.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//		softAssert.assertAll();
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterNormalUser();    	
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
//		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditNormalDealPage.clickContinueDealToGlobalCollect();
//
//		buyCreditProceedPage.verifyDefaultInternationalData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount)));				
//		if(countryOfCredit == null){
//			countryOfCredit = fullUserEntity.getCountryOfResidence();
//		}
//		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
//		
//		@SuppressWarnings("unused")
//		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyInternationalDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
//				cardType, countryOfCredit,
//				currencyAmount, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount)));	
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//
//	}
//
//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterNormalUser();    	
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
//		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditNormalDealPage.clickContinueDealToWorldpay();
//
//		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//	}
//
//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterNormalUser();    	
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountDealsValue = normalAccountPage.getMyDealsCounter();
//		BuyCreditNormalDealPage buyCreditNormalDealPage = normalAccountPage.clickAccountBuyDealsButton();
//		buyCreditNormalDealPage.selectCountryAndDeal(paymentCurrency, dealCurrency, dealName);
//		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditNormalDealPage.clickContinueDealToAdyen();		
//		buyCredit3DSProceedPageAdyen.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName, cardType + "," + gatewayName);
//	}

//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller();
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
//
//		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		
//
//		
//		Float price = DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency);
//		
//		buyCreditProceedPage.verifyDefaultInternationalData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, String.valueOf(Rounder.roundFloat(price, 2)));				
//		
//		if(countryOfCredit == null){
//			countryOfCredit = fullUserEntity.getCountryOfResidence();
//		}
//		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
//		
//		@SuppressWarnings("unused")
//		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyInternationalDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
//				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
//				cardType, countryOfCredit,
//				currencyAmount, String.valueOf(Rounder.roundFloat(price, 2)));				
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//	}
//
//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller();
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
//
//		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();
//
//		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//    }
//
//    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	public void buyCreditLoggedInterResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
//			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){
//
////    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller();
//    	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//
//		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
//		String accountDealsValue = resellerAccountPage.getDealsCountByDealName(dealName);
//		BuyCreditResellerDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyDealsButton();		
//
//		buyCreditDealPage.selectDealAndQuantity(paymentCurrency, dealCurrency, dealName, dealQuantity);
//		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();
//		
//		buyCredit3DSProceedPageAdyen.verifyDefaultData();
//		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountDealsValue, dealName + "," + dealQuantity, cardType + "," + gatewayName);
//	}

}