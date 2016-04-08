package com.nymgo.tests.pages.nymgo.account;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.account.RequestTransfersResellerPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 31, 2016
 */
public class RequestTransfersResellerPage extends AbstractLoggedInPage {

	private RequestTransfersResellerPageFragment requestTransfersResellerPageFragment;
	
	public RequestTransfersResellerPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		requestTransfersResellerPageFragment = new RequestTransfersResellerPageFragment(driver);
	}

	public static final String REQUEST_TRANSFERS_RESELER_PAGE_NAME = "RequestTransfersResellerPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRequestAmountValue(String requestAmountValue){
		
		requestTransfersResellerPageFragment.setRequestAmountValue(requestAmountValue);
	}

	public void clickRequestTransfersButton(){
		
		requestTransfersResellerPageFragment.clickRequestTransfersButton();
	}

	public ViewResellerAccountPage setAmountAndClickRequestTransferButton(String requestAmountValue){
		
		setRequestAmountValue(requestAmountValue);
		clickRequestTransfersButton();
		ViewResellerAccountPage viewResellerAccountPage = new ViewResellerAccountPage(starter);
		PageNavigation<ViewResellerAccountPage> navigation = new PageNavigation<ViewResellerAccountPage>(viewResellerAccountPage);
		navigation.NavigatedTo();
		Assert.assertTrue(getSuccessMessage().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.REQUEST_TRANSFER_CREDIT_SUCCESS_MESSAGE)), "Success Message is incorrect: '" + getSuccessMessage() + "'");		
		return viewResellerAccountPage;
	}
}
