package com.nymgo.tests.fragments.nymgo.signUp;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 1, 2015
 */
public class ResellerSignUpPageFragment extends BaseNymgoFragment{

	public ResellerSignUpPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String fullNameId = "fullname-el";
	private static final String businessNameXpath = "//input[@name='business_name']";;
	private static final String emailId = "emailaddress-el";
	private static final String usernameId = "Username-el";
	private static final String passwordId = "create-password-el";
	private static final String confirmPasswordId = "confirm-password-el";
	private static final String phoneId = "phonenumber-el";
	private static final String mobileXpath = "//input[@name='mobile_number']";
	private static final String countryOfResidenceId = "country_of_residence";
	private static final String cityXpath = "//input[@name='city']";
	private static final String fullAddressXpath = "//input[@name='full_address']";
	private static final String streetXpath = "//input[@name='street']";
	private static final String postalCodeXpath = "//input[@name='postal_code']";
	
	
	@FindBy(id = fullNameId)
	private WebElement fullNameEdit;

	@FindBy(xpath = businessNameXpath)
	private WebElement businessNameEdit;

	@FindBy(id = emailId)
	private WebElement emailEdit;

	@FindBy(id = usernameId)
	private WebElement usernameEdit;

	@FindBy(id = passwordId)
	private WebElement passwordEdit;

	@FindBy(id = confirmPasswordId)
	private WebElement confirmPasswordEdit;

	@FindBy(id = phoneId)	
	private WebElement phoneEdit;

	@FindBy(xpath = mobileXpath)
	private WebElement mobileEdit;

	@FindBy(id = countryOfResidenceId)
	private WebElement countryOfResidenceSelect;
	
	@FindBy(xpath = cityXpath)
	private WebElement cityEdit;

	@FindBy(xpath = fullAddressXpath)
	private WebElement fullAddressEdit;

	@FindBy(xpath = streetXpath)
	private WebElement streetEdit;

	@FindBy(xpath = postalCodeXpath)
	private WebElement postalCodeEdit;

	@FindBy(id = "send-btn-el")
	private WebElement joinButton;
	
	@FindBy(xpath = "//input[@id='" + fullNameId + "']/../div[@class='validation-msg']")
	private WebElement fullNameValidationMessage;

