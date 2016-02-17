package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.BaseAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditNormalDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditResellerDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.starter.Starter;

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

	public BuyCreditNormalDealPage clickAccountBuyDealsButton(){

		baseAccountPageFragment.clickAccountBuyDealsButton();
		BuyCreditNormalDealPage buyCreditNormalDealPage = new BuyCreditNormalDealPage(starter);
		PageNavigation<BuyCreditNormalDealPage> navigation = new PageNavigation<BuyCreditNormalDealPage>(buyCreditNormalDealPage);
		navigation.NavigatedTo();
		return buyCreditNormalDealPage;
	}

	public BuyCreditResellerDealPage clickResellerAccountBuyCreditButton(){

		baseAccountPageFragment.clickAccountBuyCreditButton();
		BuyCreditResellerDealPage buyCreditDealPage = new BuyCreditResellerDealPage(starter);
		PageNavigation<BuyCreditResellerDealPage> navigation = new PageNavigation<BuyCreditResellerDealPage>(buyCreditDealPage);
		navigation.NavigatedTo();
		return buyCreditDealPage;
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
