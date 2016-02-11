package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.transactions;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingIframeTransactionFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 23, 2015
 */
public abstract class PendingIframeTransactionPage extends AbstractIframeTransactionPage{

	private PendingIframeTransactionFragment pendingIframeTransactionFragment;	
	
	public PendingIframeTransactionPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingIframeTransactionFragment = new PendingIframeTransactionFragment(driver);
	}

	//can return Normal user, Reseller and Master pages
	protected void clickBackToDashboardButton(){
		
		pendingIframeTransactionFragment.pendingTransactionFragment.clickBackToDashboardButton();
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
