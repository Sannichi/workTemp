package nymgoAutomation.tests.pages.admin.widgets;

import java.util.Map;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.admin.widgets.MemberPaymentHistoryWidgetFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.PopupNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.admin.popups.TransactionAcceptedPopup;
import nymgoAutomation.tests.pages.admin.popups.TransactionDeclinedPopup;

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

	public MemberPaymentHistoryWidget navigateToPaymentActionTab(){
		
		memberPaymentHistoryWidgetFragment.navigateToPaymentActionTab();
		return this;
	}
	
	public String getTransactionInformationRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.getTransactionInformationRowValueByRowName(rowName);
	}

	public String getUserInformationRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.getUserInformationRowValueByRowName(rowName);
	}

	public String getUserSummaryRowValueByRowName(String rowName){
		
		return memberPaymentHistoryWidgetFragment.getUserSummaryRowValueByRowName(rowName);
	}

	private Map<String, String> getAllTransactionInformation(){
		
		return memberPaymentHistoryWidgetFragment.getAllTransactionInformation();
	}
/*
	public Map<String, String> getAllUserInformation(){
		
		return getAllTableInformation(getUserInformationTable());
	}

	public Map<String, String> getAllUserSummary(){
		
		return getAllTableInformation(getUserSummaryTable());
	}
*/
	private void clickAcceptTransaction(){
		
		memberPaymentHistoryWidgetFragment.clickAcceptTransaction();
	}

	private void clickCancelTransaction(){
		
		memberPaymentHistoryWidgetFragment.clickCancelTransaction();
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
		
		return memberPaymentHistoryWidgetFragment.getPaymentActionTransactionID();
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
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
	    	if(isWidgetExist()){
				clickOnCloseButton();
		        delay(2000);
		        LOGGER.info("Closing the Member Payment History Widget");            
		    	Assert.assertFalse(isWidgetExist(), "Member Payment History Widget was not closed");
				break;
			}
			if (i == 4){
		        LOGGER.fatal("Member Payment History Widget was not appeared in 10 seconds");            
			}
		}
    }
}
