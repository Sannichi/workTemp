package nymgoAutomation.tests.pages.nymgo;

import nymgoAutomation.tests.fragments.nymgo.SecureHomePageFragment;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class SecureHomePage extends AbstractNymgoPage{

	private SecureHomePageFragment secureHomePageFragment;
	
	private static final String SECURE_HOME_PAGE_NAME_ENG = "SecureHomePage"; 
			
	public SecureHomePage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		secureHomePageFragment = new SecureHomePageFragment(driver);
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return SECURE_HOME_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return secureHomePageFragment.isCorrectURL();
	}
}
