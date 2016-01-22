package com.nymgo.tests.enums;

public enum TRANSACTIONS_TABLE_COLUMNS {

    ID( "ID"),
	USERNAME( "Username"),
    DATE( "Date"),
    AMOUNT( "Amount"),
    CURRENCY( "currency"),
    PRODUCT( "Product"),
    PROD_COUNT( "Prod Count"),
    SERVICE( "Service"),
    METHOD( "Method"),
    COUNTRY( "Country");

    private final String text;

    private TRANSACTIONS_TABLE_COLUMNS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
