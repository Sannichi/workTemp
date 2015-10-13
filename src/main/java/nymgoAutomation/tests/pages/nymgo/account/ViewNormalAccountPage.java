package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.ViewNormalAccountPageFragment;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class ViewNormalAccountPage extends AbstractViewAccountPage{

	private ViewNormalAccountPageFragment viewNormalAccountPageFragment;
	
	public ViewNormalAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewNormalAccountPageFragment = new ViewNormalAccountPageFragment(driver);
	}

	private static final String VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN = "ViewNormalAccountPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return viewNormalAccountPageFragment.isCorrectURL();
	}
}
