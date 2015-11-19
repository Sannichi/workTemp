package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.MembersAdminPage;
import com.nymgo.tests.pages.admin.base.AdminPage;
import com.nymgo.tests.pages.admin.widgets.MemberListWidget;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class AdminNormalMembersCase extends AbstractCase{

	@Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void editNormalUserGatewayAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		AdminPage adminPage = new AdminPage(starter);

		MembersAdminPage membersAdminPage = adminPage.navigateMembersTab();
		String username = fullUserEntity.getUsername();
		membersAdminPage.searchUsernameExactMatch(username);
		MemberListWidget memberListWidget = membersAdminPage.openEditUserWidgetByUsername(username);
		memberListWidget.editUserPaymentMethod(gatewayName);
		LOGGER.info("End");
	}
	
}
