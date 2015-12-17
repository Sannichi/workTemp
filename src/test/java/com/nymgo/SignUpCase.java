package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
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
import com.nymgo.tests.pages.nymgo.signUp.ResellerSignUpPage;
import com.nymgo.tests.pages.tempMail.TempMailEmailListPage;

import org.testng.Assert;

public class SignUpCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.SIGN_UP_NORMAL_USER_PROVIDER, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserSuccessTest(FullUserEntity fullUserEntity){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		TempMailEmailListPage tempMailEmailListPage = normalUserSignUpPage.navigateToTempMailInNewTab();
		String signUpEmail = tempMailEmailListPage.getEmailAddress();
		String signUpUsername = signUpEmail.split("@")[0] + "Name";
        
		fullUserEntity = DataAdapter.getSignUpNormalUser();
		fullUserEntity.setEmail(signUpEmail);
		fullUserEntity.setUsername(signUpUsername);
		tempMailEmailListPage.navigateToTabByURL(normalUserSignUpPage.getPageURL());
		//TODO RegistrationPage + success message
		normalUserSignUpPage.setSignUpDataAndClickJoinSuccess(fullUserEntity);
		normalUserSignUpPage.navigateToTabByURL(tempMailEmailListPage.getPageURL());
		Assert.assertTrue(tempMailEmailListPage.isRegistrationSuccessEmailExists(), "Registration Success Email was not received");
		tempMailEmailListPage.openRegistrationSuccessEmail();
		
    }
	
    @Test    
	public void signUpNormalUserMandatoryFieldsTest(){    

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
	
    @Test(dataProvider = PROVIDER_CONST.EMAIL_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserEmailFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyEmailUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.MOBILE_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpNormalUserMobileFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
		NormalUserSignUpPage normalUserSignUpPage = homePage.clickJoinNowButton();
		normalUserSignUpPage.verifyMobileUnsuccess(testCaseName, testCaseString);
    }
	
    @Test    
	public void signUpResellerMandatoryFieldsTest(){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyEmptyFields();
    }
	
    @Test(dataProvider = PROVIDER_CONST.FULLNAME_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerFullNameFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyFullNameUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.BUSINESS_NAME_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerBusinessNameFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyBusinessNameUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.EMAIL_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerEmailFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyEmailUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.USERNAME_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerUsernameFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyUsernameUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.PHONE_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerPhoneFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyPhoneUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.MOBILE_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerMobileFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyMobileUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.CITY_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerCityFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyCityUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.COUNTRY_OF_RESIDENCE_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerCountryOfResidenceFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyCountryOfResidenceUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.FULL_ADDRESS_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerFullAddressFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyFullAddressUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.STREET_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerStreetFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyStreetUnsuccess(testCaseName, testCaseString);
    }
	
    @Test(dataProvider = PROVIDER_CONST.POSTAL_CODE_SIGN_UP_VERIFIES, dataProviderClass = GeneralDataProvider.class)    
	public void signUpResellerPostalCodeFieldTest(String testCaseName, String testCaseString){    

    	NymgoPage nymgoPage = new NymgoPage(starter);
    	HomePage homePage = nymgoPage.setDefaultState();
    	ResellersPage resellersPage = homePage.clickResellersLink();
    	ResellerSignUpPage resellerSignUpPage = resellersPage.clickJoinResellerButton();
    	resellerSignUpPage.verifyPostalCodeUnsuccess(testCaseName, testCaseString);
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
