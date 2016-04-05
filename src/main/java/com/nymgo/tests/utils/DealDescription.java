package com.nymgo.tests.utils;

import com.nymgo.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Jan 20, 2016
 */
public class DealDescription {

	private Float usdPrice;
	private Float sarPrice;
	private Float aedPrice;
	private Float kwdPrice;
	private Float qarPrice;
	private Float eurPrice;
	private Float gbpPrice;
	private Float cadPrice;
	private Float audPrice;
	private Float nzdPrice;
	private Float myrPrice;
	private Float sgdPrice;
	private Float inrPrice;
	private Float aoaPrice;
	private Float bndPrice;
	private CURRENCY_SIGNS currencySign;
	private int minutes;
	private int imtuAmount;
	
	public DealDescription() {

		this.usdPrice = (float) 0;
		this.sarPrice = (float) 0;
		this.aedPrice = (float) 0;
		this.kwdPrice = (float) 0;
		this.qarPrice = (float) 0;
		this.eurPrice = (float) 0;
		this.gbpPrice = (float) 0;
		this.cadPrice = (float) 0;
		this.audPrice = (float) 0;
		this.nzdPrice = (float) 0;
		this.myrPrice = (float) 0;
		this.sgdPrice = (float) 0;
		this.inrPrice = (float) 0;
		this.aoaPrice = (float) 0;
		this.bndPrice = (float) 0;
		this.currencySign = CURRENCY_SIGNS.USD;
		this.minutes = 0;
		this.imtuAmount = 0;
	}

	public DealDescription(Float usdPrice, Float audPrice, Float cadPrice, Float eurPrice, Float inrPrice, Float nzdPrice, Float qarPrice, Float sarPrice, 
			Float aedPrice, Float gbpPrice, Float kwdPrice, Float myrPrice, Float sgdPrice, Float aoaPrice, Float bndPrice, CURRENCY_SIGNS currencySign, int minutes, int imtuAmount) {

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

	public Float getSarPrice() {
		return sarPrice;
	}

	public void setSarPrice(Float sarPrice) {
		this.sarPrice = sarPrice;
	}

	public Float getAedPrice() {
		return aedPrice;
	}

	public void setAedPrice(Float aedPrice) {
		this.aedPrice = aedPrice;
	}

	public Float getKwdPrice() {
		return kwdPrice;
	}

	public void setKwdPrice(Float kwdPrice) {
		this.kwdPrice = kwdPrice;
	}

	public Float getQarPrice() {
		return qarPrice;
	}

	public void setQarPrice(Float qarPrice) {
		this.qarPrice = qarPrice;
	}

	public Float getEurPrice() {
		return eurPrice;
	}

	public void setEurPrice(Float eurPrice) {
		this.eurPrice = eurPrice;
	}

	public Float getGbpPrice() {
		return gbpPrice;
	}

	public void setGbpPrice(Float gbpPrice) {
		this.gbpPrice = gbpPrice;
	}

	public Float getCadPrice() {
		return cadPrice;
	}

	public void setCadPrice(Float cadPrice) {
		this.cadPrice = cadPrice;
	}

	public Float getAudPrice() {
		return audPrice;
	}

	public void setAudPrice(Float audPrice) {
		this.audPrice = audPrice;
	}

	public Float getNzdPrice() {
		return nzdPrice;
	}

	public void setNzdPrice(Float nzdPrice) {
		this.nzdPrice = nzdPrice;
	}

	public Float getMyrPrice() {
		return myrPrice;
	}

	public void setMyrPrice(Float myrPrice) {
		this.myrPrice = myrPrice;
	}

	public Float getSgdPrice() {
		return sgdPrice;
	}

	public void setSgdPrice(Float sgdPrice) {
		this.sgdPrice = sgdPrice;
	}

	public Float getInrPrice() {
		return inrPrice;
	}

	public void setInrPrice(Float inrPrice) {
		this.inrPrice = inrPrice;
	}

	public Float getAoaPrice() {
		return aoaPrice;
	}

	public void setAoaPrice(Float aoaPrice) {
		this.aoaPrice = aoaPrice;
	}

	public Float getBndPrice() {
		return bndPrice;
	}

	public void setBndPrice(Float bndPrice) {
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
