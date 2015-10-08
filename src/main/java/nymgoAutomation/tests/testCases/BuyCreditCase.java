package nymgoAutomation.tests.testCases;

import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPagePending;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditProceedPageGlobalCollect;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyCreditCase extends AbstractCase{
	
	@Test
	public void buyCreditLoggedNormalUserGlobalCollectTest(){

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		BuyCreditPage buyCreditPage = normalAccountPage.clickAccountBuyCreditButton();
		BuyCreditProceedPageGlobalCollect buyCreditProceedPage = buyCreditPage.selectAmountAndClickContinueToGlobalCollect(40);

//		buyCreditProceedPage.verifyDefaultPaymentBlock("Spain");
		buyCreditProceedPage.verifyDefaultData(
				"GL Testing", "gltesting13@gmail.com", "+380979029368", "+380979029368",
				"Spain", "00001", "Street", "Full",
				"Spain",
				"40", "21", "48.4");
		buyCreditProceedPage.setPaymentBlockData("American Express", "Belgium");
		
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPage = buyCreditProceedPage.verifyDataAndClickContinue(
				"GL Testing", "gltesting13@gmail.com", "+380979029368", "+380979029368",
				"Spain", "00001", "Street", "Full",
				"American Express", "Belgium",
				"40", "21", "48.4");

		BuyCreditConfirmPagePending buyCreditConfirmPagePending = buyCreditConfirmPage.setCreditCardDataAndClickContinue("34343434343434", "06", "17", "042");
		String transactionID = buyCreditConfirmPagePending.getTransactionNumber();
		String paymentStatus = buyCreditConfirmPagePending.getPaymentStatus();
		Assert.assertTrue(buyCreditConfirmPagePending.isTransactionPending(), 
				"Transaction is not pending, current status is: " + buyCreditConfirmPagePending.getPaymentStatus());
		normalAccountPage = buyCreditConfirmPagePending.clickBackToNormalUserDashboardButton();
		LOGGER.info("transaction ID = " + transactionID + ", payment status = " + paymentStatus);
	}
}
