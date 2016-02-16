package com.nymgo.tests.utils;

import com.nymgo.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class DealDescription {

	private Float usdPrice;
	private int sarPrice;
	private int aedPrice;
	private Float kwdPrice;
	private int qarPrice;
	private int eurPrice;
	private int gbpPrice;
	private int cadPrice;
	private int audPrice;
	private int nzdPrice;
	private int myrPrice;
	private int sgdPrice;
	private int inrPrice;
	private int aoaPrice;
	private int bndPrice;
	private CURRENCY_SIGNS currencySign;
	private int minutes;
	private int imtuAmount;
	
	public DealDescription(Float usdPrice, int audPrice, int cadPrice, int eurPrice, int inrPrice, int nzdPrice, int qarPrice, int sarPrice, 
			int aedPrice, int gbpPrice, Float kwdPrice, int myrPrice, int sgdPrice, int aoaPrice, int bndPrice, CURRENCY_SIGNS currencySign, int minutes, int imtuAmount) {

		this.usdPrice = usdPrice;
		this.sarPrice = sarPrice;
		this.aedPrice = aedPrice;
		this.kwdPrice = kwdPrice;
		this.qarPrice = qarPrice;
		this.eurPrice = eurPrice;
		this.gbpPrice = gbpPrice;
		this.cadPrice = cadPrice;
		this.audPrice = audPrice;
		this.nzdPrice = nzdPrice;
		this.myrPrice = myrPrice;
		this.sgdPrice = sgdPrice;
		this.inrPrice = inrPrice;
		this.aoaPrice = aoaPrice;
		this.bndPrice = bndPrice;
		this.currencySign = currencySign;
		this.minutes = minutes;
		this.imtuAmount = imtuAmount;
}

	public Float getUsdPrice() {
		return usdPrice;
	}

	public void setUsdPrice(Float usdPrice) {
		this.usdPrice = usdPrice;
	}

	public int getSarPrice() {
		return sarPrice;
	}

	public void setSarPrice(int sarPrice) {
		this.sarPrice = sarPrice;
	}

	public int getAedPrice() {
		return aedPrice;
	}

	public void setAedPrice(int aedPrice) {
		this.aedPrice = aedPrice;
	}

	public Float getKwdPrice() {
		return kwdPrice;
	}

	public void setKwdPrice(Float kwdPrice) {
		this.kwdPrice = kwdPrice;
	}

	public int getQarPrice() {
		return qarPrice;
	}

	public void setQarPrice(int qarPrice) {
		this.qarPrice = qarPrice;
	}

	public int getEurPrice() {
		return eurPrice;
	}

	public void setEurPrice(int eurPrice) {
		this.eurPrice = eurPrice;
	}

	public int getGbpPrice() {
		return gbpPrice;
	}

	public void setGbpPrice(int gbpPrice) {
		this.gbpPrice = gbpPrice;
	}

	public int getCadPrice() {
		return cadPrice;
	}

	public void setCadPrice(int cadPrice) {
		this.cadPrice = cadPrice;
	}

	public int getAudPrice() {
		return audPrice;
	}

	public void setAudPrice(int audPrice) {
		this.audPrice = audPrice;
	}

	public int getNzdPrice() {
		return nzdPrice;
	}

	public void setNzdPrice(int nzdPrice) {
		this.nzdPrice = nzdPrice;
	}

	public int getMyrPrice() {
		return myrPrice;
	}

	public void setMyrPrice(int myrPrice) {
		this.myrPrice = myrPrice;
	}

	public int getSgdPrice() {
		return sgdPrice;
	}

	public void setSgdPrice(int sgdPrice) {
		this.sgdPrice = sgdPrice;
	}

	public int getInrPrice() {
		return inrPrice;
	}

	public void setInrPrice(int inrPrice) {
		this.inrPrice = inrPrice;
	}

	public int getAoaPrice() {
		return aoaPrice;
	}

	public void setAoaPrice(int aoaPrice) {
		this.aoaPrice = aoaPrice;
	}

	public int getBndPrice() {
		return bndPrice;
	}

	public void setBndPrice(int bndPrice) {
		this.bndPrice = bndPrice;
	}

	public CURRENCY_SIGNS getCurrencySign() {
		return currencySign;
	}

	public void setCurrencySign(CURRENCY_SIGNS currencySign) {
		this.currencySign = currencySign;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getImtuAmount() {
		return imtuAmount;
	}

	public void setImtuAmount(int imtuAmount) {
		this.imtuAmount = imtuAmount;
	}

	public Float getPriceByPaymentCurrency(String paymentCurrency){
		
		CURRENCY_SIGNS CURR_SIGN = CURRENCY_SIGNS.valueOf(paymentCurrency);
		switch (CURR_SIGN){
			case USD:
				return getUsdPrice();
			case AUD:
				return (float) getAudPrice();
			case CAD:
				return (float) getCadPrice();
			case EUR:
				return (float) getEurPrice();
			case INR:
				return (float) getInrPrice();
			case NZD:
				return (float) getNzdPrice();
			case QAR:
				return (float) getQarPrice();
			case SAR:
				return (float) getSarPrice();
			case AED:
				return (float) getAedPrice();
			case GBP:
				return (float) getGbpPrice();
			case KWD:
				return (float) getKwdPrice();
			case MYR:
				return (float) getMyrPrice();
			case SGD:
				return (float) getSgdPrice();
			case AOA:
				return (float) getAoaPrice();
			case BND:
				return (float) getBndPrice();
			default:
				return getUsdPrice();
		}
	}
}
