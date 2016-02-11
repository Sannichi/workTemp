package com.nymgo.data.enums;

public enum USER_PARAMS {

//    USERS_FILE_PATH,
    USERS_FILE_NAME,
//    TRANSACTIONS_FILE_PATH,
    TRANSACTIONS_FILE_NAME,
    USERNAME( "Username"),
    PASSWORD( "Password"),
    FULL_NAME( "FullName"),
    BUSINESS_NAME("BusinessName"),
    EMAIL( "Email"),
    MOBILE( "Mobile"),
    PHONE( "Phone"),
    COUNTRY_OF_RESIDENCE( "CountryOfResidence"),
    CITY( "City"),
    FULL_ADDRESS( "FullAddress"),
    STREET( "Street"),
    POSTAL_CODE( "PostalCode"),
    DISPLAY_CURRENCY( "DisplayCurrency"),
    PAYMENT_CURRENCY( "PaymentCurrency"),
    LANGUAGE( "Language"),
    GEOIP_COUNTRY( "GeoIpCountry"),
    VAT( "VAT"),
	BONUS_TYPE( "BonusType"),
	BONUS( "Bonus");
    
    private USER_PARAMS(){
    	
    }
    
    private String text = "";

    private USER_PARAMS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
