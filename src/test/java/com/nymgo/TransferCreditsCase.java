package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class TransferCreditsCase extends AbstractCase {

	public TransferCreditsCase() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void transrerCreditLoggedEuroNormalUserToEuroNormalUserTest(){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		@SuppressWarnings("unused")
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		@SuppressWarnings("unused")
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
//		normalAccountTransferCreditPage.
	}
	
}
