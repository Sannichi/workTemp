package nymgoAutomation.tests.fragments.admin.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nymgoAutomation.tests.fragments.BaseFragment;

public class BaseWidgetFragment extends BaseFragment{

	public BaseWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		setWidgetContainer();
		setWidgetName();
	}

    protected WebElement widgetContainer;
    protected String widgetName;

    protected void setWidgetContainer() throws NotFoundException{
    	
    	widgetContainer = driver.findElement(By.id("widjectWindow"));
    };

    protected void setWidgetName() throws NotFoundException{
    	
    	widgetName = widgetContainer.findElement(By.xpath(".//div[@class='drag-handle']")).getText().split("\n")[0];
    };

    public String getWidgetName(){

    	setWidgetName();
    	return widgetName;
    };

    public boolean isWidgetExist(){

        try{
            setWidgetContainer();
            setWidgetName();
        }
        catch (NotFoundException e){
            return false;
        }
        boolean result = widgetContainer.isDisplayed();
        return widgetContainer.isDisplayed();
    }

    protected WebElement getWidgetContentArea() throws NotFoundException{
    	
    	return widgetContainer.findElement(By.id("drag-contentarea"));
    };

    public void clickOnCloseButton(){
        driver.findElement(By.xpath(".//img[@title='Close']")).click();
        LOGGER.info("Widget close button was clicked");
    }

    public void clickOnTabByAltText(String tabText){

    	String imageXpath = ".//img[@alt='" + tabText + "']";
		WebElement imageByAlt = widgetContainer.findElement(By.xpath(imageXpath));
//		imageByAlt.click();
		clickWidgetTabImage(imageByAlt);
    }
    
}
