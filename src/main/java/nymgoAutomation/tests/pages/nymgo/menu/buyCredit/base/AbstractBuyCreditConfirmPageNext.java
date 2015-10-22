package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseBuyCreditConfirmPageNextFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractBuyCreditConfirmPageNext extends AbstractBuyCreditConfirmPage{

	private BaseBuyCreditConfirmPageNextFragment baseBuyCreditConfirmPageNextFragment;
	
	public AbstractBuyCreditConfirmPageNext(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseBuyCreditConfirmPageNextFragment = new BaseBuyCreditConfirmPageNextFragment(driver); 
	}

	//can return Normal user, Reseller and Master pages
	protected void clickBackToDashboardButton(){
		
		baseBuyCreditConfirmPageNextFragment.clickBackToDashboardButton();
	}

	public NormalAccountPage clickBackToNormalUserDashboardButton(){
		
		clickBackToDashboardButton();
		NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		PageNavigation<NormalAccountPage> navigation = new PageNavigation<NormalAccountPage>(normalAccountPage);
		navigation.NavigatedTo();
		return normalAccountPage;
		
	}
}
