package nymgoAutomation.tests.pages.admin.alerts;

import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class MemberEditAlert extends AbstractAlert{

	public MemberEditAlert(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
	}

	private static final String MEMBER_EDIT_ALERT_NAME_ENG = "MemberEditAlert"; 
	private static final String MEMBER_EDIT_ALERT_TEXT_ENG = "your changes have been saved successfully"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return MEMBER_EDIT_ALERT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		setAlert();
		return getAlertText().equals(MEMBER_EDIT_ALERT_TEXT_ENG);
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return MEMBER_EDIT_ALERT_TEXT_ENG;
	}

}
