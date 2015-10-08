package nymgoAutomation.tests.navigation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import nymgoAutomation.tests.factories.WebPageInterface;
import nymgoAutomation.tests.pages.AbstractPage;

public class WebNavigator<T extends AbstractPage>
{
    private final WebPageInterface<T> factory;
    private WebDriver driver;

    WebNavigator(WebPageInterface<T> factory, WebDriver driver){
    	
    	this.factory = factory;
    	this.driver = driver;
    }

    T createContents() {
        return factory.create(driver);
    }

	public T NavigatedTo(WebDriver driver){
		T arg = createContents();
		Assert.assertTrue(arg.isCorrectPage(), "Could not navigate to page: " + arg.getPageName());
		System.out.println("Successfully navigated to page: " + arg.getPageName());
		return arg;
	}
}
