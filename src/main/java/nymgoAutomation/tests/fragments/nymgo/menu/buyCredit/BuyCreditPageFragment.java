package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditPageFragment extends BaseLoggedInFragment implements HasURL{

	public BuyCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/buy-credits";	
			
    @FindBy(css="div[class^='adyenOption ']")
    private List<WebElement> adyenOptions;

    @FindBy(css="div[class='adyenOption checked']")
    private WebElement adyenOptionChecked;

    @FindBy(css="div[class='adyenOption disabled']")
    private List<WebElement> adyenOptionsDisabled;

    @FindBy(id="transaction-proceed")
    private WebElement continueButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_PAGE_URL));
	}

	private String getAmountCurrencyIcon(WebElement option){
		
		return option.findElement(By.xpath(".//label/strong[1]")).getText();
	}

	private int getAmountCurrencyValue(WebElement option){
		
		return Integer.valueOf(option.findElement(By.xpath(".//label/strong[2]")).getText());
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

	private WebElement returnCheckedOption(){
		
		return adyenOptionChecked;
	}
	
	public void clickContinueButton(){
		
//		continueButton.click();
		clickButton(continueButton);
	}

	public String getCheckedOptionDescription(){
		
		return getFullAdyenOptionDescription(returnCheckedOption());
	}

	public boolean isOptionByValueChecked(int value){
	
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
				returnOptionByValue(value).click();
			}
		}
		else{
			LOGGER.debug("Value " + value+ " is already checked");
		}
	}
	
	private String getFullAdyenOptionDescription(WebElement option){
		
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

	public ArrayList<Integer> getDisabledAdyenOptionsValues(){
		
		ArrayList<Integer> disabledAdyenValues = new ArrayList<Integer>();
		for( WebElement option: getDisabledAdyenOptions()){
			disabledAdyenValues.add(getAmountCurrencyValue(option));
		} 
		return disabledAdyenValues;
	}

	public List<String> getAllCurencyValuesOptions(){
		
		List<String> adyenValuesText = new ArrayList<String>();
		for( WebElement option: getAllAdyenOptions()){
			adyenValuesText.add(String.valueOf(getAmountCurrencyValue(option)));
		} 
		return adyenValuesText;
	}

	public boolean isValueDisabled(int value){
		
		for (int i: getDisabledAdyenOptionsValues()){
			if(i == value){
				LOGGER.info("Value is disabled");
				return true;
			}
		}
		return false;
	}
}
