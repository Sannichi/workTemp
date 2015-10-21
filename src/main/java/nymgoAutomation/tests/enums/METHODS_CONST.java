package nymgoAutomation.tests.enums;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public enum METHODS_CONST {

	AMERICAN_EXPRESS( "American Express"),
	AMEX_SSL( "AMEX-SSL"),
	VISA( "visa"),
	VISA_SSL( "VISA-SSL"),
	MASTERCARD( "mc"),
	IMTU( "imtu");
	
    private final String text;

    private METHODS_CONST(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
