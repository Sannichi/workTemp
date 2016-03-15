package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.NormalAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditNormalDealPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;
import com.nymgo.tests.starter.Starter;

public class NormalAccountPage extends AbstractAccountPage{
	
	private NormalAccountPageFragment normalAccountPageFragment;
	
	public NormalAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
    	normalAccountPageFragment = new NormalAccountPageFragment(driver);
	}

	private static final String NORMAL_ACCOUNT_PAGE_NAME_EN = "NormalAccountPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
    	return NORMAL_ACCOUNT_PAGE_NAME_EN;
	}

	public String getDepositLimitValue(){
		
		return normalAccountPageFragment.getDepositLimitValue();
	}
	
	public String getDealName(int i){
		
		return normalAccountPageFragment.getDealName(i);
	}

	public String getMyDealsCounter(){
		
		return normalAccountPageFragment.getMyDealsCounter();
	}

	public String getDealDaysCounter(int i){
		
		return normalAccountPageFragment.getDealDaysCounter(i);
	}

	public String getDealMinutes(int i){
		
		return normalAccountPageFragment.getDealMinutes(i);
	}
	
	public String getDealTopUp(int i){
		
		return normalAccountPageFragment.getDealTopUp(i);
	}

	public int navigateToDeal(String dealName){
		
		return normalAccountPageFragment.navigateToDeal(dealName);
	}

	public BuyCreditPage clickAccountBuyCreditButton(){

		normalAccountPageFragment.clickAccountBuyCreditButton();
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
	}

	public BuyCreditNormalDealPage clickAccountBuyDealsButton(){

		normalAccountPageFragment.clickAccountBuyDealsButton();
		BuyCreditNormalDealPage buyCreditNormalDealPage = new BuyCreditNormalDealPage(starter);
		PageNavigation<BuyCreditNormalDealPage> navigation = new PageNavigation<BuyCreditNormalDealPage>(buyCreditNormalDealPage);
		navigation.NavigatedTo();
		return buyCreditNormalDealPage;
	}

	public ViewNormalAccountPage clickViewFullNormalAccountButton(){
		
		normalAccountPageFragment.clickViewFullAccountButton();
		ViewNormalAccountPage viewNormalAccountPage = new ViewNormalAccountPage(starter);
		PageNavigation<ViewNormalAccountPage> navigation = new PageNavigation<ViewNormalAccountPage>(viewNormalAccountPage);
		navigation.NavigatedTo();
		return viewNormalAccountPage;
	}

	public NormalAccountTransferCreditPage clickNormalAccountTransferCreditButton(){

		normalAccountPageFragment.clickAccountTransferCreditButton();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = new NormalAccountTransferCreditPage(starter);
		PageNavigation<NormalAccountTransferCreditPage> navigation = new PageNavigation<NormalAccountTransferCreditPage>(normalAccountTransferCreditPage);
		navigation.NavigatedTo();
		return normalAccountTransferCreditPage;
	}

}
