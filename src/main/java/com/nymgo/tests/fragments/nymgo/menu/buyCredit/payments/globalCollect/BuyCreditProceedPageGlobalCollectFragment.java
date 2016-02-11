package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.globalCollect;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.BaseBuyCreditProceedPageFragment;

public class BuyCreditProceedPageGlobalCollectFragment extends BaseBuyCreditProceedPageFragment{

	public BuyCreditProceedPageGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectCountryOfResidence(String countryOfResidence){

		super.selectCountryOfResidence(countryOfResidence);
	}

	public String getSelectedCountryOfResidence(){
		
		return super.getSelectedCountryOfResidence();
	}
	
	public String getFullName(){
		
		return super.getFullName();
	}

	public void setFullName(String fullName){
		
		super.setFullName(fullName);
	}

	public String getEmail(){
		
		return super.getEmail();
	}

	public void setEmail(String email){
		
		super.setEmail(email);
	}

	public String getMobile(){
		
		return super.getMobile();
	}

	public void setMobile(String mobile){
		
		super.setMobile(mobile);
	}

	public String getPhone(){
		
		return super.getPhone();
	}

	public void setPhone(String phone){
		
		super.setPhone(phone);
	}

	public String getPostalCode(){
		
		return super.getPostalCode();
	}

	public void setPostalCode(String postalCode){
		
		super.setPostalCode(postalCode);
	}

	public String getStreet(){
		
		return super.getStreet();
	}

	public void setStreet(String street){
		
		super.setStreet(street);
	}

	public String getAddress(){
		
		return super.getAddress();		
	}

	public void setAddress(String address){
		
		super.setAddress(address);
	}
}
