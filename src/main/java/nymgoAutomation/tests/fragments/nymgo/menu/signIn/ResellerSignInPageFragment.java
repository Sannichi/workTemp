package nymgoAutomation.tests.fragments.nymgo.menu.signIn;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.nymgo.base.BaseNymgoFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.starter.Starter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResellerSignInPageFragment extends BaseNymgoFragment{
	
	public ResellerSignInPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "username-el")
	private WebElement username;
	
	@FindBy(id = "Password-el")
	private WebElement password;
	
	@FindBy(id = "reseller-login-el")
	private WebElement signInButton;
	
	private static final String RESELLER_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/";
	
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
    
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(RESELLER_ACCOUNT_PAGE_URL));
	}
}
