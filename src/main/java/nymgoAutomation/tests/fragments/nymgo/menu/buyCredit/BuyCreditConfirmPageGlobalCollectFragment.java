package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditConfirmPageGlobalCollectFragment extends BaseBuyCreditConfirmPageFragment{

	public BuyCreditConfirmPageGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	wait.until(ExpectedConditions.visibilityOf(cardNumber));
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_URL = "https://eu.gcsip.nl/orb/orb?ACTION=DO_START&REF=";	

	@FindBy(name = "CREDITCARDNUMBER")
	private WebElement cardNumber;
	
	@FindBy(name = "EXPIRYDATE_MM")
	private WebElement expireDateMonth;

	@FindBy(name = "EXPIRYDATE_YY")
	private WebElement expireDateYear;

	@FindBy(name = "CVV")
	private WebElement cvv;

	@FindBy(id = "btnSubmit")
	private WebElement continueButton;

	@FindBy(id = "btnCancel")
	private WebElement cancelButton;
	
//	@Override
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_GC_URL));
	}

	public void setCardNumberValue(String cardNumberValue){
		
//		cardNumber.sendKeys(cardNumberValue);
		setTextToEditField(cardNumber, cardNumberValue);
	}
	
	public void selectExpireDateMonthByLCName(String monthValue){
		
//		Select select = new Select(expireDateMonth);
//		select.selectByVisibleText(LocaleGenerator.getLocaleKeyByLocaleName(localeName));
//		select.selectByVisibleText(monthValue);
		selectValueFromSelectByVisibleText(expireDateMonth, monthValue);
	}
	
	public void selectExpireDateYearByLCName(String yearValue){
		
//		Select select = new Select(expireDateYear);
//		select.selectByVisibleText(LocaleGenerator.getLocaleKeyByLocaleName(localeName));
//		select.selectByVisibleText(yearValue);
		selectValueFromSelectByVisibleText(expireDateYear, yearValue);
	}
	
	public void setCVVValue(String cvvValue){
		
//		cvv.sendKeys(cvvValue);
		setTextToEditField(cvv, cvvValue);
	}

	public void clickContinueButton(){
		
//		continueButton.click();
		clickSubmitButton(continueButton);
	}

	public void clickCancelButton(){
		
//		cancelButton.click();
		clickSubmitButton(cancelButton);
	}

	public String getSelectedExpireDateMonth(){
		
		Select select = new Select(expireDateMonth);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedExpireDateYear(){
		
		Select select = new Select(expireDateYear);
		return select.getFirstSelectedOption().getText();
	}
}
