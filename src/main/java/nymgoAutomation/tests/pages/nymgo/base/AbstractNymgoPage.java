package nymgoAutomation.tests.pages.nymgo.base;

import nymgoAutomation.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import nymgoAutomation.tests.fragments.nymgo.base.NymgoPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.pages.nymgo.HomePage;
import nymgoAutomation.tests.pages.nymgo.SecureHomePage;
import nymgoAutomation.tests.pages.nymgo.menu.AppsPage;
import nymgoAutomation.tests.pages.nymgo.menu.PricesPage;
import nymgoAutomation.tests.pages.nymgo.menu.ResellersPage;
import nymgoAutomation.tests.pages.nymgo.menu.SupportPage;
import nymgoAutomation.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractNymgoPage extends AbstractPage{

	private NymgoPageFragment nymgoPageFragment;
	private LoggedNymgoPageFragment loggedNymgoPageFragment;
	
	
	
	public AbstractNymgoPage(Starter starter) {

		super(starter);
		nymgoPageFragment = new NymgoPageFragment(driver); 
		loggedNymgoPageFragment = new LoggedNymgoPageFragment(driver); 
    }

			 
    public HomePage clickHomepageLink()
	{

    	nymgoPageFragment.clickHomepageLink();
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
		return homePage;
	}

	public AppsPage clickAppsLink()
	{
		
		nymgoPageFragment.clickAppsLink();
		AppsPage appsPage = new AppsPage(starter);
		PageNavigation<AppsPage> navigation = new PageNavigation<AppsPage>(appsPage); 
		navigation.NavigatedTo();
  		return appsPage;    		
	}

	public PricesPage clickPricesLink()
	{
		
		nymgoPageFragment.clickPricesLink();
		PricesPage pricesPage = new PricesPage(starter);
		PageNavigation<PricesPage> navigation = new PageNavigation<PricesPage>(pricesPage); 
		navigation.NavigatedTo();
  		return pricesPage;    		
	}

	public SupportPage clickSupportLink()
	{
		
		nymgoPageFragment.clickSupportLink();
		SupportPage supportPage = new SupportPage(starter);
		PageNavigation<SupportPage> navigation = new PageNavigation<SupportPage>(supportPage); 
		navigation.NavigatedTo();
  		return supportPage;    		
	}

	public ResellersPage clickResellersLink()
	{
		
		nymgoPageFragment.clickResellersLink();
		ResellersPage resellersPage = new ResellersPage(starter);
		PageNavigation<ResellersPage> navigation = new PageNavigation<ResellersPage>(resellersPage); 
		navigation.NavigatedTo();
  		return resellersPage;    		
	}

	//void because can return both BuyCreditPage and NormalUserLoginPage
	public void clickMenuBuyCreditButton()
	{

		nymgoPageFragment.clickMenuBuyCreditButton();
	}

	public NormalUserSignInPage clickMenuNormalUserSignInButton()
    {

		nymgoPageFragment.clickMenuNormalUserSignInButton();
    	NormalUserSignInPage normalUserSignInPage = new NormalUserSignInPage(starter);
		PageNavigation<NormalUserSignInPage> navigation = new PageNavigation<NormalUserSignInPage>(normalUserSignInPage); 
		navigation.NavigatedTo();
    	return normalUserSignInPage;
    }
	
	public boolean isUserLogged()
	{
		return nymgoPageFragment.isUserLogged();
	}

	public boolean isUserLogged(String username)
	{
		return nymgoPageFragment.isUserLogged(username);
	}
	
	public HomePage setDefaultState()
	{

		if (!getCurrentURL().equals(nymgoPageFragment.getHomeURL())){
//			LOGGER.info("Current URL = '" + getCurrentURL() + "'");
			navigateToHomePage();
		}
		if (isUserLogged())
		{
			loggedNymgoPageFragment.clickLogOut();
			SecureHomePage secureHomePage = new SecureHomePage(starter);
			PageNavigation<SecureHomePage> navigation = new PageNavigation<SecureHomePage>(secureHomePage);
			navigation.NavigatedTo();
			navigateToHomePage();
		}
/*		
		if (!getCurrentURL().equals(baseNymgoFragment.getHomeURL())){
			LOGGER.info("Current URL = '" + getCurrentURL() + "'");
//			clickHomepageLink();
			navigateToHomePage();
		}
*/		
		nymgoPageFragment.setLanguage(starter.LOCALE);
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
		return homePage;
		
	}
}
