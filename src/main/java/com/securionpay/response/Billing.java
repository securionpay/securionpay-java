package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Billing {
	private String name;
	private Address address;
	private String vat;
	private String email;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public String getVat() {
		return vat;
	}

	public String getEmail() {
		return email;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
