package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Address {
	private String line1;
	private String line2;
	private String zip;
	private String city;
	private String state;
	private String country;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
