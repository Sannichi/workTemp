package com.nymgo.tests.pages.nymgo.base;

import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import com.nymgo.tests.fragments.nymgo.base.NymgoPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.nymgo.SecureHomePage;
import com.nymgo.tests.pages.nymgo.menu.AppsPage;
import com.nymgo.tests.pages.nymgo.menu.PricesPage;
import com.nymgo.tests.pages.nymgo.menu.ResellersPage;
import com.nymgo.tests.pages.nymgo.menu.SupportPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import com.nymgo.tests.starter.Starter;

public abstract class AbstractNymgoPage extends AbstractPage{

	private NymgoPageFragment nymgoPageFragment;
	private LoggedNymgoPageFragment loggedNymgoPageFragment;
	
	public String getSuccessMessage(){
		
		return nymgoPageFragment.getSuccessMessage();
	}
	
	public String getErrorMessage(){
		
		return nymgoPageFragment.getErrorMessage();
	}
	
	public String getUpperMessage(){
		
		return nymgoPageFragment.getUpperMessage();
	}
	
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

		if (!getCurrentURL().equals(BaseNymgoFragment.getHomeURL())){
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
		nymgoPageFragment.setLanguage(starter.LOCALE);
		HomePage homePage = new HomePage(starter);
		PageNavigation<HomePage> navigation = new PageNavigation<HomePage>(homePage); 
		navigation.NavigatedTo();
		return homePage;
		
	}
}
