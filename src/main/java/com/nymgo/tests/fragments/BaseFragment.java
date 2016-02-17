package com.nymgo.tests.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;

public class BaseFragment {

	protected WebDriver driver;
	protected Logger LOGGER = AbstractCase.LOGGER;

	public BaseFragment(WebDriver driver) {

		PageFactory.initElements(driver, this);
        this.driver = driver;
    }

	public String getCurrentURL(){

		return driver.getCurrentUrl();
	}

	public void navigateToURL(String URL){

		driver.get(URL);
	}

	/*
	 * Returns windowHandle
	 * before new window
	 * is opened
	 */
	public String getCurrentWindowHandle(){
		
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
	
	public void switchToWindowHandle(String windowHandle){
		
		driver.switchTo().window(windowHandle);
	}
	
	public void openURLInNewTab(String URL){
	
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		driver.findElement(By.cssSelector("body")).sendKeys(selectLinkOpeninNewTab);
		navigateToURL(URL);

		//switch driver to the current tab
//		Set<String> handles = driver.getWindowHandles();
//	    List<String> handlesList = new ArrayList<String>(handles);
//	    String tab = handlesList.get(handlesList.size() - 1);
//	    driver.switchTo().window(tab); 
}
	
	public boolean navigateToTabByURL(String URL){

		Set<String> handles = driver.getWindowHandles();
	    List<String> handlesList = new ArrayList<String>(handles);
	    String tab = handlesList.get(handlesList.size() - 1);

		for(int i = 0; i < 10; i++){
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
			//switch driver to the current tab
		    driver.switchTo().window(tab); 
			if (getCurrentURL().equals(URL)){
				LOGGER.info("Switched to tab with URL: " + URL);
				return true;
			}
		}
		LOGGER.fatal("There is no tab with URL: " + URL + " within 10 first tabs");
		return false;
	}
	
	
	public boolean navigateToTabByURLContains(String URLContains){

		Set<String> handles = driver.getWindowHandles();
	    List<String> handlesList = new ArrayList<String>(handles);
	    String tab = handlesList.get(handlesList.size() - 1);

		for(int i = 0; i < 10; i++){
			if (getCurrentURL().contains(URLContains)){
				LOGGER.info("Switched to tab with URL contains: " + URLContains);
				return true;
			}
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
			//switch driver to the current tab
		    driver.switchTo().window(tab); 
		}
		LOGGER.fatal("There is no tab with URL contains: " + URLContains + " within 10 first tabs");
		return false;
	}
	
	public boolean closeTabByURLContains(String URLContains){

		Set<String> handles = driver.getWindowHandles();
	    List<String> handlesList = new ArrayList<String>(handles);
	    String tab = handlesList.get(handlesList.size() - 1);

		for(int i = 0; i < 10; i++){
			if (getCurrentURL().contains(URLContains)){
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
				LOGGER.info("Closed tab with URL contains: " + URLContains);
				return true;
			}
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
			//switch driver to the new browser
		    switchToWindowHandle(tab);
		}
		LOGGER.fatal("There is no tab with URL contains: " + URLContains + " within 10 first tabs");
		return false;
	}
	
	public void closeAndSwitchBrowser(String windowHandle){

			driver.close();
			//switch driver to the new browser
		    switchToWindowHandle(windowHandle);
			LOGGER.info("Browser was closed and switched to another Browser window");
	}
	
	public void navigateHomePage(){

		driver.get(ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
				LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL));
	}

	public void navigateAdminLoginPage(){

		driver.get(ServerGenerator.getServerKey(URL_CONST.ADMIN_URL));
	}
	
