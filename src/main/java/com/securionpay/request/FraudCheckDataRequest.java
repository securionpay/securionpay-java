package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class FraudCheckDataRequest {

	private String ipAddress;
	private String email;
	private String userAgent;
	private String acceptLanguage;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public String getIpAddress() {
		return ipAddress;
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

	public FraudCheckDataRequest ipAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	public FraudCheckDataRequest email(String email) {
		this.email = email;
		return this;
	}

	public FraudCheckDataRequest userAgent(String userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	public FraudCheckDataRequest acceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public FraudCheckDataRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
