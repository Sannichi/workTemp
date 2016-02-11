package com.nymgo.tests.pages.nymgo.transactions;

import com.nymgo.tests.fragments.nymgo.transactions.BaseIframeTransactionFragment;
import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public abstract class AbstractIframeTransactionPage extends AbstractPage{
	
	private BaseIframeTransactionFragment baseIframeTransactionFragment;

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

	public boolean isTransactionSuccessful(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.isTransactionSuccessful();
	}

	public boolean isTransactionChallenged(){
		
		return baseIframeTransactionFragment.baseTransactionFragment.isTransactionChallenged();
	}
}
