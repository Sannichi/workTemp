package com.nymgo.tests.fragments.tempMail;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Dec 22, 2015
 */
public class TempMailRegistrationSuccessPageFragment extends BaseTempMailEmailContentPageFragment {

	public TempMailRegistrationSuccessPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a[href*='nymgo.com/activate']")
	private List<WebElement> verifyAccountLinks;
	
	private WebElement verifyAccountButton = verifyAccountLinks.get(0); 
	private WebElement verifyAccountLink = verifyAccountLinks.get(1); 
	
	public void clickVerifyAccountButton(){
		
		clickButton(verifyAccountButton);
	}

	public String getVerifyAccountButtonLink(){
		
		return verifyAccountButton.getAttribute("href");
	}

	public void clickVerifyAccountLink(){
		
		clickButton(verifyAccountLinks.get(1));
	}

	public String getVerifyAccountLinkLink(){
		
		return verifyAccountLink.getAttribute("href");
	}

}
