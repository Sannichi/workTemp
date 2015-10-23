package nymgoAutomation.tests.pages.nymgo;

import nymgoAutomation.tests.fragments.nymgo.HomePageFragment;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.starter.Starter;

public class HomePage extends AbstractNymgoPage{

	private HomePageFragment homePageFragment;
	
	private static final String HOME_PAGE_NAME_ENG = "HomePage"; 
			
    public HomePage(Starter starter) {

    	super(starter);
    	homePageFragment = new HomePageFragment(driver);
    }

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return HOME_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return homePageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return homePageFragment.getCorrectURL();
	}
}
