package nymgoAutomation.data.enums;

public enum USER_PARAMS {

    USERS_FILE_PATH,
    TRANSACTIONS_FILE_PATH,
    USERNAME( "Username"),
    PASSWORD( "Password"),
    FULL_NAME( "FullName"),
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
    LANGUAGE( "Language");
    
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
