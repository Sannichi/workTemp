package com.nymgo.data.providers;

import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.AdminEntity;
import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.entity.ThreeDSUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.utils.NewEmailUtils;

public class GeneralDataProvider extends BaseDataProvider{


    @DataProvider(name=PROVIDER_CONST.ADMIN_PROVIDER)
    public static Object[][] adminDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1];
        AdminEntity adminEntity = DataAdapter.getAdmin();
        dataAdapterArray[0][0] = adminEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.SIGN_UP_RESELLER_PROVIDER)
    public static Object[][] signUpResellerDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getSignUpReseller();
        /*
        List<String> signUpData = NewEmailUtils.getUniqueEmailAndUsername();
        fullUserEntity.setEmail(signUpData.get(0));
        fullUserEntity.setUsername(signUpData.get(1));
        */
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.SIGN_UP_NORMAL_USER_PROVIDER)
    public static Object[][] signUpNormalUserDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getSignUpNormalUser(); 
        /*
        List<String> signUpData = NewEmailUtils.getUniqueEmailAndUsername();
        fullUserEntity.setEmail(signUpData.get(0));
        fullUserEntity.setUsername(signUpData.get(1));
        */
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
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

        Object[][] dataAdapterArray = new Object[1][6]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    	
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
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");

        Object[][] dataAdapterArray = new Object[1][8]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    
        dataAdapterArray[0][6] = bonusType;
        dataAdapterArray[0][7] = bonusTypeValue;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER)
    public static Object[][] euroMasterResellerDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EURO_MASTER_RESELLER_PROVIDER_W_PARAMS)
    public static Object[][] euroMasterResellerDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");

        Object[][] dataAdapterArray = new Object[1][8]; 
        FullUserEntity fullUserEntity = DataAdapter.getEuroMasterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    
        dataAdapterArray[0][6] = bonusType;
        dataAdapterArray[0][7] = bonusTypeValue;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER)
    public static Object[][] interNormalWhitelistDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_NORMAL_WHITELIST_PROVIDER_W_PARAMS)
    public static Object[][] interNormalWhitelistDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");

        Object[][] dataAdapterArray = new Object[1][6]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterNormalWhitelist(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    	
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_RESELLER_PROVIDER)
    public static Object[][] interResellerDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_RESELLER_PROVIDER_W_PARAMS)
    public static Object[][] interResellerDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");

        Object[][] dataAdapterArray = new Object[1][8]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    
        dataAdapterArray[0][6] = bonusType;
        dataAdapterArray[0][7] = bonusTypeValue;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER)
    public static Object[][] interMasterResellerDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.INTER_MASTER_RESELLER_PROVIDER_W_PARAMS)
    public static Object[][] interMasterResellerDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");

        Object[][] dataAdapterArray = new Object[1][8]; 
        FullUserEntity fullUserEntity = DataAdapter.getInterMasterReseller(); 
        dataAdapterArray[0][0] = fullUserEntity;
        dataAdapterArray[0][1] = paymentCurrency;   	
        dataAdapterArray[0][2] = countryOfCredit;    	
        dataAdapterArray[0][3] = cardType;    	
        dataAdapterArray[0][4] = gatewayName;    	
        dataAdapterArray[0][5] = currencyAmount;    
        dataAdapterArray[0][6] = bonusType;
        dataAdapterArray[0][7] = bonusTypeValue;
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

    @DataProvider(name=PROVIDER_CONST.SET_MASTER_RESELLER_PARAMS_PROVIDER)
    public static Object[][] setMasterResellerParamsDataProvider(ITestContext context) throws Exception {

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

    @DataProvider(name=PROVIDER_CONST.AMERICAN_EXPRESS_CARD_PROVIDER)
    public static Object[][] americanExpressCardDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getAmericanExpressCard();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.VISA_CARD_PROVIDER)
    public static Object[][] visaCardDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getVisaCard();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.MASTER_CARD_CARD_PROVIDER)
    public static Object[][] masterCardCardDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getMasterCardCard();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.VISA_ADYEN_CARD_PROVIDER)
    public static Object[][] visaAdyenCardDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getVisaAdyenCard();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }
    
    @DataProvider(name=PROVIDER_CONST.WP_AMERICAN_EXPRESS_CARD_3DS_PROVIDER)
    public static Object[][] wpAmericanExpressCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getWPAmericanExpressCard3DS();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.WP_VISA_CARD_3DS_PROVIDER)
    public static Object[][] wpVisaCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getWPVisaCard3DS();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.WP_MASTER_CARD_CARD_3DS_PROVIDER)
    public static Object[][] wpMasterCardCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][1]; 
        FullCardEntity fullCardEntity = DataAdapter.getWPMasterCardCard3DS();
        dataAdapterArray[0][0] = fullCardEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.ADYEN_AMERICAN_EXPRESS_CARD_3DS_PROVIDER)
    public static Object[][] adyenAmericanExpressCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][2]; 
        FullCardEntity fullCardEntity = DataAdapter.getAdyenAmericanExpressCard3DS();
        ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();
        dataAdapterArray[0][0] = fullCardEntity;
        dataAdapterArray[0][1] = threeDSUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.ADYEN_VISA_CARD_3DS_PROVIDER)
    public static Object[][] adyenVisaCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][2]; 
        FullCardEntity fullCardEntity = DataAdapter.getAdyenVisaCard3DS();
        ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();
        dataAdapterArray[0][0] = fullCardEntity;
        dataAdapterArray[0][1] = threeDSUserEntity;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.ADYEN_MASTER_CARD_CARD_3DS_PROVIDER)
    public static Object[][] adyenMasterCardCard3DSDataProvider() throws Exception {

        Object[][] dataAdapterArray = new Object[1][2]; 
        FullCardEntity fullCardEntity = DataAdapter.getAdyenMasterCardCard3DS();
        ThreeDSUserEntity threeDSUserEntity = DataAdapter.getThreeDSUser();
        dataAdapterArray[0][0] = fullCardEntity;
        dataAdapterArray[0][1] = threeDSUserEntity;
        return dataAdapterArray;
    }

}
