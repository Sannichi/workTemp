package com.nymgo.tests.fragments.nymgo.menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class ResellersPageFragment extends BaseNymgoFragment{
	
	public ResellersPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String RESELLERS_PAGE_URL = Starter.SECURE_PART_PATTERN +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/home";
	
	private static final String ResellerSingInButtonXpath = "//a[@href='" + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/']";

	private WebElement resellerSignInButton;

	@FindBy(id = "join-reseller")
	private WebElement joinResellerButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(RESELLERS_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
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
