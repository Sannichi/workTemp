package com.nymgo;

import org.testng.Assert;
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
import com.nymgo.tests.utils.CurrencyUtils;

public class VerifyBuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroNormalUserTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
/*		String previousAccountBalanceValue = ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()));
		String accountBalanceValue = normalAccountPage.getAccountBalanceValue();
		Assert.assertEquals(Float.parseFloat(previousAccountBalanceValue) + Float.parseFloat(currencyAmount), Float.parseFloat(accountBalanceValue));
*/
		Assert.assertEquals( Float.parseFloat(normalAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
	}

    @Test(dataProvider = PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroResellerTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
/*		String previousAccountBalanceValue = ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()));
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		Assert.assertEquals(Float.parseFloat(previousAccountBalanceValue) + Float.parseFloat(currencyAmount), Float.parseFloat(accountBalanceValue));
*/
//		String bonusStr = fullUserEntity.getBonus();
//		Float bonus = (float) (Integer.parseInt(bonusStr));
		Float bonusValue = (Float.parseFloat(currencyAmount)/100)*Float.parseFloat(fullUserEntity.getBonus());
		LOGGER.info("BonusValue is '" + bonusValue + "'");
		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + (Float.parseFloat(currencyAmount)/100)*Float.parseFloat(fullUserEntity.getBonus()));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
    }

    @Test(dataProvider = PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroMasterResellerTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
/*		String previousAccountBalanceValue = ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()));
		String accountBalanceValue = resellerAccountPage.getAccountBalanceValue();
		Assert.assertEquals(Float.parseFloat(previousAccountBalanceValue) + Float.parseFloat(currencyAmount), Float.parseFloat(accountBalanceValue));
*/
		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + Float.parseFloat(currencyAmount)/100*Float.parseFloat(fullUserEntity.getBonus()));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterNormalUserTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinNormalUserBuyCurrencyValue(paymentCurrency);			
		}
		Assert.assertEquals( Float.parseFloat(normalAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
	}

    @Test(dataProvider = PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterResellerTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + Float.parseFloat(currencyAmount)/100*Float.parseFloat(fullUserEntity.getBonus()));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
    }

    @Test(dataProvider = PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedInterMasterResellerTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, 
			String gatewayName, String currencyAmount, String bonusType, String bonusTypeValue){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);
		
		ResellerAccountPage resellerAccountPage = loggedNymgoPage.navigateToResellerMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
		}
		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount) + Float.parseFloat(currencyAmount)/100*Float.parseFloat(fullUserEntity.getBonus()));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
	}
}
