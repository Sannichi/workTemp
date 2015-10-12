package nymgoAutomation.data.providers;

import nymgoAutomation.data.adapters.DataAdapter;
import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class GeneralDataProvider extends BaseDataProvider{



    @DataProvider(name=PROVIDER_CONST.INTER_NORMAL_WHITELIST_GC_PROVIDER)
    public static Object[][] interNormalWhitelistedGCDataProvider() throws Exception {

        return DataAdapter.getInterNormalWhitelistGC();
    }

    @DataProvider(name=PROVIDER_CONST.EURO_NORMAL_WHITELIST_GC_PROVIDER)
    public static Object[][] euroNormalWhitelistedGCDataProvider() throws Exception {

        return DataAdapter.getEuroNormalWhitelistGC();
    }

    @DataProvider(name=PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER)
    public static Object[][] euroNormalWhitelistDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_W_PARAMS)
    public static Object[][] euroNormalWhitelistDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String conversionRate = context.getCurrentXmlTest().getParameter("conversionRate");

        Object[][] dataAdapterArray = new Object[1][7]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    	
        dataAdapterArray[0][6] = conversionRate;    	
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER)
    public static Object[][] americanExpressCardDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }
}
