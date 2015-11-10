package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.LoggedNymgoPage;
import nymgoAutomation.tests.pages.nymgo.base.NymgoPage;
import nymgoAutomation.tests.utils.CurrencyUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyBuyCreditCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS, dataProviderClass = GeneralDataProvider.class)
	public void verifyBuyCreditAcceptedLoggedEuroNormalUserTest(FullUserEntity fullUserEntity, String paymentCurrency, String countryOfCredit, String cardType, String gatewayName, String currencyAmount){

		NymgoPage nymgoPage = new NymgoPage(starter);
		nymgoPage.navigateToHomePage();

		LoggedNymgoPage loggedNymgoPage = new LoggedNymgoPage(starter);

		NormalAccountPage normalAccountPage = loggedNymgoPage.navigateToNormalUserMyAccountPage();
		if(currencyAmount == null){
			currencyAmount = CurrencyUtils.getMinResellerBuyCurrencyValue(paymentCurrency);			
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
		Assert.assertEquals( Float.parseFloat(resellerAccountPage.getAccountBalanceValue()),
				Float.parseFloat(ExcelUtils.getAccountBalanceBeforeTransaction(ExcelUtils.getLastTransactionByUsername(fullUserEntity.getUsername()))) 
				+ Float.parseFloat(currencyAmount));
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
				+ Float.parseFloat(currencyAmount));
		LOGGER.info("Account balance is updated with amount " + currencyAmount + " " + paymentCurrency);
	}
}
