package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.admin.BusinessTransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.NormalTransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.popups.TransactionAcceptedPopup;
import nymgoAutomation.tests.pages.admin.popups.TransactionDeclinedPopup;
import nymgoAutomation.tests.pages.admin.widgets.BusinessMemberPaymentHistoryWidget;
import nymgoAutomation.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import nymgoAutomation.tests.utils.CurrencyUtils;

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
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
//		transactionsAdminPage.verifyTransactionData(transactionID, username, amount, currency, product, service, method, country);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
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
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
//		transactionsAdminPage.verifyTransactionData(transactionID, username, amount, currency, product, service, method, country);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
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
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinBuyCurrencyValue(paymentCurrency);
		}
		transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), conversionRate,
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}

	@Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroNormalUserTransactionAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinBuyCurrencyValue(paymentCurrency);
		}
		transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), conversionRate,
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();
		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}

	@Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroResellerTransactionAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), conversionRate,
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		LOGGER.info("End");
	}

}
