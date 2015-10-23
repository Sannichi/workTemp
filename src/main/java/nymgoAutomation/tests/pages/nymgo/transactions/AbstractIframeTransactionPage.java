package nymgoAutomation.tests.pages.nymgo.transactions;

import nymgoAutomation.tests.fragments.nymgo.transactions.BaseIframeTransactionFragment;
import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public abstract class AbstractIframeTransactionPage extends AbstractPage{
	
	BaseIframeTransactionFragment baseTransactionFragment;

	public AbstractIframeTransactionPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseTransactionFragment = new BaseIframeTransactionFragment(driver);
	}

	public String getPaymentStatus(){
		
		return baseTransactionFragment.getPaymentStatus();		
	}

	public String getTransactionAmountValue(){
		
		return baseTransactionFragment.getTransactionAmountValue();		
	}

	public String getTransactionNumber(){
		
		return baseTransactionFragment.getTransactionNumber();
	}

	public String getTransactionDate(){
		
		return baseTransactionFragment.getTransactionDate();
	}

	public String getTransactionTime(){
		
		return baseTransactionFragment.getTransactionTime();
	}
	
	public boolean isTransactionPending(){
		
		return baseTransactionFragment.isTransactionPending();
	}

	public boolean isTransactionDeclined(){
		
		return baseTransactionFragment.isTransactionPending();
	}
}
