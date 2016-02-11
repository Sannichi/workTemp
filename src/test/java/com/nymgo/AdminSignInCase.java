package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.AdminEntity;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.LoginAdminPage;
import com.nymgo.tests.pages.admin.MembersAdminPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;

import org.testng.Assert;

public class AdminSignInCase extends AbstractCase{
	
    @Test
	public void signInAdminTest(){
    	
    	AdminEntity adminEntity = DataAdapter.getAdmin(); 

    	String login = adminEntity.getUsername();
    	String password = adminEntity.getPassword();
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		LoginAdminPage loginAdminPage = nymgoPage.navigateToAdminLoginPage();
		
		MembersAdminPage membersAdminPage = loginAdminPage.signInUserSuccess(login, password);
		Assert.assertTrue(membersAdminPage.isAdminLogged());
	}
}
