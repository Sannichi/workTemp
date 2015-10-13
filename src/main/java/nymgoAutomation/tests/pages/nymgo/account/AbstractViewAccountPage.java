package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.BaseViewAccountFragment;
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

	public String getSelectedLanguage(){
		
		return baseViewAccountFragment.getSelectedLanguage();		
	}

	public void selectLanguage(String language){
		
		baseViewAccountFragment.selectLanguage(language);		
	}
	
}
