package com.securionpay.request;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.response.Credit;
import com.securionpay.response.Customer;

@JsonInclude(NON_NULL)
public class CreditUpdateRequest {
	@JsonIgnore
	private String creditId;

	private String customerId;
	private String description;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	public CreditUpdateRequest() {
	}

	public CreditUpdateRequest(String creditId) {
		creditId(creditId);
	}

	public CreditUpdateRequest(Credit credit) {
		credit(credit);
	}

	public String getCreditId() {
		return creditId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public CreditUpdateRequest creditId(String creditId) {
		this.creditId = creditId;
		return this;
	}

	public CreditUpdateRequest credit(Credit credit) {
		return creditId(credit.getId());
	}
	

	public CreditUpdateRequest description(String description) {
		this.description = description;
		return this;
	}

	public CreditUpdateRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CreditUpdateRequest customerId(Customer customer) {
		return customerId(customer.getId());
	}

	public CreditUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CreditUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
