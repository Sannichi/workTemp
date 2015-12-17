package com.nymgo.tests.fragments.tempMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Dec 17, 2015
 */
public class TempMailEmailContentPageFragment extends TempMailPageFragment{

	public TempMailEmailContentPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h4[@class='pm-subject']")
	private WebElement emailSubject;
	
	@FindBy(xpath = "//div[@class='pm-text']")
	private WebElement emailContent;
	
	public String getEmailSubjectText(){
		
		return emailSubject.getText();
	}

	public String getEmailContentText(){
		
		return emailContent.getText();
	}
}
