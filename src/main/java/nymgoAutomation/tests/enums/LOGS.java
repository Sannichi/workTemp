package nymgoAutomation.tests.enums;

public enum LOGS {

    LOGGER_NAME("nymgoLogger");

    private final String text;

    private LOGS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
