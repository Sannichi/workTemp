package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPagePending;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditProceedPageGlobalCollect;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void buyCreditLoggedNormalUserGlobalCollectTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		buyCreditPage.selectAmountAndVerifyVAT(currencyAmount);
		String VATPercent = buyCreditPage.getVATPercent();
		Double VATValue = Double.valueOf(buyCreditPage.getVATValue());
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(currencyAmount);

		buyCreditProceedPage.verifyDefaultData(fullUserEntity.getFullName(), fullUserEntity.getEmail(), fullUserEntity.getMobile(), fullUserEntity.getPhone(), 
				fullUserEntity.getCountryOfResidence(), fullUserEntity.getPostalCode(), fullUserEntity.getStreet(), fullUserEntity.getFullAddress(), 
				currencyAmount, VATPercent, String.valueOf(Double.valueOf(currencyAmount) + VATValue));
		
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

		BuyCreditConfirmPagePending buyCreditConfirmPagePending = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = buyCreditConfirmPagePending.getTransactionNumber();
		String paymentStatus = buyCreditConfirmPagePending.getPaymentStatus();
		Assert.assertTrue(buyCreditConfirmPagePending.isTransactionPending(), 
				"Transaction is not pending, current status is: " + buyCreditConfirmPagePending.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		LOGGER.info("transactionID " + transactionID + " was added to Excel");
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = buyCreditConfirmPagePending.clickBackToNormalUserDashboardButton();
	}
}
