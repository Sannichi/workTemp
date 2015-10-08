package nymgoAutomation.tests.enums;

public enum TRANSACTION_INFORMATION_ROWS {

	PRODUCT( "Product"), 
	PAYMENT_SERVICE( "Payment Service"),
	AMOUNT_PAID( "Amount Paid"), 
	DATE( "Date"),
	PAYMENT_ID( "Payment ID"), 
	TRANSACTION_ID( "Transaction ID"), 
	CARD_USED( "Card Used"),
	CVV_RESULT( "CVV Result"), 
	AVS_RESULT( "AVS Result"),
	CREDIT_CARD( "Credit card"), 
	STATUS_DESCRIPTION( "Status Description"), 
	RISK_SCORE( "Risk Score/Status ID"),
	RULE_DESCRIPTION( "Rule Description"); 

    private final String text;

    private TRANSACTION_INFORMATION_ROWS(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
