package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.ViewResellerAccountPageFragment;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ViewResellerAccountPage extends AbstractViewAccountPage{

	ViewResellerAccountPageFragment viewResellerAccountPageFragment;
	
	public ViewResellerAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewResellerAccountPageFragment = new ViewResellerAccountPageFragment(driver);
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
		return viewResellerAccountPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewResellerAccountPageFragment.getCorrectURL();
	}
}
