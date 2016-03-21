package com.nymgo.tests.fragments.nymgo.menu.signIn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
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
	
	public static final String NORMAL_ACCOUNT_PAGE_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/login";
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(NORMAL_ACCOUNT_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
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
