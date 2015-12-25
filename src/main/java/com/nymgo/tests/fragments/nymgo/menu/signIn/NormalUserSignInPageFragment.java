package com.nymgo.tests.fragments.nymgo.menu.signIn;

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

public class NormalUserSignInPageFragment extends BaseNymgoFragment{
	
	public NormalUserSignInPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "username-el")
	private WebElement username;
	
	@FindBy(id = "Password-el")
	private WebElement password;
	
	@FindBy(id = "user-login-el")
	private WebElement signInButton;
	
//	public static final String NORMAL_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
	public static final String NORMAL_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/login";
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
//    	return wait.until(ExpectedConditions.urlToBe(NORMAL_ACCOUNT_PAGE_URL));
    	return wait.until(ExpectedConditions.urlContains(NORMAL_ACCOUNT_PAGE_URL));    	
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return NORMAL_ACCOUNT_PAGE_URL;
	}

	public void typeUsername(String login){
    	
    	setTextToEditField(this.username, login);
    }
    
    public void typePassword(String password){
    	
    	setTextToEditField(this.password, password);
    }

    public void clickSignIn(){

    	clickSubmitButton(signInButton);
    }

}
