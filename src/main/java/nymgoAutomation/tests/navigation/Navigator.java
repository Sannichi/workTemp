package nymgoAutomation.tests.navigation;

import nymgoAutomation.tests.testCases.AbstractCase;

import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

public class Navigator {
	
	protected Logger LOGGER = AbstractCase.LOGGER;

	public Navigator() {

    }

	public void clickButton(WebElement button){
		
		button.click();
		LOGGER.info("Button " + button.getText() + " was clicked");
	}
	
	public void setTextToEditField(WebElement editField, String textToSet){
		
		editField.sendKeys(textToSet);
		LOGGER.info("Text " + textToSet + " was set to editField");
	}
}
