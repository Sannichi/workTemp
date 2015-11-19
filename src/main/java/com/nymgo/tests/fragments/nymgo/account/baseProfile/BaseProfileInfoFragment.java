package com.nymgo.tests.fragments.nymgo.account.baseProfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public abstract class BaseProfileInfoFragment extends BaseLoggedInFragment{

	public BaseProfileInfoFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "country_of_residence")
	private WebElement countryOfResidenceSelect;
	
	@FindBy(id = "fullname-el")
	private WebElement fullName;

	@FindBy(id = "email-el")
	private WebElement email;

	@FindBy(id = "mobile-el")
	private WebElement mobile;

	@FindBy(xpath = "//input[@id='home-el']")	
	private List<WebElement> phoneAndCityAndStreet;

	@FindBy(id = "pobox-el")
	private WebElement postalCode;

	@FindBy(id = "street-el")
	private WebElement address;

	@FindBy(id = "display_currency")
	private WebElement displayCurrencySelect;

	@FindBy(id = "pay_currency")
	private WebElement payCurrencySelect;

	@FindBy(id = "language_id")
	private WebElement languageSelect;

	@FindBy(id = "save-el")
	private WebElement saveButton;

	protected void selectCountryOfResidence(String countryOfResidence){

		selectValueFromSelectByLocaleText(countryOfResidenceSelect, countryOfResidence);
	}

	protected String getSelectedCountryOfResidence(){
		
		Select select = new Select(countryOfResidenceSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	protected void selectDisplayCurrency(String displayCurrency){

		selectValueFromSelectByLocaleText(displayCurrencySelect, displayCurrency);
	}

	protected String getSelectedDisplayCurrency(){
		
		Select select = new Select(displayCurrencySelect);
		return select.getFirstSelectedOption().getText();
	}
	
	protected void selectPaymentCurrency(String paymentCurrency){

		selectValueFromSelectByLocaleText(payCurrencySelect, paymentCurrency);
	}

	protected String getSelectedPaymentCurrency(){
		
		Select select = new Select(payCurrencySelect);
		return select.getFirstSelectedOption().getText();
	}
	
	protected void selectLanguage(String language){

		selectValueFromSelectByLocaleText(languageSelect, language);
	}

	protected String getSelectedLanguage(){
		
		Select select = new Select(languageSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	protected String getFullName(){
		
		return fullName.getAttribute("value");
	}

	protected void setFullName(String fullName){
		
		setTextToEditField(this.fullName, fullName);
	}

	protected String getEmail(){
		
		return email.getAttribute("value");
	}

	protected void setEmail(String email){
		
		setTextToEditField(this.email, email);
	}

	protected String getMobile(){
		
		return mobile.getAttribute("value");
	}

	protected void setMobile(String mobile){
		
		setTextToEditField(this.mobile, mobile);
	}

	protected String getPhone(){
		
		return phoneAndCityAndStreet.get(0).getAttribute("value");		
	}

	protected void setPhone(String phone){
		
		setTextToEditField(this.phoneAndCityAndStreet.get(0), phone);
	}

	protected String getCity(){
		
		return phoneAndCityAndStreet.get(1).getAttribute("value");		
	}

	protected void setCity(String city){
		
		setTextToEditField(this.phoneAndCityAndStreet.get(1), city);
	}

	protected String getPostalCode(){
		
		return postalCode.getAttribute("value");
	}

	protected void setPostalCode(String postalCode){
		
		setTextToEditField(this.postalCode, postalCode);
	}

	protected String getStreet(){
		
		return phoneAndCityAndStreet.get(2).getAttribute("value");
	}

	protected void setStreet(String street){
		
		setTextToEditField(this.phoneAndCityAndStreet.get(2), street);
	}

	protected String getAddress(){
		
		return address.getAttribute("value");
	}

	protected void setAddress(String address){
		
		setTextToEditField(this.address, address);
	}

	protected void clickSaveButton(){
		
		clickSubmitButton(saveButton);
	}
}
