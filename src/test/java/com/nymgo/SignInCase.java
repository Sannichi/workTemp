package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
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
	
    @Test    
	public void signInEuroNormalWhitelistUserTest(){    

    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
//    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
    	
    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test    
	public void signInDealEuroNormalWhitelistUserTest(){    

    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
    	
    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test    
	public void signInRecurrentEuroNormalWhitelistUserTest(){    

    	FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroNormalWhitelist();
    	
    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test    
	public void signInEuroResellerTest(){
		
    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller();
    	
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
	public void signInDealEuroResellerTest(){
		
    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller();
    	
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
	public void signInEuroMasterResellerTest(){
		
    	FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller();
    	
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
	public void signInRecurrentEuroMasterResellerTest(){
		
    	FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroMasterReseller();
    	
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
	public void signInInterNormalWhitelistUserTest(){    

	  	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist();
	
  		HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
	}
	
    @Test    
	public void signInDealInterNormalWhitelistUserTest(){    

    	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterNormalUser();    	
    	
    	HomePage homePage = new HomePage(starter);
		NormalUserSignInPage normalUserSignInPage = homePage.clickMenuNormalUserSignInButton();

		String username = fullUserEntity.getUsername();
		String password = fullUserEntity.getPassword();
		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(username, password);
		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
	@Test    
	public void signInInterResellerTest(){
		
	  	FullUserEntity fullUserEntity = DataAdapter.getInterReseller();
	
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
	public void signInDealInterResellerTest(){
		
	  	FullUserEntity fullUserEntity = DataAdapter.getNymgoInterReseller();
	
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
	public void signInInterMasterResellerTest(){
		
    	FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller();
    	
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
