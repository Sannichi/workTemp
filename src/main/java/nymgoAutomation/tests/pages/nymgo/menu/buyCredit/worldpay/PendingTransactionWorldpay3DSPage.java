package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay.PendingTransactionWorldpay3DSFragment;
import nymgoAutomation.tests.pages.nymgo.transactions.PendingIframeTransactionPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class PendingTransactionWorldpay3DSPage extends PendingIframeTransactionPage{

	private PendingTransactionWorldpay3DSFragment pendingTransactionWorldpay3DSFragment;

	public PendingTransactionWorldpay3DSPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionWorldpay3DSFragment = new PendingTransactionWorldpay3DSFragment(driver);
	}

	private static final String PENDING_TRANSACTION_WP_3DS_NAME_ENG = "PendingTransactionWorldpay3DSPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return PENDING_TRANSACTION_WP_3DS_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return pendingTransactionWorldpay3DSFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pendingTransactionWorldpay3DSFragment.getCorrectURL();
	}
}
