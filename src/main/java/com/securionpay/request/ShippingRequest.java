package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShippingRequest {
	private String name;
	private AddressRequest address;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public ShippingRequest() {
	}

	public ShippingRequest(String name, AddressRequest address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public ShippingRequest name(String name) {
		this.name = name;
		return this;
	}

	public ShippingRequest address(AddressRequest address) {
		this.address = address;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ShippingRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
