package com.nymgo.tests.pages.nymgo.signUp;

import java.util.Map;

import org.testng.Assert;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.signUp.NormalUserSignUpPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 1, 2015
 */
public class NormalUserSignUpPage extends AbstractNymgoPage{
	
	private NormalUserSignUpPageFragment normalUserSignUpPageFragment;

	public NormalUserSignUpPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		normalUserSignUpPageFragment = new NormalUserSignUpPageFragment(driver);
	}

	private static final String NORMAL_USER_SIGN_UP_PAGE_NAME_EN = "NormalUserSignUpPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return NORMAL_USER_SIGN_UP_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return normalUserSignUpPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return normalUserSignUpPageFragment.getCorrectURL();
	}

	public void setFullName(String fullName){
		
		normalUserSignUpPageFragment.typeFullName(fullName);
	}

	public void setUsername(String username){
		
		normalUserSignUpPageFragment.typeUsername(username);
	}

	public void setPassword(String password){
		
		normalUserSignUpPageFragment.typePassword(password);
	}

	public void setConfirmPassword(String confirmPassword){
		
		normalUserSignUpPageFragment.typeConfirmPassword(confirmPassword);
	}

	public void setEmail(String email){
		
		normalUserSignUpPageFragment.typeEmail(email);
	}

	public void setMobile(String mobile){
		
		normalUserSignUpPageFragment.typeMobile(mobile);
	}

	public void clickJoinButton(){
		
		normalUserSignUpPageFragment.clickJoinButton();
	}
	
	//TODO instead of void
	public void setSignUpDataAndClickJoinSuccess(FullUserEntity fullUserEntity){
		
		setFullName(fullUserEntity.getFullName());
		setUsername(fullUserEntity.getUsername());
		setPassword(fullUserEntity.getPassword());
		setConfirmPassword(fullUserEntity.getPassword());
		setEmail(fullUserEntity.getEmail());
		setMobile(fullUserEntity.getMobile());
		clickJoinButton();
	}
	
	public void clearAllFields(){
		
		normalUserSignUpPageFragment.clearAllFields();
	}
	
	public void verifyEmptyFields(){

		clickJoinButton();
		Assert.assertEquals(normalUserSignUpPageFragment.getFullNameValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_NAME_REQUIRED));
		LOGGER.info("FullName required message is correct");
		Assert.assertEquals(normalUserSignUpPageFragment.getUsernameValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_REQUIRED));
		LOGGER.info("Username required message is correct");
		Assert.assertEquals(normalUserSignUpPageFragment.getEmailValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_REQUIRED));
		LOGGER.info("Email required message is correct");
		Assert.assertEquals(normalUserSignUpPageFragment.getPasswordValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_REQUIRED));
		LOGGER.info("Password required message is correct");
		Assert.assertEquals(normalUserSignUpPageFragment.getConfirmPasswordValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.CONFIRM_PASSWORD_REQUIRED));
		LOGGER.info("Confirm Password required message is correct");
		Assert.assertEquals(normalUserSignUpPageFragment.getMobileValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_REQUIRED));
		LOGGER.info("Mobile required message is correct");
	}

	public void verifyFullNameUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

//		Map<String, String> fullNameVerifies = ExcelUtils.getFullNameVerifyParameters();
//		for (String key : fullNameVerifies.keySet()){
		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(testString);
			setUsername(fullUserEntity.getUsername());
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getFullNameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_NAME_REQUIRED)), 
					"FullName required message is incorrect: '" + normalUserSignUpPageFragment.getFullNameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("FullName required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(normalUserSignUpPageFragment.getFullName(), testString.substring(1));
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(normalUserSignUpPageFragment.getFullName(), testString.substring(0, testString.length()-1));
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(normalUserSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(normalUserSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(normalUserSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
	}

	public void verifyUsernameUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(testString);				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_REQUIRED)), 
					"Username required message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_EXISTING_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotStartWithLatin")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_START_WITH_LATIN_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotLatinOnly")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ConsecutiveSpecial")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_CONSECUTIVE_SEPARATORS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Reserved")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue((normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_EXISTING_VALIDATION)))
					|| (normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION))), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyPasswordUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(testString);				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_REQUIRED)), 
					"Username required message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_EXISTING_VALIDATION)), 
					"Username length message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
	}
}
