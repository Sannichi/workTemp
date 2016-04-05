package com.nymgo.tests.fragments.nymgo.menu.buyCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.BuyCreditPageFragment;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditResellerDealPageFragment extends BuyCreditPageFragment {

	public BuyCreditResellerDealPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "package-product")
	private WebElement dealsSelect;

	@FindBy(id = "package-quantity")
	private WebElement dealsQuantityField;

    @FindBys({@FindBy(xpath = "//div[@id='package-vat-holder']/div[@class='vatHolder'][1]"),
    	@FindBy(xpath = ".//label")})
    private WebElement dealVatLabel;

    @FindBy(id = "package-vat-total")
    private WebElement dealVatValue;
	
    @FindBy(id = "package-price-total")
    private WebElement dealTotalAmountValue;

    @FindBy(id = "package-minutes")
    private WebElement dealPackageMinutesValue;

    @FindBy(id = "package-imtu-amount")
    private WebElement dealImtuAmountValue;

    public void selectDealByName(String dealName){
		
		selectValueFromSelectByVisibleText(dealsSelect, dealName);
	}
	
    public String getSelectedDealName(){
		
		Select select = new Select(dealsSelect);
		return select.getFirstSelectedOption().getCssValue("value");
	}
	
	public void setDealsQuantity(String dealsQuantity){
		
		setTextToEditField(dealsQuantityField, dealsQuantity);
		pressEnterOnElement(dealsQuantityField);
	}

	public String getDealsQuantity(String dealsQuantity){
		
		return dealsQuantityField.getText();
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

	public String getDealPackageMinutesValue(){
		
		return dealPackageMinutesValue.getText();
	}

	public String getDealImtuAmountValue(){
		
		return dealImtuAmountValue.getText();
	}
}
