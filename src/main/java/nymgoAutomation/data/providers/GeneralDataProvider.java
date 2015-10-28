package nymgoAutomation.data.providers;

import nymgoAutomation.data.adapters.DataAdapter;
import nymgoAutomation.data.entity.AdminEntity;
import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class GeneralDataProvider extends BaseDataProvider{


    @DataProvider(name=PROVIDER_CONST.ADMIN_PROVIDER)
    public static Object[][] adminDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1];
        AdminEntity adminEntity = DataAdapter.getAdmin();
        dataAdapterArray[0][0] = adminEntity;
        return dataAdapterArray;
    }

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

    @DataProvider(name=PROVIDER_CONST.EURO_NORMAL_WHITELIST_PROVIDER_SET_PARAMS)
    public static Object[][] euroNormalWhitelistDataProviderSetParams(ITestContext context) throws Exception {

        String fullName = context.getCurrentXmlTest().getParameter("fullName");
        String mobile = context.getCurrentXmlTest().getParameter("mobile");
        String phone = context.getCurrentXmlTest().getParameter("phone");
        String countryOfResidence = context.getCurrentXmlTest().getParameter("countryOfResidence");
        String city = context.getCurrentXmlTest().getParameter("city");
        String address = context.getCurrentXmlTest().getParameter("address");
        String street = context.getCurrentXmlTest().getParameter("street");
        String postalCode = context.getCurrentXmlTest().getParameter("postalCode");
        String displayCurrency = context.getCurrentXmlTest().getParameter("displayCurrency");
        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String language = context.getCurrentXmlTest().getParameter("language");

        Object[][] dataAdapterArray = new Object[1][12]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = fullName;   	
        dataAdapterArray[0][2] = mobile;    	
        dataAdapterArray[0][3] = phone;    	
        dataAdapterArray[0][4] = countryOfResidence;    	
        dataAdapterArray[0][5] = city;    	
        dataAdapterArray[0][6] = address;    	
        dataAdapterArray[0][7] = street;    	
        dataAdapterArray[0][8] = postalCode;    	
        dataAdapterArray[0][9] = displayCurrency;    	
        dataAdapterArray[0][10] = paymentCurrency;    	
        dataAdapterArray[0][11] = language;    	
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.SET_NORMAL_USER_PARAMS_PROVIDER)
    public static Object[][] setNormalUserParamsDataProvider(ITestContext context) throws Exception {

        String fullName = context.getCurrentXmlTest().getParameter("fullName");
        String mobile = context.getCurrentXmlTest().getParameter("mobile");
        String phone = context.getCurrentXmlTest().getParameter("phone");
        String countryOfResidence = context.getCurrentXmlTest().getParameter("countryOfResidence");
        String city = context.getCurrentXmlTest().getParameter("city");
        String address = context.getCurrentXmlTest().getParameter("address");
        String street = context.getCurrentXmlTest().getParameter("street");
        String postalCode = context.getCurrentXmlTest().getParameter("postalCode");
        String displayCurrency = context.getCurrentXmlTest().getParameter("displayCurrency");
        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String language = context.getCurrentXmlTest().getParameter("language");

        Object[][] dataAdapterArray = new Object[1][11]; 
        dataAdapterArray[0][0] = fullName;   	
        dataAdapterArray[0][1] = mobile;    	
        dataAdapterArray[0][2] = phone;    	
        dataAdapterArray[0][3] = countryOfResidence;    	
        dataAdapterArray[0][4] = city;    	
        dataAdapterArray[0][5] = address;    	
        dataAdapterArray[0][6] = street;    	
        dataAdapterArray[0][7] = postalCode;    	
        dataAdapterArray[0][8] = displayCurrency;    	
        dataAdapterArray[0][9] = paymentCurrency;    	
        dataAdapterArray[0][10] = language;    	
        return dataAdapterArray;
    }


    @DataProvider(name=PROVIDER_CONST.SET_RESELLER_PARAMS_PROVIDER)
    public static Object[][] setResellerParamsDataProvider(ITestContext context) throws Exception {

        String fullName = context.getCurrentXmlTest().getParameter("fullName");
        String mobile = context.getCurrentXmlTest().getParameter("mobile");
        String phone = context.getCurrentXmlTest().getParameter("phone");
        String countryOfResidence = context.getCurrentXmlTest().getParameter("countryOfResidence");
        String city = context.getCurrentXmlTest().getParameter("city");
        String address = context.getCurrentXmlTest().getParameter("address");
        String street = context.getCurrentXmlTest().getParameter("street");
        String postalCode = context.getCurrentXmlTest().getParameter("postalCode");
        String displayCurrency = context.getCurrentXmlTest().getParameter("displayCurrency");
        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String language = context.getCurrentXmlTest().getParameter("language");

        Object[][] dataAdapterArray = new Object[1][11]; 
        dataAdapterArray[0][0] = fullName;   	
        dataAdapterArray[0][1] = mobile;    	
        dataAdapterArray[0][2] = phone;    	
        dataAdapterArray[0][3] = countryOfResidence;    	
        dataAdapterArray[0][4] = city;    	
        dataAdapterArray[0][5] = address;    	
        dataAdapterArray[0][6] = street;    	
        dataAdapterArray[0][7] = postalCode;    	
        dataAdapterArray[0][8] = displayCurrency;    	
        dataAdapterArray[0][9] = paymentCurrency;    	
        dataAdapterArray[0][10] = language;    	
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EURO_RESELLER_PROVIDER)
    public static Object[][] euroResellerDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EURO_RESELLER_PROVIDER_W_PARAMS)
    public static Object[][] euroResellerDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String conversionRate = context.getCurrentXmlTest().getParameter("conversionRate");

        Object[][] dataAdapterArray = new Object[1][7]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
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
