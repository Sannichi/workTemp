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
	
	public void clearEdit(WebElement editField){
		
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
