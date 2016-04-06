package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.generators.DealsCountryNameGenerator;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.utils.DealUtils;

public class VerifyDealCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1), 
				normalAccountPage.getMyDealsCounter());
		String countryDealName = DealsCountryNameGenerator.getDealKeyBySign(dealCurrency);
		int i = normalAccountPage.navigateToDeal(countryDealName);
		Assert.assertNotEquals(i, -1, "There is no deal with deal Name " + countryDealName);
		LOGGER.info("Deal name is '" + normalAccountPage.getDealName(i) + "' Deal days counter is " + normalAccountPage.getDealDaysCounter(i) + 
				" Deal count is " + normalAccountPage.getMyDealsCounter() + 
				" Deal minutes are " + normalAccountPage.getDealMinutes(i));
		Assert.assertEquals(Integer.parseInt(normalAccountPage.getMyDealsCounter()),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1,
				"Expected and actual Deal values differ");
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();

		int i = resellerAccountPage.navigateToDeal(DealUtils.getFullDealName(dealName, dealCurrency));
		Assert.assertNotEquals(i, -1, "There is no deal with deal Name " + dealName);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity)), 
				resellerAccountPage.getDealsCount(i));
		LOGGER.info("Deal name is '" + resellerAccountPage.getDealName(i) + "' Deal days counter is " + resellerAccountPage.getDealDaysCounter(i) +  
				" Deal count is " + resellerAccountPage.getDealsCount(i) + 
				" Deal minutes are " + resellerAccountPage.getDealMinutes(i));
		Assert.assertEquals(Integer.parseInt(resellerAccountPage.getDealsCount(i)),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(
								ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity), 
				"Expected and actual Deal values differ");
    }
}
