package com.nymgo.tests.pages.admin;

import com.nymgo.tests.fragments.admin.NormalTransactionsAdminPageFragment;
import com.nymgo.tests.navigation.WidgetNavigation;
import com.nymgo.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class NormalTransactionsAdminPage extends AbstractTransactionsAdminPage{

	NormalTransactionsAdminPageFragment normalTransactionsAdminPageFragment;
	
	public NormalTransactionsAdminPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		normalTransactionsAdminPageFragment = new NormalTransactionsAdminPageFragment(driver);
	}

	private static final String NORMAL_TRANSACTIONS_PAGE_NAME_ENG = "AdminNormalTransactionsPage"; 
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return normalTransactionsAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return NORMAL_TRANSACTIONS_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return normalTransactionsAdminPageFragment.getCorrectURL();
	}

	public MemberPaymentHistoryWidget openViewTransactionsWidgetByID(String stringID){

		transactionsAdminPageFragment.clickViewTransactionsByID(stringID);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = new MemberPaymentHistoryWidget(starter);
		WidgetNavigation<MemberPaymentHistoryWidget> navigation = new WidgetNavigation<MemberPaymentHistoryWidget>(memberPaymentHistoryWidget);
		navigation.NavigatedTo();
		return memberPaymentHistoryWidget;
	}

	public MemberPaymentHistoryWidget clickFirstViewTransactionsByUsername(String username){

		transactionsAdminPageFragment.clickFirstViewTransactionsByUsername(username);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = new MemberPaymentHistoryWidget(starter);
		WidgetNavigation<MemberPaymentHistoryWidget> navigation = new WidgetNavigation<MemberPaymentHistoryWidget>(memberPaymentHistoryWidget);
		navigation.NavigatedTo();
		return memberPaymentHistoryWidget;
	}
}
