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
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 11, 2015
 */
public class PayCreditCardCase extends AbstractCase{


    @Test
	public void payAmericanExpressGlobalCollectPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

    @Test
	public void payVisaGlobalCollectPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

    @Test
	public void payVisaGlobalCollectSuccessfulTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

    @Test
	public void payVisaGlobalCollectChallengedTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
	    	FullCardEntity fullCardEntity = DataAdapter.getVisaCard();
	    	
			BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);
	
			SuccessfulTransactionGlobalCollectPage successfulTransactionGlobalCollectPage = buyCreditConfirmPageGlobalCollect.setCreditCardDataAndClickContinueSuccessful(fullCardEntity.getCardNumber(), 
					fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
	
	//		Assert.assertTrue(successfulTransactionGlobalCollectPage.isTransactionChallenged(), 
	//				"Transaction is not challenged, current status is: " + successfulTransactionGlobalCollectPage.getPaymentStatus());
			Assert.assertTrue(successfulTransactionGlobalCollectPage.isTransactionChallenged() || successfulTransactionGlobalCollectPage.isTransactionSuccessful()
					 			|| successfulTransactionGlobalCollectPage.isTransactionPending(), 
					"Transaction is not challenged or autoaccepted or pending, current status is: " + successfulTransactionGlobalCollectPage.getPaymentStatus());
			String transactionID = successfulTransactionGlobalCollectPage.getTransactionNumber();
			String paymentStatus = successfulTransactionGlobalCollectPage.getPaymentStatus();
			if(successfulTransactionGlobalCollectPage.isTransactionSuccessful()){
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = true;
			}
			LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
			ExcelUtils.addTransactionData(transactionID);		
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = successfulTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
	//		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
		}
		else{
			LOGGER.fatal("User's limit is reached");
		}
	}

    @Test
	public void payMasterCardGlobalCollectPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionGlobalCollectPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payAmericanExpressWorldpayPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payVisaWorldpayPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payMasterCardWorldpayPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionWorldpayPage.clickBackToNormalUserDashboardButton();
	//Due to Deals values		
	//		Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payAmericanExpressAdyenDeclinedTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payVisaAdyenDeclinedTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payMasterCardAdyenDeclinedTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payMasterCardAdyenPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payVisaAdyenPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payAmericanExpressAdyenPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			@SuppressWarnings("unused")
			NormalAccountPage normalAccountPage = pendingTransactionAdyenPage.clickBackToNormalUserDashboardButton();
			//Due to Deals values		
//			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payAmericanExpressWorldpay3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
			
			Assert.assertEquals(normalAccountPage.getAccountBalanceValue(), ExcelUtils.getAccountBalanceBeforeTransaction(transactionID));
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payVisaWorldpay3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payMasterCardWorldpay3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}


	@Test
	public void payAmericanExpressAdyen3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payVisaAdyen3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test
	public void payMasterCardAdyen3DSPendingTest(){

    	if (!Starter.USER_LIMIT_REACHED){
        	
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
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

}
