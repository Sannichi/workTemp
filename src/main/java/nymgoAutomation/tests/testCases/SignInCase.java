package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullUserEntity;
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
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_GC_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInNormalUserTest(FullUserEntity... fullUserEntities){ 
		/*
		HomePage homePage = new HomePage(driver);
		homePage.setDefaultState();
		Assert.assertTrue(homePage.isCorrectPage());	
        System.out.println("Navigated to " + homePage.getPageName() + " page.");
		*/
    	/*
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();
		*/
		HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();
		String username = fullUserEntities[0].getUsername();
		String password = fullUserEntities[0].getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInEuroNormalWhitelistUserTest(FullUserEntity fullUserEntity){    
/*
    	NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();
*/
		HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInResellerTest(FullUserEntity fullUserEntity){
		
    	String login = fullUserEntity.getUsername();
    	String password = fullUserEntity.getPassword();
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

	@Test
	@Parameters({"masterLogin", "masterPassword"})
	public void signInMasterTest(String login, String password){
		
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}
}
