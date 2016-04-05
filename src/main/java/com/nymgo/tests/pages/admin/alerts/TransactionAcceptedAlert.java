package com.nymgo.tests.pages.admin.alerts;

import com.nymgo.tests.pages.admin.alerts.AbstractAlert;
import com.nymgo.tests.starter.Starter;

public class TransactionAcceptedAlert extends AbstractAlert{
	
	public TransactionAcceptedAlert(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		
	}
	
	private static final String TRANSACTION_ACCEPTED_POPUP_NAME_ENG = "TransactionAcceptedAlert"; 
	private static final String TRANSACTION_ACCEPTED_POPUP_TEXT_ENG = "transaction accepted successfully And queued successfully|3Transaction event has been posted successfully"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return TRANSACTION_ACCEPTED_POPUP_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		setAlert();
		return getAlertText().contains(TRANSACTION_ACCEPTED_POPUP_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return TRANSACTION_ACCEPTED_POPUP_TEXT_ENG;
	}
}
