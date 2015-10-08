package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.pages.nymgo.HomePage;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.NymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.ResellersPage;
import nymgoAutomation.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import nymgoAutomation.tests.pages.nymgo.menu.signIn.ResellerSignInPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SignInCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_GC_PROVIDER, dataProviderClass = GeneralDataProvider.class)
//	@Parameters({"normalLogin", "normalPassword"})
	public void signInNormalUserTest(String login, String password){

		/*
		HomePage homePage = new HomePage(driver);
		homePage.setDefaultState();
		Assert.assertTrue(homePage.isCorrectPage());	
        System.out.println("Navigated to " + homePage.getPageName() + " page.");
		*/
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();
		
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(login, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(login));
	}
	
	@Test
	@Parameters({"resellerLogin", "resellerPassword"})
	public void signInResellerTest(String login, String password){
		
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.setDefaultState();

		ResellersPage resellersPage = nymgoPage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

	@Test
	@Parameters({"masterLogin", "masterPassword"})
	public void signInMasterTest(String login, String password){
		
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.setDefaultState();

		ResellersPage resellersPage = nymgoPage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}
}
