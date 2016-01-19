package com.nymgo.tests.fragments.nymgo.menu.buyCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditDealPageFragment extends BuyCreditPageFragment {

	public BuyCreditDealPageFragment(WebDriver driver) {
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

    @FindBy(css="span[id='package-vat-total']")
    private WebElement dealVatValue;
	
    @FindBy(css="span[id='package-price-total']")
    private WebElement dealTotalAmountValue;

	public void selectDealByName(String dealName){
		
		selectValueFromSelectByVisibleText(dealsSelect, dealName);
	}
	
	public void setDealsQuantity(String dealsQuantity){
		
		setTextToEditField(dealsQuantityField, dealsQuantity);
	}

	public String getDealVATPercent(){
		
		LOGGER.debug(dealVatValue.getText());
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
}
