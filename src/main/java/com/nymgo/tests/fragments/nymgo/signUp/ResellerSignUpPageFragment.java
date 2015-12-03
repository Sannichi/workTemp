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

	@FindBy(id = "fullname-el")
	private WebElement fullNameEdit;

	@FindBy(css = "input[name='businessname-el']")
	private WebElement businessNameEdit;

	@FindBy(id = "emailaddress-el")
	private WebElement emailEdit;

	@FindBy(id = "Username-el")
	private WebElement usernameEdit;

	@FindBy(css = "input[name='password']")
	private WebElement passwordEdit;

	@FindBy(css = "input[name='confirm_password']")
	private WebElement confirmPasswordEdit;

	@FindBy(id = "phonenumber-el")	
	private WebElement phoneEdit;

	@FindBy(css = "input[name='mobile_number']")
	private WebElement mobileEdit;

	@FindBy(id = "country_of_residence")
	private WebElement countryOfResidenceSelect;
	
	@FindBy(css = "input[name='city']")
	private WebElement cityEdit;

	@FindBy(css = "input[name='full_address']")
	private WebElement fullAddressEdit;

	@FindBy(css = "input[name='street']")
	private WebElement streetEdit;

	@FindBy(css = "input[name='postal_code']")
	private WebElement postalCodeEdit;

	@FindBy(id = "send-btn-el")
	private WebElement joinButton;

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
			return false;
		}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return RESELLER_SIGN_UP_PAGE_URL;
	}

	public String getFullName() {
		return fullNameEdit.getText();
	}

	public void setFullName(String fullName) {
		
		setTextToEditField(fullNameEdit, fullName);
	}

	public String getBusinessName() {
		return businessNameEdit.getText();
	}

	public void setBusinessName(String businessName) {
		
		setTextToEditField(businessNameEdit, businessName);
	}

	public String getEmail() {
		return emailEdit.getText();
	}

	public void setEmail(String email) {

		setTextToEditField(emailEdit, email);
	}

	public String getUsername() {
		return usernameEdit.getText();
	}

	public void setUsername(String username) {

		setTextToEditField(usernameEdit, username);
	}

	public String getPassword() {
		return passwordEdit.getText();
	}

	public void setPassword(String password) {

		setTextToEditField(passwordEdit, password);
	}

	public String getConfirmPassword() {
		return confirmPasswordEdit.getText();
	}

	public void setConfirmPassword(String confirmPassword) {

		setTextToEditField(confirmPasswordEdit, confirmPassword);
	}

	public String getPhone() {
		return phoneEdit.getText();
	}

	public void setPhone(String phone) {

		setTextToEditField(phoneEdit, phone);
	}

	public String getMobile() {
		return mobileEdit.getText();
	}

	public void setMobile(String mobile) {

		setTextToEditField(mobileEdit, mobile);
	}

	public String getCountryOfResidenceSelect() {

		Select select = new Select(countryOfResidenceSelect);
		return select.getFirstSelectedOption().getText();
	}

	public void selectCountryOfResidence(String countryOfResidence) {

		Select select = new Select(countryOfResidenceSelect);
		select.selectByVisibleText(countryOfResidence);
}

	public String getCity() {
		return cityEdit.getText();
	}

	public void setCity(String city) {

		setTextToEditField(cityEdit, city);
	}

	public String getFullAddress() {
		return fullAddressEdit.getText();
	}

	public void setFullAddress(String fullAddress) {

		setTextToEditField(fullAddressEdit, fullAddress);
	}

	public String getStreet() {
		return streetEdit.getText();
	}

	public void setStreet(String street) {

		setTextToEditField(streetEdit, street);
	}

	public String getPostalCode() {
		return postalCodeEdit.getText();
	}

	public void setPostalCode(String postalCode) {

		setTextToEditField(postalCodeEdit, postalCode);
	}

	public void clickJoinButton(){
		
		clickInputButton(joinButton);
	}
}
