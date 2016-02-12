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
public class PayCreditCardRecurrentCase extends AbstractCase{

	@Test
	public void payRecurrentMasterCardWorldpayPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(buyCredit3DSProceedPageWorldpay.compareFirstAndLastCreditCardSections(buyCredit3DSProceedPageWorldpay.getSavedCardNumber(), 
				fullCardEntity.getCardNumber()), "Saved recurrent card number not equals to current card number, saved card number is '" + 
						buyCredit3DSProceedPageWorldpay.getSavedCardNumber() + "', current card number is '" + fullCardEntity.getCardNumber() + "'");

		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.selectSavedCreditCardAndClickPay();

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
	public void payRecurrentMasterCardAdyenPendingTest(){

    	FullCardEntity fullCardEntity = DataAdapter.getMasterCardAdyenCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(buyCredit3DSProceedPageAdyen.compareFirstAndLastCreditCardSections(buyCredit3DSProceedPageAdyen.getSavedCardNumber(), 
				fullCardEntity.getCardNumber()), "Saved recurrent card number not equals to current card number, saved card number is '" + 
						buyCredit3DSProceedPageAdyen.getSavedCardNumber() + "', current card number is '" + fullCardEntity.getCardNumber() + "'");

		PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSProceedPageAdyen.selectSavedCreditCardAndClickPay();

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
