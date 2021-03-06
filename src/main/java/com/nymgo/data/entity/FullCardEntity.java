package com.nymgo.data.entity;

/**
 * Created by Iuliia Khikmatova on Oct 12, 2015
 */
public class FullCardEntity {

	String cardNumber;
    String expirationMonth;
    String expirationYear;
    String cvv;
    String cardholdersName;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardholdersName() {
		return cardholdersName;
	}

	public void setCardholdersName(String cardholdersName) {
		this.cardholdersName = cardholdersName;
	}

	public FullCardEntity(){
		
		this.cardNumber = "";
		this.expirationMonth = "";
		this.expirationYear= "";
		this.cvv = "";
		this.cardholdersName = "";
	}
	
}
