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
public class ChargeRequest {

	private Integer amount;
	private String currency;
	private String description;
	private String customerId;
	private CardRequest card;
	private Boolean captured;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public ChargeRequest() {
	}

	public ChargeRequest(Integer amount, String currency) {
		amount(amount).currency(currency);
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDescription() {
		return description;
	}

	public String getCustomerId() {
		return customerId;
	}

	public CardRequest getCard() {
		return card;
	}

	public Boolean getCaptured() {
		return captured;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public ChargeRequest amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public ChargeRequest currency(String currency) {
		this.currency = currency;
		return this;
	}

	public ChargeRequest description(String description) {
		this.description = description;
		return this;
	}

	public ChargeRequest customerId(String cusomerId) {
		this.customerId = cusomerId;
		return this;
	}

	public ChargeRequest customerId(Customer cusomer) {
		return customerId(cusomer.getId());
	}

	public ChargeRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public ChargeRequest captured(Boolean captured) {
		this.captured = captured;
		return this;
	}

	public ChargeRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ChargeRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
