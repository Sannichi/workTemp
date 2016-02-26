package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.BusinessMembersAdminPage;
import com.nymgo.tests.pages.admin.base.AdminPage;
import com.nymgo.tests.pages.admin.widgets.BusinessMemberListWidget;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class AdminResellersCase extends AbstractCase{

	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editEuroResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editDealEuroResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editEuroMasterResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editRecurrentEuroMasterResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroMasterReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editInterResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editDealInterResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
	@Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editInterMasterResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller(); 
		
		AdminPage adminPage = new AdminPage(starter);

		BusinessMembersAdminPage businessMembersAdminPage = adminPage.navigateBusinessMembersTab();
		String username = fullUserEntity.getUsername();
		businessMembersAdminPage.searchUsernameExactMatch(username);
		BusinessMemberListWidget businessMemberListWidget = businessMembersAdminPage.openEditBusinessUserWidgetByUsername(username);
		if (gatewayName != null){
			businessMemberListWidget.editBusinessUserPaymentMethod(gatewayName);
		}
		if (bonusType != null){
			businessMemberListWidget.editBusinessUserBonusType(bonusType, bonusTypeValue);
		}
		LOGGER.info("End");
	}
	
}
