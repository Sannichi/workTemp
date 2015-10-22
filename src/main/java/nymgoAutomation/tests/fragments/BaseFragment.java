package nymgoAutomation.tests.fragments;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.testCases.AbstractCase;

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

	public void navigateHomePage(){

		driver.get(ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
				LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL));
	}

	public void navigateAdminLoginPage(){

		driver.get(ServerGenerator.getServerKey(URL_CONST.ADMIN_URL));
	}
	
	//input with only text
	protected void clickButton(WebElement button){
		
		String text = button.getText();
		button.click();
		LOGGER.info("Button '" + text + "' was clicked");
	}
	
	//input with title
	protected void clickSubmitButton(WebElement button){
		
		String title = button.getAttribute("title");
		button.click();
		LOGGER.info("Button '" + title + "' was clicked");
	}
	
	//input with only value
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
