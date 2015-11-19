package com.nymgo.tests.pages.nymgo.base;

import com.nymgo.tests.fragments.nymgo.base.NymgoPageFragment;
import com.nymgo.tests.starter.Starter;

/*
 * 
 * Any Nymgo page  
 * 
 */

public class NymgoPage extends AbstractNymgoPage{

	private NymgoPageFragment nymgoPageFragment;

	private static final String NYMGO_PAGE_NAME_ENG = "NymgoPage"; 
			
    public NymgoPage(Starter starter) {
        super(starter);
        nymgoPageFragment = new NymgoPageFragment(driver);
    }
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return nymgoPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return NYMGO_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return nymgoPageFragment.getCorrectURL();
	}
}
