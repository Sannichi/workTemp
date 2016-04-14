package com.nymgo.tests.pages.nymgo.account;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.account.BaseViewAccountFragment;
import com.nymgo.tests.generators.CurrencyNameGenerator;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public abstract class AbstractViewAccountPage extends AbstractLoggedInPage{

	private BaseViewAccountFragment baseViewAccountFragment;
	
	public AbstractViewAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseViewAccountFragment = new BaseViewAccountFragment(driver);
	}

	public AbstractViewAccountPage expandContentByText(String contentName){

		baseViewAccountFragment.expandContentByText(contentName);
		delay(1000);
		LOGGER.info("Expandable content " + contentName + " is expanded");
		return this;
	}
	
	public void selectCountryOfResidence(String countryOfResidence){

		baseViewAccountFragment.selectCountryOfResidence(countryOfResidence);
	}

	public String getSelectedCountryOfResidence(){
		
		return baseViewAccountFragment.getSelectedCountryOfResidence();
	}
	
	public String getFullName(){
		
		return baseViewAccountFragment.getFullName();
	}

	public void setFullName(String fullName){
		
		baseViewAccountFragment.setFullName(fullName);
	}

	public String getEmail(){
		
		return baseViewAccountFragment.getEmail();
	}

	public void setEmail(String email){
		
		baseViewAccountFragment.setEmail(email);
	}

	public String getMobile(){
		
		return baseViewAccountFragment.getMobile();
	}

	public void setMobile(String mobile){
		
		baseViewAccountFragment.setMobile(mobile);
	}

	public String getPhone(){
		
		return baseViewAccountFragment.getPhone();
	}

	public void setPhone(String phone){
		
		baseViewAccountFragment.setPhone(phone);
	}

	public String getCity(){
		
		return baseViewAccountFragment.getCity();
	}

	public void setCity(String city){
		
		baseViewAccountFragment.setCity(city);
	}

	public String getPostalCode(){
		
		return baseViewAccountFragment.getPostalCode();
	}

	public void setPostalCode(String postalCode){
		
		baseViewAccountFragment.setPostalCode(postalCode);
	}

	public String getStreet(){
		
		return baseViewAccountFragment.getStreet();
	}

	public void setStreet(String street){
		
		baseViewAccountFragment.setStreet(street);
	}

	public String getAddress(){
		
		return baseViewAccountFragment.getAddress();		
	}

	public void setAddress(String address){
		
		baseViewAccountFragment.setAddress(address);
	}

	public String getSelectedDisplayCurrency(){
		
		return baseViewAccountFragment.getSelectedDisplayCurrency();		
	}

	public void selectDisplayCurrency(String displayCurrency){
		
		baseViewAccountFragment.selectDisplayCurrency(displayCurrency);		
	}

	public String getSelectedPaymentCurrency(){
		
		return baseViewAccountFragment.getSelectedPaymentCurrency();		
	}

	public void selectPaymentCurrency(String paymentCurrency){
		
		baseViewAccountFragment.selectPaymentCurrency(paymentCurrency);		
	}

	public void selectPaymentCurrencyBySign(String paymentCurrency){
		
		
		baseViewAccountFragment.selectPaymentCurrency(paymentCurrency);		
	}

	public String getSelectedLanguage(){
		
		return baseViewAccountFragment.getSelectedLanguage();		
	}

	public void selectLanguage(String language){
		
		baseViewAccountFragment.selectLanguage(language);		
	}
	
	public AbstractViewAccountPage clickSaveButton(){
		
		baseViewAccountFragment.clickSaveButton();
		return this;
	}

	private boolean editProfileAndSave(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){
		
		boolean edited = false;
		if (fullName != null){
			if (!getFullName().equals(fullName)){
				setFullName(fullName);
				edited = true;
			}
		}
		if (mobile != null){
			if (!getMobile().equals(mobile)){
				setMobile(mobile);
				edited = true;
			}
		}
		if (phone != null){
			if (!getPhone().equals(phone)){
				setPhone(phone);
				edited = true;
			}
		}
		if (countryOfResidence != null){
			if (!getSelectedCountryOfResidence().equals(countryOfResidence)){
				selectCountryOfResidence(countryOfResidence);
				edited = true;
			}
		}
		if (city != null){
			if (!getCity().equals(city)){
				setCity(city);
				edited = true;
			}
		}
		if (address != null){
			if (!getAddress().equals(address)){
				setAddress(address);
				edited = true;
			}
		}
		if (street != null){
			if (!getStreet().equals(street)){
				setStreet(street);
				edited = true;
			}
		}
		if (postalCode != null){
			if (!getPostalCode().equals(postalCode)){
				setPostalCode(postalCode);
				edited = true;
			}
		}
		if (displayCurrency != null){
			if (!getSelectedDisplayCurrency().equals(displayCurrency)){
				selectDisplayCurrency(displayCurrency);
				edited = true;
			}
		}
		if (paymentCurrency != null){
			String paymentCurrencyName = CurrencyNameGenerator.getCurrencyKeyBySign(paymentCurrency); 
			if (!getSelectedPaymentCurrency().equals(paymentCurrencyName)){
				selectPaymentCurrency(paymentCurrencyName);
				edited = true;
			}
		}
		if (language != null){
			if (!getSelectedLanguage().equals(language)){
				selectLanguage(language);
				edited = true;
			}
		}
		if (edited){
			clickSaveButton();
			return edited;
		}else{
			LOGGER.info("Nothing to change in profile");
			return edited;
		}
	}

	private void verifyEditedProfile(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){
		
		if (fullName != null){
			String currentFullName = getFullName();
			Assert.assertTrue(currentFullName.equals(fullName), "FullName was not updated. Current value is '" + currentFullName + "', should be '" + fullName + "'");
			LOGGER.info("FullName is updated with " + fullName);
		}
		if (mobile != null){
			String currentMobile = getMobile();
			Assert.assertTrue(currentMobile.equals(mobile), "Mobile was not updated. Current value is '" + currentMobile + "', should be '" + mobile + "'");
			LOGGER.info("Mobile is updated with " + mobile);
		}
		if (phone != null){
			String currentPhone = getPhone();
			Assert.assertTrue(currentPhone.equals(phone), "Phone was not updated. Current value is '" + currentPhone + "', should be '" + phone + "'");
			LOGGER.info("Phone is updated with " + phone);
		}
		if (countryOfResidence != null){
			String selectedCountryOfResidence = getSelectedCountryOfResidence();
			Assert.assertTrue(selectedCountryOfResidence.equals(countryOfResidence), "Country of Residence was not updated. Current value is '" 
			+ selectedCountryOfResidence + "', should be '" + countryOfResidence + "'");
			LOGGER.info("Country of Residence is updated with " + countryOfResidence);
		}
		if (city != null){
			String currentCity = getCity();
			Assert.assertTrue(currentCity.equals(city), "City was not updated. Current value is '" + currentCity + "', should be '" + city + "'");
			LOGGER.info("City is updated with " + city);
		}
		if (address != null){
			String currentAddress = getAddress();
			Assert.assertTrue(currentAddress.equals(address), "Address was not updated. Current value is '" + currentAddress + "', should be '" + address + "'");
			LOGGER.info("Address is updated with " + address);
		}
		if (street != null){
			String currentStreet = getStreet();
			Assert.assertTrue(currentStreet.equals(street), "Street was not updated. Current value is '" + currentStreet + "', should be '" + street + "'");
			LOGGER.info("Street is updated with " + street);
		}
		if (postalCode != null){
			String currentPostalCode = getPostalCode();
			Assert.assertTrue(currentPostalCode.equals(postalCode), "Postal Code was not updated. Current value is '" + currentPostalCode + "', should be '" + postalCode + "'");
			LOGGER.info("Postal Code is updated with " + postalCode);
		}
		if (displayCurrency != null){
			String selectedDisplayCurrency = getSelectedDisplayCurrency();
			Assert.assertTrue(selectedDisplayCurrency.equals(displayCurrency), "Display Currency was not updated. Current value is '"
			+ selectedDisplayCurrency + "', should be '" + displayCurrency + "'");
			LOGGER.info("Display Currency is updated with " + displayCurrency);
		}
		if (paymentCurrency != null){
			String paymentCurrencyName = CurrencyNameGenerator.getCurrencyKeyBySign(paymentCurrency); 
			String selectedPaymentCurrency = getSelectedPaymentCurrency();
			Assert.assertTrue(selectedPaymentCurrency.equals(paymentCurrencyName), "Payment Currency was not updated. Current value is '"
			+ selectedPaymentCurrency + "', should be '" + paymentCurrencyName + "'");
			LOGGER.info("Payment Currency is updated with " + paymentCurrencyName);
		}
		if (language != null){
			String selectedLanguage = getSelectedLanguage();
			Assert.assertTrue(selectedLanguage.equals(language), "Language was not updated. Current value is '"
			+ selectedLanguage + "', should be '" + language + "'");
			LOGGER.info("Language is updated with " + language);
		}
	}

	public void editNormalUserProfileAndSave(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){
		
		expandContentByText(LocaleGenerator.getLocaleKey(LOCALE_CONST.EDIT_PROFILE));
		if (editProfileAndSave(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language)){
			Assert.assertTrue(getSuccessMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_UPDATED_SUCCESS_MESSAGE)), 
					"Success message is incorrect: '" + getSuccessMessage() + "' should be '" + 
							LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_UPDATED_SUCCESS_MESSAGE) + "'");
			LOGGER.info("Successful message is correct");
			expandContentByText(LocaleGenerator.getLocaleKey(LOCALE_CONST.EDIT_PROFILE));
			verifyEditedProfile(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language);
		}else{
			LOGGER.info("Nothing to verify in profile");
		}
	}

	public void editResellerProfileAndSave(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){
		
		expandContentByText(LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_DETAILS));
		if (editProfileAndSave(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language)){
			Assert.assertTrue(getSuccessMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_UPDATED_SUCCESS_MESSAGE)), 
					"Success message is incorrect: '" + getSuccessMessage() + "' should be '" + 
							LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_UPDATED_SUCCESS_MESSAGE) + "'");
			LOGGER.info("Successful message is correct");
			expandContentByText(LocaleGenerator.getLocaleKey(LOCALE_CONST.ACCOUNT_DETAILS));
			verifyEditedProfile(fullName, mobile, phone, countryOfResidence, city, address, street, postalCode, displayCurrency, paymentCurrency, language);
		}else{
			LOGGER.info("Nothing to verify in profile");
		}
	}
}
