package com.nymgo.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 15, 2015
 */
public enum CURRENCY_SIGNS {
	
	USD( "USD"),
	AUD( "AUD"),
	CAD( "CAD"),
	EUR( "EUR"),
	INR( "INR"),
	NZD( "NZD"),
	QAR( "QAR"),
	SAR( "SAR"),
	AED( "AED"),
	GBP( "GBP"),
	KWD( "KWD"),
	MYR( "MYR"),
	SGD( "SGD"),
	AOA( "AOA"),
	BND( "BND");
	
    private final String text;

    private CURRENCY_SIGNS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
