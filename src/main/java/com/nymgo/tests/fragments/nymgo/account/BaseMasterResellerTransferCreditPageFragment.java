package com.nymgo.tests.fragments.nymgo.account;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
/**
 * Created by Iuliia Khikmatova on Mar 09, 2016
 */
public class BaseMasterResellerTransferCreditPageFragment extends BaseLoggedInFragment{
	
    public BaseMasterResellerTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='balance']")
	private WebElement accountBalance; 
	
	@FindBy(xpath = "//div[@id='grid-container-resellers-list']//div[@class='row']")
	private List<WebElement> resellersListRows;

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getAccountBalance(){
		
		return accountBalance.getText();
	}

	public String getAccountBalanceValue(){
		
		return getAccountBalance().replace("\\D+", "").replace(" ", "").replace(",", "");
	}

	private String getResellerName(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='column reseller']")).getText();
	}

	private String getResellerBalance(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='column balance']")).getText();
	}

	private void clickResellerTransferCredit(WebElement row){
		
		clickElement(row.findElement(By.xpath("//div[@class='column transfer-credits']")));
	}

	private String getResellerBalanceCurrency(WebElement row){
		
		return getResellerBalance(row).replace("\\d+", "").replace(" ", "").replace(".", "").replace(",", "");
	}

	private String getResellerBalanceValue(WebElement row){
		
		return getResellerBalance(row).replace("\\D+", "").replace(" ", "").replace(",", "");
	}

	public String getResellerBalanceCurrencyByResellerName(String resellerName){
		
		for(WebElement row : resellersListRows){
			if(getResellerName(row).equals(resellerName.toLowerCase())){
				return getResellerBalanceCurrency(row);
			}
		}
		return "";
	}

	public String getResellerBalanceValueByResellerName(String resellerName){
		
		for(WebElement row : resellersListRows){
			if(getResellerName(row).equals(resellerName.toLowerCase())){
				return getResellerBalanceValue(row);
			}
		}
		return "";
	}
	
	public boolean clickTransferCreditByResellerName(String resellerName){
		
		boolean found = false;
		for(WebElement row : resellersListRows){
			if(getResellerName(row).equals(resellerName.toLowerCase())){
				clickResellerTransferCredit(row);
				found = true;
				break;
			}
		}
		return found;
	}

}
