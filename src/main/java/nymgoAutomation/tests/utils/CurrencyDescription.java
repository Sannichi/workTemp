package nymgoAutomation.tests.utils;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyDescription {

	private int firstBuyNormalValue;
	private int firstNormalValue;
	private int secondNormalValue;
	private int thirdNormalValue;
	private int firstBuyResellerValue;
	private int firstResellerValue;
	private int secondResellerValue;
	private int thirdResellerValue;
	private int forthResellerValue;
	private int fifthResellerValue;
	private int sixthResellerValue;
	private String icon;
	private Float conversionRate;
	
	public CurrencyDescription(int firstBuyNormalValue, 
			int firstNormalValue, int secondNormalValue, int thirdNormalValue,
			int firstBuyResellerValue, int firstResellerValue, int secondResellerValue, int thirdResellerValue, 
			int forthResellerValue, int fifthResellerValue, int sixthResellerValue,
			String icon, String conversionRate){
		
		this.firstBuyNormalValue = firstBuyNormalValue;
		this.firstNormalValue = firstNormalValue;
		this.secondNormalValue = secondNormalValue;
		this.thirdNormalValue = thirdNormalValue;
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
	
	public int[] getCurrencyNormalValues(){
		
		int[] currencyDescription = {firstBuyNormalValue, firstNormalValue, secondNormalValue, thirdNormalValue};
		return currencyDescription;
	}

	public int[] getCurrencyResellerValues(){
		
		int[] currencyDescription = {firstBuyResellerValue, firstResellerValue, secondResellerValue, thirdResellerValue, 
				forthResellerValue, fifthResellerValue, sixthResellerValue};
		return currencyDescription;
	}

	public int getFirstBuyNormalValue(){
		
		return firstBuyNormalValue;
	}

	public int getFirstNormalValue(){
		
		return firstNormalValue;
	}
	
	public int getSecondNormalValue(){
		
		return secondNormalValue;
	}
	
	public int getThirdNormalValue(){
		
		return thirdNormalValue;
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
