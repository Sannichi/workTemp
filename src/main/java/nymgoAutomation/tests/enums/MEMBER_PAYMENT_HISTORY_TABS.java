package nymgoAutomation.tests.enums;

public enum MEMBER_PAYMENT_HISTORY_TABS {

    MEMBER_PAYMENT_HISTORY( "Member Payment History"),
    PAYMENT_ACTION( "Payment Action"),
    PAYMENT_NOTE( "Payment Note"),
    USER_LIST( "User List"),
    CREDIT_CARD_USED( "Credit Cards Used"),
    HIGH_LEVEL_PAYMENT_ACTION( "High Level Payment Action");

    private final String text;

    private MEMBER_PAYMENT_HISTORY_TABS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
