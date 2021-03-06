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

	@FindBy(id = "deal-search")
	private WebElement countrySearch;

	@FindBy(xpath = "//li[@class='ui-menu-item odd']")
	private WebElement countryMenuItem;

	private final String dealOptionClassEnding = "optionsList clickable2 voip-deal";
	private final String dealOptionCheckedCSS = "div[class$='" + dealOptionClassEnding + " checked']";

	@FindBy(css = ("div[class$='" + dealOptionClassEnding + "']"))
	private List<WebElement> dealsOptions;
	
    @FindBy(css = dealOptionCheckedCSS)	
    private WebElement dealOptionChecked;

    @FindBy(css="div[class$='optionsList clickable2 disabled']")
    private List<WebElement> dealsOptionsDisabled;
    
    @FindBys({@FindBy(xpath = "//div[@id='user-package-vat-holder']/div[@class='vatHolder'][1]"),
    	@FindBy(xpath = ".//label")})
    private WebElement dealVatLabel;

    @FindBy(css="span[id='user-package-vat-total']")
    private WebElement dealVatValue;
	
    @FindBy(css="span[id='user-package-price-total']")
    private WebElement dealTotalAmountValue;

    @FindBys({@FindBy(css = dealOptionCheckedCSS),
		@FindBy(id="deal-price")})    
	private WebElement checkedDealPriceValue;

	@FindBys({@FindBy(css = dealOptionCheckedCSS),
		@FindBy(id="deal-minutes")})    
	private WebElement checkedDealMinutesValue;

	@FindBys({@FindBy(css = "div[class$='optionsList clickable2 checked']"),
		@FindBy(id="deal-imtu-amount")})    
	private WebElement checkedDealImtuAmountValue;

  @FindBy(css="button[id='transaction-proceed-user']")
    private WebElement continueDealButton;

    public void selectCountryByName(String countryName){
		
		selectValueFromSelectByVisibleText(countrySelect, countryName);
	}
	
    public void selectCountryName(String countryName){
		
		setTextToEditField(countrySearch, countryName);
		clickElement(countryMenuItem);
	}
	
    public String getSelectedCountryName(){
		
		Select select = new Select(countrySelect);
		return select.getFirstSelectedOption().getCssValue("value");
	}
	
	public String getDealVATPercent(){
		
		String[] splitted = dealVatLabel.getText().split(" ");
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

//	public String getDealMinutesValue(){
//		
//		return dealMinutesValue.getText();
//	}
//
//	public String getDealImtuAmountValue(){
//		
//		return dealImtuAmountValue.getText();
//	}

	public String getCheckedDealPriceValue(){
		
		return checkedDealPriceValue.getText();
	}

	public String getCheckedDealMinutesValue(){
		
		return checkedDealMinutesValue.getText();
	}

	public String getCheckedDealImtuAmountValue(){
		
		return checkedDealImtuAmountValue.getText();
	}

	private List<WebElement> getAllDealsOptions(){
		
		List<WebElement> visibleDealsOptions = new ArrayList<>();
		for (WebElement option : dealsOptions){
			if(isElementDisplayed(option)){
				visibleDealsOptions.add(option);
			}
		}
		return visibleDealsOptions;
	}

	private Float getDealPrice(WebElement option){
		
		try{
			return Float.valueOf(option.findElement(By.id("deal-price")).getText());
		}
		catch(NoSuchElementException e){
			return null;
		}
	}

	private int getDealMinutes(WebElement option){
		
		try{
			return Integer.valueOf(option.findElement(By.id("deal-minutes")).getText());
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
	
	public String getCheckedDealOptionDescription() throws NoSuchElementException{
		
		return getFullDealOptionDescription(returnCheckedOption());
	}

	public int getCheckedDealOptionMinutes() throws NoSuchElementException{
		
		return getDealMinutes(returnCheckedOption());
	}

	private boolean isDealOptionByPriceChecked(Float value){
	
		return (getDealPrice(returnCheckedOption()) == value);
	}

	private boolean isDealOptionByMinutesChecked(int value){
		
		return (getDealMinutes(returnCheckedOption()) == value);
	}

	private WebElement returnOptionByPrice(Float value){
		
		List<WebElement> options = getAllDealsOptions();
		for (WebElement option: options){
			if(getDealPrice(option).equals(value)){
				return option;
			}
		}
		LOGGER.fatal("There is no option with price " + value);
		return null;
	}

	private WebElement returnOptionByMinutes(int value){
		
		List<WebElement> options = getAllDealsOptions();
		for (WebElement option: options){
			if(getDealMinutes(option) == value){
				return option;
			}
		}
		LOGGER.fatal("There is no option with minutes " + value);
		return null;
	}

	public void checkDealOptionByPrice(Float value){
		
		if (!isDealOptionByPriceChecked(value)){
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
	
	public void checkDealOptionByMinutes(int value){
		
		if (!isDealOptionByMinutesChecked(value)){
				WebElement element = returnOptionByMinutes(value);
				if(element != null){
					LOGGER.info("Option is found");
					clickElement(element);
				}
		}
		else{
			LOGGER.debug("Minutes " + value+ " are already checked");
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

	public ArrayList<Float> getDisabledDealsOptionsPrices(){
		
		ArrayList<Float> disabledAdyenValues = new ArrayList<Float>();
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

	public boolean isPriceDisabled(Float value){
		
		for (Float i: getDisabledDealsOptionsPrices()){
			if(i == value){
				LOGGER.info("Price is disabled");
				return true;
			}
		}
		return false;
	}
	
	public void clickContinueDealButton(){
		
		scrollToElement(continueDealButton);
		clickButton(continueDealButton);
	}

}
