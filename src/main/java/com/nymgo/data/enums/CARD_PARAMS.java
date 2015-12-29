package com.nymgo.data.enums;

/**
 * Created by Iuliia Khikmatova on Oct 12, 2015
 */
public enum CARD_PARAMS {

//    CREDIT_CARDS_FILE_PATH,
    CREDIT_CARDS_FILE_NAME,
    CARD_NUMBER( "CardNumber"),
    EXPIRATION_MONTH( "ExpirationMonth"),
    EXPIRATION_YEAR( "ExpirationYear"),
    CVV( "CVV"),
    CARDHOLDERS_NAME( "CardholdersName");
	
    private CARD_PARAMS(){
    	
    }
    
    private String text = "";

    private CARD_PARAMS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
