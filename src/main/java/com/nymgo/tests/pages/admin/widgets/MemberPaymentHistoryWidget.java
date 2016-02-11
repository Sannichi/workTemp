package com.nymgo.tests.pages.admin.widgets;

import java.util.Map;

import org.testng.Assert;

import com.nymgo.tests.fragments.admin.widgets.MemberPaymentHistoryWidgetFragment;
import com.nymgo.tests.navigation.PopupNavigation;
import com.nymgo.tests.pages.admin.popups.TransactionAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionDeclinedPopup;
import com.nymgo.tests.starter.Starter;

public class MemberPaymentHistoryWidget extends AbstractWidget{

	MemberPaymentHistoryWidgetFragment memberPaymentHistoryWidgetFragment;
	
	public MemberPaymentHistoryWidget(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		memberPaymentHistoryWidgetFragment = new MemberPaymentHistoryWidgetFragment(driver);
	}

	private static final String WIDGET_MEMBERS_PAYMENT_HISTORY_NAME_ENG = "Member Payment History"; 

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return memberPaymentHistoryWidgetFragment.getWidgetName();
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPageName().equals(WIDGET_MEMBERS_PAYMENT_HISTORY_NAME_ENG);
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return WIDGET_MEMBERS_PAYMENT_HISTORY_NAME_ENG;
	}

	public MemberPaymentHistoryWidget navigateToPaymentActionTab(){
		
		memberPaymentHistoryWidgetFragment.navigateToPaymentActionTab();
		return this;
	}
	
	public String getTransactionInformationRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.paymentActionFragment.getTransactionInformationRowValueByRowName(rowName);
	}

	public String getUserInformationRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.paymentActionFragment.getUserInformationRowValueByRowName(rowName);
	}

	public String getUserSummaryRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.paymentActionFragment.getUserSummaryRowValueByRowName(rowName);
	}

	private Map<String, String> getAllTransactionInformation(){
		
		return memberPaymentHistoryWidgetFragment.paymentActionFragment.getAllTransactionInformation();
	}

	protected void clickAcceptTransaction(){
		
		memberPaymentHistoryWidgetFragment.paymentActionFragment.clickAcceptTransaction();
	}

	protected void clickCancelTransaction(){
		
		memberPaymentHistoryWidgetFragment.paymentActionFragment.clickCancelTransaction();
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
		
		return memberPaymentHistoryWidgetFragment.paymentActionFragment.getPaymentActionTransactionID();
	}
	
	public TransactionAcceptedPopup verifyTransactionInformationAndAccept(String transactionID){
		
		navigateToPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickAcceptTransaction();
		TransactionAcceptedPopup transactionAcceptedPopup = new TransactionAcceptedPopup(starter);
		PopupNavigation<TransactionAcceptedPopup> navigation = new PopupNavigation<TransactionAcceptedPopup>(transactionAcceptedPopup);
		navigation.NavigatedTo();
		return transactionAcceptedPopup;
	}
	
	public TransactionDeclinedPopup verifyTransactionInformationAndCancel(String transactionID){
		
		navigateToPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickCancelTransaction();
		TransactionDeclinedPopup transactionDeclinedPopup = new TransactionDeclinedPopup(starter);
		PopupNavigation<TransactionDeclinedPopup> navigation = new PopupNavigation<TransactionDeclinedPopup>(transactionDeclinedPopup);
		navigation.NavigatedTo();
		return transactionDeclinedPopup;
	}
	
	public void closeMemberPaymentHistoryWidget(){
    	
    	closeWidget(getPageName());
    }
}
