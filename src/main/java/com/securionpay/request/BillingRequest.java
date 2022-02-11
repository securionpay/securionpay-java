package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BillingRequest {
	private String name;
	private AddressRequest address;
	private String vat;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public BillingRequest() {
	}

	public BillingRequest(String name, AddressRequest address, String vat) {
		this.name = name;
		this.address = address;
		this.vat = vat;
	}

	public String getName() {
		return name;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public String getVat() {
		return vat;
	}

	public BillingRequest name(String name) {
		this.name = name;
		return this;
	}

	public BillingRequest address(AddressRequest address) {
		this.address = address;
		return this;
	}

	public BillingRequest vat(String vat) {
		this.vat = vat;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public BillingRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
