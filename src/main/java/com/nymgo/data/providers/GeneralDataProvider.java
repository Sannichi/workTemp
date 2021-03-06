package com.nymgo.data.providers;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.nymgo.data.adapters.DataAdapter;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.enums.PROVIDER_CONST;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.enums.NYMGO_USERS;

public class GeneralDataProvider extends BaseDataProvider{

    @DataProvider(name=PROVIDER_CONST.FULLNAME_SIGN_UP_VERIFIES)
    public static Object[][] fullNameSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getFullNameVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.BUSINESS_NAME_SIGN_UP_VERIFIES)
    public static Object[][] businessNameSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getBusinessNameVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.USERNAME_SIGN_UP_VERIFIES)
    public static Object[][] usernameSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getUsernameVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.PASSWORD_SIGN_UP_VERIFIES)
    public static Object[][] passwordSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getPasswordVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.CONFIRM_PASSWORD_SIGN_UP_VERIFIES)
    public static Object[][] confirmPasswordSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getConfirmPasswordVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.EMAIL_SIGN_UP_VERIFIES)
    public static Object[][] emailSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getEmailVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.PHONE_SIGN_UP_VERIFIES)
    public static Object[][] phoneSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getPhoneVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.MOBILE_SIGN_UP_VERIFIES)
    public static Object[][] mobileSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getMobileVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.COUNTRY_OF_RESIDENCE_SIGN_UP_VERIFIES)
    public static Object[][] countryOfResidenceSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getCountryOfResidenceVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.CITY_SIGN_UP_VERIFIES)
    public static Object[][] citySignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getCityVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.FULL_ADDRESS_SIGN_UP_VERIFIES)
    public static Object[][] fullAddressSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getFullAddressVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.STREET_SIGN_UP_VERIFIES)
    public static Object[][] streetSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getStreetVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.POSTAL_CODE_SIGN_UP_VERIFIES)
    public static Object[][] postalCodeSignUpVerifiesDataProvider() throws Exception {

    	Object[][] dataAdapterArray = ExcelUtils.getPostalCodeVerifiesArray();
    	return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.PAYMENT_PARAMS_PROVIDER)
    public static Object[][] buyCreditParamsDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String dealCurrency = context.getCurrentXmlTest().getParameter("dealCurrency");
        String dealName = context.getCurrentXmlTest().getParameter("dealName");
        String dealQuantity = context.getCurrentXmlTest().getParameter("dealQuantity");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");

        Object[][] dataAdapterArray = new Object[1][10]; 
        dataAdapterArray[0][0] = paymentCurrency;   	
        dataAdapterArray[0][1] = dealCurrency;   	
        dataAdapterArray[0][2] = dealName;   	
        dataAdapterArray[0][3] = dealQuantity;   	
        dataAdapterArray[0][4] = countryOfCredit;    	
        dataAdapterArray[0][5] = cardType;    	
        dataAdapterArray[0][6] = gatewayName;    	
        dataAdapterArray[0][7] = currencyAmount;    
        dataAdapterArray[0][8] = bonusType;
        dataAdapterArray[0][9] = bonusTypeValue;
        return dataAdapterArray;
    }

    @DataProvider(name=PROVIDER_CONST.USER_AND_PAYMENT_PARAMS_PROVIDER)
    public static Object[][] userAndBuyCreditParamsDataProviderWithParams(ITestContext context) throws Exception {

        String paymentCurrency = context.getCurrentXmlTest().getParameter("paymentCurrency");
        String dealCurrency = context.getCurrentXmlTest().getParameter("dealCurrency");
        String dealName = context.getCurrentXmlTest().getParameter("dealName");
        String dealQuantity = context.getCurrentXmlTest().getParameter("dealQuantity");
        String countryOfCredit = context.getCurrentXmlTest().getParameter("countryOfCredit");
        String cardType = context.getCurrentXmlTest().getParameter("cardType");
        String gatewayName = context.getCurrentXmlTest().getParameter("gatewayName");
        String currencyAmount = context.getCurrentXmlTest().getParameter("currencyAmount");
        String bonusType = context.getCurrentXmlTest().getParameter("bonusType");
        String bonusTypeValue = context.getCurrentXmlTest().getParameter("bonusTypeValue");
        FullUserEntity loginUserEntity = getNymgoUserEntity(context.getCurrentXmlTest().getParameter("loginUser"));

        Object[][] dataAdapterArray = new Object[1][11]; 
        dataAdapterArray[0][0] = paymentCurrency;   	
        dataAdapterArray[0][1] = dealCurrency;   	
        dataAdapterArray[0][2] = dealName;   	
        dataAdapterArray[0][3] = dealQuantity;   	
        dataAdapterArray[0][4] = countryOfCredit;    	
        dataAdapterArray[0][5] = cardType;    	
        dataAdapterArray[0][6] = gatewayName;    	
        dataAdapterArray[0][7] = currencyAmount;    
        dataAdapterArray[0][8] = bonusType;
        dataAdapterArray[0][9] = bonusTypeValue;
        dataAdapterArray[0][10] = loginUserEntity;
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

    @DataProvider(name=PROVIDER_CONST.TRANSFER_PARAMS_PROVIDER)
    public static Object[][] transferCreditParamsDataProvider(ITestContext context) throws Exception {

        FullUserEntity userEntityFrom = getNymgoUserEntity(context.getCurrentXmlTest().getParameter("userFrom"));
        FullUserEntity userEntityTo = getNymgoUserEntity(context.getCurrentXmlTest().getParameter("userTo"));
        String transferAmount = context.getCurrentXmlTest().getParameter("transferAmount");
        
        Object[][] dataAdapterArray = new Object[1][3]; 
        dataAdapterArray[0][0] = userEntityFrom;   	
        dataAdapterArray[0][1] = userEntityTo;   	
        dataAdapterArray[0][2] = transferAmount;   	
        return dataAdapterArray;
    }
    
    public static FullUserEntity getNymgoUserEntity(String nymgoUser){
    	
    	NYMGO_USERS NYMGO_USER = NYMGO_USERS.findUserByValue(nymgoUser);
		
		switch(NYMGO_USER){
		
			case EURO_NORMAL_WHITELIST:
				return DataAdapter.getEuroNormalWhitelist();
			case EURO_RESELLER:
				return DataAdapter.getEuroReseller();
			case EURO_MASTER_RESELLER:
				return DataAdapter.getEuroMasterReseller();
			case INTER_NORMAL_WHITELIST:
				return DataAdapter.getInterNormalWhitelist();
			case INTER_RESELLER:
				return DataAdapter.getInterReseller();
			case INTER_MASTER_RESELLER:
				return DataAdapter.getInterMasterReseller();
			case RECURRENT_EURO_NORMAL_WHITELIST:
				return DataAdapter.getRecurrentEuroNormalWhitelist();
			case RECURRENT_EURO_MASTER_RESELLER:
				return DataAdapter.getRecurrentEuroMasterReseller();
			case NYMGO_EURO_NORMAL_USER:
				return DataAdapter.getNymgoEuroNormalUser();
			case NYMGO_EURO_RESELLER:
				return DataAdapter.getNymgoEuroReseller();
			case NYMGO_INTER_NORMAL_USER:
				return DataAdapter.getNymgoInterNormalUser();
			case NYMGO_INTER_RESELLER:
				return DataAdapter.getNymgoInterReseller();
			default: 
				return DataAdapter.getEuroNormalWhitelist();
		}
    }

    @DataProvider(name=PROVIDER_CONST.LOGIN_USER_PROVIDER)
    public static Object[][] loginUserDataProvider(ITestContext context) throws Exception {

        FullUserEntity loginUserEntity = getNymgoUserEntity(context.getCurrentXmlTest().getParameter("loginUser"));
        Object[][] dataAdapterArray = new Object[1][1]; 
        dataAdapterArray[0][0] = loginUserEntity;   	
        return dataAdapterArray;
    }
    
}
