package com.nymgo.tests.fragments.nymgo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

public abstract class BaseLoggedInFragment extends BaseNymgoFragment{
	
	public BaseLoggedInFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected WebElement myAccountDropdown;
	protected WebElement logOutDropdown;
	
	private void initializeWebElements() throws NoSuchElementException{
		
		try{
			myAccountDropdown = driver.findElement(By.xpath("//div[@class='dropdown-holder']")).findElement(By.xpath(nymgoMyAccountXpath));
			logOutDropdown = driver.findElement(By.xpath("//div[@class='dropdown-holder']")).findElement(By.xpath(nymgoLogOutXpath));
		}
		catch(NoSuchElementException e){
			LOGGER.fatal("There are no such elements on the page");
		}
	}
	
	public void clickLogOut(){

		initializeWebElements();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME)).perform();
		LOGGER.info("Hover Account dropdown");
		actions.moveToElement(accountButton).perform();
		WebDriverWait wait = new WebDriverWait(driver, Starter.INITIALIZED_ELEMENT_WAIT_TIME);
		WebElement webElement = null;
		try {
			webElement = wait.until(ExpectedConditions.visibilityOf(logOutDropdown)); 
		}
		catch (TimeoutException e){
			actions.moveToElement(nymgoLogo).perform();
			LOGGER.info("Hover Account dropdown again...");
			actions.moveToElement(accountButton).perform();
			try {
				webElement = wait.until(ExpectedConditions.visibilityOf(myAccountDropdown)); 
			}
			catch (TimeoutException e2){
				LOGGER.fatal("Something was wrong with account dropdown items");
			}
		}
		if (webElement != null){
			clickButton(webElement);
		}
		else{
			LOGGER.fatal("myAccountDropdown = null");
		}
	}

	public void clickMyAccountDropdown(){

		initializeWebElements();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME)).perform();
//		scrollToElement(accountButton);
		LOGGER.info("Hover Account dropdown");
		actions.moveToElement(accountButton).perform();
		WebDriverWait wait = new WebDriverWait(driver, Starter.ELEMENT_WAIT_TIME);
		WebElement webElement = null;
		try {
			webElement = wait.until(ExpectedConditions.visibilityOf(myAccountDropdown)); 
		}
		catch (TimeoutException e){
			actions.moveToElement(nymgoLogo).perform();
			LOGGER.info("Hover Account dropdown again...");
			actions.moveToElement(accountButton).perform();
			try {
				webElement = wait.until(ExpectedConditions.visibilityOf(myAccountDropdown)); 
			}
			catch (TimeoutException e2){
				LOGGER.fatal("Something was wrong with account dropdown items");
			}
		}
		if (webElement != null){
			clickButton(webElement);
		}
		else{
			LOGGER.fatal("myAccountDropdown = null");
		}
	}
}
