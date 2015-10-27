package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.ResellerAccountPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.starter.Starter;

public class ResellerAccountPage extends AbstractAccountPage{
	
	private ResellerAccountPageFragment resellerAccountPageFragment;
	
    public ResellerAccountPage(Starter starter) {

    	super(starter);
    	resellerAccountPageFragment = new ResellerAccountPageFragment(driver);
    }

	private static final String RESELLER_ACCOUNT_PAGE_NAME_EN = "ResellerAccountPage";
    
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLER_ACCOUNT_PAGE_NAME_EN;
	}
    
	public ViewResellerAccountPage clickViewAccountDetailsButton(){
		
		resellerAccountPageFragment.clickViewAccountDetailsButton();
		ViewResellerAccountPage viewResellerAccountPage = new ViewResellerAccountPage(starter);
		PageNavigation<ViewResellerAccountPage> navigation = new PageNavigation<ViewResellerAccountPage>(viewResellerAccountPage);
		navigation.NavigatedTo();
		return viewResellerAccountPage;
	}

}
