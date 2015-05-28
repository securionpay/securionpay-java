package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_EMPTY)
public class CustomerUpdateRequest {

	@JsonIgnore
	private String customerId;

	private String email;
	private String description;
	private String defaultCardId;
	private CardRequest card;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CustomerUpdateRequest() {
	}

	public CustomerUpdateRequest(String customerId) {
		customerId(customerId);
	}

	public CustomerUpdateRequest(Customer customer) {
		customer(customer);
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public String getDefaultCardId() {
		return defaultCardId;
	}

	public CardRequest getCard() {
		return card;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public CustomerUpdateRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CustomerUpdateRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public CustomerUpdateRequest email(String email) {
		this.email = email;
		return this;
	}

	public CustomerUpdateRequest description(String description) {
		this.description = description;
		return this;
	}

	public CustomerUpdateRequest defaultCardId(String defaultCardId) {
		this.defaultCardId = defaultCardId;
		return this;
	}

	public CustomerUpdateRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public CustomerUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
