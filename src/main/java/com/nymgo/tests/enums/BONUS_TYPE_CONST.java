package com.nymgo.tests.enums;

/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
public enum BONUS_TYPE_CONST {

	MANUAL( "MANUAL"),
	AUTOMATIC( "AUTOMATIC"),
    _0( "0% (disabled)"),
    _5( "5%"),
    _10( "10%"),
    _15( "15%");

    private final String text;

    private BONUS_TYPE_CONST(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
