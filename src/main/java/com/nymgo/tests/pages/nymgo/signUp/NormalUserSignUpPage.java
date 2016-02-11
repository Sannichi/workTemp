package com.nymgo.tests.pages.nymgo.signUp;

import javax.swing.JOptionPane;

import org.testng.Assert;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
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
	
	public boolean getRecaptchaState(){
		
		return normalUserSignUpPageFragment.getRecaptchaState();
	}
	
	public void waitRecaptchaFieldHasText(){

		if (!normalUserSignUpPageFragment.waitRecaptchaFieldHasText()){
			LOGGER.fatal("Recaptcha was not entered within 90 seconds!");
		}
	}
	
	public NormalUserSignUpPage setSignUpDataAndClickJoin(FullUserEntity fullUserEntity){
		
		setFullName(fullUserEntity.getFullName());
		setUsername(fullUserEntity.getUsername());
		setPassword(fullUserEntity.getPassword());
		setConfirmPassword(fullUserEntity.getPassword());
		setEmail(fullUserEntity.getEmail());
		setMobile(fullUserEntity.getMobile());
		if(getRecaptchaState()){
			String message = "Recaptcha is on the Screen. Please, enter the Captcha.";
			LOGGER.warn(message);
			JOptionPane.showMessageDialog(null, message);
			waitRecaptchaFieldHasText();
			delay(5);
		}
		clickJoinButton();
		return this;
	}
	
	public NormalUserSignUpPage setSignUpDataAndClickJoinSuccess(FullUserEntity fullUserEntity){
		
		NormalUserSignUpPage normalUserSignUpPage = setSignUpDataAndClickJoin(fullUserEntity);
		if(!isSuccessRegistrationMessageExists()){
			if(getRecaptchaState()){
				String message = "Recaptcha is on the Screen. Please, enter the Captcha.";
				LOGGER.warn(message);
				JOptionPane.showMessageDialog(null, message);
				waitRecaptchaFieldHasText();
				delay(5);
				return setSignUpDataAndClickJoin(fullUserEntity);
			}
		}
		return normalUserSignUpPage;
	}
	
	public boolean isSuccessRegistrationMessageExists(){

		return normalUserSignUpPageFragment.getSuccessMessageState();
	}
	
	public NormalUserSignUpPage verifySuccessRegistrationMessage(){

		Assert.assertTrue(getSuccessMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_MESSAGE)), "Success Message is incorrect: '" + getSuccessMessage() + "'");		
		return this;
	}
	
	public void clearAllFields(){
		
		normalUserSignUpPageFragment.clearAllFields();
	}
	
	public void verifyEmptyFields(){

		clearAllFields();
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
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_EXISTING_VALIDATION)), 
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotStartWithLatin")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_START_WITH_LATIN_VALIDATION)), 
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotLatinOnly")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ConsecutiveSpecial")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_CONSECUTIVE_SEPARATORS_VALIDATION)), 
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Reserved")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_RESERVED_VALIDATION)), 
					"Username validation message is incorrect: '" + normalUserSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyPasswordUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(fullUserEntity.getUsername());				
			setPassword(testString);
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_REQUIRED)), 
					"Password required message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ContainSpace")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(fullUserEntity.getUsername());				
			setPassword(testString);
			setConfirmPassword(testString);
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Password length message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ContainSemicolon")){
			clearAllFields();
			setPassword(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_SEMICOLON_VALIDATION)), 
					"Password length message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setPassword(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_LENGTH_VALIDATION)), 
					"Password length message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setPassword(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_LENGTH_VALIDATION)), 
					"Password length message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("IdenticalToUsername")){
			clearAllFields();
			setUsername(testString);				
			setPassword(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_USERNAME_VALIDATION)), 
					"Password validation message is incorrect: '" + normalUserSignUpPageFragment.getPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Password validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("DisplayAs")){
			clearAllFields();
			setPassword(testString);
			String passwordDisplay = "";
			for (int i = 0; i < testString.toCharArray().length; i++){
				passwordDisplay += "*";
			}
			Assert.assertTrue(normalUserSignUpPageFragment.getPassword().equals(passwordDisplay), 
					"Password displays incorrect: '" + normalUserSignUpPageFragment.getPassword() + "' for test '" + testName + "'");
			LOGGER.info("Password displays correct for test '" + testName + "'");
		}
	}

	public void verifyConfirmPasswordUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getConfirmPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CONFIRM_PASSWORD_REQUIRED)), 
					"Confirm Password required message is incorrect: '" + normalUserSignUpPageFragment.getConfirmPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Confirm Password required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MatchPassword")){
			clearAllFields();
			setPassword(testString);
			setConfirmPassword("not" + testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getConfirmPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CONFIRM_PASSWORD_MATCH_PASSWORD_VALIDATION)), 
					"Confirm Password required message is incorrect: '" + normalUserSignUpPageFragment.getConfirmPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Confirm Password required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("DisplayAs")){
			clearAllFields();
			setPassword(testString);
			String passwordDisplay = "";
			for (int i = 0; i < testString.toCharArray().length; i++){
				passwordDisplay += "*";
			}
			Assert.assertTrue(normalUserSignUpPageFragment.getPassword().equals(passwordDisplay), 
					"Password displays incorrect: '" + normalUserSignUpPageFragment.getPassword() + "' for test '" + testName + "'");
			LOGGER.info("Password displays correct for test '" + testName + "'");
		}
		else if(testName.equals("CaseSensitive")){
			clearAllFields();
			setPassword(testString.toUpperCase());
			setConfirmPassword(testString.toLowerCase());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getConfirmPasswordValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CONFIRM_PASSWORD_MATCH_PASSWORD_VALIDATION)), 
					"Confirm Password required message is incorrect: '" + normalUserSignUpPageFragment.getConfirmPasswordValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Confirm Password required message is correct for test '" + testName + "'");
		}
	}

	public void verifyEmailUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(testString);
			setMobile(fullUserEntity.getMobile());
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_REQUIRED)), 
					"Email required message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithDot")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithDot")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_EXISTING_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ConsecutiveDots")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Reserved")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_RESERVED_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidDomain")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ContainSpace")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + normalUserSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyMobileUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setEmail(fullUserEntity.getEmail());
			setMobile(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getMobileValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_REQUIRED)), 
					"Mobile required message is incorrect: '" + normalUserSignUpPageFragment.getMobileValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Mobile required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidPattern")){
			clearAllFields();
			setMobile(testString);
			clickJoinButton();
			Assert.assertTrue(normalUserSignUpPageFragment.getMobileValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_INVALID_PATTERN_VALIDATION)), 
					"Mobile validation message is incorrect: '" + normalUserSignUpPageFragment.getMobileValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Mobile validation message is correct for test '" + testName + "'");
		}
	}
}
