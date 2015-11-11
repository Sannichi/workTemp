package nymgoAutomation.tests.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.ThreeDSUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSConfirmPageAdyen;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.DeclinedTransactionAdyenPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.PendingTransactionAdyenPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.PendingTransactionGlobalCollectPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpay;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayNext;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.PendingTransactionWorldpayPage;

/**
 * Created by Iuliia Khikmatova on Nov 11, 2015
 */
public class PayCreditCardCase extends AbstractCase{


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
//		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		ExcelUtils.addTransactionData(transactionID);		
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
//		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		ExcelUtils.addTransactionData(transactionID);		
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
//		ExcelUtils.addTransactionData(transactionID, paymentStatus);		
		ExcelUtils.addTransactionData(transactionID);		
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
	public void payAmericanExpressAdyenDSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_VISA_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaAdyen3DSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_MASTER_CARD_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardAdyen3DSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

}
