package nymgoAutomation.tests.testCases;

import nymgoAutomation.tests.pages.admin.TransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.popups.TransactionAcceptedPopup;
import nymgoAutomation.tests.pages.admin.popups.TransactionDeclinedPopup;
import nymgoAutomation.tests.pages.admin.widgets.MemberPaymentHistoryWidget;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminTransactionsCase extends AbstractCase{
	
	@Test
	@Parameters({"transactionID", "username", "amount", "currency", "product", "service", "method", "country"})
	public void acceptNormalUserTransactionAdminTest(String transactionID, String username, String amount, String currency, String product, String service, String method, String country){

		AdminPage adminPage = new AdminPage(starter);

		TransactionsAdminPage transactionsAdminPage = adminPage.clickTransactionsLink();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		transactionsAdminPage.verifyTransactionData(transactionID, username, amount, currency, product, service, method, country);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgedByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}

	@Test
	@Parameters({"transactionID", "username", "amount", "currency", "product", "service", "method", "country"})
	public void cancelNormalUserTransactionAdminTest(String transactionID, String username, String amount, String currency, String product, String service, String method, String country){

		AdminPage adminPage = new AdminPage(starter);

		TransactionsAdminPage transactionsAdminPage = adminPage.clickTransactionsLink();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		transactionsAdminPage.verifyTransactionData(transactionID, username, amount, currency, product, service, method, country);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgedByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}
}
