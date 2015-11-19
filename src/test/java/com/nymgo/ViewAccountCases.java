package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.account.ViewNormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ViewResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class ViewAccountCases extends AbstractCase{

//    @Test(groups={"editEuroNormalUser"}, dependsOnGroups={"euroNormalSignIn"}, dataProvider = PROVIDER_CONST.SET_NORMAL_USER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
    @Test(dataProvider = PROVIDER_CONST.SET_NORMAL_USER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)	
	public void editEuroNormalUserAccountTest(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ViewNormalAccountPage viewNormalAccountPage = normalAccountPage.clickViewFullNormalAccountButton();
		viewNormalAccountPage.editProfileAndSave(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language);
	}

//    @Test(groups={"editEuroReseller"}, dependsOnGroups={"euroResellerSignIn"}, dataProvider = PROVIDER_CONST.SET_RESELLER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
    @Test(dataProvider = PROVIDER_CONST.SET_RESELLER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void editEuroResellerAccountTest(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		ResellerAccountPage resellerAccountPage =  loggedNymgoPage.navigateToResellerMyAccountPage();
		ViewResellerAccountPage viewResellerAccountPage = resellerAccountPage.clickViewAccountDetailsButton();
		viewResellerAccountPage.editProfileAndSave(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language);
	}

}
