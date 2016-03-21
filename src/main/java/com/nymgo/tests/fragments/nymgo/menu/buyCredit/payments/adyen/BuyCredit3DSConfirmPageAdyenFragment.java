package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BaseIframePageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */

public class BuyCredit3DSConfirmPageAdyenFragment extends BaseIframePageFragment{
	
	public BuyCredit3DSConfirmPageAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final String BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	private static final String BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_CHROME_URL = "https://test.adyen.com/hpp/3d/validate.shtml";	
	
	@FindBy(css = "input[id='username']")
	private WebElement usernameField;
	
	@FindBy(css = "input[id='password']")
	private WebElement passwordField;
	
	@FindBy(css = "input[class='button']")
	private WebElement submitButton;
	
	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL;
            case CHROME:
                return BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_CHROME_URL;
            case IE:
                return BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL;
            default:
                return BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL;
        }
	}
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(defineCorrectURL());
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return defineCorrectURL();	
	}

	public void setUsername(String username){
		
		setTextToEditField(usernameField, username);
	}
	
	public void setPassword(String password){
		
		setTextToEditField(passwordField, password);
	}

	public void clickSubmitButton(){
		
		clickInputButton(submitButton);
	}

}
