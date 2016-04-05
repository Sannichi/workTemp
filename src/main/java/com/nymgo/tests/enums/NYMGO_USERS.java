package com.nymgo.tests.enums;

/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public enum NYMGO_USERS {

	EURO_NORMAL_WHITELIST( "EuroNormalWhitelist"),
	EURO_RESELLER( "EuroReseller"),
	EURO_MASTER_RESELLER( "EuroMasterReseller"),
	INTER_NORMAL_WHITELIST( "InterNormalWhitelist"),
	INTER_RESELLER( "InterReseller"),
	INTER_MASTER_RESELLER( "InterMasterReseller"),
	RECURRENT_EURO_NORMAL_WHITELIST( "RecurrentEuroNormalWhitelist"),
	RECURRENT_EURO_MASTER_RESELLER( "RecurrentEuroMasterReseller"),
	NYMGO_EURO_NORMAL_USER( "NymgoEuroNormalUser"),
	NYMGO_EURO_RESELLER( "NymgoEuroReseller"),
	NYMGO_INTER_NORMAL_USER( "NymgoInterNormalUser"),
	NYMGO_INTER_RESELLER( "NymgoInterReseller");
    
    private final String text;

    private NYMGO_USERS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
    public static NYMGO_USERS findUserByValue(String nymgoUser){
        for(NYMGO_USERS user : values()){
            if( user.toString().equals(nymgoUser)){
                return user;
            }
        }
        return null;
    }
}