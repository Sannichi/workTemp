package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.NormalAccountPageFragment;
import nymgoAutomation.tests.navigation.Starter;

public class NormalAccountPage extends AbstractAccountPage{
	
	private NormalAccountPageFragment normalAccountPageFragment;
	
    public NormalAccountPage(Starter starter) {

    	super(starter);
    	normalAccountPageFragment = new NormalAccountPageFragment(driver);
    }

	private static final String NORMAL_ACCOUNT_PAGE_NAME_EN = "NormalAccountPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
    	return NORMAL_ACCOUNT_PAGE_NAME_EN;
	}
    
}
