package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.utils.CurrencyUtils;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class BuyDealCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		
		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);		

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		
		
		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	
    }

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedMasterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());

		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditDealPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

    }

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedMasterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedMasterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

	}

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	
    }

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);
		
		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterMasterResellerGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);

    }

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterMasterResellerWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);

		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = buyCreditDealPage.selectAmountAndClickContinueToWorldpay(currencyAmount);
		buyCredit3DSProceedPageWorldpay.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyDealLoggedInterMasterResellerAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String dealCurrency, String dealName, String dealQuantity,
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		BuyCreditDealPage buyCreditDealPage = resellerAccountPage.clickResellerAccountBuyCreditButton();		

//		buyCreditDealPage.selectAmount(currencyAmount);
		
		buyCreditDealPage.selectDealAndQuantityAndVerifyVATAndTotal(paymentCurrency, dealCurrency, dealName, dealQuantity);
		String VATPercent = buyCreditDealPage.getDealVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "Deal VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		Float VATValue = Float.valueOf(buyCreditDealPage.getDealVATValue());
		
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditDealPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountAndCardTypeData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount, cardType);
	}
}