package com.nymgo.tests.pages.nymgo.signUp;

import com.nymgo.tests.fragments.nymgo.signUp.ResellerSignUpPageFragment;
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

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return null;
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
}
