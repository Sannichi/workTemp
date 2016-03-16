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
import com.nymgo.tests.pages.admin.popups.DealAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionAcceptedPopup;
import com.nymgo.tests.pages.admin.popups.TransactionCancelledPopup;
import com.nymgo.tests.pages.admin.popups.TransactionDeclinedPopup;
import com.nymgo.tests.pages.admin.widgets.BusinessMemberPaymentHistoryWidget;
import com.nymgo.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.CurrencyUtils;
import com.nymgo.tests.utils.DealDescriptionMap;
import com.nymgo.tests.utils.Rounder;

public class AdminTransactionsCase extends AbstractCase{
	
	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			AdminPage adminPage = new AdminPage(starter);
	
			if (! Starter.NORMAL_USER_VISA_AUTOACCEPTED){
				String transactionID = ExcelUtils.getLastTransaction();		
				Assert.assertNotNull(transactionID, "TransactionID is null!");
				NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
				transactionsAdminPage.searchIDExactMatch(transactionID);
				Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
				if (dealName == null){
					if(currencyAmount == null){
						currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
					}
				}
				else{
					currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
				}
				transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
						paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
				MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
				TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
				transactionAcceptedPopup.closeTransactionAcceptedPopup();
		//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
			}
			else{
				LOGGER.info("Visa transaction was autoaccepted");
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = false;
			}
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionCancelledPopup transactionCancelledPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
			transactionCancelledPopup.closeTransactionCancelledPopup();
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndDecline(transactionID);
			transactionDeclinedPopup.closeTransactionDeclinedPopup();
			transactionsAdminPage = transactionsAdminPage.clickDeclinedTransactionsLink();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionCancelledPopup transactionCancelledPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionCancelledPopup.closeTransactionCancelledPopup();
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
	}

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndDecline(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		businessTransactionsAdminPage = businessTransactionsAdminPage.clickDeclinedTransactionsLink();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionCancelledPopup transactionCancelledPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
			transactionCancelledPopup.closeTransactionCancelledPopup();
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void declineEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionDeclinedPopup transactionDeclinedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndDecline(transactionID);
			transactionDeclinedPopup.closeTransactionDeclinedPopup();
			transactionsAdminPage = transactionsAdminPage.clickDeclinedTransactionsLink();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
	
			if (! Starter.NORMAL_USER_VISA_AUTOACCEPTED){
				String transactionID = ExcelUtils.getLastTransaction();		
				Assert.assertNotNull(transactionID, "TransactionID is null!");
				NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
				transactionsAdminPage.searchIDExactMatch(transactionID);
				Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
				if (dealName == null){
					if(currencyAmount == null){
						currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
					}
				}
				else{
					currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
				}
				transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
						paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
				MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
				TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
				transactionAcceptedPopup.closeTransactionAcceptedPopup();
		//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
			}
			else{
				LOGGER.info("Visa transaction was autoaccepted");
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = false;
			}
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptNymgoEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();
			
			AdminPage adminPage = new AdminPage(starter);
	
			if (! Starter.NORMAL_USER_VISA_AUTOACCEPTED){
				String transactionID = ExcelUtils.getLastTransaction();		
				Assert.assertNotNull(transactionID, "TransactionID is null!");
				NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
				transactionsAdminPage.searchIDExactMatch(transactionID);
				Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
				if (dealName == null){
					if(currencyAmount == null){
						currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
					}
				}
				else{
					currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
				}
				transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
						paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
				MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
				TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
				transactionAcceptedPopup.closeTransactionAcceptedPopup();
		//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
			}
			else{
				LOGGER.info("Visa transaction was autoaccepted");
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = false;
			}
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptRecurrentEuroNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelEuroResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionCancelledPopup transactionCancelledPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionCancelledPopup.closeTransactionCancelledPopup();
//		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
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
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionDeclinedPopup transactionDeclinedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndDecline(transactionID);
		transactionDeclinedPopup.closeTransactionDeclinedPopup();
		businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		businessTransactionsAdminPage = businessTransactionsAdminPage.clickDeclinedTransactionsLink();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
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
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptNymgoEuroResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelEuroMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionCancelledPopup transactionCancelledPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionCancelledPopup.closeTransactionCancelledPopup();
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
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
//				currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);			
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptRecurrentEuroMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroMasterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		Assert.assertNotEquals(transactionID, " ", "TransactionID is empty!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
//				currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);			
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelInterNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
	
			String transactionID = ExcelUtils.getLastTransaction();		
			Assert.assertNotNull(transactionID, "TransactionID is null!");
			NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
			transactionsAdminPage.searchIDExactMatch(transactionID);
			Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
			if (dealName == null){
				if(currencyAmount == null){
					currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
				}
			}
			else{
				currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
			}
			transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
					paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
			MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
			TransactionCancelledPopup transactionCancelledPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
			transactionCancelledPopup.closeTransactionCancelledPopup();
	//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptInterNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
			
			AdminPage adminPage = new AdminPage(starter);
			
			if (! Starter.NORMAL_USER_VISA_AUTOACCEPTED){
				String transactionID = ExcelUtils.getLastTransaction();		
				Assert.assertNotNull(transactionID, "TransactionID is null!");
				NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
				transactionsAdminPage.searchIDExactMatch(transactionID);
				Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
				if (dealName == null){
					if(currencyAmount == null){
						currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
					}
				}
				else{
					currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
				}
				transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
						paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
				MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
				TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
				transactionAcceptedPopup.closeTransactionAcceptedPopup();
		//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
			}
			else{
				LOGGER.info("Visa transaction was autoaccepted");
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = false;
			}
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptNymgoInterNormalUserTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	if (!Starter.USER_LIMIT_REACHED){
        	
			FullUserEntity fullUserEntity = DataAdapter.getNymgoInterNormalUser();
			
			AdminPage adminPage = new AdminPage(starter);
			
			if (! Starter.NORMAL_USER_VISA_AUTOACCEPTED){
				String transactionID = ExcelUtils.getLastTransaction();		
				Assert.assertNotNull(transactionID, "TransactionID is null!");
				NormalTransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
				transactionsAdminPage.searchIDExactMatch(transactionID);
				Assert.assertFalse(transactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
				if (dealName == null){
					if(currencyAmount == null){
						currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);
					}
				}
				else{
					currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2));
				}
				transactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
						paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
				MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgetByID(transactionID);
				TransactionAcceptedPopup transactionAcceptedPopup = memberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
				transactionAcceptedPopup.closeTransactionAcceptedPopup();
		//		memberPaymentHistoryWidget.closeMemberPaymentHistoryWidget();
			}
			else{
				LOGGER.info("Visa transaction was autoaccepted");
				Starter.NORMAL_USER_VISA_AUTOACCEPTED = false;
			}
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    	}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelInterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionCancelledPopup transactionCancelledPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionCancelledPopup.closeTransactionCancelledPopup();
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
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void acceptNymgoInterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(),
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void cancelInterMasterResellerTransactionAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
		
		AdminPage adminPage = new AdminPage(starter);

		String transactionID = ExcelUtils.getLastTransaction();		
		Assert.assertNotNull(transactionID, "TransactionID is null!");
		BusinessTransactionsAdminPage businessTransactionsAdminPage = adminPage.navigateBusinessTransactionsTab();
		businessTransactionsAdminPage.searchIDExactMatch(transactionID);
		Assert.assertFalse(businessTransactionsAdminPage.isSearchResultEmpty(), "Search result by transaction ID = '" + transactionID + "' is empty");
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		TransactionCancelledPopup transactionCancelledPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndCancel(transactionID);
		transactionCancelledPopup.closeTransactionCancelledPopup();
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
		if (dealName == null){
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
			}
		}
		else{
			currencyAmount = String.valueOf(Rounder.roundFloat(DealDescriptionMap.getDealDescriptionByName(dealName).getPriceByPaymentCurrency(paymentCurrency), 2) 
					* Integer.valueOf(dealQuantity));
		}
		businessTransactionsAdminPage.verifyTransactionData(transactionID, fullUserEntity.getUsername(), currencyAmount, fullUserEntity.getVat(), 
				paymentCurrency, gatewayName, cardType, fullUserEntity.getGeoIpCountry(), dealName);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = businessTransactionsAdminPage.openViewBusinessTransactionsWidgetByID(transactionID);
		if (dealName == null){
			TransactionAcceptedPopup transactionAcceptedPopup = businessMemberPaymentHistoryWidget.verifyTransactionInformationAndAccept(transactionID);
			transactionAcceptedPopup.closeTransactionAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
		else{
			DealAcceptedPopup dealAcceptedPopup = businessMemberPaymentHistoryWidget.verifyDealInformationAndAccept(transactionID);
			dealAcceptedPopup.closeDealAcceptedPopup();
//			businessMemberPaymentHistoryWidget.closeBusinessMemberPaymentHistoryWidget();
		}
	}

}
