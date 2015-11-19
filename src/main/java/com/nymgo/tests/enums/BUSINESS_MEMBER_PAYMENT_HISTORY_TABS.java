package com.nymgo.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public enum BUSINESS_MEMBER_PAYMENT_HISTORY_TABS {

	TRANSACTION_BUSINESS_MEMBER_PAYMENT_HISTORY( "Transaction Business Member Payment History"),
	BUSINESS_PAYMENT_ACTION( "Business Payment Action"),
	BUSINESS_PAYMENT_NOTE( "Business Payment Note");

    private final String text;

    private BUSINESS_MEMBER_PAYMENT_HISTORY_TABS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
