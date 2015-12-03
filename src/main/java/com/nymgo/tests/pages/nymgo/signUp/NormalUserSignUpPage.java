package com.nymgo.tests.pages.nymgo.signUp;

import com.nymgo.tests.fragments.nymgo.signUp.NormalUserSignUpPageFragment;
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
	
	//TODO instead of void
	public void setSignUpDataAndClickJoinSuccess(String fullName, String username, String password, String email, String mobile){
		
		setFullName(fullName);
		setUsername(username);
		setPassword(password);
		setConfirmPassword(password);
		setEmail(email);
		setMobile(mobile);
		clickJoinButton();
	}
}
