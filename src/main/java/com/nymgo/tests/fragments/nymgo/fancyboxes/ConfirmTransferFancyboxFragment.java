package com.nymgo.tests.fragments.nymgo.fancyboxes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Mar 10, 2016
 */
public class ConfirmTransferFancyboxFragment extends BaseFancyboxFragment{

	public ConfirmTransferFancyboxFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='sendbutton']")
	WebElement transferButton;
	
	@FindBy(xpath = "//a[@id='cancelBtn']")
	WebElement cancelButton;

	@FindBy(xpath = "//div[@id='confirmationPopup']//p")
	WebElement popupText;

	public void clickTransfer(){
		clickInputButton(transferButton);
	}

	public void clickCancel(){
		clickInputButton(cancelButton);
	}
	
	public String getHelpText(){
		
		return popupText.getText();
	}
}
