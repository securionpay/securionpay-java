package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustomerRequest {

	private String email;
	private String description;
	private CardRequest card;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CustomerRequest() {
	}

	public CustomerRequest(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public CardRequest getCard() {
		return card;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public CustomerRequest email(String email) {
		this.email = email;
		return this;
	}

	public CustomerRequest description(String description) {
		this.description = description;
		return this;
	}

	public CustomerRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public CustomerRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
