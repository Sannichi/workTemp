package nymgoAutomation.tests.factories;

import org.openqa.selenium.WebDriver;

public interface WebPageInterface<T> {
	
	T create(WebDriver driver);
}
