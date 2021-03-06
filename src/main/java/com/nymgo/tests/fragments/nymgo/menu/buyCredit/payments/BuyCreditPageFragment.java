package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class BuyCreditPageFragment extends BaseLoggedInFragment{

	public BuyCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String BUY_CREDIT_PAGE_URL_PATTERN = Starter.SECURE_PART_PATTERN +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/buy-credits";	
//	public static final String BUY_CREDIT_PAGE_URL = Starter.SECURE_PART +
//			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/buy-credits";	
	public static final String BUY_CREDIT_PAGE_URL_END = LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/buy-credits";	
			
    @FindBy(css="div[class^='adyenOption']")
    private List<WebElement> adyenOptions;

    @FindBy(css="div[class='adyenOption checked']")
    private WebElement adyenOptionChecked;

    @FindBy(css="div[class='adyenOption disabled']")
    private List<WebElement> adyenOptionsDisabled;

//    @FindBy(id="transaction-proceed")
    @FindBy(css="button[id='transaction-proceed']")
    private WebElement continueButton;
    
    @FindBys({@FindBy(xpath = "//div[@id='resultHolder']/div[@class='vatHolder'][1]"),
    	@FindBy(xpath = ".//label")})
    private WebElement vatLabel;

    @FindBy(css="div[id='vat-calc']")
    private WebElement vatValue;

    public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(BUY_CREDIT_PAGE_URL_PATTERN);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PAGE_URL_END;
	}

	private String getAmountCurrencyIcon(WebElement option){
		try{
			return option.findElement(By.xpath(".//label/strong[1]")).getText();
		}
		catch(NoSuchElementException e){
			return "";
		}
	}

	private int getAmountCurrencyValue(WebElement option){
		try{
			return Integer.valueOf(option.findElement(By.xpath(".//label/strong[2]")).getText());
		}
		catch(NoSuchElementException e){
			
			return 0;
		}
	}

	private String getAmountCurrencyName(WebElement option){
		
		return option.findElement(By.xpath(".//label/span")).getText();
	}

	private List<WebElement> getAllAdyenOptions(){
		
		return adyenOptions;
	}

	private List<WebElement> getDisabledAdyenOptions(){
		
		return adyenOptionsDisabled;
	}

	private WebElement returnCheckedOption() throws NoSuchElementException{
		return adyenOptionChecked;
	}
	
	public void clickContinueButton(){
		
		scrollToElement(continueButton);
		clickButton(continueButton);
	}

	public String getCheckedOptionDescription() throws NoSuchElementException{
		
		return getFullAdyenOptionDescription(returnCheckedOption());
	}

	private boolean isOptionByValueChecked(int value){
	
		return (getAmountCurrencyValue(returnCheckedOption()) == value);
	}

	private WebElement returnOptionByValue(int value){
		
		List<WebElement> options = getAllAdyenOptions();
		for (WebElement option: options){
			if(getAmountCurrencyValue(option) == value){
				return option;
			}
		}
		LOGGER.fatal("There is no option with value " + value);
		return null;
	}

	public void checkOptionByValue(int value){
		
		if (!isOptionByValueChecked(value)){
			if (!isValueDisabled(value)){
				WebElement element = returnOptionByValue(value);
				if(element != null){
					LOGGER.info("Option is found");
					WebElement radioElement = element.findElement(By.cssSelector("input[type='radio']"));
					scrollToElement(radioElement);
//					clickRadioButton(radioElement);
					clickElementByCoordinates(radioElement);
				}
			}
			else{
				LOGGER.debug("Value " + value+ " is disabled");
			}
		}
		else{
			LOGGER.debug("Value " + value+ " is already checked");
		}
	}
	
	private String getFullAdyenOptionDescription(WebElement option) throws NoSuchElementException{
		
		return getAmountCurrencyIcon(option) + " "
				+  String.valueOf(getAmountCurrencyValue(option)) + " "
				+ getAmountCurrencyName(option);
	}
	
	public List<String> getAllAdyenOptionsDescription(){
		
		List<String> adyenValuesText = new ArrayList<String>();
		for( WebElement option: getAllAdyenOptions()){
			adyenValuesText.add(getFullAdyenOptionDescription(option));
		} 
		return adyenValuesText;
	}

	private ArrayList<Integer> getDisabledAdyenOptionsValues(){
		
		ArrayList<Integer> disabledAdyenValues = new ArrayList<Integer>();
		for( WebElement option: getDisabledAdyenOptions()){
			disabledAdyenValues.add(getAmountCurrencyValue(option));
		} 
		return disabledAdyenValues;
	}

	@SuppressWarnings("unused")
	private List<String> getAllCurencyValuesOptions(){
		
		List<String> adyenValuesText = new ArrayList<String>();
		for( WebElement option: getAllAdyenOptions()){
			adyenValuesText.add(String.valueOf(getAmountCurrencyValue(option)));
		} 
		return adyenValuesText;
	}

	private boolean isValueDisabled(int value){
		
		for (int i: getDisabledAdyenOptionsValues()){
			if(i == value){
				LOGGER.info("Value is disabled");
				return true;
			}
		}
		return false;
	}
	
	public String getVATPercent(){
		
		String[] splitted = vatLabel.getText().split(" ");
		if(splitted.length > 1){
			return splitted[1];
		}
		else{
			return "";
		}
				
	}

	public String getVATValue(){
		
		return vatValue.getText();
	}
}
