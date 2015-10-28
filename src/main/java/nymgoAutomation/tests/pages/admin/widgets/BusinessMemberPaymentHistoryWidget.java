package nymgoAutomation.tests.pages.admin.widgets;

import java.util.Map;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.admin.widgets.BusinessMemberPaymentHistoryWidgetFragment;
import nymgoAutomation.tests.navigation.PopupNavigation;
import nymgoAutomation.tests.pages.admin.popups.TransactionAcceptedPopup;
import nymgoAutomation.tests.pages.admin.popups.TransactionDeclinedPopup;
import nymgoAutomation.tests.starter.Starter;

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
/*
	public Map<String, String> getAllUserInformation(){
		
		return getAllTableInformation(getUserInformationTable());
	}

	public Map<String, String> getAllUserSummary(){
		
		return getAllTableInformation(getUserSummaryTable());
	}
*/
	protected void clickAcceptTransaction(){
		
		businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.clickAcceptTransaction();
	}

	protected void clickCancelTransaction(){
		
		businessMemberPaymentHistoryWidgetFragment.paymentActionFragment.clickCancelTransaction();
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
	
	public TransactionDeclinedPopup verifyTransactionInformationAndCancel(String transactionID){
		
		navigateToBusinessPaymentActionTab();
		Assert.assertTrue(getPaymentActionTransactionID().equals(transactionID));
		LOGGER.info("Transaction ID is correct");
		clickCancelTransaction();
		TransactionDeclinedPopup transactionDeclinedPopup = new TransactionDeclinedPopup(starter);
		PopupNavigation<TransactionDeclinedPopup> navigation = new PopupNavigation<TransactionDeclinedPopup>(transactionDeclinedPopup);
		navigation.NavigatedTo();
		return transactionDeclinedPopup;
	}
	
	public void closeBusinessMemberPaymentHistoryWidget(){
    	
    	closeWidget(getPageName());
    }
}
