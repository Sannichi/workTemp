package com.nymgo.tests.pages.nymgo.signUp;

import org.testng.Assert;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.signUp.ResellerSignUpPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 1, 2015
 */
public class ResellerSignUpPage extends AbstractNymgoPage {
	
	private ResellerSignUpPageFragment resellerSignUpPageFragment; 

	public ResellerSignUpPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellerSignUpPageFragment = new ResellerSignUpPageFragment(driver);
	}

	private static final String RESELLER_SIGN_UP_PAGE_NAME_EN = "ResellerSignUpPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLER_SIGN_UP_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return resellerSignUpPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return resellerSignUpPageFragment.getCorrectURL();
	}

	public void setFullName(String fullName){
		
		resellerSignUpPageFragment.setFullName(fullName);
	}

	public void setBusinessName(String businessName){
		
		resellerSignUpPageFragment.setBusinessName(businessName);
	}

	public void setEmail(String email){
		
		resellerSignUpPageFragment.setEmail(email);
	}

	public void setUsername(String username){
		
		resellerSignUpPageFragment.setUsername(username);
	}

	public void setPassword(String password){
		
		resellerSignUpPageFragment.setPassword(password);
	}

	public void setConfirmPassword(String confirmPassword){
		
		resellerSignUpPageFragment.setConfirmPassword(confirmPassword);
	}

	public void setPhone(String phone){
		
		resellerSignUpPageFragment.setPhone(phone);
	}

	public void setMobile(String mobile){
		
		resellerSignUpPageFragment.setMobile(mobile);
	}

	public void selectCountryOfResidence(String countryOfResidence){
		
		resellerSignUpPageFragment.selectCountryOfResidence(countryOfResidence);
	}

	public void selectCountryOfResidenceToNone(){
		
		resellerSignUpPageFragment.selectCountryOfResidenceToNone();
	}

	public void setCity(String city){
		
		resellerSignUpPageFragment.setCity(city);
	}

	public void setFullAddress(String fullAddress){
		
		resellerSignUpPageFragment.setFullAddress(fullAddress);
	}

	public void setStreet(String street){
		
		resellerSignUpPageFragment.setStreet(street);
	}

	public void setPostalCode(String postalCode){
		
		resellerSignUpPageFragment.setPostalCode(postalCode);
	}

	public void clickJoinButton(){
		
		resellerSignUpPageFragment.clickJoinButton();
	}

	public String getSuccessMessage(){
		
		return resellerSignUpPageFragment.getSuccessMessage();
	}
	
	public void clearAllFields(){
		
		resellerSignUpPageFragment.clearAllFields();
	}
	
	public ResellerSignUpPage setSignUpDataAndClickJoinSuccess(FullUserEntity fullUserEntity){
		
		setFullName(fullUserEntity.getFullName());
		setBusinessName(fullUserEntity.getBusinessName());
		setEmail(fullUserEntity.getEmail());
		setUsername(fullUserEntity.getUsername());
		setPassword(fullUserEntity.getPassword());
		setConfirmPassword(fullUserEntity.getPassword());
		setPhone(fullUserEntity.getPhone());
		setMobile(fullUserEntity.getMobile());
		selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
		setCity(fullUserEntity.getCity());
		setFullAddress(fullUserEntity.getFullAddress());
		setStreet(fullUserEntity.getStreet());
		setPostalCode(fullUserEntity.getPostalCode());
		clickJoinButton();
		ResellerSignUpPage resellerSignUpPage = new ResellerSignUpPage(starter);
		PageNavigation<ResellerSignUpPage> navigation = new PageNavigation<ResellerSignUpPage>(resellerSignUpPage);
		navigation.NavigatedTo();
		return resellerSignUpPage;
	}

	public void verifyEmptyFields(){

		clearAllFields();
		clickJoinButton();
		Assert.assertEquals(resellerSignUpPageFragment.getFullNameValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_NAME_REQUIRED));
		LOGGER.info("FullName required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getBusinessNameValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.BUSINESS_NAME_REQUIRED));
		LOGGER.info("BusinessName required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getEmailValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_REQUIRED));
		LOGGER.info("Email required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getUsernameValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_REQUIRED));
		LOGGER.info("Username required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getPasswordValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.PASSWORD_REQUIRED));
		LOGGER.info("Password required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getConfirmPasswordValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.CONFIRM_PASSWORD_REQUIRED));
		LOGGER.info("Confirm Password required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getPhoneValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.PHONE_REQUIRED));
		LOGGER.info("Phone required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getMobileValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_REQUIRED));
		LOGGER.info("Mobile required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getCountryOfResidenceValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.COUNTRY_OF_RESIDENCE_REQIURED));
		LOGGER.info("Country Of Residence required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getCityValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.CITY_REQUIRED));
		LOGGER.info("City required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getFullAddressValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_ADDRESS_REQUIRED));
		LOGGER.info("FullAddress required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getStreetValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.STREET_REQUIRED));
		LOGGER.info("Street required message is correct");
		Assert.assertEquals(resellerSignUpPageFragment.getPostalCodeValidationMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.POSTAL_CODE_REQUIRED));
		LOGGER.info("Postal Code required message is correct");
	}

	public void verifyFullNameUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(testString);
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getFullNameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_NAME_REQUIRED)), 
					"FullName required message is incorrect: '" + resellerSignUpPageFragment.getFullNameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("FullName required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getFullName(), testString.substring(1));
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getFullName(), testString.substring(0, testString.length()-1));
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setFullName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getFullName(), testString);
			LOGGER.info("FullName is correct for test '" + testName + "'");
		}
	}

	public void verifyBusinessNameUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(testString);
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getBusinessNameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.BUSINESS_NAME_REQUIRED)), 
					"BusinessName required message is incorrect: '" + resellerSignUpPageFragment.getBusinessNameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("BusinessName required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setBusinessName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getBusinessName(), testString.substring(1));
			LOGGER.info("BusinessName is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setBusinessName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getBusinessName(), testString.substring(0, testString.length()-1));
			LOGGER.info("BusinessName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setBusinessName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getBusinessName(), testString);
			LOGGER.info("BusinessName is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setBusinessName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getBusinessName(), testString);
			LOGGER.info("BusinessName is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setBusinessName(testString);
			clickJoinButton();
			Assert.assertEquals(resellerSignUpPageFragment.getBusinessName(), testString);
			LOGGER.info("BusinessName is correct for test '" + testName + "'");
		}
	}

	public void verifyEmailUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(testString);
			setUsername(fullUserEntity.getUsername());
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_REQUIRED)), 
					"Email required message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithDot")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithDot")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_EXISTING_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ConsecutiveDots")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Reserved")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_RESERVED_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidDomain")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_INVALID_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ContainSpace")){
			clearAllFields();
			setEmail(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getEmailValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.EMAIL_SYMBOLS_VALIDATION)), 
					"Email validation message is incorrect: '" + resellerSignUpPageFragment.getEmailValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Email validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyUsernameUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(testString);				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_REQUIRED)), 
					"Username required message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("StartWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("EndWithSpace")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username length message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_LENGTH_VALIDATION)), 
					"Username length message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("SpecialSymbols")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Existing")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_EXISTING_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotStartWithLatin")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_START_WITH_LATIN_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("NotLatinOnly")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_SYMBOLS_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("ConsecutiveSpecial")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_CONSECUTIVE_SEPARATORS_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("Reserved")){
			clearAllFields();
			setUsername(testString);				
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getUsernameValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.USERNAME_RESERVED_VALIDATION)), 
					"Username validation message is incorrect: '" + resellerSignUpPageFragment.getUsernameValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Username validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyPhoneUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(testString);
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getPhoneValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PHONE_REQUIRED)), 
					"Phone required message is incorrect: '" + resellerSignUpPageFragment.getPhoneValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Phone required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidPattern")){
			clearAllFields();
			setPhone(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getPhoneValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PHONE_RESELLER_INVALID_PATTERN_VALIDATION)), 
					"Phone validation message is incorrect: '" + resellerSignUpPageFragment.getPhoneValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Phone validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyMobileUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(testString);
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getMobileValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_REQUIRED)), 
					"Mobile required message is incorrect: '" + resellerSignUpPageFragment.getMobileValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Mobile required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidPattern")){
			clearAllFields();
			setMobile(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getMobileValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MOBILE_RESELLER_INVALID_PATTERN_VALIDATION)), 
					"Mobile validation message is incorrect: '" + resellerSignUpPageFragment.getMobileValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Mobile validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyCountryOfResidenceUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidenceToNone();
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getCountryOfResidenceValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.COUNTRY_OF_RESIDENCE_REQIURED)), 
					"CountryOfResidence required message is incorrect: '" + resellerSignUpPageFragment.getCountryOfResidenceValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("CountryOfResidence required message is correct for test '" + testName + "'");
		}
	}

	public void verifyCityUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(testString);
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getCityValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CITY_REQUIRED)), 
					"City required message is incorrect: '" + resellerSignUpPageFragment.getCityValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("City required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setCity(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getCityValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CITY_LENGTH_VALIDATION)), 
					"City length message is incorrect: '" + resellerSignUpPageFragment.getCityValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("City validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setCity(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getCityValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CITY_LENGTH_VALIDATION)), 
					"City length message is incorrect: '" + resellerSignUpPageFragment.getCityValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("City validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidPattern")){
			clearAllFields();
			setCity(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getCityValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.CITY_SYMBOLS_VALIDATION)), 
					"City validation message is incorrect: '" + resellerSignUpPageFragment.getCityValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("City validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyFullAddressUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(testString);
			setStreet(fullUserEntity.getStreet());
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getFullAddressValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_ADDRESS_REQUIRED)), 
					"FullAddress required message is incorrect: '" + resellerSignUpPageFragment.getFullAddressValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("FullAddress required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setFullAddress(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getFullAddressValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_ADDRESS_LENGTH_VALIDATION)), 
					"FullAddress length message is incorrect: '" + resellerSignUpPageFragment.getFullAddressValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("FullAddress validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setFullAddress(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getFullAddressValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.FULL_ADDRESS_LENGTH_VALIDATION)), 
					"FullAddress length message is incorrect: '" + resellerSignUpPageFragment.getFullAddressValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("FullAddress validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyStreetUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(testString);
			setPostalCode(fullUserEntity.getPostalCode());
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getStreetValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.STREET_REQUIRED)), 
					"Street required message is incorrect: '" + resellerSignUpPageFragment.getStreetValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Street required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MaxCharacters")){
			clearAllFields();
			setStreet(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getStreetValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.STREET_LENGTH_VALIDATION)), 
					"Street length message is incorrect: '" + resellerSignUpPageFragment.getStreetValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Street validation message is correct for test '" + testName + "'");
		}
		else if(testName.equals("MinCharacters")){
			clearAllFields();
			setStreet(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getStreetValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.STREET_LENGTH_VALIDATION)), 
					"Street length message is incorrect: '" + resellerSignUpPageFragment.getStreetValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("Street validation message is correct for test '" + testName + "'");
		}
	}

	public void verifyPostalCodeUnsuccess(String testName, String testString){	

		FullUserEntity fullUserEntity = new FullUserEntity();		
		fullUserEntity = DataAdapter.getSignUpNormalUser();

		if(testName.equals("Empty")){
			clearAllFields();
			setFullName(fullUserEntity.getFullName());
			setBusinessName(fullUserEntity.getBusinessName());
			setEmail(fullUserEntity.getEmail());
			setUsername(fullUserEntity.getUsername());				
			setPassword(fullUserEntity.getPassword());
			setConfirmPassword(fullUserEntity.getPassword());
			setPhone(fullUserEntity.getPhone());
			setMobile(fullUserEntity.getMobile());
			selectCountryOfResidence(fullUserEntity.getCountryOfResidence());
			setCity(fullUserEntity.getCity());
			setFullAddress(fullUserEntity.getFullAddress());
			setStreet(fullUserEntity.getStreet());
			setPostalCode(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getPostalCodeValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.POSTAL_CODE_REQUIRED)), 
					"PostalCode required message is incorrect: '" + resellerSignUpPageFragment.getPostalCodeValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("PostalCode required message is correct for test '" + testName + "'");
		}
		else if(testName.equals("InvalidPattern")){
			clearAllFields();
			setPostalCode(testString);
			clickJoinButton();
			Assert.assertTrue(resellerSignUpPageFragment.getPostalCodeValidationMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.POSTAL_CODE_INVALID_PATTERN_VALIDATION)), 
					"PostalCode validation message is incorrect: '" + resellerSignUpPageFragment.getPostalCodeValidationMessage() + "' for test '" + testName + "'");
			LOGGER.info("PostalCode validation message is correct for test '" + testName + "'");
		}
	}

	public boolean isSuccessRegistrationMessageExists(){

		return resellerSignUpPageFragment.getSuccessMessageState();
	}
	
	public ResellerSignUpPage verifySuccessRegistrationMessage(){

		Assert.assertTrue(getSuccessMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_MESSAGE)), "Success Message is incorrect: '" + getSuccessMessage() + "'");		
		return this;
	}
	
}
