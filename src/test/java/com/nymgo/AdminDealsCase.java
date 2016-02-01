package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.BusinessTransactionsAdminPage;
import com.nymgo.tests.pages.admin.NormalTransactionsAdminPage;
import com.nymgo.tests.pages.admin.base.AdminPage;
import com.nymgo.tests.pages.admin.popups.TransactionAcceptedPopup;
import com.nymgo.tests.pages.admin.widgets.BusinessMemberPaymentHistoryWidget;
import com.nymgo.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import com.nymgo.tests.utils.CurrencyUtils;

/**
 * Created by Iuliia Khikmatova on Jan 22, 2016
 */
public class AdminDealsCase extends AbstractCase{
	
	@Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroNormalUserDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
		}
		transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();
//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroResellerDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroMasterResellerDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		Assert.assertNotEquals(transactionID, " ", "TransactionID is empty!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterNormalUserDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		transactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
		}
		transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();
//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterResellerDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterMasterResellerDealAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		Assert.assertNotEquals(transactionID, " ", "TransactionID is empty!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

}