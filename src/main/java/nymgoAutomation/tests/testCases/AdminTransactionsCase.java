package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.admin.TransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.popups.TransactionAcceptedPopup;
import nymgoAutomation.tests.pages.admin.popups.TransactionDeclinedPopup;
import nymgoAutomation.tests.pages.admin.widgets.MemberPaymentHistoryWidget;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminTransactionsCase extends AbstractCase{
	
	@Test
	@Parameters({"transactionID", "username", "amount", "currency", "product", "service", "method", "country"})
	public void acceptNormalUserTransactionAdminTest(String transactionID, String username, String amount, String currency, String product, String service, String method, String country){

		AdminPage adminPage = new AdminPage(starter);

		transactionID = ExcelUtils.getLastTransactionByUsername(username);
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		LOGGER.info("Last transaction ID = " + transactionID);
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
	public void declineNormalUserTransactionAdminTest(String transactionID, String username, String amount, String currency, String product, String service, String method, String country){

		AdminPage adminPage = new AdminPage(starter);

		transactionID = ExcelUtils.getLastTransactionByUsername(username);
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		TransactionsAdminPage transactionsAdminPage = adminPage.clickTransactionsLink();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		transactionsAdminPage.verifyTransactionData(transactionID, username, amount, currency, product, service, method, country);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgedByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}

	@Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroNormalUserTransactionAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		AdminPage adminPage = new AdminPage(starter);

//		String transactionID = ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername());
		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		TransactionsAdminPage transactionsAdminPage = adminPage.clickTransactionsLink();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), 
				String.valueOf(Double.valueOf(currencyAmount)*Double.valueOf(fullUserEntity.getVat())/100 + Integer.valueOf(currencyAmount))+paymentCurrency+"/"
						+(String.valueOf(String.valueOf((Double.valueOf(currencyAmount)*Double.valueOf(fullUserEntity.getVat())/100 + Integer.valueOf(currencyAmount))*Integer.valueOf(conversionRate))))+"$", 
				paymentCurrency, "$"+currencyAmount, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgedByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}
}
