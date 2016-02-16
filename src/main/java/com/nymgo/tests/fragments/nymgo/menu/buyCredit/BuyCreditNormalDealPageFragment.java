package com.nymgo.tests.fragments.nymgo.menu.buyCredit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.BuyCreditPageFragment;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditNormalDealPageFragment extends BuyCreditPageFragment {

	public BuyCreditNormalDealPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "deal-countries-list")
	private WebElement countrySelect;

	@FindBy(css = ("div[id^=country-deal]"))
	private List<WebElement> dealsOptions;
	
    @FindBy(css="div[class='multi_optionsList clickable2 checked']")
    private WebElement dealOptionChecked;

    @FindBy(css="div[class='multi_optionsList clickable2 disabled']")
    private List<WebElement> dealsOptionsDisabled;
    
    @FindBys({@FindBy(xpath = "//div[@id='user-package-vat-holder']/div[@class='vatHolder'][1]"),
    	@FindBy(xpath = ".//label")})
    private WebElement dealVatLabel;

    @FindBy(css="span[id='user-package-vat-total']")
    private WebElement dealVatValue;
	
    @FindBy(css="span[id='user-package-price-total']")
    private WebElement dealTotalAmountValue;

    @FindBy(css="span[id='deal-minutes']")
    private WebElement dealMinutesValue;

    @FindBy(css="span[id='deal-imtu-amount']")
    private WebElement dealImtuAmountValue;

    public void selectCountryByName(String countryName){
		
		selectValueFromSelectByVisibleText(countrySelect, countryName);
	}
	
    public String getSelectedCountryName(){
		
		Select select = new Select(countrySelect);
		return select.getFirstSelectedOption().getCssValue("value");
	}
	
	public String getDealVATPercent(){
		
		String[] splitted = dealVatValue.getText().split(" ");
		if(splitted.length > 1){
			return splitted[1];
		}
		else{
			return "";
		}
				
	}

	public String getDealVATValue(){
		
		return dealVatValue.getText();
	}

	public String getDealTotalAmountValue(){
		
		return dealTotalAmountValue.getText();
	}

	public String getDealMinutesValue(){
		
		return dealMinutesValue.getText();
	}

	public String getDealImtuAmountValue(){
		
		return dealImtuAmountValue.getText();
	}

	private List<WebElement> getAllDealsOptions(){
		
		return dealsOptions;
	}

	private int getDealPrice(WebElement option){
		
		try{
			return Integer.valueOf(option.findElement(By.id("deal-price")).getText());
		}
		catch(NoSuchElementException e){
			return 0;
		}
	}

	private String getDealCurrencyName(WebElement option){
		
		return option.findElement(By.id("deal-symbol")).getText();
	}

	private String getDealNymgoPart(WebElement option){
		
		return option.findElement(By.cssSelector("span[class='nymgoPart']")).getText();
	}

	private String getDealNymgoPlus(WebElement option){
		
		return option.findElement(By.cssSelector("span[class='nymgoPlus']")).getText();
	}

	private List<WebElement> getDisabledDealsOptions(){
		
		return dealsOptionsDisabled;
	}

	private WebElement returnCheckedOption() throws NoSuchElementException{
		
		return dealOptionChecked;
	}
	
	public String getCheckedOptionDescription() throws NoSuchElementException{
		
		return getFullDealOptionDescription(returnCheckedOption());
	}

	public boolean isOptionByPriceChecked(int value){
	
		return (getDealPrice(returnCheckedOption()) == value);
	}

	private WebElement returnOptionByPrice(int value){
		
		List<WebElement> options = getAllDealsOptions();
		for (WebElement option: options){
			if(getDealPrice(option) == value){
				return option;
			}
		}
		LOGGER.fatal("There is no option with price " + value);
		return null;
	}

	public void checkOptionByPrice(int value){
		
		if (!isOptionByPriceChecked(value)){
			if (!isPriceDisabled(value)){
				WebElement element = returnOptionByPrice(value);
				if(element != null){
					LOGGER.info("Option is found");
					clickElement(element);
				}
			}
			else{
				LOGGER.debug("Price " + value+ " is disabled");
			}
		}
		else{
			LOGGER.debug("Price " + value+ " is already checked");
		}
	}
	
	private String getFullDealOptionDescription(WebElement option) throws NoSuchElementException{
		
		return String.valueOf(getDealPrice(option)) + " "
				+ getDealCurrencyName(option) + " "
				+ getDealNymgoPart(option) + " "
				+ getDealNymgoPlus(option);
	}
	
	public List<String> getAllDealsOptionsDescription(){
		
		List<String> adyenValuesText = new ArrayList<String>();
		for( WebElement option: getAllDealsOptions()){
			adyenValuesText.add(getFullDealOptionDescription(option));
		} 
		return adyenValuesText;
	}

	public ArrayList<Integer> getDisabledDealsOptionsPrices(){
		
		ArrayList<Integer> disabledAdyenValues = new ArrayList<Integer>();
		for( WebElement option: getDisabledDealsOptions()){
			disabledAdyenValues.add(getDealPrice(option));
		} 
		return disabledAdyenValues;
	}

	public List<String> getAllCurencyPricesOptions(){
		
		List<String> adyenValuesText = new ArrayList<String>();
		for( WebElement option: getAllDealsOptions()){
			adyenValuesText.add(String.valueOf(getDealPrice(option)));
		} 
		return adyenValuesText;
	}

	public boolean isPriceDisabled(int value){
		
		for (int i: getDisabledDealsOptionsPrices()){
			if(i == value){
				LOGGER.info("Price is disabled");
				return true;
			}
		}
		return false;
	}
	
}
