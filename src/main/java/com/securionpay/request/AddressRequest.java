package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressRequest {
	private String line1;
	private String line2;
	private String zip;
	private String city;
	private String state;
	private String country;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public AddressRequest() {
	}

	public AddressRequest(String line1, String line2, String zip, String city, String state, String country) {
		this.line1 = line1;
		this.line2 = line2;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.country = country;
	}

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

	public AddressRequest line1(String line1) {
		this.line1 = line1;
		return this;
	}

	public AddressRequest line2(String line2) {
		this.line2 = line2;
		return this;
	}

	public AddressRequest zip(String zip) {
		this.zip = zip;
		return this;
	}

	public AddressRequest city(String city) {
		this.city = city;
		return this;
	}

	public AddressRequest state(String state) {
		this.state = state;
		return this;
	}

	public AddressRequest country(String country) {
		this.country = country;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public AddressRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
