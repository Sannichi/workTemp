package com.nymgo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
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

public class VerifyDealCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedEuroNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

//    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist();
    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroNormalUser();    	
    	
    	NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1), 
				normalAccountPage.getMyDealsCounter());
		int i = normalAccountPage.navigateToDeal(DealsCountryNameGenerator.getDealKeyBySign(dealCurrency));
		LOGGER.info("Deal name is '" + normalAccountPage.getDealName(i) + "' Deal days counter is " + normalAccountPage.getDealDaysCounter(i) + 
				" Deal count is " + normalAccountPage.getMyDealsCounter() + 
				" Deal minutes are " + normalAccountPage.getDealMinutes(i) +
				" Deal Top Up is " + normalAccountPage.getDealTopUp(i));
		Assert.assertEquals(Integer.parseInt(normalAccountPage.getMyDealsCounter()),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1,
				"Expected and actual Deal values differ");
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedEuroResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

//    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
    	FullUserEntity fullUserEntity = DataAdapter.getNymgoEuroReseller(); 

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();

		int i = resellerAccountPage.navigateToDeal(dealName);
		Assert.assertNotEquals(i, -1, "There is no dela with deal Name " + dealName);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity)), 
				resellerAccountPage.getDealsCount(i));
		LOGGER.info("Deal name is '" + resellerAccountPage.getDealName(i) + "' Deal days counter is " + resellerAccountPage.getDealDaysCounter(i) +  
				" Deal count is " + resellerAccountPage.getDealsCount(i) + 
				" Deal minutes are " + resellerAccountPage.getDealMinutes(i) +
				" Deal Top Up is " + resellerAccountPage.getDealTopUp(i));
		Assert.assertEquals(Integer.parseInt(resellerAccountPage.getDealsCount(i)),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(
								ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity), 
				"Expected and actual Deal values differ");
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedInterNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist(); 
    	
    	NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1), 
				normalAccountPage.getMyDealsCounter());
		int i = normalAccountPage.navigateToDeal(DealsCountryNameGenerator.getDealKeyBySign(dealCurrency));
		LOGGER.info("Deal name is '" + normalAccountPage.getDealName(i) + "' Deal days counter is " + normalAccountPage.getDealDaysCounter(i) + 
				" Deal count is " + normalAccountPage.getMyDealsCounter() + 
				" Deal minutes are " + normalAccountPage.getDealMinutes(i) +
				" Deal Top Up is " + normalAccountPage.getDealTopUp(i));
		Assert.assertEquals(Integer.parseInt(normalAccountPage.getMyDealsCounter()),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + 1,
				"Expected and actual Deal values differ");
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedInterResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller(); 
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();

		int i = resellerAccountPage.navigateToDeal(dealName);
		Assert.assertNotEquals(i, -1, "There is no dela with deal Name " + dealName);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(
				ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity)), 
				resellerAccountPage.getDealsCount(i));
		LOGGER.info("Deal name is '" + resellerAccountPage.getDealName(i) + "' Deal days counter is " + resellerAccountPage.getDealDaysCounter(i) +  
				" Deal count is " + resellerAccountPage.getDealsCount(i) + 
				" Deal minutes are " + resellerAccountPage.getDealMinutes(i) +
				" Deal Top Up is " + resellerAccountPage.getDealTopUp(i));
		Assert.assertEquals(Integer.parseInt(resellerAccountPage.getDealsCount(i)),
				Integer.parseInt(
						ExcelUtils.getAccountBalanceBeforeTransaction(
								ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) + Integer.parseInt(dealQuantity), 
				"Expected and actual Deal values differ");
    }

}
