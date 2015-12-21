package com.nymgo.tests.fragments.tempMail;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.fragments.HasURL;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 3, 2015
 */
public class TempMailPageFragment extends BaseFragment implements HasURL{

	public TempMailPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final static String TEMP_MAIL_PAGE_URL = "http://temp-mail.org/en/";
	
	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlContains(TEMP_MAIL_PAGE_URL));
			return true;
		}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return TEMP_MAIL_PAGE_URL;
	}

	@FindBy(xpath = "//input[@id='mail']")
	private WebElement emailEdit;
	
	@FindBy(xpath = "//a[@id='click-to-refresh']")
	private WebElement refreshButton;
	
	@FindBy(xpath = "//a[@id='click-to-delete']")
	private WebElement deleteButton;
	
	public String getEmailAddress(){
		
		return emailEdit.getAttribute("value");
	}
	
	public void clickRefresh(){
		
		clickButton(refreshButton);
	}

	public void clickDelete(){
		
		clickButton(deleteButton);
	}

}
