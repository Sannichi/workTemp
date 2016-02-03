package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.data.entity.ThreeDSUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSConfirmPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.DeclinedTransactionAdyenPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.PendingTransactionAdyen3DSPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.PendingTransactionGlobalCollectPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSConfirmPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayNext;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.PendingTransactionWorldpay3DSPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.PendingTransactionWorldpayPage;

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

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
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

	@Test(dataProvider = PROVIDER_CONST.VISA_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.MASTER_CARD_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardWorldpayPendingTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
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

	@Test(dataProvider = PROVIDER_CONST.MASTER_CARD_ADYEN_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardAdyenPendingTest(FullCardEntity fullCardEntity){

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

	@Test(dataProvider = PROVIDER_CONST.VISA_ADYEN_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaAdyenPendingTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test(dataProvider = PROVIDER_CONST.AMERICAN_EXPRESS_ADYEN_CARD_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressAdyenPendingTest(FullCardEntity fullCardEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
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

		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		

		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.WP_VISA_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaWorldpay3DSPendingTest(FullCardEntity fullCardEntity){

//		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
//		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
//				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		

		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.WP_MASTER_CARD_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardWorldpay3DSPendingTest(FullCardEntity fullCardEntity){

//		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
//		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = buyCreditConfirmPageWorldpay.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
//				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv(), fullCardEntity.getCardholdersName());

//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCreditConfirmPageWorldpayNext.continuePayment();

		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		

		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData("NormalTester", transactionID);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}


	@Test(dataProvider = PROVIDER_CONST.ADYEN_AMERICAN_EXPRESS_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payAmericanExpressAdyen3DSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_VISA_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payVisaAdyen3DSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test(dataProvider = PROVIDER_CONST.ADYEN_MASTER_CARD_CARD_3DS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void payMasterCardAdyen3DSPendingTest(FullCardEntity fullCardEntity, ThreeDSUserEntity threeDSUserEntity){

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

}
