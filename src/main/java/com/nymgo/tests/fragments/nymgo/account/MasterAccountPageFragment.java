package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterAccountPageFragment extends BaseAccountPageFragment{
	
    public MasterAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy(xpath = "//div[@id='reports'][1]//a[@class='button-edit']")
	private WebElement viewMastersListButton;

    @FindBy(xpath = "//div[@id='reports'][2]//a[@class='button-edit']")
	private WebElement viewResellerListButton;

	public void clickViewMastersListButton(){
		
		scrollToElement(viewMastersListButton);
		clickSubmitButton(viewMastersListButton);
	}

	public void clickViewResellerListButton(){
		
		scrollToElement(viewResellerListButton);
		clickSubmitButton(viewResellerListButton);
	}

}
