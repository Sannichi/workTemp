package nymgoAutomation.tests.fragments.nymgo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.starter.Starter;

public abstract class BaseLoggedInFragment extends BaseNymgoFragment{
	
	public BaseLoggedInFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected WebElement myAccountDropdown;
	protected WebElement logOutDropdown;
	
	private void initializeWebElements() throws NoSuchElementException{
		
		myAccountDropdown = driver.findElement(By.xpath("//div[@class='dropdown-holder']")).findElement(By.xpath(nymgoMyAccountXpath));
		logOutDropdown = driver.findElement(By.xpath("//div[@class='dropdown-holder']")).findElement(By.xpath(nymgoLogOutXpath));
	}
	
	public void clickLogOut(){

		initializeWebElements();
		Actions actions = new Actions(driver);
		actions.moveToElement(accountButton).perform();
		WebDriverWait wait = new WebDriverWait(driver, Starter.INITIALIZED_ELEMENT_WAIT_TIME);
		try{
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(logOutDropdown));
			clickButton(webElement);
		}
		catch(TimeoutException e){
			LOGGER.fatal("Sign out dropdown was not shown");
		}
	}

	public void clickMyAccountDropdown(){

		initializeWebElements();
		Actions actions = new Actions(driver);
		actions.moveToElement(accountButton).perform();
		WebDriverWait wait = new WebDriverWait(driver, Starter.INITIALIZED_ELEMENT_WAIT_TIME);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(myAccountDropdown)); 
		clickButton(webElement);
	}
}
