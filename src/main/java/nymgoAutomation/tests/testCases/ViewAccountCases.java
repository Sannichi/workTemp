package nymgoAutomation.tests.testCases;

import org.testng.annotations.Test;

import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ViewNormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class ViewAccountCases extends AbstractCase{

    @Test(dataProvider = PROVIDER_CONST.SET_NORMAL_USER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void editEuroNormalUserAccountTest(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ViewNormalAccountPage viewNormalAccountPage = normalAccountPage.clickViewFullNormalAccountButton();
		viewNormalAccountPage.editProfileAndSave(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language);
		LOGGER.info("mess");

	}

}
