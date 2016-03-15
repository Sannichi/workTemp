package com.nymgo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.fancyboxes.ConfirmTransferFancybox;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class TransferCreditsCase extends AbstractCase {

	public TransferCreditsCase() {
		// TODO Auto-generated constructor stub
	}

	@Test
	@Parameters("transferAmount")
	public void transferCreditLoggedInterNormalUserToEuroNormalUserTest(String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		FullUserEntity interNormalUser = DataAdapter.getInterNormalWhitelist();
		FullUserEntity euroNormalUser = DataAdapter.getEuroNormalWhitelist();

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		@SuppressWarnings("unused")
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		@SuppressWarnings("unused")
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(euroNormalUser.getUsername(), interNormalUser.getPassword(), transferAmount);
	}
	
}
