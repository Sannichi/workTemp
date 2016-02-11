package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.BusinessTransactionsAdminPage;
import com.nymgo.tests.pages.admin.NormalTransactionsAdminPage;
import com.nymgo.tests.pages.admin.base.AdminPage;
import com.nymgo.tests.pages.admin.popups.TransactionAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionDeclinedPopup;
import com.nymgo.tests.pages.admin.widgets.BusinessMemberPaymentHistoryWidget;
import com.nymgo.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import com.nymgo.tests.utils.CurrencyUtils;

public class AdminTransactionsCase extends AbstractCase{
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
		
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

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
		
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

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		Assert.assertNotEquals(transactionID, " ", "TransactionID is empty!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);			
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineInterNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
		
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

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineInterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
		
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

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineInterMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
		
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
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		Assert.assertNotEquals(transactionID, " ", "TransactionID is empty!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry());
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
		transactionAcceptedPopup.closeTransactionAcceptedPopup();;
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

}
