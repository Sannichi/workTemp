package nymgoAutomation.tests.enums;

public enum FILES_NAMES {

    LOCALE_EN( "LOCALE_EN.properties"),
    LOCALE_FR( "LOCALE_FR.properties"),
    LOCALE_AR( "LOCALE_AR.properties"),
    LOCALE_IN( "LOCALE_IN.properties"),
    LOCALE_TU( "LOCALE_TU.properties"),
    DEV( "DEV.properties"),
    STAGING( "STAGING.properties"),
    LIVE( "LIVE.properties");

    private final String text;

    private FILES_NAMES(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
