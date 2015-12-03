package com.nymgo.tests.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.admin.LoginAdminPage;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.tempMail.TempMailPage;
import com.nymgo.tests.starter.Starter;

public abstract class AbstractPage {

	protected WebDriver driver;

	protected Logger LOGGER;

    public static Starter starter;
	private BaseFragment baseFragment;
	private String TEMP_MAIL_URL = "http://temp-mail.org/en/";
	
	public AbstractPage(Starter starter) {	

        AbstractPage.starter = starter;
        this.driver = starter.driver;
		baseFragment = new BaseFragment(driver);
		LOGGER = starter.LOGGER;
    }

	public abstract String getPageName();
	public abstract boolean isCorrectPage();
	public abstract String getPageURL();
	
    protected void delay(final long amount) {
        try {
            Thread.sleep(amount);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public String getCurrentURL(){

		return baseFragment.getCurrentURL();
	}

	public void navigateToURL(String URL){

		baseFragment.navigateToURL(URL);
	}

	public HomePage navigateToHomePage(){

		LOGGER.info("Navigating to Nymgo Home page...");
		baseFragment.navigateHomePage();
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
  		return homePage;    		
	}

	public LoginAdminPage navigateToAdminLoginPage(){

		LOGGER.info("Navigating to Nymgo Admin page...");
		baseFragment.navigateAdminLoginPage();
		LoginAdminPage loginAdminPage = new LoginAdminPage(starter);
		PageNavigation<LoginAdminPage> navigation = new PageNavigation<LoginAdminPage>(loginAdminPage); 
		navigation.NavigatedTo();
  		return loginAdminPage;    		
	}

	public void openURLInNewTab(String URL){
		
		baseFragment.openURLInNewTab(URL);
	}

	public TempMailPage navigateToTempMailInNewTab(){
		
		LOGGER.info("Navigating to TempMail page...");
		baseFragment.openURLInNewTab(TEMP_MAIL_URL);
		TempMailPage tempMailPage = new TempMailPage(starter);
		PageNavigation<TempMailPage> navigation = new PageNavigation<TempMailPage>(tempMailPage); 
		navigation.NavigatedTo();
  		return tempMailPage;    		
	}

	public void navigateToTabByURL(String URL){
		
		baseFragment.navigateToTabByURL(URL);
	}

}
