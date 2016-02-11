package com.nymgo.tests.fragments.nymgo;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.starter.Starter;

public class HomePageFragment extends BaseNymgoFragment{

public HomePageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="a[class='join']")
	private WebElement joinNowButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(getHomeURL()));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return getHomeURL();
	}
	
	public void clickJoinNowButton(){
		
		clickButton(joinNowButton);
	}
}
