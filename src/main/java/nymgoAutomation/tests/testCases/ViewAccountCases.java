package nymgoAutomation.tests.testCases;

import org.testng.annotations.Test;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ViewNormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.base.NymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditProceedPageGlobalCollect;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class ViewAccountCases extends AbstractCase{

    @Test(dataProvider = PROVIDER_CONST.SET_NORMAL_USER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class, dependsOnGroups = {"euroNormalSignIn"})
	public void changeEuroNormalUserAccountTest(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ViewNormalAccountPage viewNormalAccountPage = normalAccountPage.clickViewFullNormalAccountButton();

	}

}
