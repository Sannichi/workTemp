package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

public class ResellerAccountPageFragment extends BaseAccountPageFragment{
	
    public ResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.IMPLICITLY_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.visibilityOf(accountDetailsButton));
		}
		catch(TimeoutException e){
			LOGGER.fatal("There is no element accountDetailsButton on the Page");
		}
	}

//    @FindBy(xpath = "//div[@id='account-details']/a[@class='button-edit']")
    @FindBys({@FindBy(css = "div[id='account-details']"),
    	@FindBy(css = "a[class='button-edit']")    
    })
	private WebElement accountDetailsButton;

	public void clickViewAccountDetailsButton(){
		
		clickSubmitButton(accountDetailsButton);
	}
}
