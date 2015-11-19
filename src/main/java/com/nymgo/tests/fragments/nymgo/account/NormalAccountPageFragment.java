package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */

public class NormalAccountPageFragment extends BaseAccountPageFragment{
	
    public NormalAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.IMPLICITLY_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.visibilityOf(viewFullAccountButton));
		}
		catch(TimeoutException e){
			LOGGER.fatal("There is no element viewFullAccountButton on the Page");
		}
	}

	@FindBy(xpath = "//a[@class='view-profile']")
	private WebElement viewFullAccountButton;

	public void clickViewFullAccountButton(){
		
		clickSubmitButton(viewFullAccountButton);
	}

}
