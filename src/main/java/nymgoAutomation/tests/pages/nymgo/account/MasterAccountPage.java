package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.MasterAccountPageFragment;
import nymgoAutomation.tests.starter.Starter;

public class MasterAccountPage extends AbstractAccountPage{
	
	private MasterAccountPageFragment masterAccountPageFragment;
	
    public MasterAccountPage(Starter starter) {

    	super(starter);
    	masterAccountPageFragment = new MasterAccountPageFragment(driver);
    }
    
	private static final String MASTER_ACCOUNT_PAGE_NAME_EN = "MasterAccountPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
    	return MASTER_ACCOUNT_PAGE_NAME_EN;
	}
    
}
