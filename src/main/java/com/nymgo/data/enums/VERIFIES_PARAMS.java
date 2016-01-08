package com.nymgo.data.enums;

/**
 * Created by Iuliia Khikmatova on Dec 29, 2015
 */
public enum VERIFIES_PARAMS {

//    VERIFIES_FILE_PATH,
    VERIFIES_FILE_NAME,
//    ACTIVATION_FILE_PATH,
    ACTIVATION_FILE_NAME,
//    REGISTRATION_FILE_PATH,
    REGISTRATION_FILE_NAME,
    ;
	
    private VERIFIES_PARAMS(){
    	
    }
    
    private String text = "";

    private VERIFIES_PARAMS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
