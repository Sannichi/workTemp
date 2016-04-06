package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.pages.nymgo.menu.ResellersPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.ResellerSignInPage;

import org.testng.Assert;

public class SignInCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.LOGIN_USER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInNormalUserTest(FullUserEntity fullUserEntity){    

    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(fullUserEntity.getUsername(), fullUserEntity.getPassword());
		Assert.assertTrue(normalAccountPage.isUserLogged(fullUserEntity.getUsername()), "User was not logged");
    }
	
    @Test(dataProvider = PROVIDER_CONST.LOGIN_USER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInResellerTest(FullUserEntity fullUserEntity){    

		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(fullUserEntity.getUsername(), fullUserEntity.getPassword());
		Assert.assertTrue(resellerAccountPage.isUserLogged(fullUserEntity.getUsername()));
    }
}
