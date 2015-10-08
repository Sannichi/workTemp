package nymgoAutomation.tests.fragments.nymgo.menu.signIn;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.nymgo.base.BaseNymgoFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.navigation.Starter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NormalUserSignInPageFragment extends BaseNymgoFragment{
	
	public NormalUserSignInPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "username-el")
	private WebElement username;
	
	@FindBy(id = "Password-el")
	private WebElement password;
	
	@FindBy(id = "user-login-el")
	private WebElement signInButton;
	
	private static final String NORMAL_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/login";
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(NORMAL_ACCOUNT_PAGE_URL));
	}

    public void typeUsername(String login){
    	
//    	this.username.sendKeys(login);
    	setTextToEditField(this.username, login);
    }
    
    public void typePassword(String password){
    	
//    	this.password.sendKeys(password);
    	setTextToEditField(this.password, password);
    }

    public void clickSignIn(){

//    	signInButton.click();
    	clickSubmitButton(signInButton);
    }
}
