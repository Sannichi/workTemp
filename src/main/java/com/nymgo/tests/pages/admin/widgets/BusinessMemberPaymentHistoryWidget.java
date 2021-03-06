package com.nymgo.tests.pages.admin.widgets;

import java.util.Map;

import org.testng.Assert;

import com.nymgo.tests.fragments.admin.widgets.BusinessMemberPaymentHistoryWidgetFragment;
import com.nymgo.tests.navigation.PopupNavigation;
import com.nymgo.tests.pages.admin.popups.DealAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionCancelledPopup;
import com.nymgo.tests.pages.admin.popups.TransactionDeclinedPopup;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class BusinessMemberPaymentHistoryWidget extends AbstractWidget{

	BusinessMemberPaymentHistoryWidgetFragment businessMemberPaymentHistoryWidgetFragment;
	
	public BusinessMemberPaymentHistoryWidget(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		businessMemberPaymentHistoryWidgetFragment = new BusinessMemberPaymentHistoryWidgetFragment(driver);
	}

	private static final String WIDGET_BUSINESS_MEMBERS_PAYMENT_HISTORY_NAME_ENG = "Transaction Business Member Payment History"; 

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return businessMemberPaymentHistoryWidgetFragment.getWidgetName();
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPageName().equals(WIDGET_BUSINESS_MEMBERS_PAYMENT_HISTORY_NAME_ENG);
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return WIDGET_BUSINESS_MEMBERS_PAYMENT_HISTORY_NAME_ENG;
	}


	public BusinessMemberPaymentHistoryWidget navigateToBusinessPaymentActionTab(){
		
		businessMemberPaymentHistoryWidgetFragment.navigateToBusinessPaymentActionTab();
		return this;
	}
	
	public String getTransactionInformationRowValueByRowName(String rowName){
		
		return businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.getTransactionInformationRowValueByRowName(rowName);
	}

	public String getUserInformationRowValueByRowName(String rowName){
		
		return businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.getUserInformationRowValueByRowName(rowName);
	}

	public String getUserSummaryRowValueByRowName(String rowName){
		
		return businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.getUserSummaryRowValueByRowName(rowName);
	}

	private Map<String, String> getAllTransactionInformation(){
		
		return businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.getAllTransactionInformation();
	}

	protected void clickAcceptTransaction(){
		
		businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.clickAcceptTransaction();
	}

	protected void clickCancelTransaction(){
		
		businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.clickCancelTransaction();
	}

	protected void clickDeclineTransaction(){
		
		businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.clickDeclineTransaction();
	}

	public Map<String, String> acceptAndReturnTransactionInformation(){
		
		Map<String, String> allTransactionParameters = getAllTransactionInformation();
		clickAcceptTransaction();
		return allTransactionParameters;
	}

	public Map<String, String> cancelAndReturnTransactionInformatiom(){
		
		Map<String, String> allTransactionParameters = getAllTransactionInformation();
		clickCancelTransaction();
		return allTransactionParameters;
	}
	
	public String getPaymentActionTransactionID(){
		
		return businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.getPaymentActionTransactionID();
	}
	
	public TransactionAcceptedPopup verifyTransactionInformationAndAccept(String transactionID){
		
		navigateToBusinessPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickAcceptTransaction();
		TransactionAcceptedPopup transactionAcceptedPopup = new TransactionAcceptedPopup(starter);
		PopupNavigation<TransactionAcceptedPopup> navigation = new PopupNavigation<TransactionAcceptedPopup>(transactionAcceptedPopup);
		navigation.NavigatedTo();
		return transactionAcceptedPopup;
	}
	
	public DealAcceptedPopup verifyDealInformationAndAccept(String transactionID){
		
		navigateToBusinessPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Deal ID is correct");
		clickAcceptTransaction();
		DealAcceptedPopup dealAcceptedPopup = new DealAcceptedPopup(starter);
		PopupNavigation<DealAcceptedPopup> navigation = new PopupNavigation<DealAcceptedPopup>(dealAcceptedPopup);
		navigation.NavigatedTo();
		return dealAcceptedPopup;
	}
	
	public TransactionCancelledPopup verifyTransactionInformationAndCancel(String transactionID){
		
		navigateToBusinessPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickCancelTransaction();
		TransactionCancelledPopup transactionCancelledPopup = new TransactionCancelledPopup(starter);
		PopupNavigation<TransactionCancelledPopup> navigation = new PopupNavigation<TransactionCancelledPopup>(transactionCancelledPopup);
		navigation.NavigatedTo();
		return transactionCancelledPopup;
	}
	
	public TransactionDeclinedPopup verifyTransactionInformationAndDecline(String transactionID){
		
		navigateToBusinessPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickDeclineTransaction();
		TransactionDeclinedPopup transactionDeclinedPopup = new TransactionDeclinedPopup(starter);
		PopupNavigation<TransactionDeclinedPopup> navigation = new PopupNavigation<TransactionDeclinedPopup>(transactionDeclinedPopup);
		navigation.NavigatedTo();
		return transactionDeclinedPopup;
	}
	
	public void closeBusinessMemberPaymentHistoryWidget(){
    	
    	closeWidget(getPageName());
    }
}
