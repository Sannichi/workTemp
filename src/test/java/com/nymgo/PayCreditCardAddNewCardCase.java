package com.nymgo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.PendingTransactionAdyenPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.PendingTransactionWorldpayPage;

/**
 * Created by Iuliia Khikmatova on Feb 11, 2016
 */
public class PayCreditCardAddNewCardCase extends AbstractCase{

	@Test
	public void payAmericanExpressWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = 
				buyCredit3DSProceedPageWorldpay.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payVisaWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = 
				buyCredit3DSProceedPageWorldpay.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payMasterCardWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = 
				buyCredit3DSProceedPageWorldpay.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
		String transactionID = pendingTransactionWorldpayPage.getTransactionNumber();
		String paymentStatus = pendingTransactionWorldpayPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payMasterCardAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = 
				buyCredit3DSProceedPageAdyen.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payVisaAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getVisaAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = 
				buyCredit3DSProceedPageAdyen.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		@SuppressWarnings("unused")
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
//		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
	}

	@Test
	public void payAmericanExpressAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getAmexAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		PendingTransactionAdyenPage pendingTransactionAdyenPage = 
				buyCredit3DSProceedPageAdyen.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
				fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
				"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
		String transactionID = pendingTransactionAdyenPage.getTransactionNumber();
		String paymentStatus = pendingTransactionAdyenPage.getPaymentStatus();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
		ExcelUtils.addTransactionData(transactionID);		
		NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
		softAssert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		
	}
}
