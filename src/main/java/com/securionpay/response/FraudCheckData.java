package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FraudCheckData {

	private String ipAddress;
	private String ipCountry;
	private String email;
	private String userAgent;
	private String acceptLanguage;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getIpAddress() {
		return ipAddress;
	}

	public String getIpCountry() {
		return ipCountry;
	}

	public String getEmail() {
		return email;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
