package com.nymgo;

import org.testng.annotations.Test;

import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.providers.GeneralDataProvider;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.account.NormalAccountPage;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.CurrencyUtils;
import com.nymgo.tests.utils.Rounder;

public class VerifyBuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	if (!Starter.USER_LIMIT_REACHED){
        	
	    	NymgoPage nymgoPage = new NymgoPage(starter);
			nymgoPage.navigateToHomePage();
	
			LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
	
			NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
			}
			ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf((Rounder.roundFloat(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))), 2) 
					+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2))), String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue())));
			LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    		Starter.USER_LIMIT_REACHED = false;
    	}
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditCancelledLoggedNormalUserTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

    	if (!Starter.USER_LIMIT_REACHED){
        	
	    	NymgoPage nymgoPage = new NymgoPage(starter);
			nymgoPage.navigateToHomePage();
	
			LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
	
			NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
			if(currencyAmount == null){
				currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
			}
			ExcelUtils.addExpectedAndActualAddedAmountData(
					String.valueOf(Rounder.roundFloat(Float.parseFloat(
							ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))), 2)), 
					String.valueOf(Float.parseFloat(normalAccountPage.getAccountBalanceValue()))
			);
			LOGGER.info("Account balance is  " + normalAccountPage.getAccountBalanceValue());
    	}
    	else{
    		LOGGER.fatal("User's limit is reached");
    		Starter.USER_LIMIT_REACHED = false;
    	}
	}

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

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
		
		ExcelUtils.addExpectedAndActualAddedAmountData(String.valueOf(Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Rounder.roundFloat(Float.parseFloat(currencyAmount), 2) + Rounder.roundFloat(Float.parseFloat(currencyAmount)/100*bonusPercent, 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue())));
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
    }

    @Test(dataProvider = PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditCancelledLoggedResellerTest(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity, 
			String countryOfCredit, String cardType, String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue, FullUserEntity fullUserEntity){

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
		
		ExcelUtils.addExpectedAndActualAddedAmountData(
				String.valueOf(Rounder.roundFloat(Float.parseFloat(
						ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))), 2)), 
				String.valueOf(Float.parseFloat(resellerAccountPage.getAccountBalanceValue()))
		);
		LOGGER.info("Account balance is  " + resellerAccountPage.getAccountBalanceValue());
    }
}
