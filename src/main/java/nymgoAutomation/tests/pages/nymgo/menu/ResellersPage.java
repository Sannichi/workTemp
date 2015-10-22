package nymgoAutomation.tests.pages.nymgo.menu;

import nymgoAutomation.tests.fragments.nymgo.menu.ResellersPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.signIn.ResellerSignInPage;
import nymgoAutomation.tests.starter.Starter;

public class ResellersPage extends AbstractNymgoPage{
	
	private ResellersPageFragment resellersPageFragment;
	
	public ResellersPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellersPageFragment = new ResellersPageFragment(driver);
	}

	private static final String RESELLERS_PAGE_NAME_EN = "ResellersPage";

	public ResellerSignInPage clickResellerSignInButton(){

		resellersPageFragment.clickResellerSignInButton();
    	ResellerSignInPage resellerSignInPage = new ResellerSignInPage(starter);
		PageNavigation<ResellerSignInPage> navigation = new PageNavigation<ResellerSignInPage>(resellerSignInPage); 
		navigation.NavigatedTo();
		return resellerSignInPage;
    }


	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return resellersPageFragment.isCorrectURL();
	}


	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLERS_PAGE_NAME_EN;
	}
    
}
