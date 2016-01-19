package com.nymgo.tests.fragments.nymgo.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class ResellersPageFragment extends BaseNymgoFragment{
	
	public ResellersPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String RESELLERS_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
//	public static final String RESELLERS_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
//	public static final String RESELLERS_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https") +
	public static final String RESELLERS_PAGE_URL = Starter.SECURE_PART +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/home";
	
	private static final String ResellerSingInButtonXpath = "//a[@href='" + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/']";

	private WebElement resellerSignInButton;

	@FindBy(id = "join-reseller")
	private WebElement joinResellerButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
	    	wait.until(ExpectedConditions.urlToBe(RESELLERS_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return RESELLERS_PAGE_URL;
	}

	private void initializeResellerSignInButton() throws NoSuchElementException{

		resellerSignInButton = driver.findElement(By.xpath(ResellerSingInButtonXpath));
	}

	public void clickResellerSignInButton(){

		initializeResellerSignInButton();
		clickButton(resellerSignInButton);
    }

	public void clickJoinResellerButton(){

		clickButton(joinResellerButton);
    }
}
