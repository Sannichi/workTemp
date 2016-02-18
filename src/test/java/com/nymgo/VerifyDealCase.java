package com.nymgo;

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
import com.nymgo.tests.utils.CurrencyUtils;

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
//		Assert.assertEquals( Float.parseFloat(normalAccountPage.getAccountBalanceValue()),
//				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
//				+ Float.parseFloat(currencyAmount));
//		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Integer.parseInt(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ 1), normalAccountPage.getMyDealsCounter());
		int i = normalAccountPage.navigateToDeal(DealsCountryNameGenerator.getDealKeyBySign(dealCurrency));
		LOGGER.info("Deal name is '" + normalAccountPage.getDealName(i) + "' Deal days counter is " + normalAccountPage.getDealDaysCounter(i) + 
				" Deal count is " + normalAccountPage.getMyDealsCounter() + 
				" Deal minutes are " + normalAccountPage.getDealMinutes(i) +
				" Deal Top Up is " + normalAccountPage.getDealTopUp(i));
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedRecurrentEuroNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getRecurrentEuroNormalWhitelist(); 
    	
    	NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
//		Assert.assertEquals( Float.parseFloat(normalAccountPage.getAccountBalanceValue()),
//				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
//				+ Float.parseFloat(currencyAmount));
//		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount)), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedEuroResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		int bonusPercent = CurrencyUtils.getResellerBonus(paymentCurrency, currencyAmount);
		if (fullUserEntity.getBonusType().equals("Manual") && bonusPercent!=0){
			bonusPercent = Integer.valueOf(fullUserEntity.getBonus());
		}
		
//		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
//				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
//				+ Float.parseFloat(currencyAmount) + (Float.parseFloat(currencyAmount)/100)*bonusPercent);
//
//		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + (Float.parseFloat(currencyAmount)/100)*bonusPercent), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
		
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedInterNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist(); 
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
//		Assert.assertEquals( Float.parseFloat(normalAccountPage.getAccountBalanceValue()),
//				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
//				+ Float.parseFloat(currencyAmount));
//		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount)), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyDealAcceptedLoggedInterResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterReseller(); 
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}

		int bonusPercent = CurrencyUtils.getResellerBonus(paymentCurrency, currencyAmount);
		if (fullUserEntity.getBonusType().equals("Manual") && bonusPercent!=0){
			bonusPercent = Integer.valueOf(fullUserEntity.getBonus());
		}
		
//		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
//				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
//				+ Float.parseFloat(currencyAmount) + (Float.parseFloat(currencyAmount)/100)*bonusPercent);
//
//		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + (Float.parseFloat(currencyAmount)/100)*bonusPercent), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
    }

}
