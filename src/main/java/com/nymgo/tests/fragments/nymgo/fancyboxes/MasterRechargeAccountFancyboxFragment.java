package com.nymgo.tests.fragments.nymgo.fancyboxes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Mar 10, 2016
 */
public class MasterRechargeAccountFancyboxFragment extends BaseFancyboxFragment{

	public MasterRechargeAccountFancyboxFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='transfer_credit_master']")
	WebElement transferAmountField;
	
	@FindBy(xpath = "//input[@name='save']")
	WebElement sendButton;
	
	@FindBy(xpath = "//a[@id='cancelBtn']")
	WebElement cancelButton;

	@FindBy(xpath = "//p[@id='help-mr-transfer']")
	WebElement helpText;

	public void setAmount(String amount){
		setTextToEditField(transferAmountField, amount);
	}

	public void clickSend(){
		clickInputButton(sendButton);
	}

	public void clickCancel(){
		clickInputButton(cancelButton);
	}
	
	public String getHelpText(){
		
		return helpText.getText();
	}
}
