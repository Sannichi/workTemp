package com.nymgo.tests.fragments.nymgo.transferCredits;

/**
 * Created by Iuliia Khikmatova on Mar 22, 2016
 */
public class TransferCreditData {
	
	String activity;
	String sender;
	String recipient;
	String date;
	String amount;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public TransferCreditData() {
		// TODO Auto-generated constructor stub
	}

	public TransferCreditData(String activity, String sender, String recipient, String date, String amount) {
		
		this.activity = activity;
		this.sender = sender;
		this.recipient = recipient;
		this.date = date;
		this.amount = amount;
	}
}
