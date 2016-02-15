package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;

/**
 * Created by Iuliia Khikmatova on Feb 11, 2016
 */
public abstract class BaseRecurrentCreditCardFragment extends BaseLoggedInFragment {

	public BaseRecurrentCreditCardFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "input[id='savecard']")
	private WebElement saveCardCheckbox;

	@FindBy(css = "label[for='savecard']")
	private WebElement saveCardLabel;

	@FindBy(css = "label[for='saved-card']")
	private WebElement savedCardLabel;

	@FindBy(css = "div[class='addNewCard']")
	private WebElement addNewCard;

	public void setSaveCardCheckbox(){
		
		if (!isSaveCardCheckboxChecked()){
			scrollToElement(saveCardCheckbox);
			clickCheckbox(saveCardCheckbox);
		}
	}
	
	private boolean isSaveCardCheckboxChecked(){
		
		return saveCardCheckbox.getAttribute("checked") == "checked" ? true : false;
	}
	
	private boolean isSavedCardLabelChecked(){
		
		return savedCardLabel.getAttribute("class") == "checked" ? true : false;
	}
	
	public void checkSaveCardLabel(){
		
		if (!isSaveCardCheckboxChecked()){
			clickElement(saveCardLabel);
		}
	}

	public void checkSavedCard(){
		
		if (!isSavedCardLabelChecked()){
			clickElement(savedCardLabel);
		}
	}

	public void clickAddNewCard(){
		
		clickElement(addNewCard);
	}
	
	public void clickSavedCardLabel(){
		
		clickElement(savedCardLabel);
	}
	
	public String getSavedCardNumber(){
		
		return savedCardLabel.getText();
	}
}
