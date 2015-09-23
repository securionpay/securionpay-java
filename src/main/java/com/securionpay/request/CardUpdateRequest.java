package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Card;

@JsonInclude(Include.NON_NULL)
public class CardUpdateRequest {

	@JsonIgnore
	private String cardId;
	@JsonIgnore
	private String customerId;

	private String expMonth;
	private String expYear;
	private String cardholderName;

	private String addressCountry;
	private String addressCity;
	private String addressState;
	private String addressZip;
	private String addressLine1;
	private String addressLine2;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CardUpdateRequest() {
	}

	public CardUpdateRequest(String cardId, String customerId) {
		cardId(cardId).customerId(customerId);
	}

	public CardUpdateRequest(Card card) {
		card(card);
	}

	public String getCardId() {
		return cardId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public String getAddressCountry() {
		return addressCountry;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public CardUpdateRequest cardId(String cardId) {
		this.cardId = cardId;
		return this;
	}

	public CardUpdateRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CardUpdateRequest card(Card card) {
		return cardId(card.getId()).customerId(card.getCustomerId());
	}

	public CardUpdateRequest expMonth(String expMonth) {
		this.expMonth = expMonth;
		return this;
	}

	public CardUpdateRequest expYear(String expYear) {
		this.expYear = expYear;
		return this;
	}

	public CardUpdateRequest cardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
		return this;
	}

	public CardUpdateRequest addressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
		return this;
	}

	public CardUpdateRequest addressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}

	public CardUpdateRequest addressState(String addressState) {
		this.addressState = addressState;
		return this;
	}

	public CardUpdateRequest addressZip(String addressZip) {
		this.addressZip = addressZip;
		return this;
	}

	public CardUpdateRequest addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public CardUpdateRequest addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CardUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
