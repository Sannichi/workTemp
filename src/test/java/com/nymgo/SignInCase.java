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
	
//    @Test(groups={"euroNormalSignIn"}, dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER, dataProviderClass = GeneralDataProvider.class)
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInEuroNormalWhitelistUserTest(FullUserEntity fullUserEntity){    

    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
//    @Test(groups={"euroResellerSignIn"}, dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInEuroResellerTest(FullUserEntity fullUserEntity){
		
    	String login = fullUserEntity.getUsername();
    	String password = fullUserEntity.getPassword();
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

//    @Test(groups={"euroMasterResellerSignIn"}, dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInEuroMasterResellerTest(FullUserEntity fullUserEntity){
		
    	String login = fullUserEntity.getUsername();
    	String password = fullUserEntity.getPassword();
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

//  @Test(groups={"interNormalSignIn"}, dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER, dataProviderClass = GeneralDataProvider.class)
  @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInInterNormalWhitelistUserTest(FullUserEntity fullUserEntity){    

  	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
  }
	
//  @Test(groups={"interResellerSignIn"}, dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
  @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInInterResellerTest(FullUserEntity fullUserEntity){
		
  	String login = fullUserEntity.getUsername();
  	String password = fullUserEntity.getPassword();
  	
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

//  @Test(groups={"interMasterResellerSignIn"}, dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)
  @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signInInterMasterResellerTest(FullUserEntity fullUserEntity){
		
  	String login = fullUserEntity.getUsername();
  	String password = fullUserEntity.getPassword();
  	
		NymgoPage nymgoPage = new NymgoPage(starter);
		HomePage homePage = nymgoPage.setDefaultState();

		ResellersPage resellersPage = homePage.clickResellersLink();
		ResellerSignInPage resellerSignInPage = resellersPage.clickResellerSignInButton();
		ResellerAccountPage resellerAccountPage = resellerSignInPage.signInResellerSuccess(login, password);
		Assert.assertTrue(resellerAccountPage.isUserLogged(login));
	}

}
