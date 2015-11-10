package nymgoAutomation.tests.pages.nymgo.account;

import nymgoAutomation.tests.fragments.nymgo.account.BaseAccountPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractAccountPage extends AbstractLoggedInPage{
	
	private BaseAccountPageFragment baseAccountPageFragment;
	
	public AbstractAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseAccountPageFragment =  new BaseAccountPageFragment(driver);
	}

	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return baseAccountPageFragment.isCorrectURL();
	}
	
	public String getPageURL() {
		// TODO Auto-generated method stub
		return baseAccountPageFragment.getCorrectURL();
	}
    
	public BuyCreditPage clickAccountBuyCreditButton(){

		baseAccountPageFragment.clickAccountBuyCreditButton();
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
	}

	public String getAccountBalance(){
		
		return baseAccountPageFragment.getAccountBalance();
	}

	public String getAccountBalanceValue(){
		
		return baseAccountPageFragment.getAccountBalanceValue();
	}

	public String getAccountBalanceCurrency(){
		
		return baseAccountPageFragment.getAccountBalanceCurrency();
	}
}
