package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.utils.CurrencyUtils;

public class BuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
    	
    	LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.clickContinueToGlobalCollect();		

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		@SuppressWarnings("unused")
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.clickContinueToWorldpay();		
//		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		@SuppressWarnings("unused")
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.clickContinueToAdyen();		
//		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
		
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}

		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getVATValue());		
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();		

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroMasterResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");

		Float VATValue = Float.valueOf(buyCreditDealPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.clickContinueToGlobalCollect();		

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, VATPercent, CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(currencyAmount) + VATValue));				
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroMasterResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.clickContinueToWorldpay();		
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedEuroMasterResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		buyCreditDealPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditDealPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.clickContinueToAdyen();		
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterNormalUserAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
		
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerGlobalCollectTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);

    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerWorldpayTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedInterMasterResellerAdyenTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
    	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType + "," + gatewayName);
	}
}
