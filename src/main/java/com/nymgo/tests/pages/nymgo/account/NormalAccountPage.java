package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.NormalAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
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
