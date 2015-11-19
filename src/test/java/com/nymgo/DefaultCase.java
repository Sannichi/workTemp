package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.HomePage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class DefaultCase extends AbstractCase{
    
	@Test
    public void setNymgoDefaultState(){
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		LOGGER.info("Setting default state...");
		@SuppressWarnings("unused")
		HomePage homePage = nymgoPage.setDefaultState();
    }

}
