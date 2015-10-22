package nymgoAutomation.tests.utils;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyDescription {

	private int firstBuyFirstValue;
	private int firstBuySecondValue;
	private int firstValue;
	private int secondValue;
	private int thirdValue;
	private String icon;
	private Float conversionRate;
	
	public CurrencyDescription(int firstBuyFirstValue, int firstBuySecondValue, 
			int firstValue, int secondValue, int thirdValue, String icon, String conversionRate){
		
		this.firstBuyFirstValue = firstBuyFirstValue;
		this.firstBuySecondValue = firstBuySecondValue;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.thirdValue = thirdValue;
		this.icon = icon;
		this.conversionRate = Float.valueOf(conversionRate);
	}
	
	public int[] getCurrencyValues(){
		
		int[] currencyDescription = {firstBuyFirstValue, firstBuySecondValue, firstValue, secondValue, thirdValue};
		return currencyDescription;
	}

	public int getFirstBuyFirstValue(){
		
		return firstBuyFirstValue;
	}

	public int getFirstBuySecondValue(){
		
		return firstBuySecondValue;
	}
	
	public int getFirstValue(){
		
		return firstValue;
	}
	
	public int getSecondValue(){
		
		return secondValue;
	}
	
	public int getThirdValue(){
		
		return thirdValue;
	}
	
	public String getCurrencyIcon() {
		
		return icon;
	}

	public Float getConversionRate() {
		
		return conversionRate;
	}
}
