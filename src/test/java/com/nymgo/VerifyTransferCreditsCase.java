package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.SecureHomePage;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.fancyboxes.ConfirmTransferFancybox;
import com.nymgo.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;
import com.nymgo.tests.utils.Rounder;


/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class VerifyTransferCreditsCase extends AbstractCase {

	public VerifyTransferCreditsCase() {
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyTransferCreditLoggedNormalUserToNormalUserTest(FullUserEntity normalUserFrom, FullUserEntity normalUserTo, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		SecureHomePage secureHomePage = loggedNymgoPage.logout();
		
		NormalUserSignInPage normalUserSignInPage = secureHomePage.clickMenuNormalUserSignInButton();

		NormalAccountPage normalAccountPage = normalUserSignInPage.signInUserSuccess(normalUserTo.getUsername(), normalUserTo.getPassword());
		Assert.assertTrue(normalAccountPage.isUserLogged(normalUserTo.getUsername()), "User was not logged");
		
		@SuppressWarnings("unused")
		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
//		Assert.assertEquals(transferAmount, 
//				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
	}
	
	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void transferCreditLoggedMasterResellerToMasterResellerTest(FullUserEntity masterResellerFrom, FullUserEntity masterResellerTo, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueBefore = normalAccountPage.getAccountBalanceValue();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
				masterResellerTo.getUsername(), masterResellerFrom.getPassword(), transferAmount);
		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
		normalAccountPage = normalAccountTransferCreditPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
		Assert.assertEquals(transferAmount, 
				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
	}
	
	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void transferCreditLoggedResellerToNormalUserTest(FullUserEntity resellerFrom, FullUserEntity normalUserTo, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueBefore = normalAccountPage.getAccountBalanceValue();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
				normalUserTo.getUsername(), resellerFrom.getPassword(), transferAmount);
		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
		normalAccountPage = normalAccountTransferCreditPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
		Assert.assertEquals(transferAmount, 
				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
	}
	
	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void transferCreditLoggedMasterResellerToResellerTest(FullUserEntity masterResellerFrom, FullUserEntity resellerTo, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueBefore = normalAccountPage.getAccountBalanceValue();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
				resellerTo.getUsername(), masterResellerFrom.getPassword(), transferAmount);
		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
		normalAccountPage = normalAccountTransferCreditPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
		Assert.assertEquals(transferAmount, 
				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
	}
	
	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void transferCreditLoggedResellerFromMasterResellerTest(FullUserEntity resellerTo, FullUserEntity masterResellerFrom, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueBefore = normalAccountPage.getAccountBalanceValue();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
				resellerTo.getUsername(), masterResellerFrom.getPassword(), transferAmount);
		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
		normalAccountPage = normalAccountTransferCreditPage.navigateToNormalUserMyAccountPage();
		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
		Assert.assertEquals(transferAmount, 
				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
	}
	
	
//	@Test
//	@Parameters("transferAmount")
//	public void transferCreditLoggedInterNormalUserToEuroNormalUserTest(String transferAmount){
//	
//		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
//		
//		FullUserEntity interNormalUser = DataAdapter.getInterNormalWhitelist();
//		FullUserEntity euroNormalUser = DataAdapter.getEuroNormalWhitelist();
//
//		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
//		String accountBalanceValueBefore = normalAccountPage.getAccountBalanceValue();
//		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
//		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
//				euroNormalUser.getUsername(), interNormalUser.getPassword(), transferAmount);
//		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
//		normalAccountPage = normalAccountTransferCreditPage.navigateToNormalUserMyAccountPage();
//		String accountBalanceValueAfter = normalAccountPage.getAccountBalanceValue();
//		Assert.assertEquals(transferAmount, 
//				(Rounder.roundFloat(Float.valueOf(accountBalanceValueBefore), 2) - Rounder.roundFloat(Float.valueOf(accountBalanceValueAfter), 2)));
//	}

}
