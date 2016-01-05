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

public class ResellerSignInPageFragment extends BaseNymgoFragment{
	
	public ResellerSignInPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "username-el")
	private WebElement username;
	
	@FindBy(id = "Password-el")
	private WebElement password;
	
	@FindBy(id = "reseller-login-el")
	private WebElement signInButton;
	
//	private static final String RESELLER_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
//	private static final String RESELLER_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
	private static final String RESELLER_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https") +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/";
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(RESELLER_ACCOUNT_PAGE_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return RESELLER_ACCOUNT_PAGE_URL;
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
