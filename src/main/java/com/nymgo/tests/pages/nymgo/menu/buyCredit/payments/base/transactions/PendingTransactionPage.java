package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.transactions;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingTransactionFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
public abstract class PendingTransactionPage extends AbstractTransactionPage{

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
		delay(150);
		NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		PageNavigation<NormalAccountPage> navigation = new PageNavigation<NormalAccountPage>(normalAccountPage);
		navigation.NavigatedTo();
		return normalAccountPage;
		
	}

	public ResellerAccountPage clickBackToResellerDashboardButton(){
		
		clickBackToDashboardButton();
		delay(150);
		ResellerAccountPage resellerAccountPage = new ResellerAccountPage(starter);
		PageNavigation<ResellerAccountPage> navigation = new PageNavigation<ResellerAccountPage>(resellerAccountPage);
		navigation.NavigatedTo();
		return resellerAccountPage;
		
	}

	public BuyCreditPage clickBackToBuyCreditButton(){
		
		clickBackToDashboardButton();
		delay(150);
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
		
	}

}
