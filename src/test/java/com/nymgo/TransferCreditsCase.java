package com.nymgo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.fancyboxes.ConfirmTransferFancybox;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;
import com.nymgo.tests.pages.nymgo.transferCredits.ResellerAccountTransferCreditPage;
import com.nymgo.tests.utils.Rounder;

import junit.framework.Assert;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class TransferCreditsCase extends AbstractCase {

	public TransferCreditsCase() {
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void transferCreditLoggedNormalUserToNormalUserTest(FullUserEntity normalUserFrom, FullUserEntity normalUserTo, String transferAmount){
	
		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = normalAccountPage.clickNormalAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = normalAccountTransferCreditPage.setDataAndClickTransferCredit(
				normalUserTo.getUsername(), normalUserFrom.getPassword(), transferAmount);
		normalAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountNormalAccount();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(normalAccountTransferCreditPage.getLastTransferData().getSender(), normalUserFrom.getUsername());
		softAssert.assertEquals(normalAccountTransferCreditPage.getLastTransferData().getRecipient(), normalUserTo.getUsername());
		softAssert.assertEquals(normalAccountTransferCreditPage.getLastTransferData().getAmount(), transferAmount);
		softAssert.assertAll();
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
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		String accountBalanceValueBefore = resellerAccountPage.getAccountBalanceValue();
		ResellerAccountTransferCreditPage resellerAccountTransferCreditPage = resellerAccountPage.clickResellerAccountTransferCreditButton();
		ConfirmTransferFancybox confirmTransferFancybox = resellerAccountTransferCreditPage.setDataAndClickTransferCredit(
				normalUserTo.getUsername(), resellerFrom.getPassword(), transferAmount);
		resellerAccountTransferCreditPage = confirmTransferFancybox.clickSendAmountResellerAccount();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(resellerAccountTransferCreditPage.getLastTransferData().getSender(), resellerFrom.getUsername());
		softAssert.assertEquals(resellerAccountTransferCreditPage.getLastTransferData().getRecipient(), normalUserTo.getUsername());
		softAssert.assertEquals(resellerAccountTransferCreditPage.getLastTransferData().getAmount(), transferAmount);
		softAssert.assertAll();
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
