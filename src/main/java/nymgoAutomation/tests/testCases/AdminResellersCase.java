package nymgoAutomation.tests.testCases;

import org.testng.annotations.Test;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.pages.admin.BusinessMembersAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.widgets.BusinessMemberListWidget;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class AdminResellersCase extends AbstractCase{

	@Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void editResellerGatewayAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

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
	
	@Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void editMasterResellerGatewayAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

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
