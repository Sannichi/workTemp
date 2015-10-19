package nymgoAutomation.tests.fragments.admin.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nymgoAutomation.tests.fragments.BaseFragment;

public class BasePopupFragment extends BaseFragment{

	public BasePopupFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		setPopupContainer();
	}

    private WebElement popup;

    private void setPopupContainer() throws NotFoundException{
    	
    	popup = driver.findElement(By.id("facebox"));
    };

    public boolean isPopupExist(){

        try{
            setPopupContainer();
            return popup.isDisplayed();
        }
        catch (NotFoundException e){
            return false;
        }
    }

    private WebElement getPopupContentArea() throws NotFoundException{
    	
    	return popup.findElement(By.xpath(".//div[@class='content']"));
    };

    public String getPopupText() throws NotFoundException{
    	
    	return getPopupContentArea().getText();
    };

    public void clickOnCloseButton(){
    	
    	popup.findElement(By.xpath(".//img[@title='close']")).click();
        LOGGER.info("Popup close button was clicked");
    }
}
