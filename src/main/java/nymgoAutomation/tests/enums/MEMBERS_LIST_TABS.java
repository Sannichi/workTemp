package nymgoAutomation.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public enum MEMBERS_LIST_TABS {

    FUNDS_TRANSFER( "Funds Transfer"),
    SMS( "SMS"),
    PAYMENTS( "Payments"),
    CALL_HISTORY( "Call History"),
    INFOS( "Infos"),
    NOTES( "Notes"),
    BUS_FUNDS_TRANSFER( "Bus Funds Transfer"),
    USER_PAYMENT_METHOD( "User Payment Method"),
    UPDATE_PROFILE( "Update Profile"),
    UPDATE_PASSWORD( "Update Password");

    private final String text;

    private MEMBERS_LIST_TABS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
