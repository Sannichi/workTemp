package nymgoAutomation.tests.pages.nymgo.base;

import nymgoAutomation.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import nymgoAutomation.tests.starter.Starter;

/*
 * 
 * Any logged Nymgo page  
 * 
 */

public class LoggedNymgoPage extends AbstractLoggedInPage{

	private LoggedNymgoPageFragment loggedNymgoPageFragment;

	private static final String LOGGED_NYMGO_PAGE_NAME_ENG = "LoggedNymgoPage"; 

    public LoggedNymgoPage(Starter starter) {
        super(starter);
        loggedNymgoPageFragment = new LoggedNymgoPageFragment(driver);
    }

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return loggedNymgoPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return LOGGED_NYMGO_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return loggedNymgoPageFragment.getCorrectURL();
	}
}
