package nymgoAutomation.tests.fragments.admin.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseLoggedAdminFragment extends BaseAdminFragment{

	public BaseLoggedAdminFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@href='/modules/users/index.php']")
	private WebElement membersLink;

	@FindBy(xpath = "//a[@href='/modules/transactions/index.php']")
	private WebElement transactionsLink;

	@FindBy(xpath = "//a[@href='/logout.php']")
	private WebElement logOutButton;
	
    public void clickMembersLink()
	{
		
//		membersLink.click();
    	clickLink(membersLink);
	}

    public void clickTransactionsLink()
	{
		
    	clickLink(transactionsLink);
	}

	public boolean isAdminLogged()
	{
		boolean flag = false;
        try{
    		WebDriverWait wait = new WebDriverWait(driver, 5);
    		@SuppressWarnings("unused")
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(logOutButton)); 
            flag = true;
        	LOGGER.debug("Admin is logged");            
        }
        catch (TimeoutException e){
        	LOGGER.debug("Admin is not logged");        	
        }
		
		return flag;
	}

	public void clickLogout()
	{
		
	}
	
}
