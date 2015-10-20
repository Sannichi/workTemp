package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPagePendingGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPagePendingWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageWorldpayNext;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditProceedPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditProceedPageWorldpay;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Double VATValue = Double.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));

	}

    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserWorldpayTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Double VATValue = Double.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageWorldpay buyCreditProceedPageWorldpay = buyCreditPage.selectAmountAndClickContinueToWorldpay(currencyAmount);

		buyCreditProceedPageWorldpay.verifyDefaultData(fullUserEntity.getCountryOfResidence(), currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPageWorldpay.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = buyCreditProceedPageWorldpay.verifyDataAndClickContinue(cardType, countryOfCredit,
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));

	}

    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserAdyenTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		String VATPercent = buyCreditPage.getVATPercent();
		Assert.assertTrue(VATPercent.equals(fullUserEntity.getVat()), "VAT percent does not corresponds to user preferences. Current value is '" + VATPercent
				+ "' should be '" + fullUserEntity.getVat() + "'");
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		Double VATValue = Double.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));
		if(countryOfCredit == null){
			countryOfCredit = fullUserEntity.getCountryOfResidence();
		}
		buyCreditProceedPage.setPaymentBlockData(cardType, countryOfCredit);
		
		@SuppressWarnings("unused")
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(),
				cardType, countryOfCredit,
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));

	}

    @Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressGlobalCollectPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		BuyCreditConfirmPagePendingGlobalCollect buyCreditConfirmPagePendingGlobalCollect = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = buyCreditConfirmPagePendingGlobalCollect.getTransactionNumber();
		String paymentStatus = buyCreditConfirmPagePendingGlobalCollect.getPaymentStatus();
		Assert.assertTrue(buyCreditConfirmPagePendingGlobalCollect.isTransactionPending(), 
				"Transaction is not pending, current status is: " + buyCreditConfirmPagePendingGlobalCollect.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		LOGGER.info("transactionID " + transactionID + " was added to Excel");
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = buyCreditConfirmPagePendingGlobalCollect.clickBackToNormalUserDashboardButton();
	}

	@Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

		BuyCreditConfirmPagePendingWorldpay buyCreditConfirmPagePendingWorldpay = buyCreditConfirmPageWorldpayNext.continuePayment();

		String transactionID = buyCreditConfirmPagePendingWorldpay.getTransactionNumber();
		String paymentStatus = buyCreditConfirmPagePendingWorldpay.getPaymentStatus();
		Assert.assertTrue(buyCreditConfirmPagePendingWorldpay.isTransactionPending(), 
				"Transaction is not pending, current status is: " + buyCreditConfirmPagePendingWorldpay.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		LOGGER.info("transactionID " + transactionID + " was added to Excel");
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = buyCreditConfirmPagePendingWorldpay.clickBackToNormalUserDashboardButton();
	}
}
