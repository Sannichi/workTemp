package com.nymgo.tests.fragments.nymgo.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class BaseAccountPageFragment extends BaseLoggedInFragment{
	
	public BaseAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String ACCOUNT_PAGE_URL_EN = Starter.SECURE_PART +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/dashboard";
	
	private static final String language = LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL);
	
	private static final String accountMyBalanceBlockClassName = "block my-balance";
	private static final String accountPackageBlockClassName = "block package";
	private static final String accountBuyCreditXpath = "//div[@class='" + accountMyBalanceBlockClassName + "']//a[@href='" + language + "/buy-credits']";
//	private static final String accountBuyDealsXpath = "(//a[@href='" + language + "/buy-credits'])[last()]";
	private static final String accountBuyDealsXpath = "//div[starts-with(@class,'" + accountPackageBlockClassName + "')]//a[@href='" + language + "/buy-credits']";
	private static final String transferCreditXpath = "//div[@class='" + accountMyBalanceBlockClassName + "']//a[@href='" + language + "/user/credits/transfer-credits']";

	private WebElement accountBuyCreditButton;
	private WebElement accountBuyDealsButton;
	private WebElement accountTransferCreditButton;
	
	@FindBy(xpath = "//div[@class='block my-balance']//div[@class='balance']")
	private WebElement accountBalance;

	@FindBy(xpath = "//div[starts-with(@class,'block package')]//div[@class='owl-item']")
	private List<WebElement> dealsList;

	@FindBy(xpath = "//div[@class='owl-item']//div[@class='innerPadding']/div[2]")
	private List<WebElement> dealsNamesList;

	@FindBy(xpath = "//div[starts-with(@class,'block package')]//span[@class='notification']")	
	private WebElement myDealsCounter;

	@FindBy(xpath = "//div[@class='owl-next']")	
	private WebElement dealNext;

	@FindBy(xpath = "//div[@class='owl-next']")	
	private WebElement dealPrev;

	//	@FindBy(xpath = "//div[starts-with(@class,'block package')]//div[@class='daysCounter']//strong")
	@FindBy(xpath = "//div[@class='daysCounter']//strong")
	private List<WebElement> dealDaysCounter;

	@FindBy(xpath = "(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[1]/div[2]")	
	private WebElement firstDealName;

	@FindBy(xpath = "(//div[@class='packageInfo']//strong)[1]")
	private WebElement firstDealMinutes;

	@FindBy(xpath = "(//div[@class='packageInfo']//strong)[2]")	
	private WebElement firstDealTopUp;

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

	private void initializeBuyDealsButton() throws NoSuchElementException{
		
		accountBuyDealsButton = driver.findElement(By.xpath(accountBuyDealsXpath));
	}

	private void initializeTransferCreditCreditButton() throws NoSuchElementException{
		
		accountTransferCreditButton = driver.findElement(By.xpath(transferCreditXpath));
	}

	public void clickAccountBuyCreditButton(){
		
		initializeBuyCreditButton();
		clickSubmitButton(accountBuyCreditButton);
	}
	
	public void clickAccountBuyDealsButton(){
		
		initializeBuyDealsButton();
		clickSubmitButton(accountBuyDealsButton);
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

	public String getMyDealsCounter(){
		
		try {
			return myDealsCounter.getText();
		}
		catch (NoSuchElementException e){
			return "0";
		}
	}

	public void clickNextDealButton(){
		
		clickElement(dealNext);
	}

	public void clickPrevDealButton(){
		
		clickElement(dealPrev);
	}

	public String getFirstDealName(){
		
		return firstDealName.getText();
	}

	public String getFirstDealMinutes(){
		
		return firstDealMinutes.getText();
	}
	
	public String getFirstDealTopUp(){
		
		return firstDealTopUp.getText();
	}

	public String getDealName(int i){
		
		return dealsNamesList.get(i).getText();
	}

	public String getDealDaysCounter(int i){
		
		return dealDaysCounter.get(i).getText();
	}

	public String getDealMinutes(int i){
		
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2 - 1) + "]")).getText();
	}
	
	public String getDealTopUp(int i){
		
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2) + "]")).getText();
	}

	public int navigateToDeal(String dealName){
		
		int i = 0;
		int dealsCount = dealsList.size(); 
		for (i = 0; i < dealsCount; i++){
			if (!driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[" + 
					(Integer.valueOf(i) + 1) + "]/div[2]")).getText().equals(dealName)){
			LOGGER.debug(driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[" + 
					(Integer.valueOf(i) + 1) + "]/div[2]")).getText());
				clickNextDealButton();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				return i;
			}
		}
		LOGGER.fatal("There is no Deal with name '" + dealName + "'");
		return -1;
	}

}
