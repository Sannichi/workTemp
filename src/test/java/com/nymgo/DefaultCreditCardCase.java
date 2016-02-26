package com.nymgo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.PendingTransactionAdyenPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.PendingTransactionWorldpayPage;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class DefaultCreditCardCase extends AbstractCase{
    
	@Test
    public void setAdyenDefaultRecurrentCreditCard(){
    	
    	FullCardEntity fullCardEntity = DataAdapter.getDefaultRecurrentCreditCard();

		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		
		if (!buyCredit3DSProceedPageAdyen.compareFirstAndLastCreditCardSections(buyCredit3DSProceedPageAdyen.getSavedCardNumber(), 
				fullCardEntity.getCardNumber())){
			PendingTransactionAdyenPage pendingTransactionAdyenPage = buyCredit3DSProceedPageAdyen.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
					fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(pendingTransactionAdyenPage.isTransactionPending(), 
					"Transaction is not pending, current status is: " + pendingTransactionAdyenPage.getPaymentStatus());
			softAssert.assertAll();
		}
    }

	@Test
    public void setWorldpayDefaultRecurrentCreditCard(){
    	
    	FullCardEntity fullCardEntity = DataAdapter.getDefaultRecurrentCreditCard();

		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);		
		
		if (!buyCredit3DSProceedPageWorldpay.compareFirstAndLastCreditCardSections(buyCredit3DSProceedPageWorldpay.getSavedCardNumber(), 
				fullCardEntity.getCardNumber())){
			PendingTransactionWorldpayPage pendingTransactionWorldpayPage = buyCredit3DSProceedPageWorldpay.addNewCreditCardSetCreditCardDataAndClickPay(fullCardEntity.getCardNumber(), 
					fullCardEntity.getCardholdersName(), fullCardEntity.getExpirationMonth(), fullCardEntity.getExpirationYear(), fullCardEntity.getCvv());
	
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(pendingTransactionWorldpayPage.isTransactionPending(), 
					"Transaction is not pending, current status is: " + pendingTransactionWorldpayPage.getPaymentStatus());
			softAssert.assertAll();
		}
    }
}
