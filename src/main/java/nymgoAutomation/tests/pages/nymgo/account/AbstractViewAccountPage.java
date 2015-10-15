package nymgoAutomation.tests.pages.nymgo.account;

import org.testng.Assert;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.fragments.nymgo.account.BaseViewAccountFragment;
import nymgoAutomation.tests.generators.CurrencyGenerator;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;

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

	public void expandContentByText(String contentName){

		baseViewAccountFragment.expandContentByText(contentName);
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
	
	public void clickSaveButton(){
		
		baseViewAccountFragment.clickSaveButton();		
	}

	public void editProfileAndSave(String fullName, String mobile, String phone, String countryOfResidence, String city, String address, 
			String street, String postalCode, String displayCurrency, String paymentCurrency, String language){
		
		expandContentByText(LocaleGenerator.getLocaleKey(LOCALE_CONST.EDIT_PROFILE));
		boolean edited = false;
		if (fullName != null){
			if (!getFullName().equals(fullName)){
				setFullName(fullName);
				Assert.assertTrue(getFullName().equals(fullName), "FullName was not updated. Current value is '" + getFullName() + "', should be '" + fullName + "'");
				edited = true;
				LOGGER.info("FullName is updated with " + fullName);
			}
		}
		if (mobile != null){
			if (!getMobile().equals(mobile)){
				setMobile(mobile);
				Assert.assertTrue(getMobile().equals(mobile), "Mobile was not updated. Current value is '" + getMobile() + "', should be '" + mobile + "'");
				edited = true;
				LOGGER.info("Mobile is updated with " + mobile);
			}
		}
		if (phone != null){
			if (!getPhone().equals(phone)){
				setPhone(phone);
				Assert.assertTrue(getPhone().equals(phone), "Phone was not updated. Current value is '" + getPhone() + "', should be '" + phone + "'");
				edited = true;
				LOGGER.info("Phone is updated with " + phone);
			}
		}
		if (countryOfResidence != null){
			if (!getSelectedCountryOfResidence().equals(countryOfResidence)){
				selectCountryOfResidence(countryOfResidence);
				Assert.assertTrue(getSelectedCountryOfResidence().equals(countryOfResidence), "Country of Residence was not updated. Current value is '" 
				+ getSelectedCountryOfResidence() + "', should be '" + countryOfResidence + "'");
				edited = true;
				LOGGER.info("Country of Residence is updated with " + countryOfResidence);
			}
		}
		if (city != null){
			if (!getCity().equals(city)){
				setCity(city);
				Assert.assertTrue(getCity().equals(city), "City was not updated. Current value is '" + getCity() + "', should be '" + city + "'");
				edited = true;
				LOGGER.info("City is updated with " + city);
			}
		}
		if (address != null){
			if (!getAddress().equals(address)){
				setAddress(address);
				Assert.assertTrue(getAddress().equals(address), "Address was not updated. Current value is '" + getAddress() + "', should be '" + address + "'");
				edited = true;
				LOGGER.info("Address is updated with " + address);
			}
		}
		if (street != null){
			if (!getStreet().equals(street)){
				setStreet(street);
				Assert.assertTrue(getStreet().equals(street), "Street was not updated. Current value is '" + getStreet() + "', should be '" + street + "'");
				edited = true;
				LOGGER.info("Street is updated with " + street);
			}
		}
		if (postalCode != null){
			if (!getPostalCode().equals(postalCode)){
				setPostalCode(postalCode);
				Assert.assertTrue(getPostalCode().equals(postalCode), "Postal Code was not updated. Current value is '" + getPostalCode() + "', should be '" + postalCode + "'");
				edited = true;
				LOGGER.info("Postal Code is updated with " + postalCode);
			}
		}
		if (displayCurrency != null){
			if (!getSelectedDisplayCurrency().equals(displayCurrency)){
				selectDisplayCurrency(displayCurrency);
				Assert.assertTrue(getSelectedDisplayCurrency().equals(displayCurrency), "Display Currency was not updated. Current value is '"
				+ getSelectedDisplayCurrency() + "', should be '" + displayCurrency + "'");
				edited = true;
				LOGGER.info("Display Currency is updated with " + displayCurrency);
			}
		}
		if (paymentCurrency != null){
			String paymenCurrencyName = CurrencyGenerator.getCurrencyKeyBySign(paymentCurrency); 
			if (!getSelectedPaymentCurrency().equals(paymenCurrencyName)){
				selectPaymentCurrency(paymenCurrencyName);
				Assert.assertTrue(getSelectedPaymentCurrency().equals(paymenCurrencyName), "Payment Currency was not updated. Current value is '"
				+ getSelectedPaymentCurrency() + "', should be '" + paymenCurrencyName + "'");
				edited = true;
				LOGGER.info("Payment Currency is updated with " + paymenCurrencyName);
			}
		}
		if (language != null){
			if (!getSelectedLanguage().equals(language)){
				selectLanguage(language);
				Assert.assertTrue(getSelectedLanguage().equals(language), "Language was not updated. Current value is '"
				+ getSelectedLanguage() + "', should be '" + language + "'");
				edited = true;
				LOGGER.info("Language is updated with " + language);
			}
		}
		if (edited){
			clickSaveButton();
		}else{
			LOGGER.info("Nothing to change in profile");
		}
	}
}
