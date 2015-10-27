package nymgoAutomation.tests.testCases;

import org.testng.annotations.Test;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.pages.admin.MembersAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.widgets.MemberListWidget;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class AdminResellersCase extends AbstractCase{

	@Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void editResellerGatewayAdminTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String conversionRate){

		AdminPage adminPage = new AdminPage(starter);

		MembersAdminPage membersAdminPage = adminPage.navigateMembersTab();
		String username = fullUserEntity.getUsername();
		membersAdminPage.searchUsernameExactMatch(username);
		MemberListWidget memberListWidget = membersAdminPage.openEditUserWidgetByUsername(username);
		memberListWidget.editUserPaymentMethod(gatewayName);
		LOGGER.info("End");
	}
	
}
