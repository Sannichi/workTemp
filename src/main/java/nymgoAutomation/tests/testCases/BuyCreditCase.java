package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.DeclinedTransactionAdyenPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.PendingTransactionGlobalCollectPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayNext;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.PendingTransactionWorldpayPage;
import nymgoAutomation.tests.utils.CurrencyUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinBuyCurrencyValue(paymentCurrency);			
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);

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
			currencyAmount = CurrencyUtils.getMinBuyCurrencyValue(paymentCurrency);			
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
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
			currencyAmount = CurrencyUtils.getMinBuyCurrencyValue(paymentCurrency);			
		}
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = buyCreditPage.selectAmountAndClickContinueToAdyen(currencyAmount);
		buyCredit3DSProceedPageAdyen.verifyDefaultData();
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
		
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
	
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);

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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
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
		ExcelUtils.addUserAndCurrencyAndBalanceAndAmountData(fullUserEntity.getUsername(), paymentCurrency, accountBalanceValue, currencyAmount);
	}

    @Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressGlobalCollectPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
/*		String accountBalanceValue = normalAccountPage.getAccountBalanceValue(); 
		String previuosAccountBalanceValue = ExcelUtils.getAccountBalanceBeforeTransaction(transactionID);
		Assert.assertEquals(accountBalanceValue, previuosAccountBalanceValue);
*/		
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

    @Test(dataProvider = PROVIDER_CONST.VISA_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaGlobalCollectPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

    @Test(dataProvider = PROVIDER_CONST.MASTER_CARD_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardGlobalCollectPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

	@Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.VISA_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.MASTER_CARD_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressAdyenDeclinedTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test(dataProvider = PROVIDER_CONST.VISA_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaAdyenDeclinedTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test(dataProvider = PROVIDER_CONST.MASTER_CARD_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardAdyenDeclinedTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test(dataProvider = PROVIDER_CONST.WP_AMERICAN_EXPRESS_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressWorldpay3DSPendingTest(FullCardEntity fullCardEntity){

//		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
//		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
//				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.WP_VISA_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaWorldpay3DSPendingTest(FullCardEntity fullCardEntity){

//		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
//		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
//				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.WP_MASTER_CARD_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardWorldpay3DSPendingTest(FullCardEntity fullCardEntity){

//		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
//		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
//				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}


	@Test(dataProvider = PROVIDER_CONST.ADYEN_AMERICAN_EXPRESS_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressAdyenDSPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_VISA_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaAdyen3DSPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_MASTER_CARD_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardAdyen3DSPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

}
