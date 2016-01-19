package com.nymgo.tests.fragments.admin;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.admin.base.BaseAdminFragment;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class LoginAdminPageFragment extends BaseAdminFragment{

	public LoginAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String LOGIN_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL); 

	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = ".//*[@src = '/images/login.png']")
	private WebElement loginButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlMatches(LOGIN_PAGE_URL_ENG));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return LOGIN_PAGE_URL_ENG;
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
