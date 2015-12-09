package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.pages.nymgo.menu.ResellersPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.ResellerSignInPage;
import com.nymgo.tests.pages.nymgo.signUp.NormalUserSignUpPage;
import com.nymgo.tests.pages.tempMail.TempMailPage;

import org.testng.Assert;

public class SignUpCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.SIGN_UP_NORMAL_USER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserSuccessTest(FullUserEntity fullUserEntity){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		TempMailPage tempMailPage = normalUserSignUpPage.navigateToTempMailInNewTab();
		String signUpEmail = tempMailPage.getEmailAddress();
		String signUpUsername = signUpEmail.split("@")[0] + "Name";
        
		fullUserEntity.setEmail(signUpEmail);
		fullUserEntity.setUsername(signUpUsername);
		tempMailPage.navigateToTabByURL(normalUserSignUpPage.getPageURL());
		//TODO RegistrationPage + success message
		normalUserSignUpPage.setSignUpDataAndClickJoinSuccess(fullUserEntity);
		
    }
	
    @Test    
	public void signUpNormalUserMandatoryFieldsTest(FullUserEntity fullUserEntity){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyEmptyFields();
    }
	
    @Test(dataProvider = PROVIDER_CONST.FULLNAME_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserFullNameFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyFullNameUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.USERNAME_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserUsernameFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyUsernameUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.PASSWORD_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserPasswordFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyPasswordUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.CONFIRM_PASSWORD_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserConfirmPasswordFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyConfirmPasswordUnsuccess(testCaseName, testCaseString);
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
