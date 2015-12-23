package com.nymgo.tests.fragments.tempMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Dec 22, 2015
 */
public class TempMailActivationSuccessPageFragment extends BaseTempMailEmailContentPageFragment {

	public TempMailActivationSuccessPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "verify_account")
	private WebElement verifyAccountButton;
	
	public void clickVerifyAccountButton(){
		
		clickButton(verifyAccountButton);
	}
}
