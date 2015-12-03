package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.NewEmailUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.pages.nymgo.menu.ResellersPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.ResellerSignInPage;
import com.nymgo.tests.pages.nymgo.signUp.NormalUserSignUpPage;
import com.nymgo.tests.pages.tempMail.TempMailPage;

import java.util.List;

import org.testng.Assert;

public class SignUpCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.SIGN_UP_NORMAL_USER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserSuccessTest(FullUserEntity fullUserEntity){    

    	HomePage homePage = new HomePage(starter);
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		TempMailPage tempMailPage = normalUserSignUpPage.navigateToTempMailInNewTab();
		String signUpEmail = tempMailPage.getEmailAddress();
		String signUpUsername = signUpEmail.split("@")[0] + "Name";
        
		String fullName = fullUserEntity.getFullName();
		String username = signUpUsername;
		String password = fullUserEntity.getPassword();
		String email = signUpEmail;
		String mobile = fullUserEntity.getMobile();
		tempMailPage.navigateToTabByURL(normalUserSignUpPage.getPageURL());
		normalUserSignUpPage.setSignUpDataAndClickJoinSuccess(fullName, username, password, email, mobile);
		
		LOGGER.info("Link is opened");
//		Assert.assertTrue(normalAccountPage.isUserLogged(username), "User was not logged");
    }
	
    @Test(dataProvider = PROVIDER_CONST.SIGN_UP_RESELLER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signUpEuroResellerTest(FullUserEntity fullUserEntity){
		
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
