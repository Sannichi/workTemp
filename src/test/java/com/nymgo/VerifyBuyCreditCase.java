package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.utils.CurrencyUtils;
import com.nymgo.tests.utils.Rounder;

public class VerifyBuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist(); 
    	
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
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Rounder.roundFloat(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))), 2) 
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2)), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedRecurrentEuroNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2)), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2) + Rounder.roundFloat(Float.parseFloat(currencyAmount)/100*bonusPercent, 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
		
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroMasterResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller(); 
    	
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2) + Rounder.roundFloat(Float.parseFloat(currencyAmount)/100*bonusPercent, 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2)), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
	}

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2) + Rounder.roundFloat(Float.parseFloat(currencyAmount)/100*bonusPercent, 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
    }

    @Test(dataProvider = PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterMasterResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

    	FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller(); 
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);
//			currencyAmount = CurrencyUtils.getSecondResellerBuyCurrencyValue(paymentCurrency);
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
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2) + Rounder.roundFloat(Float.parseFloat(currencyAmount)/100*bonusPercent, 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
	}
}
