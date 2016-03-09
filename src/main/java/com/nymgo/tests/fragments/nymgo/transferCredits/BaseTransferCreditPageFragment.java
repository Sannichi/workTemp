package com.nymgo.tests.fragments.nymgo.transferCredits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.fragments.nymgo.base.LoggedNymgoPageFragment;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class BaseTransferCreditPageFragment extends LoggedNymgoPageFragment {

	public BaseTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "recipient-username-el")
	private WebElement usernameField;
	
	@FindBy(id = "amount-el")
	private WebElement amountField;

	@FindBy(id = "your-password-el")
	private WebElement passwordField;

	@FindBy(id = "send-button-el")
	private WebElement transferButton;
	
	public void setUsername(String username){
		setTextToEditField(usernameField, username);
	}
	
	public void setAmount(String amount){
		setTextToEditField(amountField, amount);
	}
	
	public void setPassword(String password){
		setTextToEditField(passwordField, password);
	}
	
	public void clickTransferButton(){
		clickInputButton(transferButton);
	}
}