	public boolean isElementEnabled(WebElement element){
		try{
			return element.isEnabled();
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	public boolean isElementSelected(WebElement element){
		try{
			return element.isSelected();
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement element){
		try{
			return element.isDisplayed();
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	protected void pressEnter(){
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		LOGGER.info("Enter was pressed");
	}
	
	protected void pressEnterOnElement(WebElement element){
		
		element.sendKeys(Keys.ENTER);
		LOGGER.info("Enter was pressed");
	}
	
    public void scrollToElement(WebElement element)
    {
       int elementPosition = element.getLocation().getY();
       LOGGER.info("Scrolling to the element...");
       String js = String.format("window.scroll(0, %s)", elementPosition);
       ((JavascriptExecutor)driver).executeScript(js);
    }    
    
    public void clickElementByCoordinates(WebElement element)
    {
//    	Point p = element.getLocation();
    	LOGGER.info("Clicking the element...");
    	String js = "arguments[0].click()";
    	((JavascriptExecutor)driver).executeScript(js, element);
    }    
    
	protected void clickRadioButton(WebElement radioButton){
		
		String text = radioButton.getAttribute("value");
		radioButton.click();
		LOGGER.info("RadioButton '" + text + "' was clicked");
	}
	
	protected void clearEdit(WebElement editField){
		
		editField.clear();
		LOGGER.info("EditField is cleared");
	}
	
	/**
	*input with only text e.g <a>
	*/
	protected void clickButton(WebElement button){
		
		String text = button.getText();
		button.click();
		LOGGER.info("Button '" + text + "' was clicked");
	}
	
	/**
	*input with title
	*/
	protected void clickSubmitButton(WebElement button){
		
		String title = button.getAttribute("title");
		button.click();
		LOGGER.info("Button '" + title + "' was clicked");
	}
	
	/**
	*input with only value
	*/
	protected void clickInputButton(WebElement button){
		
		String value = button.getAttribute("value");
		button.click();
		LOGGER.info("Button '" + value + "' was clicked");
	}
	
	/**
	*Checkbox with value
	*/
	protected void clickCheckbox(WebElement checkbox){
		
		String value = checkbox.getAttribute("value");
		checkbox.click();
		LOGGER.info("Checkbox '" + value + "' was clicked");
	}
	
	/**
	*Element with text
	*/
	protected void clickElement(WebElement element){
		
		String text = element.getText();
		element.click();
		LOGGER.info("Element with text '" + text + "' was clicked");
	}

	protected void clickLink(WebElement link){
		
		String text = link.getText();
		link.click();
		LOGGER.info("Link '" + text + "' was clicked");
	}
	
	protected void clickTitleLink(WebElement link){
		
		String title = link.getAttribute("title");
		link.click();
		LOGGER.info("Link '" + title + "' was clicked");
	}
	
	protected void expandClickableContent(WebElement element){
		
		String text = element.getText();
		element.click();
		LOGGER.info("Clickable content '" + text + "' was expanded");
	}

	protected void clickWidget(WebElement widget){
		
		String alt = widget.getAttribute("alt");
		widget.click();
		LOGGER.info("Widget '" + alt + "' was clicked");
	}
	
	protected void clickWidgetTabImage(WebElement tab){
		
		String alt = tab.getAttribute("alt");
		tab.click();
		LOGGER.info("Widget tab '" + alt + "' was clicked");
	}
	
	protected void setTextToEditField(WebElement editField, String textToSet){
		
		clearEdit(editField);
		editField.sendKeys(textToSet);
		LOGGER.info("Text '" + textToSet + "' was set to editField");
	}
	
	protected void selectValueFromSelectByLocaleText(WebElement elementWithSelect, String localeText){
		
		String localeName = LocaleGenerator.getLocaleKeyNameByValue(localeText);
		Select select = new Select(elementWithSelect);
		select.selectByVisibleText(LocaleGenerator.getLocaleKey(LOCALE_CONST.valueOf(localeName)));
		
		LOGGER.info("Value " + localeText + " was selected from Select");
	}

	protected void selectValueFromSelectByVisibleText(WebElement elementWithSelect, String visibleText){
		
		Select select = new Select(elementWithSelect);
		select.selectByVisibleText(visibleText);
		
		LOGGER.info("Value " + visibleText + " was selected from Select");
	}

	protected void selectValueFromSelectByValue(WebElement elementWithSelect, String value){
		
		Select select = new Select(elementWithSelect);
		select.selectByValue(value);
		
		LOGGER.info("Value " + value + " was selected from Select");
	}
}
