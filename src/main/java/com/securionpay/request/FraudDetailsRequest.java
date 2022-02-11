package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.enums.FraudStatus;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FraudDetailsRequest {

	private FraudStatus status;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public FraudStatus getStatus() {
		return status;
	}

	public FraudDetailsRequest status(FraudStatus status) {
		this.status = status;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public FraudDetailsRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
