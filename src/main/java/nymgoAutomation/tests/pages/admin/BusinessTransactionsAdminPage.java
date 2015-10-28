package nymgoAutomation.tests.pages.admin;

import nymgoAutomation.tests.fragments.admin.BusinessTransactionsAdminPageFragment;
import nymgoAutomation.tests.navigation.WidgetNavigation;
import nymgoAutomation.tests.pages.admin.widgets.BusinessMemberPaymentHistoryWidget;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class BusinessTransactionsAdminPage extends AbstractTransactionsAdminPage{

	BusinessTransactionsAdminPageFragment businessTransactionsAdminPageFragment;
	
	public BusinessTransactionsAdminPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		businessTransactionsAdminPageFragment = new BusinessTransactionsAdminPageFragment(driver);
	}

	private static final String BUSINESS_TRANSACTIONS_PAGE_NAME_ENG = "AdminBusinessTransactionsPage"; 
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return businessTransactionsAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUSINESS_TRANSACTIONS_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return businessTransactionsAdminPageFragment.getCorrectURL();
	}

	public BusinessMemberPaymentHistoryWidget openViewBusinessTransactionsWidgetByID(String stringID){

		transactionsAdminPageFragment.clickViewTransactionsByID(stringID);
		BusinessMemberPaymentHistoryWidget businessMemberPaymentHistoryWidget = new BusinessMemberPaymentHistoryWidget(starter);
		WidgetNavigation<BusinessMemberPaymentHistoryWidget> navigation = new WidgetNavigation<BusinessMemberPaymentHistoryWidget>(businessMemberPaymentHistoryWidget);
		navigation.NavigatedTo();
		return businessMemberPaymentHistoryWidget;
	}

}
