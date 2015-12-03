package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.utils.CurrencyUtils;

public class BuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroNormalUserGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
//		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

//		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
/*
		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));
						
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPageWorldpay.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = buyCreditProceedPageWorldpay.verifyDataAndClickContinue(cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
*/
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
		
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
//		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

//		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
/*		buyCredit3DSProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));
						
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCredit3DSProceedPageWorldpay.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = buyCreditProceedPageWorldpay.verifyDataAndClickContinue(cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
*/
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	
    }

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedMasterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

    }

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedMasterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
//		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
/*
//		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));
						
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPageWorldpay.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = buyCreditProceedPageWorldpay.verifyDataAndClickContinue(cardType, countryOfCredit,
//				currencyAmount, VATPercent, String.valueOf(Float.valueOf(currencyAmount) + VATValue));
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
*/
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedMasterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);		
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
		
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	
    }

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

    }

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = resellerAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmount(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}
}
