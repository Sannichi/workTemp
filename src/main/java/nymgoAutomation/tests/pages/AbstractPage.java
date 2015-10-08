package nymgoAutomation.tests.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import nymgoAutomation.tests.fragments.BaseFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.admin.LoginAdminPage;
import nymgoAutomation.tests.pages.nymgo.HomePage;

public abstract class AbstractPage {

	protected WebDriver driver;

	protected Logger LOGGER;

    public static Starter starter;
	private BaseFragment baseFragment;
	
	
	public AbstractPage(Starter starter) {	

        AbstractPage.starter = starter;
        this.driver = starter.driver;
		baseFragment = new BaseFragment(driver);
		LOGGER = starter.LOGGER;
    }

	public abstract String getPageName();
	public abstract boolean isCorrectPage();
	
	public String getCurrentURL(){

		return baseFragment.getCurrentURL();
	}

	public void navigateToURL(String URL){

		baseFragment.navigateToURL(URL);
	}

	public HomePage navigateToHomePage(){

		baseFragment.navigateHomePage();
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
  		return homePage;    		
	}

	public LoginAdminPage navigateToAdminLoginPage(){

		baseFragment.navigateAdminLoginPage();
		LoginAdminPage loginAdminPage = new LoginAdminPage(starter);
		PageNavigation<LoginAdminPage> navigation = new PageNavigation<LoginAdminPage>(loginAdminPage); 
		navigation.NavigatedTo();
  		return loginAdminPage;    		
	}

	
}
