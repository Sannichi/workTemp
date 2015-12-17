package com.nymgo.tests.pages.tempMail;

import com.nymgo.tests.fragments.tempMail.TempMailEmailContentPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 17, 2015
 */
public class TempMailEmailContentPage extends TempMailPage {

	private TempMailEmailContentPageFragment tempMailEmailContentPageFragment;
	
	public TempMailEmailContentPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailEmailContentPageFragment = new TempMailEmailContentPageFragment(driver);
	}

	public String getEmailSubjectText(){
		
		return tempMailEmailContentPageFragment.getEmailSubjectText();
	}

	public String getEmailContentText(){
		
		return tempMailEmailContentPageFragment.getEmailContentText();
	}
}
