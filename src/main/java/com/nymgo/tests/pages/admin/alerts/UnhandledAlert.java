package com.nymgo.tests.pages.admin.alerts;

import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Feb 9, 2016
 */
public class UnhandledAlert extends AbstractAlert{

	public UnhandledAlert(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
	}

	private static final String UNHANDLED_ALERT_NAME_ENG = "UnhandledAlert"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return UNHANDLED_ALERT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		setAlert();
		return getAlertText().equals(UNHANDLED_ALERT_NAME_ENG);
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return UNHANDLED_ALERT_NAME_ENG;
	}

}
