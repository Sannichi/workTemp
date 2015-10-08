package nymgoAutomation.tests.pages.nymgo.base;

import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.fragments.nymgo.base.BaseNymgoFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.pages.nymgo.HomePage;
import nymgoAutomation.tests.pages.nymgo.menu.AppsPage;
import nymgoAutomation.tests.pages.nymgo.menu.PricesPage;
import nymgoAutomation.tests.pages.nymgo.menu.ResellersPage;
import nymgoAutomation.tests.pages.nymgo.menu.SupportPage;
import nymgoAutomation.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;

public abstract class AbstractNymgoPage extends AbstractPage{

	private BaseNymgoFragment baseNymgoFragment;
	private BaseLoggedInFragment baseLoggedInFragment;
	
	
	public AbstractNymgoPage(Starter starter) {

		super(starter);
		baseNymgoFragment = new BaseNymgoFragment(driver); 
		baseLoggedInFragment = new BaseLoggedInFragment(driver);
    }

			 
    public HomePage clickHomepageLink()
	{

    	baseNymgoFragment.clickHomepageLink();
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
		return homePage;
	}

	public AppsPage clickAppsLink()
	{
		
    	baseNymgoFragment.clickAppsLink();
		AppsPage appsPage = new AppsPage(starter);
		PageNavigation<AppsPage> navigation = new PageNavigation<AppsPage>(appsPage); 
		navigation.NavigatedTo();
  		return appsPage;    		
	}

	public PricesPage clickPricesLink()
	{
		
    	baseNymgoFragment.clickPricesLink();
		PricesPage pricesPage = new PricesPage(starter);
		PageNavigation<PricesPage> navigation = new PageNavigation<PricesPage>(pricesPage); 
		navigation.NavigatedTo();
  		return pricesPage;    		
	}

	public SupportPage clickSupportLink()
	{
		
    	baseNymgoFragment.clickSupportLink();
		SupportPage supportPage = new SupportPage(starter);
		PageNavigation<SupportPage> navigation = new PageNavigation<SupportPage>(supportPage); 
		navigation.NavigatedTo();
  		return supportPage;    		
	}

	public ResellersPage clickResellersLink()
	{
		
    	baseNymgoFragment.clickResellersLink();
		ResellersPage resellersPage = new ResellersPage(starter);
		PageNavigation<ResellersPage> navigation = new PageNavigation<ResellersPage>(resellersPage); 
		navigation.NavigatedTo();
  		return resellersPage;    		
	}

	//void because can return both BuyCreditPage and NormalUserLoginPage
	public void clickMenuBuyCreditButton()
	{

    	baseNymgoFragment.clickMenuBuyCreditButton();
	}

	public NormalUserSignInPage clickMenuNormalUserSignInButton()
    {

		baseNymgoFragment.clickMenuNormalUserSignInButton();
    	NormalUserSignInPage normalUserSignInPage = new NormalUserSignInPage(starter);
		PageNavigation<NormalUserSignInPage> navigation = new PageNavigation<NormalUserSignInPage>(normalUserSignInPage); 
		navigation.NavigatedTo();
    	return normalUserSignInPage;
    }
	
	public boolean isUserLogged()
	{
		return baseNymgoFragment.isUserLogged();
	}

	public boolean isUserLogged(String username)
	{
		return baseNymgoFragment.isUserLogged(username);
	}
	
	public HomePage setDefaultState()
	{

		if (isUserLogged())
		{
			baseLoggedInFragment.clickLogOut();
		}
		if (getCurrentURL() != baseNymgoFragment.getHomeURL()){
			clickHomepageLink();
		}
		baseNymgoFragment.setLanguage(starter.LOCALE);
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
		return homePage;
		
	}
}
