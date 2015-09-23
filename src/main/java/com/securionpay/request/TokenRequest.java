package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TokenRequest {

	private String number;
	private String expMonth;
	private String expYear;
	private String cvc;
	private String cardholderName;

	private String addressLine1;
	private String addressLine2;
	private String addressCity;
	private String addressState;
	private String addressZip;
	private String addressCountry;

	private FraudCheckDataRequest fraudCheckData;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public TokenRequest() {
	}

	public TokenRequest(String number, String expMonth, String expYear, String cvc) {
		number(number).expMonth(expMonth).expYear(expYear).cvc(cvc);
	}

	public TokenRequest(String number, String expMonth, String expYear, String cvc, String cardholderName) {
		this(number, expMonth, expYear, cvc);
		cardholderName(cardholderName);
	}

	public String getNumber() {
		return number;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public String getCvc() {
		return cvc;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public FraudCheckDataRequest getFraudCheckData() {
		return fraudCheckData;
	}

	public TokenRequest number(String number) {
		this.number = number;
		return this;
	}

	public TokenRequest expMonth(String expMonth) {
		this.expMonth = expMonth;
		return this;
	}

	public TokenRequest expYear(String expYear) {
		this.expYear = expYear;
		return this;
	}

	public TokenRequest cvc(String cvc) {
		this.cvc = cvc;
		return this;
	}

	public TokenRequest cardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
		return this;
	}

	public TokenRequest addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public TokenRequest addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public TokenRequest addressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}

	public TokenRequest addressState(String addressState) {
		this.addressState = addressState;
		return this;
	}

	public TokenRequest addressZip(String addressZip) {
		this.addressZip = addressZip;
		return this;
	}

	public TokenRequest addressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
		return this;
	}

	public TokenRequest fraudCheckData(FraudCheckDataRequest fraudCheckData) {
		this.fraudCheckData = fraudCheckData;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public TokenRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
