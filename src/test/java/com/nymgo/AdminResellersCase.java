package com.nymgo;

import org.testng.annotations.Test;

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

	@Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editResellerGatewayAdminTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

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
