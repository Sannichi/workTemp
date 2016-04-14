package com.nymgo.tests.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.fragments.admin.LoginAdminPageFragment;
import com.nymgo.tests.fragments.tempMail.TempMailPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.admin.LoginAdminPage;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.tempMail.TempMailEmailListPage;
import com.nymgo.tests.starter.Starter;

public abstract class AbstractPage {

	protected WebDriver driver;

	protected Logger LOGGER;

    public static Starter starter;
	private BaseFragment baseFragment;
	
	protected SoftAssert softAssert = new SoftAssert();
	
	public AbstractPage(Starter starter) {	

        AbstractPage.starter = starter;
        this.driver = starter.driver;
		baseFragment = new BaseFragment(driver);
		LOGGER = starter.LOGGER;
    }

	public abstract String getPageName();
	public abstract boolean isCorrectPage();
	public abstract String getPageURL();
	
    public void delay(final long amount) {
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

	public String getCurrentWindowHandle(){
		
		return baseFragment.getCurrentWindowHandle();

	}
	
	public void switchToWindowHandle(String windowHandle){
		
		baseFragment.switchToWindowHandle(windowHandle);
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

	public TempMailEmailListPage navigateToTempMailInNewTab(){
		
		LOGGER.info("Navigating to TempMail page...");
		baseFragment.openURLInNewTab(TempMailPageFragment.TEMP_MAIL_PAGE_URL);		
		TempMailEmailListPage tempMailEmailListPage = new TempMailEmailListPage(starter);
		PageNavigation<TempMailEmailListPage> navigation = new PageNavigation<TempMailEmailListPage>(tempMailEmailListPage); 
		navigation.NavigatedTo();
  		return tempMailEmailListPage;    		
	}

	public LoginAdminPage navigateToAdminInNewTab(){
		
		LOGGER.info("Navigating to Admin page...");
		baseFragment.openURLInNewTab(LoginAdminPageFragment.LOGIN_PAGE_URL_ENG);
		LoginAdminPage loginAdminPage = new LoginAdminPage(starter);
		PageNavigation<LoginAdminPage> navigation = new PageNavigation<LoginAdminPage>(loginAdminPage); 
		navigation.NavigatedTo();
  		return loginAdminPage;    		
	}

	public void navigateToTabByURL(String URL){
		
		baseFragment.navigateToTabByURL(URL);
	}

	public void navigateToTabByURLContains(String URLContains){
		
		baseFragment.navigateToTabByURLContains(URLContains);
	}

	public boolean closeTabByURLContains(String URLContains){

		return baseFragment.closeTabByURLContains(URLContains);
	}
	
	public void closeAndSwitchBrowser(String windowHandle){
		
		baseFragment.closeAndSwitchBrowser(windowHandle);
	}

	public TempMailEmailListPage navigateToTempMailTab(){
		
		LOGGER.info("Navigating to TempMail page...");
		baseFragment.navigateToTabByURL(TempMailPageFragment.TEMP_MAIL_PAGE_URL);
		TempMailEmailListPage tempMailEmailListPage = new TempMailEmailListPage(starter);
		PageNavigation<TempMailEmailListPage> navigation = new PageNavigation<TempMailEmailListPage>(tempMailEmailListPage); 
		navigation.NavigatedTo();
  		return tempMailEmailListPage;    		
	}

}
