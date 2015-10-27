package nymgoAutomation.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public enum BUSINESS_MEMBERS_LIST_TABS {

    INFO( "Info"),
    PAYMENTS_ALL( "Payments All"),
    MEMBERS( "Members"),
    CREDITS_TRANSFER( "Credits Transfer"),
    MEMBERS_AUTO_RECHARGE( "Members Auto Recharge"),
    BUSINESS_USER_NOTE( "Business User Note"),
    MASTER_RESELLERS_FUNDS( "Master Resellers Funds"),
    MASTER_RESELLER_TRANSFER( "Master Reseller Transfer"),
    BUSINESS_PAYMENT_METHOD( "Business Payment Method"),
    UPDATE_BUSINESS_PROFILE( "Update Business Profile"),
    BUS_UPDATE_PASSWORD( "Bus Update Password");

    private final String text;

    private BUSINESS_MEMBERS_LIST_TABS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
