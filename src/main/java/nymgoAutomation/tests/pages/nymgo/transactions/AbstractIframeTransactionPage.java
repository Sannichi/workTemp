package nymgoAutomation.tests.pages.nymgo.transactions;

import nymgoAutomation.tests.fragments.nymgo.transactions.BaseIframeTransactionFragment;
import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public abstract class AbstractIframeTransactionPage extends AbstractPage{
	
	BaseIframeTransactionFragment baseIframeTransactionFragment;

	public AbstractIframeTransactionPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseIframeTransactionFragment = new BaseIframeTransactionFragment(driver);
	}

	public String getPaymentStatus(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.getPaymentStatus();		
	}

	public String getTransactionAmountValue(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.getTransactionAmountValue();		
	}

	public String getTransactionNumber(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.getTransactionNumber();
	}

	public String getTransactionDate(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.getTransactionDate();
	}

	public String getTransactionTime(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.getTransactionTime();
	}
	
	public boolean isTransactionPending(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.isTransactionPending();
	}

	public boolean isTransactionDeclined(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.isTransactionPending();
	}
}
