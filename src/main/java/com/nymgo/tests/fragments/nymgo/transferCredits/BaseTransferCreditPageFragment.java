package com.nymgo.tests.fragments.nymgo.transferCredits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.fragments.nymgo.base.LoggedNymgoPageFragment;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class BaseTransferCreditPageFragment extends LoggedNymgoPageFragment {

	public BaseTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "recipient-username-el")
	private WebElement usernameField;
	
	@FindBy(id = "amount-el")
	private WebElement amountField;

	@FindBy(id = "your-password-el")
	private WebElement passwordField;

	@FindBy(id = "send-button-el")
	private WebElement transferButton;
	
	@FindBy(id = "credit-history")
	private WebElement creditHistoryRadio;

	@FindBy(id = "business-received-credits")
	private WebElement businessReceivedCreditsRadio;

	@FindBy(xpath = "//div[@class='transfer-history']//div[@class='row']")
	private List<WebElement> transferHistoryRows;

	public void setUsername(String username){
		setTextToEditField(usernameField, username);
	}
	
	public void setAmount(String amount){
		setTextToEditField(amountField, amount);
	}
	
	public void setPassword(String password){
		setTextToEditField(passwordField, password);
	}
	
	public void clickTransferButton(){
		clickInputButton(transferButton);
	}

	private String getRowActivity(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='padd'][1]")).getText();
	}

	private String getRowSender(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='padd'][2]")).getText();
	}

	private String getRowRecipient(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='padd'][3]")).getText();
	}

	private String getRowDate(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='padd'][4]")).getText();
	}

	private String getRowAmount(WebElement row){
		
		return row.findElement(By.xpath("//div[@class='padd'][5]")).getText();
	}

	private TransferCreditData getRowData(WebElement row){
		
		return new TransferCreditData(getRowActivity(row), getRowSender(row), getRowRecipient(row), getRowDate(row), getRowAmount(row));
	}
	
	public TransferCreditData getLastTransferData(){
		
		WebElement lastTransferRow = transferHistoryRows.get(0);
		return getRowData(lastTransferRow);
		
	}
	
	public String getLastTransferActivity(){
		
		WebElement lastTransferRow = transferHistoryRows.get(0);
		return getRowActivity(lastTransferRow);
		
	}
	
	public String getLastTransferSender(){
		
		WebElement lastTransferRow = transferHistoryRows.get(0);
		return getRowSender(lastTransferRow);
		
	}
	
	public String getLastTransferRecipient(){
		
		WebElement lastTransferRow = transferHistoryRows.get(0);
		return getRowRecipient(lastTransferRow);
		
	}
	
	public String getLastTransferAmount(){
		
		WebElement lastTransferRow = transferHistoryRows.get(0);
		return getRowAmount(lastTransferRow);
		
	}
	
}
