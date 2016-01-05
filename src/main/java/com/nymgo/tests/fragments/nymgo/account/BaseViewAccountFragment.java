package com.nymgo.tests.fragments.nymgo.account;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.account.baseProfile.BaseProfileInfoFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class BaseViewAccountFragment extends BaseProfileInfoFragment{

	public BaseViewAccountFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlContains("/account/view/profile"));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return "/account/view/profile*";
	}

//	@FindBy(css = "div[class='clickable active']")
	@FindBy(css = "div[class$='active']")	
	private WebElement activeClickableContent;
	
	@FindBy(css = "div[class^='clickable']")
	private List<WebElement> allClickableContent;
	
	private WebElement getActiveContent(){
		try{
			return activeClickableContent;
		}
		catch(NoSuchElementException e){
			return null;
		}
	}
	
	private List<WebElement> getAllClickableContent(){
		
		return allClickableContent;
	}
	
	private WebElement getFirstClickableContent(){
		
		return allClickableContent.get(0);
	}
	
	private String getContentText(WebElement element){
		try{
			return element.getText();
		}
		catch(NoSuchElementException e){
			LOGGER.warn("NoSuchElementException handled");
			return "";
		}
	}
	
	private void expandContent(WebElement element){
		
		expandClickableContent(element);
	}
	
	public void expandContentByText(String contentName){
		
		if (getContentText(getActiveContent()).equals(contentName)){
			
			LOGGER.warn("Clickable content is already expanded");
		}
		else{
			boolean result = false;
			for (WebElement element: getAllClickableContent()){
				if(getContentText(element).equals(contentName)){
					expandContent(element);
					result = true;
					break;
				}
			}
			if (!result){
				LOGGER.fatal("There is no clickable content on page with text " + contentName);
			}
		}
	}
	
	public void selectCountryOfResidence(String countryOfResidence){

		super.selectCountryOfResidence(countryOfResidence);
	}

	public String getSelectedCountryOfResidence(){
		
		return super.getSelectedCountryOfResidence();
	}
	
	public String getFullName(){
		
		return super.getFullName();
	}

	public void setFullName(String fullName){
		
		super.setFullName(fullName);
	}

	public String getEmail(){
		
		return super.getEmail();
	}

	public void setEmail(String email){
		
		super.setEmail(email);
	}

	public String getMobile(){
		
		return super.getMobile();
	}

	public void setMobile(String mobile){
		
		super.setMobile(mobile);
	}

	public String getPhone(){
		
		return super.getPhone();
	}

	public void setPhone(String phone){
		
		super.setPhone(phone);
	}

	public String getCity(){
		
		return super.getCity();
	}

	public void setCity(String city){
		
		super.setCity(city);
	}

	public String getPostalCode(){
		
		return super.getPostalCode();
	}

	public void setPostalCode(String postalCode){
		
		super.setPostalCode(postalCode);
	}

	public String getStreet(){
		
		return super.getStreet();
	}

	public void setStreet(String street){
		
		super.setStreet(street);
	}

	public String getAddress(){
		
		return super.getAddress();		
	}

	public void setAddress(String address){
		
		super.setAddress(address);
	}

	public String getSelectedDisplayCurrency(){
		
		return super.getSelectedDisplayCurrency();		
	}

	public void selectDisplayCurrency(String displayCurrency){
		
		super.selectDisplayCurrency(displayCurrency);		
	}

	public String getSelectedPaymentCurrency(){
		
		return super.getSelectedPaymentCurrency();		
	}

	public void selectPaymentCurrency(String paymentCurrency){
		
		super.selectPaymentCurrency(paymentCurrency);		
	}

	public String getSelectedLanguage(){
		
		return super.getSelectedLanguage();		
	}

	public void selectLanguage(String language){
		
		super.selectLanguage(language);		
	}

	public void clickSaveButton(){
		
		super.clickSaveButton();
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getFirstClickableContent())));
		
	}
}
