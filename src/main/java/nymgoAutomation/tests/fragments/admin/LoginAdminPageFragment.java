package nymgoAutomation.tests.fragments.admin;

import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.admin.base.BaseAdminFragment;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.starter.Starter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAdminPageFragment extends BaseAdminFragment{

	public LoginAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String LOGIN_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL); 

	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = ".//*[@src = '/images/login.png']")
	private WebElement loginButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlMatches(LOGIN_PAGE_URL_ENG));
	}
	
    public void typeUsername(String login){
    	
//    	this.username.sendKeys(login);
    	setTextToEditField(this.username, login);
    }
    
    public void typePassword(String password){
    	
//    	this.password.sendKeys(password);
    	setTextToEditField(this.password, password);
    }

    public void clickLogin(){

//    	loginButton.click();
    	clickSubmitButton(loginButton);
    }
    
}
