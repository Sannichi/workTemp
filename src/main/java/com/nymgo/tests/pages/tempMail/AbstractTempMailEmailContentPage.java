package com.nymgo.tests.pages.tempMail;

import com.nymgo.tests.fragments.tempMail.BaseTempMailEmailContentPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 17, 2015
 */
public abstract class AbstractTempMailEmailContentPage extends TempMailPage {

	private BaseTempMailEmailContentPageFragment baseTempMailEmailContentPageFragment;
	
	public AbstractTempMailEmailContentPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseTempMailEmailContentPageFragment = new BaseTempMailEmailContentPageFragment(driver);
	}

	public String getEmailSubjectText(){
		
		return baseTempMailEmailContentPageFragment.getEmailSubjectText();
	}

	public String getEmailContentText(){
		
		return baseTempMailEmailContentPageFragment.getEmailContentText();
	}

}
