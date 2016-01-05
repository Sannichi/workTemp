package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class BaseAccountPageFragment extends BaseLoggedInFragment{
	
	public BaseAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String ACCOUNT_PAGE_URL_EN = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
//	public static final String ACCOUNT_PAGE_URL_EN = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +	
	public static final String ACCOUNT_PAGE_URL_EN = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https") +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/dashboard";
	
	private static final String language = LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL);
	
	private static final String accountMyBalanceBlockClassName = "block my-balance";
	private static final String accountBuyCreditXpath = "//div[@class='" + accountMyBalanceBlockClassName + "']//a[@href='" + language + "/buy-credits']";
	private static final String transferCreditXpath = "//div[@class='" + accountMyBalanceBlockClassName + "']//a[@href='" + language + "/user/credits/transfer-credits']";
//	private static final String viewFullAccountXpath = "//a[@href='" + language + "/user/account/view/profile']";

	private WebElement accountBuyCreditButton;
	private WebElement accountTransferCreditButton;
	
	@FindBy(xpath = "//div[@class='block my-balance']//div[@class='balance']")
	private WebElement accountBalance;

	public boolean isCorrectURL(){
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(ACCOUNT_PAGE_URL_EN));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return ACCOUNT_PAGE_URL_EN;
	}
	
	private void initializeBuyCreditButton() throws NoSuchElementException{
		
		accountBuyCreditButton = driver.findElement(By.xpath(accountBuyCreditXpath));
	}

	private void initializeTransferCreditCreditButton() throws NoSuchElementException{
		
		accountTransferCreditButton = driver.findElement(By.xpath(transferCreditXpath));
	}

	public void clickAccountBuyCreditButton(){
		
		initializeBuyCreditButton();
		clickSubmitButton(accountBuyCreditButton);
	}
	
	public void clickAccountTransferCreditButton(){
		
		initializeTransferCreditCreditButton();
		clickSubmitButton(accountTransferCreditButton);
	}
	
	public String getAccountBalance(){
		
		return accountBalance.getText();
	}

	public String getAccountBalanceValue(){
		
		return accountBalance.getText().split(" ")[0];
	}

	public String getAccountBalanceCurrency(){
		
		return accountBalance.getText().split(" ")[1];
	}
}
