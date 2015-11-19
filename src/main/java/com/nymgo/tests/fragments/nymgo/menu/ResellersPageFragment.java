package com.nymgo.tests.fragments.nymgo.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class ResellersPageFragment extends BaseNymgoFragment{
	
	public ResellersPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String RESELLERS_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/home";
	private static final String ResellerSingInButtonXpath = "//a[@href='" + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/']";

	private WebElement resellerSignInButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(RESELLERS_PAGE_URL));
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
}