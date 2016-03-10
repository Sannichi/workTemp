package com.nymgo.tests.pages.nymgo.fancyboxes;

import com.nymgo.tests.fragments.nymgo.fancyboxes.BaseFancyboxFragment;
import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 10, 2016
 */
public abstract class AbstractFancybox extends AbstractPage{

	private BaseFancyboxFragment baseFancyboxFragment;
	
	public AbstractFancybox(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseFancyboxFragment = new BaseFancyboxFragment(driver);
	}

    public void clickCloseButton(){
    	
    	baseFancyboxFragment.clickOnCloseButton();
    }

}
