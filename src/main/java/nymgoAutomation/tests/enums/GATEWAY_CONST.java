package nymgoAutomation.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public enum GATEWAY_CONST {
		
	ADYEN( "Adyen"),
	GLOBAL_COLLECT( "Global Collect"),
	WORLDPAY( "Worldpay");
	
    private final String text;

    private GATEWAY_CONST(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
