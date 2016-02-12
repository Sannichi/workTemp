package com.nymgo.data.enums;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public enum ADMIN_PARAMS {

    ADMIN_FILE_NAME,
    USERNAME( "Username"),
    PASSWORD( "Password");
    
    private ADMIN_PARAMS(){
    	
    }
    
    private String text = "";

    private ADMIN_PARAMS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    

}
