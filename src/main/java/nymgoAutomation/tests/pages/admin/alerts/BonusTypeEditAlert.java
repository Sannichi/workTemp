package nymgoAutomation.tests.pages.admin.alerts;

import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
public class BonusTypeEditAlert extends AbstractAlert{

	public BonusTypeEditAlert(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
	}

	private static final String BONUS_TYPE_EDIT_ALERT_NAME_ENG = "BonusTypeEditAlert"; 
	private static final String BONUS_TYPE_EDIT_ALERT_TEXT_ENG = "has been added successfully to user"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BONUS_TYPE_EDIT_ALERT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		setAlert();
		return getAlertText().contains(BONUS_TYPE_EDIT_ALERT_TEXT_ENG);
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return BONUS_TYPE_EDIT_ALERT_TEXT_ENG;
	}

}
