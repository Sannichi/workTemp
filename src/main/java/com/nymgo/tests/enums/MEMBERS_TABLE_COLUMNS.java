package com.nymgo.tests.enums;

public enum MEMBERS_TABLE_COLUMNS {

    USERNAME( "Username"),
    FULLNAME( "Fullname"),
    PHONE( "Phone"),
    EMAIL( "Email"),
    REGISTRATION_DATE( "Registration Date"),
    COUNTRY( "Country"),
    LOGIN_COUNTRY( "Login Country"),
    TYPE( "Type"),
    GOIP_COUNTRY( "Goip Country"),
	STATUS( "status");

    private final String text;

    private MEMBERS_TABLE_COLUMNS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
