package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ResellerAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.transferCredits.ResellerAccountTransferCreditPage;
import com.nymgo.tests.starter.Starter;

public class ResellerAccountPage extends AbstractAccountPage{
	
	private ResellerAccountPageFragment resellerAccountPageFragment;
	
    public ResellerAccountPage(Starter starter) {

    	super(starter);
    	resellerAccountPageFragment = new ResellerAccountPageFragment(driver);
    }

	private static final String RESELLER_ACCOUNT_PAGE_NAME_EN = "ResellerAccountPage";
    
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLER_ACCOUNT_PAGE_NAME_EN;
	}
    
	public String getDealName(int i){
		
		return resellerAccountPageFragment.getDealName(i);
	}

	public String getDealsCount(int i){
		
		return resellerAccountPageFragment.getDealsCount(i);
	}

	public String getDealsCountByDealName(String dealName){
		
		int i = navigateToDeal(dealName);
		if (i != -1){
			return getDealsCount(i);
		}
		else{
			return "0";
		}
		
	}

	public String getDealDaysCounter(int i) {

		return resellerAccountPageFragment.getDealDaysCounter(i);
	}

	public String getDealMinutes(int i){
		
		return resellerAccountPageFragment.getDealMinutes(i);
	}
	
	public String getDealTopUp(int i){
		
		return resellerAccountPageFragment.getDealTopUp(i);
	}

	public int navigateToDeal(String dealName){
		
		return resellerAccountPageFragment.navigateToDeal(dealName);
	}

	public ResellerAccountTransferCreditPage clickResellerAccountTransferCreditButton(){

		resellerAccountPageFragment.clickAccountTransferCreditButton();
		ResellerAccountTransferCreditPage resellerAccountTransferCreditPage = new ResellerAccountTransferCreditPage(starter);
		PageNavigation<ResellerAccountTransferCreditPage> navigation = new PageNavigation<ResellerAccountTransferCreditPage>(resellerAccountTransferCreditPage);
		navigation.NavigatedTo();
		return resellerAccountTransferCreditPage;
	}

	public ViewResellerAccountDetailsPage clickViewAccountDetailsButton(){
		
		resellerAccountPageFragment.clickViewAccountDetailsButton();
		ViewResellerAccountDetailsPage viewResellerAccountDetailsPage = new ViewResellerAccountDetailsPage(starter);
		PageNavigation<ViewResellerAccountDetailsPage> navigation = new PageNavigation<ViewResellerAccountDetailsPage>(viewResellerAccountDetailsPage);
		navigation.NavigatedTo();
		return viewResellerAccountDetailsPage;
	}

	public RequestTransfersResellerPage clickRequestTransfersLink(){
		
		resellerAccountPageFragment.clickRequestTransfersLink();
		RequestTransfersResellerPage requestTransfersResellerPage = new RequestTransfersResellerPage(starter);
		PageNavigation<RequestTransfersResellerPage> navigation = new PageNavigation<RequestTransfersResellerPage>(requestTransfersResellerPage);
		navigation.NavigatedTo();
		return requestTransfersResellerPage;
	}
}
