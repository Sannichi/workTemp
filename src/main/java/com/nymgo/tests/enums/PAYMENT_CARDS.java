package com.nymgo.tests.enums;

public enum PAYMENT_CARDS {

    VISA( "Visa"),
    MASTER_CARD( "MasterCard"),
    AMERICAN_EXPRESS( "American Express");

    private final String text;

    private PAYMENT_CARDS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
