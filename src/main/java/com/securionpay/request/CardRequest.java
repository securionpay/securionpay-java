package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_NULL)
public class CardRequest {

	private String id;

	@JsonIgnore
	private String customerId;

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

	public CardRequest() {
	}

	public CardRequest(String idOrToken) {
		this.id = idOrToken;
	}

	public CardRequest(String number, String expMonth, String expYear, String cvc) {
		this.number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvc = cvc;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
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

	public CardRequest id(String id) {
		this.id = id;
		return this;
	}

	public CardRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CardRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public CardRequest number(String number) {
		this.number = number;
		return this;
	}

	public CardRequest expMonth(String expMonth) {
		this.expMonth = expMonth;
		return this;
	}

	public CardRequest expYear(String expYear) {
		this.expYear = expYear;
		return this;
	}

	public CardRequest cvc(String cvc) {
		this.cvc = cvc;
		return this;
	}

	public CardRequest cardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
		return this;
	}

	public CardRequest addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public CardRequest addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public CardRequest addressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}

	public CardRequest addressState(String addressState) {
		this.addressState = addressState;
		return this;
	}

	public CardRequest addressZip(String addressZip) {
		this.addressZip = addressZip;
		return this;
	}

	public CardRequest addressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
		return this;
	}

	public CardRequest fraudCheckData(FraudCheckDataRequest fraudCheckData) {
		this.fraudCheckData = fraudCheckData;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CardRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}

}
