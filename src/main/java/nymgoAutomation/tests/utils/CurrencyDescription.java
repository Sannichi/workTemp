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
	private int firstBuyResellerValue;
	private int firstResellerValue;
	private int secondResellerValue;
	private int thirdResellerValue;
	private int forthResellerValue;
	private int fifthResellerValue;
	private int sixthResellerValue;
	private String icon;
	private Float conversionRate;
	
	public CurrencyDescription(int firstBuyFirstValue, int firstBuySecondValue, 
			int firstValue, int secondValue, int thirdValue,
			int firstBuyResellerValue, int firstResellerValue, int secondResellerValue, int thirdResellerValue, 
			int forthResellerValue, int fifthResellerValue, int sixthResellerValue,
			String icon, String conversionRate){
		
		this.firstBuyFirstValue = firstBuyFirstValue;
		this.firstBuySecondValue = firstBuySecondValue;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.thirdValue = thirdValue;
		this.firstBuyResellerValue = firstBuyResellerValue;
		this.firstResellerValue = firstResellerValue;
		this.secondResellerValue = secondResellerValue;
		this.thirdResellerValue = thirdResellerValue;
		this.forthResellerValue = forthResellerValue;
		this.fifthResellerValue = fifthResellerValue;
		this.sixthResellerValue = sixthResellerValue;
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
	
	public int getFirstBuyReselerValue(){
		
		return firstBuyResellerValue;
	}
	
	public int getFirstReselerValue(){
		
		return firstResellerValue;
	}
	
	public int getSecondReselerValue(){
		
		return secondResellerValue;
	}
	
	public int getThirdReselerValue(){
		
		return thirdResellerValue;
	}
	
	public int getForthReselerValue(){
		
		return forthResellerValue;
	}
	
	public int getFifthReselerValue(){
		
		return fifthResellerValue;
	}
	
	public int getSixthReselerValue(){
		
		return sixthResellerValue;
	}
	
	public String getCurrencyIcon() {
		
		return icon;
	}

	public Float getConversionRate() {
		
		return conversionRate;
	}
}
