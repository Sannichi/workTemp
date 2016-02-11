package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.data.entity.ThreeDSUserEntity;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSConfirmPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.DeclinedTransactionAdyenPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.PendingTransactionAdyen3DSPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.PendingTransactionAdyenPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditConfirmPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.PendingTransactionGlobalCollectPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.SuccessfulTransactionGlobalCollectPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSConfirmPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.PendingTransactionWorldpay3DSPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.PendingTransactionWorldpayPage;

/**
 * Created by Iuliia Khikmatova on Feb 11, 2016
 */
public class PayCreditCardRecurrentCase extends AbstractCase{


    @Test
	public void payAmericanExpressGlobalCollectPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();
    	
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

    @Test
	public void payVisaGlobalCollectPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

    	BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

    @Test
	public void payVisaGlobalCollectSuccessfulTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		SuccessfulTransactionGlobalCollectPage successfulTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinueSuccessful(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(successfulTransactionGlobalCollectPage.isTransactionSuccessful() || successfulTransactionGlobalCollectPage.isTransactionChallenged(), 
				"Transaction is not successful, current status is: " + successfulTransactionGlobalCollectPage.getPaymentStatus());
		String transactionID = successfulTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = successfulTransactionGlobalCollectPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = successfulTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
//		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

    @Test
	public void payVisaGlobalCollectChallengedTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		SuccessfulTransactionGlobalCollectPage successfulTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinueSuccessful(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(successfulTransactionGlobalCollectPage.isTransactionChallenged(), 
				"Transaction is not challenged, current status is: " + successfulTransactionGlobalCollectPage.getPaymentStatus());
		String transactionID = successfulTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = successfulTransactionGlobalCollectPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = successfulTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

    @Test
	public void payMasterCardGlobalCollectPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();

		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);

		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinue(fullCardEntity.getCardNumber(), 
				fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionGlobalCollectPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionGlobalCollectPage.getPaymentStatus());
		String transactionID = pendingTransactionGlobalCollectPage.getTransactionNumber();
		String paymentStatus = pendingTransactionGlobalCollectPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

	@Test
	public void payAmericanExpressWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payVisaWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payMasterCardWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payAmericanExpressAdyenDeclinedTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToDeclined(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test
	public void payVisaAdyenDeclinedTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToDeclined(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();
	}

	@Test
	public void payMasterCardAdyenDeclinedTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
	
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToDeclined(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertFalse(declinedTransactionAdyenPage.isTransactionDeclined(), 
				"Transaction is not declined, current status is: " + declinedTransactionAdyenPage.getPaymentStatus());
		String transactionID = declinedTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = declinedTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		BuyCreditPage buyCreditPage = declinedTransactionAdyenPage.clickTryAgainBuyCreditButton();

	}

	@Test
	public void payMasterCardAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

	@Test
	public void payVisaAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
//		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payAmericanExpressAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmexAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		Assert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}

	@Test
	public void payAmericanExpressWorldpay3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getWPAmericanExpressCard3DS();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		
	
		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		
//		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.set3DSAmexCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
//		fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
//
//		Assert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
//				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
//		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
//		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
//		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
//		ExcelUtils.addTransactionData(transactionID);		
//		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payVisaWorldpay3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getWPVisaCard3DS();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		

		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payMasterCardWorldpay3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getWPMasterCardCard3DS();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay = buyCredit3DSProceedPageWorldpay.set3DSCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());		
		
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = buyCredit3DSConfirmPageWorldpay.continuePayment();		

		Assert.assertTrue(pendingTransactionWorldpay3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpay3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpay3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpay3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpay3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}


	@Test
	public void payAmericanExpressAdyen3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAdyenAmericanExpressCard3DS();
    	ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payVisaAdyen3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAdyenVisaCard3DS();
    	ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
//		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payMasterCardAdyen3DSPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAdyenMasterCardCard3DS();
    	ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = buyCredit3DSProceedPageAdyen.setCreditCardDataAndClickPayToConfirm(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
		
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = buyCredit3DSConfirmPageAdyen.setUserDataAndClickSubmit(threeDSUserEntity.getUsername(), 
				threeDSUserEntity.getPassword());

		Assert.assertTrue(pendingTransactionAdyen3DSPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyen3DSPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyen3DSPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyen3DSPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyen3DSPage.clickBackToNormalUserDashboardButton();
		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

}
