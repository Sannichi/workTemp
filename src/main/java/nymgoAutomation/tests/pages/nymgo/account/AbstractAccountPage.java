package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.BaseAccountPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;

public abstract class AbstractAccountPage extends AbstractLoggedInPage{
	
	private BaseAccountPageFragment baseAccountPageFragment;
	
	public AbstractAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseAccountPageFragment =  new BaseAccountPageFragment(driver);
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return baseAccountPageFragment.isCorrectURL();
	}
    
	public BuyCreditPage clickAccountBuyCreditButton(){

		baseAccountPageFragment.clickAccountBuyCreditButton();
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
	}

}
