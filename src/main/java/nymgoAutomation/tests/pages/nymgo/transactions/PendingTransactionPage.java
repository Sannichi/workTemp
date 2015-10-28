package nymgoAutomation.tests.pages.nymgo.transactions;

import nymgoAutomation.tests.fragments.nymgo.transactions.PendingTransactionFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 23, 2015
 */
public abstract class PendingTransactionPage extends AbstractIframeTransactionPage{

	private PendingTransactionFragment pendingTransactionFragment;
	
	public PendingTransactionPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionFragment = new PendingTransactionFragment(driver);
	}

	//can return Normal user, Reseller and Master pages
	protected void clickBackToDashboardButton(){
		
		pendingTransactionFragment.clickBackToDashboardButton();
	}

	public NormalAccountPage clickBackToNormalUserDashboardButton(){
		
		clickBackToDashboardButton();
		delay(1500);
		NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		PageNavigation<NormalAccountPage> navigation = new PageNavigation<NormalAccountPage>(normalAccountPage);
		navigation.NavigatedTo();
		return normalAccountPage;
		
	}

	public ResellerAccountPage clickBackToResellerDashboardButton(){
		
		clickBackToDashboardButton();
		delay(1500);
		ResellerAccountPage resellerAccountPage = new ResellerAccountPage(starter);
		PageNavigation<ResellerAccountPage> navigation = new PageNavigation<ResellerAccountPage>(resellerAccountPage);
		navigation.NavigatedTo();
		return resellerAccountPage;
		
	}
}
