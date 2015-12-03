package com.nymgo.tests.fragments.nymgo.signUp;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class NormalUserSignUpPageFragment extends BaseNymgoFragment{

	public NormalUserSignUpPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "full_name-el")
	private WebElement fullNameEdit;

	@FindBy(id = "Username-Email-el")
	private WebElement usernameEdit;

	@FindBy(css = "input[name='password']")
	private WebElement passwordEdit;

	@FindBy(css = "input[name='confirm_password']")
	private WebElement confirmPasswordEdit;

	@FindBy(id = "Email-el")
	private WebElement emailEdit;

	@FindBy(id = "mobile-el")
	private WebElement mobileEdit;

	@FindBy(id = "send-btn-el")
	private WebElement joinButton;

	private static final String NORMAL_ACCOUNT_SIGN_UP_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
					LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/register";
	
	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlToBe(NORMAL_ACCOUNT_SIGN_UP_PAGE_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return NORMAL_ACCOUNT_SIGN_UP_PAGE_URL;
	}

	public void typeFullName(String fullName){
		
		setTextToEditField(fullNameEdit, fullName);
	}
	
	public void typeUsername(String username){
		
		setTextToEditField(usernameEdit, username);
	}

	public void typePassword(String password){
		
		setTextToEditField(passwordEdit, password);
	}

	public void typeConfirmPassword(String confirmPassword){
		
		setTextToEditField(confirmPasswordEdit, confirmPassword);
	}

	public void typeEmail(String email){
		
		setTextToEditField(emailEdit, email);
	}

	public void typeMobile(String mobile){
		
		setTextToEditField(mobileEdit, mobile);
	}

	public void clickJoinButton(){
		
		clickInputButton(joinButton);
	}
}