	@FindBy(xpath = businessNameXpath + "/../div[@class='validation-msg']")
	private WebElement businessNameValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + emailId + "']/../div[@class='validation-msg']")
	private WebElement emailValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + usernameId + "']/../div[@class='validation-msg']")
	private WebElement usernameValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + passwordId + "']/../div[@class='validation-msg']")
	private WebElement passwordValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + confirmPasswordId + "']/../div[@class='validation-msg']")
	private WebElement confirmPasswordValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + phoneId + "']/../div[@class='validation-msg']")
	private WebElement phoneValidationMessage;

	@FindBy(xpath = mobileXpath + "/../div[@class='validation-msg']")
	private WebElement mobileValidationMessage;

	@FindBy(xpath = "//select[@id='" + countryOfResidenceId + "']/../div[@class='validation-msg']")
	private WebElement countryOfResidenceValidationMessage;

	@FindBy(xpath = cityXpath + "/../div[@class='validation-msg']")
	private WebElement cityValidationMessage;

	@FindBy(xpath = fullAddressXpath + "/../div[@class='validation-msg']")
	private WebElement fullAddressValidationMessage;

	@FindBy(xpath = streetXpath + "/../div[@class='validation-msg']")
	private WebElement streetValidationMessage;

	@FindBy(xpath = postalCodeXpath + "/../div[@class='validation-msg']")
	private WebElement postalCodeValidationMessage;

	@FindBy(css = "div[class='success-message']")
	private WebElement successMessage;

	private static final String RESELLER_SIGN_UP_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/register";

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(RESELLER_SIGN_UP_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			try{
				//TODO NOT OR
				wait.until(ExpectedConditions.urlToBe(RESELLER_SIGN_UP_PAGE_URL + "/"));
				return true;
			}
			catch(TimeoutException e2){
				return false;
			}
		}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return RESELLER_SIGN_UP_PAGE_URL;
	}

	public String getFullName() {
		return fullNameEdit.getAttribute("value");
	}

	public void setFullName(String fullName) {
		
		setTextToEditField(fullNameEdit, fullName);
	}

	public String getBusinessName() {
		return businessNameEdit.getAttribute("value");
	}

	public void setBusinessName(String businessName) {
		
		setTextToEditField(businessNameEdit, businessName);
	}

	public String getEmail() {
		return emailEdit.getAttribute("value");
	}

	public void setEmail(String email) {

		setTextToEditField(emailEdit, email);
	}

	public String getUsername() {
		return usernameEdit.getAttribute("value");
	}

	public void setUsername(String username) {

		setTextToEditField(usernameEdit, username);
	}

	public String getPassword() {
		return passwordEdit.getAttribute("value");
	}

	public void setPassword(String password) {

		setTextToEditField(passwordEdit, password);
	}

	public String getConfirmPassword() {
		return confirmPasswordEdit.getAttribute("value");
	}

	public void setConfirmPassword(String confirmPassword) {

		setTextToEditField(confirmPasswordEdit, confirmPassword);
	}

	public String getPhone() {
		return phoneEdit.getAttribute("value");
	}

	public void setPhone(String phone) {

		setTextToEditField(phoneEdit, phone);
	}

	public String getMobile() {
		return mobileEdit.getAttribute("value");
	}

	public void setMobile(String mobile) {

		setTextToEditField(mobileEdit, mobile);
	}

	public String getCountryOfResidenceSelect() {

		Select select = new Select(countryOfResidenceSelect);
		return select.getFirstSelectedOption().getText();
	}

	public void selectCountryOfResidence(String countryOfResidence) {

		selectValueFromSelectByVisibleText(countryOfResidenceSelect, countryOfResidence);
	}

	public void selectCountryOfResidenceToNone() {

		selectValueFromSelectByValue(countryOfResidenceSelect, "");
	}

	public String getCity() {
		return cityEdit.getAttribute("value");
	}

	public void setCity(String city) {

		setTextToEditField(cityEdit, city);
	}

	public String getFullAddress() {
		return fullAddressEdit.getAttribute("value");
	}

	public void setFullAddress(String fullAddress) {

		setTextToEditField(fullAddressEdit, fullAddress);
	}

	public String getStreet() {
		return streetEdit.getAttribute("value");
	}

	public void setStreet(String street) {

		setTextToEditField(streetEdit, street);
	}

	public String getPostalCode() {
		return postalCodeEdit.getAttribute("value");
	}

	public void setPostalCode(String postalCode) {

		setTextToEditField(postalCodeEdit, postalCode);
	}

	public void clickJoinButton(){
		
		clickInputButton(joinButton);
	}

	private boolean isFullNameValidationMessageEnabled(){
		
		return isElementEnabled(fullNameValidationMessage);
	}

	private boolean isBusinessNameValidationMessageEnabled(){
		
		return isElementEnabled(businessNameValidationMessage);
	}

	private boolean isEmailValidationMessageEnabled(){
		
		return isElementEnabled(emailValidationMessage);
	}

	private boolean isUsernameValidationMessageEnabled(){
		
		return isElementEnabled(usernameValidationMessage);
	}

	private boolean isPasswordValidationMessageEnabled(){
		
		return isElementEnabled(passwordValidationMessage);
	}

	private boolean isConfirmPasswordValidationMessageEnabled(){
		
		return isElementEnabled(confirmPasswordValidationMessage);
	}

	private boolean isPhoneValidationMessageEnabled(){
		
		return isElementEnabled(phoneValidationMessage);
	}
	
	private boolean isMobileValidationMessageEnabled(){
		
		return isElementEnabled(mobileValidationMessage);
	}
	
	private boolean isCountryOfResidenceValidationMessageEnabled(){
		
		return isElementEnabled(countryOfResidenceValidationMessage);
	}

	private boolean isCityValidationMessageEnabled(){
		
		return isElementEnabled(cityValidationMessage);
	}

	private boolean isFullAddressValidationMessageEnabled(){
		
		return isElementEnabled(fullAddressValidationMessage);
	}
	
	private boolean isStreetValidationMessageEnabled(){
		
		return isElementEnabled(streetValidationMessage);
	}
	
	private boolean isPostalCodeValidationMessageEnabled(){
		
		return isElementEnabled(postalCodeValidationMessage);
	}
	
	private boolean isSuccessMessageEnabled(){
		
		return isElementEnabled(successMessage);
	}

	public String getFullNameValidationMessage(){
		
		if (isFullNameValidationMessageEnabled()){
			return fullNameValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getBusinessNameValidationMessage(){
		
		if (isBusinessNameValidationMessageEnabled()){
			return businessNameValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getEmailValidationMessage(){
		
		if (isEmailValidationMessageEnabled()){
			return emailValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getUsernameValidationMessage(){
		
		if (isUsernameValidationMessageEnabled()){
			return usernameValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getPasswordValidationMessage(){
		
		if (isPasswordValidationMessageEnabled()){
			return passwordValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getConfirmPasswordValidationMessage(){
		
		if (isConfirmPasswordValidationMessageEnabled()){
			return confirmPasswordValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getPhoneValidationMessage(){
		
		if (isPhoneValidationMessageEnabled()){
			return phoneValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getMobileValidationMessage(){
		
		if (isMobileValidationMessageEnabled()){
			return mobileValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getCountryOfResidenceValidationMessage(){
		
		if (isCountryOfResidenceValidationMessageEnabled()){
			return countryOfResidenceValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getCityValidationMessage(){
		
		if (isCityValidationMessageEnabled()){
			return cityValidationMessage.getText();
		}
		return "";
	}

	public String getFullAddressValidationMessage(){
		
		if (isFullAddressValidationMessageEnabled()){
			return fullAddressValidationMessage.getText();
		}
		return "";
	}

	public String getStreetValidationMessage(){
		
		if (isStreetValidationMessageEnabled()){
			return streetValidationMessage.getText();
		}
		return "";
	}

	public String getPostalCodeValidationMessage(){
		
		if (isPostalCodeValidationMessageEnabled()){
			return postalCodeValidationMessage.getText();
		}
		return "";
	}

	public String getSuccessMessage(){
		if (isSuccessMessageEnabled()){
			return successMessage.getText();
		}
		return "MessageDisabled";
	}

	public boolean getSuccessMessageState(){
		
		return isSuccessMessageEnabled();
	}

	public void clearAllFields(){
		
		clearEdit(fullNameEdit);
		clearEdit(businessNameEdit);
		clearEdit(emailEdit);
		clearEdit(usernameEdit);
		clearEdit(passwordEdit);
		clearEdit(confirmPasswordEdit);
		clearEdit(phoneEdit);
		clearEdit(mobileEdit);
		/*
		 * Selecting first value from country of residence
		 */
		selectCountryOfResidenceToNone();
		clearEdit(cityEdit);
		clearEdit(fullAddressEdit);
		clearEdit(streetEdit);
		clearEdit(postalCodeEdit);
	}
}
